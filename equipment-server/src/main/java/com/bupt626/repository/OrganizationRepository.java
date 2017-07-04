package com.bupt626.repository;

import com.bupt626.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by CJ on 2017/6/18.
 */
@RepositoryRestResource()
public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
