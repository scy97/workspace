package edu.kh.jdbc.run;

import java.sql.ResultSet;
import java.util.Scanner;

import edu.kh.jdbc.model.service.TestService;

public class Run4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("조회할 테이블 이름 입력 : ");
		String table_name = sc.next();
		
		TestService service = new TestService();
		
		try {
			ResultSet result = service.select(table_name);
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
