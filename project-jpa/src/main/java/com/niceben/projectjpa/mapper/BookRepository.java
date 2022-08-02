package com.niceben.projectjpa.mapper;

import com.niceben.projectjpa.model.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository定义
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
