<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ToDo List</title>

<link rel="stylesheet" href="${contextPath}/resources/css/main.css">

<script src="https://kit.fontawesome.com/144bd71f16.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<main>
		<section id="content">
			<section>
					<textarea id="inputText" name="inputText" rows="1"
						placeholder="해야 할 일을 입력해주세요." autofocus></textarea>
					<button id="addBtn"></button>
			</section>

			<section class="history">
				<form action="#" id="historyList">
					<div>
						<input type="checkbox" id="listCheckBtn1" class="listCheckBtn">
						<label for="listCheckBtn1"></label>
						<div class="todoText">test</div>
						<div class="listRemoveBtn"></div>
					</div>
				</form>
			</section>

			<section id="option">
				<div id="listCount">0개</div>

				<div id="all">전체</div>
				<div id="doing">진행중</div>
				<div id="done">완료</div>
			</section>
		</section>
	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>

	<script src="${contextPath}/resources/js/main.js"></script>
</body>

</html>