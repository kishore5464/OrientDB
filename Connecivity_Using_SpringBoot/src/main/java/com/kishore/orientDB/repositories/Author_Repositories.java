package com.kishore.orientDB.repositories;

import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

import com.kishore.orientDB.models.Author;

@Repository
public interface Author_Repositories extends OrientObjectRepository<Author> {

}
