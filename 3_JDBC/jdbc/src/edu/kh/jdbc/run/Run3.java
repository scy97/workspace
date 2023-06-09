package edu.kh.jdbc.run;

import java.util.Scanner;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run3 {

	public static void main(String[] args) {
		TestService service = new TestService();
		Scanner sc = new Scanner(System.in);

		System.out.println("번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.println("제목 : ");
		String title = sc.next();
		
		System.out.println("내용 : ");
		String content = sc.next();
		
		System.out.println("수정할 컬럼 번호 : ");
		int no = sc.nextInt();

		TestVO vo1 = new TestVO(num, title, content);

		try {
			int result = service.update(vo1, no);
			if (result > 0)
				System.out.println("update 성공");
			else
				System.out.println("update 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
