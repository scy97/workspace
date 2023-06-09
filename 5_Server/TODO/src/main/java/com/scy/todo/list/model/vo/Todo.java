package com.scy.todo.list.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
	private int listNo;
	private String listText;
	private String listCheck;
	private String enrollDate;
	private int userNo;
}
