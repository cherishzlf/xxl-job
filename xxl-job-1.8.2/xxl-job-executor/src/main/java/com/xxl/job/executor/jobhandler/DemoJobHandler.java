package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.MdReach;
import com.xxl.job.executor.domain.UpReach;
import com.xxl.job.executor.domain.UploadRiverMaster;
import com.xxl.job.executor.domain.zhuji.UploadReach;
import com.xxl.job.executor.service.first.MdReachService;
import com.xxl.job.executor.service.first.SmUserService;
import com.xxl.job.executor.utils.CallApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 任务Handler的一个Demo（Bean模式）
 *
 * 开发步骤：
 * 1、继承 “IJobHandler” ；
 * 2、装配到Spring，例如加 “@Service” 注解；
 * 3、加 “@JobHander” 注解，注解value值为新增任务生成的JobKey的值;多个JobKey用逗号分割;
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2015-12-19 19:43:36
 */
@JobHander(value="demoJobHandler")
@Service
public class DemoJobHandler extends IJobHandler {
	@Autowired
	private MdReachService mdReachService;
	@Autowired
	private SmUserService smUserService;
	@Override
	public ReturnT<String> execute(String...   params) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("regionId", params[0]);
		condition.put("regionLevel", params[1]);
		List<UpReach> reachids = mdReachService.getUpReachList(condition);
//		String reachs= "43393555b24311e79356286ed488ca40,b7592833b24211e79356286ed488ca40,b761d16cb24211e79356286ed488ca40,b76aa8e6b24211e79356286ed488ca40,fd908273ae8d11e79356286ed488ca40";
//		String[] reachids = reachs.split(",");
		for(int i =0 ; i<reachids.size();i++){
			String result = CallApiUtil.delReach(reachids.get(i).getRiverID(),"jxpt");
			if(!result.equals("true")){
				System.out.println(result);
				i++;
				continue;
			}
			System.out.println("删除成功");
		}
		return ReturnT.SUCCESS;
	}

}
