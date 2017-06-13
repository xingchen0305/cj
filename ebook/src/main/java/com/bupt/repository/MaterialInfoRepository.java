package com.bupt.repository;

import com.bupt.domain.MaterialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author yaosiyu
 *
 */
@Repository
public interface MaterialInfoRepository extends JpaRepository<MaterialInfo, String> {

}
