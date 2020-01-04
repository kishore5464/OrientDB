package com.kishore.orientDB.business.interfaces;

import java.util.List;

import com.kishore.orientDB.models.Author;

public interface Author_Interface {

	List<Author> getAllAuthors();
	
	Author insertAuthor(Author athor);
}
