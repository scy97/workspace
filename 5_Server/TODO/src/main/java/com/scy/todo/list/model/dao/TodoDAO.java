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

	public List<Todo> loadList(Connection conn, String option) throws Exception {
		List<Todo> todoList = new ArrayList<>();
		String sql = null;
		
		try {
			
			switch (option) {
			case "all":
				sql = prop.getProperty("loadList");
				pstmt = conn.prepareStatement(sql);
				break;
				
			case "doing":
				sql = prop.getProperty("optionLoad");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "N");
				break;
				
			case "done":
				sql = prop.getProperty("optionLoad");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "Y");
				break;
			}
			

			rs = pstmt.executeQuery();

			while (rs.next()) {			
				Todo todo = new Todo();
				todo.setListNo(rs.getInt("LIST_NO"));
				todo.setListText(rs.getString("LIST_TEXT"));
				todo.setListCheck(rs.getString("LIST_CHECK"));
				todoList.add(todo);
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
