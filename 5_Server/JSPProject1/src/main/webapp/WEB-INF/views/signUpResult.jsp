<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
    p {
    	font-weight: bold;
    	font-size: 20px;
    }
    </style>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	String hobby[] = request.getParameterValues("hobby");
	String result = (String)request.getAttribute("r");
%>
    <ul>
        <li>아이디 : <%= id %></li>
        <li>비밀번호 : <%= pw %></li>
        <li>이름 : <%= name %></li>
        <li>이메일 : <%= mail %></li>
        <li>취미 : 
        <% for (String i : hobby) { %>
        <%=i %>
        <% } %>
        </li>
    </ul>
    
    <p><%=name %><%=result %></p>
</body>
</html>