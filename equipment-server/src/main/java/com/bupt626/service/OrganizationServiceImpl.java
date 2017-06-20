package com.bupt626.service;

import com.bupt626.common.base.BasePageService;
import com.bupt626.entity.Organization;
import com.bupt626.repository.OrganizationRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CJ on 2017/6/18.
 */
@Service
@Transactional
public class OrganizationServiceImpl extends BasePageService<Organization,String> {

    @Autowired
    private OrganizationRepository organizationRepository;

    public void save(Organization organization){

        organizationRepository.save(organization);

    }

    public Organization findOne(String id){
        return  organizationRepository.findOne(id);
    }

}
