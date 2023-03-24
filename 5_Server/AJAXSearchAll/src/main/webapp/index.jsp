<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AJAX 회원 전체 조회</title>
</head>
<body>
    <h3>회원 목록 조회</h3>
    <p>일정 시간 마다 비동기로 회원 목록(회원 번호, 이메일, 닉네임) 조회</p>

    <table border="1">
        <thead>
        <tr>
            <th>회원번호</th>
            <th>이메일</th>
            <th>닉네임</th>
        </tr>
    </thead>
    <tbody id="content">
        <tr>
        </tr>
    </tbody>
    </table>

    <hr>
    <h3>데이터 입력</h3>
    <form action="input" method="post">
        이메일 : <input type="email" name="email" required>
        패스워드 : <input type="password" name="pw" required>
        닉네임 : <input type="text" name="nickname" required>
        전화번호 : <input type="number" name="phone" required>
        주소 : <input type="text" name="addr" required>

        <button type="button" id="input">입력</button>
    </form>

    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    
</body>
</html>