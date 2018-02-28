package com.xxl.job.executor.service.first;


import com.xxl.job.executor.domain.UpSteeringFeedback;

import java.util.List;
import java.util.Map;

/**
 * 重点项目接口
 * @author liruimin<br>2017/8/11
 * @version 1.8.2
 */
public interface PmSupervisionService {



    UpSteeringFeedback getFirstSection(Map<String, Object> condition);

    void updateUploadtime(Map<String, Object> entity, List<String> idList);

    List<UpSteeringFeedback> getUpSteeringFeedbackList(Map<String, Object> condition);
}
