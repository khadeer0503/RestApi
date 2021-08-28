package com.hello.RestApi.Service;

import java.util.List;

import com.hello.RestApi.model.Book;

public interface BookService {

	public Book add(Book book);
	public Book update(Book book);
	public void deleteById(int id);
	public Book getById(int id);
	public List<Book> getAll();
}
