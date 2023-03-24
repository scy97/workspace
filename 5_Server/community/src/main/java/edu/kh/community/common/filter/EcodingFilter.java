package edu.kh.community.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

// 필터 (Filter)
// - 클라이언트 요청 시 생성되는
// HttpServletRequest, HttpServletResponse가
// 요청을 처리하는 Servlet에 도달하기 전에
// 특정 코드를 수행하는 클래스

// [요청흐름]
// 클라이언트 -> 요청 -> HttpServletRequest/Response 생성
// -> 필터 -> 요청처리 Servlet

// - 여러 필터를 만들어서 연쇄적으로 연곃하여 수행할 수 있다.(FilterChain)

// @WebFilter("url 패턴")
// - 해당 클래스를 필터 클래스로 등록
// - url 패턴에 일치하는 요청이 있을 경우 해당 요청을 필터링함

// filterName 속성 : 필터의 이름을 지정, 필터 순서 지정 시 사용
// urlPatterns 속성 : 요청 주소 패턴

//	/ == /community == 최상위 주소
// 	* == 모든
//	/* == 최상위 주소 하위 모든 == 모든 요청

@WebFilter(filterName="encodingFilter", urlPatterns="/*")
public class EcodingFilter extends HttpFilter implements Filter {
	
	// 서버 실행 시 또는 코드 변경 시
	// 필터 객체가 자동 생성되는데
	// 그때, 필터에 필요한 내용을 초기화하는 메서드
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("문자 인코딩 필터 초기화");
	}
	
	// 서버 실행 중 필터 코드가 변경되어
	// 기존 필터를 엇애야 할 때 수행되는 메서드
	public void destroy() {
		System.out.println("문자 인코딩 필터 파괴");
	}
	
	// 필터 역할을 수행하는 메서드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ServletRequest == HttpServletRequest의 부모타입
		// ServletResponse == HttpServletResponse의 부모타입
		// -> 필요 시 다운 캐스팅
		
		// 모든 요청의 문자 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 모든 응답의 문자 인코딩을 UTF-8로 설정
		response.setCharacterEncoding("UTF-8");
		
		// ---------------------------------------------------
		
		// application scope로 최상위 경로를 얻어올 수 있는 값 세팅
		
		// 1) application 내장 객체 얻어오기
		ServletContext application = request.getServletContext();
		
		// 2) 최상위 주소 얻어오기
		String contextPath = ((HttpServletRequest)request).getContextPath();
		
		// 3) 세팅
		application.setAttribute("contextPath", contextPath);
		
		// 연결된 다음 필터 수행(없으면 Servlet 수행)
		chain.doFilter(request, response);
		
		
	}
	
	
}





















