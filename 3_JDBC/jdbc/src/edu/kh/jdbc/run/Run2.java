package edu.kh.jdbc.run;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run2 {

	public static void main(String[] args) {
		TestService service = new TestService();
		
		TestVO vo1 = new TestVO(1, "제목1", "내용1");
		TestVO vo2 = new TestVO(2, "제목2", "내용2");
		TestVO vo3 = new TestVO(3, "제목3", "내용3");
		
		try {
			int result = service.insert(vo1, vo2, vo3);
			
			if (result > 0)
				System.out.println("insert 성공");
			else
				System.out.println("insert 실패");
			
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

}
