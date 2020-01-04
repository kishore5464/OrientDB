package com.kishore.orientDB.business.interfaces;

import java.util.List;

import com.kishore.orientDB.models.Books;

public interface Books_Interface {

	List<Books> getAllBooks();

	Books insertBooks(Books Books);
}
