package com.kishore.orientDB.repositories;

import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

import com.kishore.orientDB.models.Books;

@Repository
public interface Books_Repositories extends OrientObjectRepository<Books> {

}
