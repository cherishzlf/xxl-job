package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.MdSection;
import com.xxl.job.executor.domain.UpRiverSection;

import java.util.List;
import java.util.Map;

/**
 * 河长河道接口
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
public interface MdSectionService {

    UpRiverSection getFirstSection(Map<String, Object> condition);

    List<UpRiverSection> getUpSectionList(Map<String, Object> condition);

    void updateUploadtime(Map<String, Object> entity);

    List<MdSection> getUpSectionId(Map<String, Object> condition);
}
