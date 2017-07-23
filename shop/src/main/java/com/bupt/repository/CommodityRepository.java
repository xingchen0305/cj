package com.bupt.repository;

import com.bupt.domain.Commodity;
import com.bupt.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ycliu
 * @Title: BookRepository
 * @Description:
 * @date 2017/07/21 20:08:10
 */
public interface CommodityRepository extends JpaRepository<Commodity, String> {
}
