package com.bupt626.repository;

import com.bupt626.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hexiuyu on 2017/1/19.
 */
@RepositoryRestResource
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
