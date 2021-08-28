package com.hello.RestApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hello.RestApi.model.Book;

@Repository
public interface BookDao  extends JpaRepository<Book, Integer>  {

}
