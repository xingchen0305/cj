package com.bupt.repository;

import com.bupt.domain.SiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 
 * @author yaosiyu
 *
 */

@RepositoryRestResource()
public interface SiteInfoRepository extends JpaRepository<SiteInfo, String> {

}
