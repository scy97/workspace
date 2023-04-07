package com.scy.todo.list.model.service;

import java.sql.Connection;

import static com.scy.todo.common.JDBCTemplate.*;
import com.scy.todo.list.model.dao.TodoDAO;

public class TodoService {
	private TodoDAO dao = new TodoDAO();

	public int addList(String inputText) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.addList(conn, inputText);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
}
