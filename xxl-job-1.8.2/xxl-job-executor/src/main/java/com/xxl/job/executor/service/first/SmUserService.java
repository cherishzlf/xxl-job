package com.xxl.job.executor.service.first;


import com.xxl.job.executor.domain.SmUser;
import com.xxl.job.executor.domain.UploadRiverMaster;
import com.xxl.job.executor.domain.UploadRiverMinister;
import com.xxl.job.executor.domain.zhuji.UpUser;
import com.xxl.job.executor.vo.SmUserVO;

import java.util.List;
import java.util.Map;

/**
 * 用户管理接口
 *
 * @author liruimin<br>2017/8/11
 * @version 1.8.2
 */
public interface SmUserService {
    UploadRiverMaster getFirstMaster(Map<String, Object> condition);

    List<UploadRiverMaster> getUpMasterList(Map<String, Object> condition);

    void updateUploadtime(Map<String, Object> entity);

    /**
     * 诸暨-绍兴   得到最后一次上报对象
     */
    UpUser getFirstUser();

    /**
     * 诸暨-绍兴   得到上报河长的数据
     */
    List<UpUser> getUpUser(Map<String, Object> condition);

    void update(Map<String, Object> param);

    /**
     * get All user where status is normal and role only is HZ
     *
     * @return SmUserVO
     * @author xu_zhu<br>2017/10/26 13:53
     */
    List<SmUserVO> findUserListWhereRoleOnlyIsHZ();
    List<UploadRiverMaster> getUserByRegion(Map condition);
    /**
     * 获取总河长列表
     */
    List<UploadRiverMinister> getUpRiverMinisterList(Map<String, Object> condition);
}
