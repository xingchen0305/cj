package com.bupt626.repository;

import com.bupt626.entity.CommodityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by i-hexiuyu on 2017/7/11.
 */
@Repository
public interface CommodityTypeRepository extends JpaRepository<CommodityType, Integer> {
}
