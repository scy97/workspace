package com.scy.todo.list.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.scy.todo.list.model.vo.Todo;

import static com.scy.todo.common.JDBCTemplate.*;

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

	public int addList(Connection conn, String inputText) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("addList");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inputText);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<Todo> loadList(Connection conn) throws Exception {
		List<Todo> todoList = new ArrayList<>();

		try {
			String sql = prop.getProperty("loadList");
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int listNo = rs.getInt("LIST_NO");
				String listText = rs.getString("LIST_TEXT");
				String listCheck = rs.getString("LIST_CHECK");
				todoList.add(new Todo(listNo, listText, listCheck));
			}
		} finally {
			close(pstmt);
			close(rs);
		}
		return todoList;
	}

	public int removeList(Connection conn, int listNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("remove");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, listNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int CheckList(Connection conn, int listNo, boolean listCheck) throws Exception {
		int result = 0;
		String temp = null;
		
		try {
			String sql = prop.getProperty("check");
			pstmt = conn.prepareStatement(sql);
			
			if(listCheck == true) {
				temp = "Y";
			} else {
				temp = "N";
			}
			
			pstmt.setString(1, temp);
			pstmt.setInt(2, listNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
