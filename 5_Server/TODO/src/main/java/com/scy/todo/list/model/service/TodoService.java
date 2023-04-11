package com.scy.todo.list.model.service;

import java.sql.Connection;
import java.util.List;

import static com.scy.todo.common.JDBCTemplate.*;
import com.scy.todo.list.model.dao.TodoDAO;
import com.scy.todo.list.model.vo.Todo;

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

	public List<Todo> loadList() throws Exception {
		Connection conn = getConnection();
		
		List<Todo> todoList = dao.loadList(conn);
		
		close(conn);
		
		return todoList;
	}

	public int removeList(int listNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.removeList(conn, listNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int CheckList(int listNo, boolean listCheck) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.CheckList(conn, listNo, listCheck);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
