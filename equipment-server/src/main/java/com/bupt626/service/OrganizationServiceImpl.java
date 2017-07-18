package com.bupt626.service;

import com.bupt626.common.base.BasePageService;
import com.bupt626.common.base.Text;
import com.bupt626.domain.Organization;
import com.bupt626.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public List<Text> findByLevel(int level){
        List<Organization> OrganizationList;
        OrganizationList = organizationRepository.findByLevel(level);
        List<Text> textList =new ArrayList<Text>();
        for (Organization organization:OrganizationList) {
            Text text=new Text(organization.getId(),organization.getName());
            textList.add(text);
        }
        return textList;
    }
    public Organization findOne(String id){
        return  organizationRepository.findOne(id);
    }

    public List<Organization> findAll(){
        return  organizationRepository.findAll();
    }
    public List<Organization> findBySuperior(String superior){
        return  organizationRepository.findBySuperior(superior);
    }
}
