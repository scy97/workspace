<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/signUp.css">
</head>

<body>
    <main>
        <div>회원 가입</div>

        <form action="signUp" method="post" class="signUpForm" onsubmit="signUpValidate()">
            <label for="inputMail">메일</label>
            <section>
                <input type="email" name="inputMail" id="inputMail" placeholder="메일" autocomplete="off" autofocus
                    required>
                <button type="button" id="inputMailBtn">인증번호 보내기</button>
            </section>
            <div id="mailMessage"></div>

            <label for="checkNum">인증번호</label>
            <section>
                <input type="text" name="checkNum" id="checkNum" placeholder="인증번호" required>
                <button type="button" id="checkNumBtn">인증번호 확인</button>
            </section>
            <div id="checkNumMessage"></div>

            <label for="inputId">아이디</label>
            <section>
                <input type="text" name="inputId" id="inputId" placeholder="아이디" autocomplete="off" required>
            </section>
            <div id="inputIdMessage">5~20자의 영문 소문자, 숫자와 특수기호(_), (-)만 사용 가능합니다.</div>

            <label for="inputPw">비밀번호</label>
            <input type="password" name="inputPw" id="inputPw" placeholder="비밀번호" required>
            <div id="inputPwMessage">6~30자의 영어 대소문자, 숫자, 특수기호(_), (-), (!), (@), (#)를 1자 이상 포함하여 작성 해주세요.</div>

            <label for="confirmPw">비밀번호 확인</label>
            <input type="password" name="confirmPw" id="confirmPw" placeholder="비밀번호 확인" required>
            <div id="confirmPwMessage"></div>

            <label for="inputName">이름</label>
            <input type="text" name="inputName" id="inputName" placeholder="이름" required>
            <div id="inputNameMessage">2~30자의 한글, 영어, 특수기호 (_), (-)만 사용 가능합니다.</div>

            <button id="signUpBtn">가입</button>
        </form>
    </main>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/signUp.js"></script>
</body>

</html>