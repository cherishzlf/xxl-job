package com.xxl.job.executor.service.thrid.impl;

import com.xxl.job.executor.domain.WaterqualityMonthly;
import com.xxl.job.executor.service.thrid.IWaterQuailtyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class WaterQuailtyDao implements IWaterQuailtyDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<WaterqualityMonthly> findByCode(String mdSectionId,Long time) {
        final Query query = new Query(Criteria.where("code").in(mdSectionId).and("statisticaltime").gt(new Date(time)));
//        final Query query = new Query(Criteria.where("code").in(mdSectionId).and("timestamp").gt(1504916121));
        return mongoTemplate.find(query,WaterqualityMonthly.class);
    }
}
