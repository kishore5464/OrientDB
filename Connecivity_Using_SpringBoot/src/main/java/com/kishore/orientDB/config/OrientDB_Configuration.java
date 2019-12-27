package com.kishore.orientDB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;

@Component
public class OrientDB_Configuration {

	@Autowired
	private OrientDB orientDB;

	@Autowired
	private ODatabaseSession oDatabaseSession;
	
	
}
