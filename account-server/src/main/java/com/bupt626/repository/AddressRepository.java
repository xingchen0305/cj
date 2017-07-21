package com.bupt626.repository;

import com.bupt626.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by i-hexiuyu on 2017/7/17.
 */

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
