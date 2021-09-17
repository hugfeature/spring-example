
/*
 * @Author: 丑牛
 * @Date: 2021-09-17 10:46:15
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-17 11:49:36
 * @Description: file content
 */
package com.example.springjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;

import com.example.springjpa.model.UserDetail;
import com.example.springjpa.param.UserDetailParam;
import com.example.springjpa.repostiory.UserDetailRepostiory;
import com.mysql.cj.util.StringUtils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    
    @Resource
    private UserDetailRepostiory userDetailRepository;

    @Override
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable) {

        return userDetailRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            //equal 示例
            if (!StringUtils.isNullOrEmpty(detailParam.getIntroduction())){
                predicates.add(cb.equal(root.get("introduction"),detailParam.getIntroduction()));
            }
            //like 示例
            if (!StringUtils.isNullOrEmpty(detailParam.getRealName())){
                predicates.add(cb.like(root.get("realName"),"%"+detailParam.getRealName()+"%"));
            }
            // //between 示例
            // if (detailParam.getMaxAge()!=null && detailParam.getMaxAge()!=null) {
            //     Predicate agePredicate = cb.between(root.get("age"), detailParam.getMaxAge(), detailParam.getMaxAge());
            //     predicates.add(agePredicate);
            // }
            // //greaterThan 大于等于示例
            // if (detailParam.getMaxAge()!=null){
            //     predicates.add(cb.greaterThanOrEqualTo(root.get("age"),detailParam.getMaxAge()));
            // }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }

    
}
