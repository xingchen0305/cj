package com.bupt626.repository;

import com.bupt626.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Xtj on 2017/7/11.
 */
public interface BookRepository extends JpaRepository<Book,String > {
}
