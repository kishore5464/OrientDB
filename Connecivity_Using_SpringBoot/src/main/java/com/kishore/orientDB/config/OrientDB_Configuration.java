package com.kishore.orientDB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

@Component
@PropertySource(value = { "application.properties" })
public class OrientDB_Configuration {

	@Value("${orientDB.url}")
	private static String db_url;

	@Value("${orientDB.dbName}")
	private static String db_Name;

	@Value("${orientDB.username}")
	private static String username;

	@Value("${orientDB.password}")
	private static String password;

	@Autowired
	private static OrientDB orientDB = new OrientDB(db_url, OrientDBConfig.defaultConfig());

	@Autowired
	private static ODatabaseSession oDatabaseSession = orientDB.open(db_Name, username, password);

	public static void main(String[] args) {
		creatStudent(oDatabaseSession);
		insertStudent(oDatabaseSession);
		executeQuery(oDatabaseSession);

		oDatabaseSession.close();
		orientDB.close();
	}

	private static void creatStudent(ODatabaseSession oDatabaseSession) {
		OClass oClassStudent = oDatabaseSession.getClass("Family");

		if (oClassStudent == null) {
			oClassStudent = oDatabaseSession.createVertexClass("Family");
		}

		if (oClassStudent.getProperty("name") == null) {
			oClassStudent.createProperty("name", OType.STRING);
			oClassStudent.createProperty("age", OType.INTEGER);
			oClassStudent.createIndex("Family_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
		}

		if (oDatabaseSession.getClass("motherOf") == null || oDatabaseSession.getClass("husbandOf") == null
				|| oDatabaseSession.getClass("sonOf") == null) {
			oDatabaseSession.createEdgeClass("husbandOf");
			oDatabaseSession.createEdgeClass("motherOf");
			oDatabaseSession.createEdgeClass("sonOf");
		}
	}

	private static void insertStudent(ODatabaseSession odatabasesession) {
		OVertex student1 = insertIntoStudent(odatabasesession, "Kishore", 29);
		OVertex student2 = insertIntoStudent(odatabasesession, "Roshini", 25);
		OVertex student3 = insertIntoStudent(odatabasesession, "Kicha", 1);

		OEdge oEdge1 = student1.addEdge(student2, "husbandOf");
		oEdge1.save();

		OEdge oEdge2 = student2.addEdge(student3, "motherOf");
		oEdge2.save();

		OEdge oEdge3 = student3.addEdge(student1, "sonOf");
		oEdge3.save();
	}

	private static OVertex insertIntoStudent(ODatabaseSession odatabasesession, String name, int age) {
		OVertex result = odatabasesession.newVertex("Family");
		result.setProperty("name", name);
		result.setProperty("age", age);
		result.save();

		return result;
	}

	private static void executeQuery(ODatabaseSession odatabasesession) {
		String query = "SELECT expand(out('motherOf').out('husbandOf')) FROM Family WHERE name=?";
		OResultSet oResultSet = odatabasesession.query(query, "Roshini");

		while (oResultSet.hasNext()) {
			OResult members = oResultSet.next();
			System.out.println(members);
		}

		oResultSet.close();
	}

}
