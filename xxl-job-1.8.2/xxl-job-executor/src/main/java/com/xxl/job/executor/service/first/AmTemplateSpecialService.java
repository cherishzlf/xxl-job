package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.AmTemplateSpecial;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface AmTemplateSpecialService {

    /**
     * 通过ID查询数据
     * @author xu_zhu<br/> 2017/11/30 8:32
     */
    AmTemplateSpecial getById(Map<String, String> pk);


    /**
     * 通过父级主键查询子级
     * @param pk
     * @author xu_zhu<br/> 2017/12/14 10:26
     */
    List<AmTemplateSpecial> findSpecialTemplateByParentPk(String pk);
}
