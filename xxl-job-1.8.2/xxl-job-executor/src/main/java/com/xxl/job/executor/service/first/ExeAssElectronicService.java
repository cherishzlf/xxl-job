package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.ExeAssElectronic;
import com.xxl.job.executor.vo.ExeAssElectronicVO;

import java.util.List;
import java.util.Map;

/**
 * 河长履职电子化考核接口
 *
 * @author xu_zhu<br>2017/10/26 10:46.
 */
public interface ExeAssElectronicService {

    /**
     * insert a new Date(new ExeAssElectronic(column...))
     *
     * @param params
     * @author xu_zhu<br>2017/10/26 10:47
     */
    void insert(Map<String, Object> params);


    /**
     * 河长履职电子化考核
     * 河长巡查达标
     * 通过用户Id和reachId进入表 LogLocusRecord 查询巡查轨迹记录
     * <p>
     * 返回结果字段
     * locusId 轨迹表轨迹Id
     * workLogId 日志Id
     * startTime 巡查开始时间
     * endTime 巡查结束时间
     *
     * @return endTime  轨迹表巡查结束时间
     * @params userId
     * @params reachId
     * @author xu_zhu<br>2017/10/27 16:27
     */
    List<ExeAssElectronicVO> findLogLocusRecordByUserIdAndReachId(Map<String, Object> params);


    /**
     * 通过工作日志Id工作内容
     * <p>
     * 返回结果字段
     * workLogId
     * content 工作日志内容
     * checkItems 工作日志涉及项
     * createTime 日志创建时间
     *
     * @param workLogId
     * @return accessoryUrl 工作日志影像附件
     * @author xu_zhu<br>2017/10/27 16:33
     */
    ExeAssElectronicVO getPatrolContentByWorkLogId(String workLogId);

    /**
     * 通过工作日志id查询附件URL
     * <p>
     * 返回结果字段
     * accessoryUrl 工作日志内容影音附件URL
     *
     * @author xu_zhu<br/> 2017/11/17 13:43
     */
    List<String> findAccessoryUrlByWorkLogId(String workLogId);


    /**
     * 河长履职电子化考核
     * 未结案事件
     * 通过河道id进入ehEvent表查询未结案事件并且非作废事件
     * <p>
     * 返回结果字段
     * eventId
     * reachName
     * eventType 事件类型
     * eventResource 事件来源
     * createTime 事件创建日期
     * endTime 事件结案日期
     *
     * @param reachId
     * @param eventInterval 事件周期数
     * @author xu_zhu<br>2017/10/27 16:45
     */
    List<ExeAssElectronicVO> findUntreatedEventByReachId(Map<String, Object> params);


    /**
     * 河长履职电子化考核
     * 投诉事件
     * 通过reachId进入ehEvent表查询事件
     * <p>
     * 返回结果字段
     * eventId
     * reachId
     * reachName
     * eventType 事件类型
     *
     * @param reachId
     * @author xu_zhu<br>2017/10/27 16:49
     */
    List<ExeAssElectronicVO> findComplaintsByReachId(String reachId);


    /**
     * 通过考核日期删除数据
     *
     * @params assessTime
     * @author xu_zhu<br/> 2017/11/15 15:21
     */
    void deleteByAssessTime(String assessTime);


    /**
     * 通过考核日期查询用户id
     *
     * @params assessTime
     * @author xu_zhu<br/> 2017/11/23 10:00
     */
    List<String> findUserIdByAssessTime(String assessTime);


    /**
     * 通过用户id与考核日期查询数据
     *
     * @params assessTime
     * @params userId
     * @author xu_zhu<br/> 2017/11/23 10:13
     */
    List<ExeAssElectronic> findByUserIdAndAssessTime(Map<String, String> params);
}
