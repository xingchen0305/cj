package com.bupt.repository;


import com.bupt.domain.CentralLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ycliu
 * @Title: CentralLibraryRepository
 * @Description:
 * @date 2017/06/14 16:51:29
 */
public interface CentralLibraryRepository extends JpaRepository<CentralLibrary, String> {
}
