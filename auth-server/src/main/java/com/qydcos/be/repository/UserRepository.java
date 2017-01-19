package com.qydcos.be.repository;

import com.qydcos.be.entity.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
public interface UserRepository extends JpaRepository<OAuthUser, Long> {

    List<UserDetails> findByUsername(String username);

    int countByUsername(String username);
}
