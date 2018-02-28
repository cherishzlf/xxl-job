package com.xxl.job.executor.service.first;


import com.xxl.job.executor.domain.UpProPlan;

import java.util.List;
import java.util.Map;

/**
 * 重点项目接口
 * @author liruimin<br>2017/8/11
 * @version 1.8.2
 */
public interface PmProjectService {


    UpProPlan getFirstProject(Map<String, Object> condition);

    List<UpProPlan> getUpProjectList(Map<String, Object> condition);

    void updateUploadtime(Map<String, Object> entity, List<String> idList);
}
