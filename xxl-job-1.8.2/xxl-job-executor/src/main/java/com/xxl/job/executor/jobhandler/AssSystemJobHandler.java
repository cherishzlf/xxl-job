package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.ExeAssSystemEndurance;
import com.xxl.job.executor.service.first.ExeAssSystemEnduranceService;
import com.xxl.job.executor.utils.UhopeUtil;
import com.xxl.job.executor.vo.ExeAssSystemEnduranceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 考核业务逻辑
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
@JobHander(value="assSystemJobHandler")
@Service
public class AssSystemJobHandler extends IJobHandler {

	@Autowired
	private ExeAssSystemEnduranceService exeAssSystemEnduranceService;

	/**
	 * 执行器方法
	 * @param params 参数数组
	 * 1、params[0] int statType 统计类型 (1按月month、2按季quarter、3按年year) 默认按月
	 * 2、params[1] Integer year 年 默认当前年份
	 * 3、params[2] Integer month 月 (0表示所有月份) 默认当前月份
	 * 3、params[2] Integer quarter 季度 (0表示所有季度) 默认当前季度
	 * 4、params[3] String chairmanId 登录用户id 默认null
	 * 5、params[4] String regionId 行政区域id 默认值:330000000000(浙江省)
	 * 6、params[5] int chairmanLevel 河长级别 (12345=省市县镇村 6=工作人员 0=12345) 默认值:0
	 * 7、params[6] String chairmanName 河长名称 默认null
	 * 8、params[7] int pageNumber 分页起始值 默认值:0
	 * 9、params[8] int pageSize 分页条数 (0表示全部)  默认值:0
	 * 参数数组; params[1, 2017, 8, '', 330000000000, 0, '', 0, 0] (默认值)
	 * @return ReturnT.SUCCESS
	 * @throws Exception
     */
	@Override
	public ReturnT<String> execute(String... params) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello World.");
		int statType = 1;
		Integer year = null, month = null, quarter = null;
		String regionId = "330000000000";
		String chairmanId = null;
		String chairmanName = null;
		int chairmanLevel = 0, pageNumber = 0, pageSize = 0;
		// 分解参数数组
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				switch (i) {
					case 0:
						statType = Integer.valueOf(params[0]);
						break;
					case 1:
						year = Integer.valueOf(params[1]);
						break;
					case 2:
						if (statType == 1) {
							month = Integer.valueOf(params[2]);
						} else if (statType == 2) {
							quarter = Integer.valueOf(params[2]);
						}
						break;
					case 3:
						chairmanId = params[3];
						break;
					case 4:
						regionId = params[4];
						break;
					case 5:
						chairmanLevel = Integer.valueOf(params[5]);
						break;
					case 6:
						chairmanName = params[6];
						break;
					case 7:
						pageNumber = Integer.valueOf(params[7]);
						break;
					case 8:
						pageSize = Integer.valueOf(params[8]);
						break;
					default:
				}
			}
		}

		ExeAssSystemEndurance exeAssSystemEndurance = null;
		// 三种统计类型都无有效的值，则从考核统计新创建的表获取数据
		if((statType == 1 && year == null && month == null) ||
				(statType == 2 && quarter == null) ||
				(statType == 3 && year == null)){
			// 获取 统计截止时间
			exeAssSystemEndurance = exeAssSystemEnduranceService.getStatCutOffTime();
		}

		// 如未从数据库中获取数据，则直接获取当前系统时间
		if (exeAssSystemEndurance != null) {
			year = exeAssSystemEndurance.getYear();
			month = exeAssSystemEndurance.getMonth()+1;
			quarter = UhopeUtil.getQuarter(month);
		} else if (params == null) {
			year = UhopeUtil.getYear();               // 年
			month = UhopeUtil.getMonth();             // 月
			quarter = UhopeUtil.getQuarter(month);    // 季度
		}

		ExeAssSystemEnduranceVO exeAssSystemEnduranceVO = new ExeAssSystemEnduranceVO();
		switch (statType) {
			case 1:
				exeAssSystemEnduranceVO.setMonthorquarter(month);
				break;
			case 2:
				exeAssSystemEnduranceVO.setMonthorquarter(quarter);
				break;
			default:
		}

		exeAssSystemEnduranceVO.setAsstype(statType);
		exeAssSystemEnduranceVO.setYear(year);
		exeAssSystemEnduranceVO.setQuarter(quarter);
		exeAssSystemEnduranceVO.setMonth(month);
		exeAssSystemEnduranceVO.setChairmanid(chairmanId);
		exeAssSystemEnduranceVO.setRegionid(regionId);
		exeAssSystemEnduranceVO.setChairmanlevel(chairmanLevel);
		exeAssSystemEnduranceVO.setChairmanname(chairmanName);
		exeAssSystemEnduranceVO.setPageNumber(pageNumber);
		exeAssSystemEnduranceVO.setPageSize(pageSize);

		this.transactionOperation(exeAssSystemEnduranceVO);
		if (chairmanLevel == 0) {
			exeAssSystemEnduranceVO.setChairmanlevel(6);
			this.transactionOperation(exeAssSystemEnduranceVO);
		}

		for (int i = 0; i < 5; i++) {
			XxlJobLogger.log("beat at:" + i);
			TimeUnit.SECONDS.sleep(2);
		}
		return ReturnT.SUCCESS;
	}

	/**
	 * 事件操作
	 * @param exeAssSystemEnduranceVO 考核扩展对象
     */
	private void transactionOperation(ExeAssSystemEnduranceVO exeAssSystemEnduranceVO){
		List<ExeAssSystemEndurance> assSystemEnduranceList = exeAssSystemEnduranceService.callProcedureByCondition(exeAssSystemEnduranceVO);
		for (int i = 0; i < assSystemEnduranceList.size(); i++) {
			ExeAssSystemEndurance assSystemEndurance = new ExeAssSystemEndurance();
			assSystemEndurance = assSystemEnduranceList.get(i);
			assSystemEndurance.setMonth(exeAssSystemEnduranceVO.getMonth());
			assSystemEndurance.setQuarter(exeAssSystemEnduranceVO.getQuarter());
			assSystemEndurance.setYear(exeAssSystemEnduranceVO.getYear());
			assSystemEndurance.setAsstype(exeAssSystemEnduranceVO.getAsstype());
			if(exeAssSystemEnduranceVO.getChairmanlevel() == 6){
				assSystemEndurance.setChairmanlevel(exeAssSystemEnduranceVO.getChairmanlevel());
			}
			exeAssSystemEnduranceService.save(assSystemEndurance);
		}
	}

}
