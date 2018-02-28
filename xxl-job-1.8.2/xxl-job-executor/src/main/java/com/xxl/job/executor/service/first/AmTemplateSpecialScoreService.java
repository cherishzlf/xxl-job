package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.AmTemplateSpecial;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface AmTemplateSpecialScoreService {

    /**
     *
     * @param
     * @return
     * @author xu_zhu<br/> 2017/12/14 10:56
     */
    void insert(Map<String, Object> entity);

    int removeByAssessTime(String assessTime);
}
