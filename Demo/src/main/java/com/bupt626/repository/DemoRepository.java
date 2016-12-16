package com.bupt626.repository;

import com.bupt626.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by hexiuyu on 2016/12/16.
 */
@RepositoryRestResource(path = "path")
public interface DemoRepository extends JpaRepository<Demo, Long > {

    /**
     * Spring Rest Data Without Controller
     * <usage>
     *     http://localhost:8080/path
     *     http://localhost:8080/path/search/queryByName?name=hexiuyu
     * </usage>
     */
    @RestResource(path = "queryByName")
    Demo findByName(@Param("name") String name);
}
