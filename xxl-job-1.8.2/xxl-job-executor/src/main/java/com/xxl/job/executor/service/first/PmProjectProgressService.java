package com.xxl.job.executor.service.first;


import com.xxl.job.executor.domain.UpProPlanProgress;

import java.util.List;
import java.util.Map;

public interface PmProjectProgressService {
    UpProPlanProgress getFirstProjectProgress(Map<String, Object> condition);

    List<UpProPlanProgress> getUpProjectProgressList(Map<String, Object> condition);

    void updateUploadtime(Map<String, Object> entity, List<String> idList);
}
