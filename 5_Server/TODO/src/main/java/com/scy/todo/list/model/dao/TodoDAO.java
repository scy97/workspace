package com.scy.todo.list.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class TodoDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public TodoDAO() {
		try {
			prop = new Properties();
		
			String filePath = TodoDAO.class.getResource("/com/scy/todo/sql/list-sql.xml").getPath();
		
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
