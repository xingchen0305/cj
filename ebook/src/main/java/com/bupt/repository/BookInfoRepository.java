package com.bupt.repository;


import com.bupt.domain.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ycliu
 * @Title: BookInfoReposition
 * @Description:
 * @date 2017/06/15 22:07:05
 */
public interface BookInfoRepository extends JpaRepository<BookInfo, String> {
}
