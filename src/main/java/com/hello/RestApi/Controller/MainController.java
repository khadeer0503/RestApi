package com.hello.RestApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hello.RestApi.Service.BookService;
import com.hello.RestApi.model.Book;

@RestController
public class MainController {
	@Autowired
 private BookService bookService;
	private Optional byId;

public BookService getBookService() {
	return bookService;
}

public void setBookService(BookService bookService) {
	this.bookService = bookService;
}
 @PostMapping("/add")
public ResponseEntity<Book> Add(@RequestBody Book book)
{
	 Book add=null;
try {
	add = this. bookService.add(book);
	return ResponseEntity.status(HttpStatus.CREATED).build();
	
	 }catch (Exception e)
	{
	 e.printStackTrace();
	}

return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}

 @PutMapping("/update/{id}")
public ResponseEntity<Book> update(@RequestBody Book book,@PathVariable("id") int id)
{
try {
	Book update = this. bookService. update(book);
	return ResponseEntity.status(HttpStatus.CREATED).build();
	
	 }catch (Exception e)
	{
	 e.printStackTrace();
	}
	return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	 
}
 
 @DeleteMapping("/delete/{id}")
public ResponseEntity<Book> deleteById(@PathVariable("id") int id)
{
try {
	this. bookService. deleteById(id);
	return ResponseEntity.status(HttpStatus.GONE).build();
	
	 }catch (Exception e)
	{
	 e.printStackTrace();
	}
	return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	 
}
 @GetMapping("/get/{id}")
 public ResponseEntity<Book> getById(@PathVariable("id") int id)
 {
	// BookService b=null;
 try {
 	//b= (BookService)
	 Book byId = this.bookService. getById(id);
 	if(byId==null)
 	
 	return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
 	 }catch (Exception e)
 	{
 	 e.printStackTrace();
 	}
	return ResponseEntity.status(HttpStatus.CREATED).build();	 
 }
 @GetMapping("/getAll")
 public ResponseEntity<List<Book>> getAll()
 {
	 List<Book> all = this. bookService. getAll();
 try {
 	if(all.size()<=0)

 		 return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
 	 
 	
 	 }catch (Exception e)
 	{
 	 e.printStackTrace();
 	}
 return ResponseEntity.status(HttpStatus.CREATED).body(all);
 }
}
