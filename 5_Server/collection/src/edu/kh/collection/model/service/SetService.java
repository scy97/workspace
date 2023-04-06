package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Student;

public class SetService {
	// - 순서 유지하지 않음 (인덱스 X)
	// - 중복데이터 저장 불가 (null도 1개만 저장 가능)

	public void ex1() {
		Set<String> set = new HashSet<String>();
		set.add("네이버");
		set.add("네이버");
		set.add("카카오");
		set.add("카카오");
		set.add("라인");
		set.add("라인");
		set.add("소프트뱅크");
		set.add("소프트뱅크");
		set.add(null);
		set.add(null);
		set.add(null);

		set.remove("카카오");
		System.out.println(set.toString());

		// Set에 저장된 요소 하나씩 얻어오기
		// 1. Iterator (반복자)
		// -> 컬렉션에서 제공하는 컬렉션 객체 반복 접근자

		Iterator<String> it = set.iterator();

		// Set.iterator();
		// Set에 저장된 객체를 이용해서 Iterator 객체를 만들어 반환

		while (it.hasNext()) {
			// hasNext() : 다음값이 존재하면 true

			String temp = it.next();

			System.out.println(temp);
		}

		System.out.println("============================================================");

		// 2. 향상된 for문
		for (String temp : set) {
			System.out.println(temp);
		}
	}

	public void ex2() {
		// Set에 저장된 객체가 중복임을 판단하는 방법

		// 필드에 저장된 값이 모두 일치하면 중복으로 판단
		// -> 중복 판단에 사용하는 메소드는
		// Object.equals() -> Student 오버라이딩

		// Hash라는 단어가 붙은 컬렉션이 중복을 판단하는 방법
		// -> Object.hashCode() 오버라이딩

		// hashCode() : 객체에 저장된 필드를 이용해서 만들어진 정수를 반환

		// HashSet -> equals(), hashCode() 둘 다 오버라이딩 되어 있어야 함

		Set<Student> set = new HashSet<Student>();

		set.add(new Student("홍길동", 15, "서울시 중구", 'M', 50));
		set.add(new Student("김길순", 17, "서울시 종로구", 'F', 100));
		set.add(new Student("홍길동", 15, "서울시 중구", 'M', 50));

		for (Student s : set) {
			System.out.println(s);
		}
	}
	
	public void ex3() {
		// TreeSet : 오름차순으로 정렬되고 중복 제거되는 Set
		
		Set<Integer> lotto = new TreeSet<Integer>();
		
		while (lotto.size() < 6) {
			int ran = (int)(Math.random() * 45 + 1); // 1 ~ 45 난수
			lotto.add(ran);
		}
		
		System.out.println(lotto);
	}
}
