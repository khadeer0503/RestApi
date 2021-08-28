package com.hello.RestApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Author")
public class Author {

	@Id
	@Column(name="Author_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private Long year;
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Author(int id, String name, Long year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", year=" + year + "]";
	}
	
}
