package com.hello.RestApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.RestApi.Dao.BookDao;
import com.hello.RestApi.model.Book;
@Service
public class BookServiceImp  implements BookService{
		@Autowired
	private BookDao bookDao;
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override	// Adding
	public Book add(Book book) {
		return	this.bookDao.save(book);
		 
	}

	@Override
	public Book update(Book book) {
		return this.bookDao.save(book)   ;
	}

	@Override
	public void deleteById(int id) {
		 this.bookDao.deleteById(id);
	}

	@Override
	public Book getById(int id) {
		return this.bookDao.getById(id);
	}

	@Override
	public List<Book> getAll() {
		return this.bookDao.findAll();
	}

}
