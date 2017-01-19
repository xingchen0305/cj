package com.qydcos.be.repository;

import com.qydcos.be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByCodeIn(String... code);
}
