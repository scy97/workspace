package com.scy.todo.list.model.service;

import java.sql.Connection;
import java.util.List;

import static com.scy.todo.common.JDBCTemplate.*;
import com.scy.todo.list.model.dao.TodoDAO;
import com.scy.todo.list.model.vo.Todo;

public class TodoService {
	private TodoDAO dao = new TodoDAO();

	public int addList(String inputText, int loginMemberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.addList(conn, inputText, loginMemberNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public List<Todo> loadList(String option, int loginMemberNo) throws Exception {
		Connection conn = getConnection();
		
		List<Todo> todoList = dao.loadList(conn, option, loginMemberNo);
		
		close(conn);
		
		return todoList;
	}

	public int removeList(int listNo, int loginMemberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.removeList(conn, listNo, loginMemberNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
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
		
		close(conn);
		
		return result;
	}
}
