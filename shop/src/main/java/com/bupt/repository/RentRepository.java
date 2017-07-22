package com.bupt.repository;

import com.bupt.domain.Book;
import com.bupt.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ycliu
 * @Title: BookRepository
 * @Description:
 * @date 2017/07/21 20:08:10
 */
public interface RentRepository extends JpaRepository<Rent, String> {
}
