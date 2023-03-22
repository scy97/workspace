<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>경영학과 학과 검색 결과</title>
            <style>
                table {
                    text-align: center;
                    border-collapse: collapse;
                }

                thead {
                    background-color: black;
                    color: white;
                    font-weight: bold;
                }

                th {
                    width: 100px;
                    height: 30px;
                }

                tr>td:last-child {
                    text-align: left;
                    width: 600px;
                }
            </style>

        </head>

        <body>
            <table>
                <thead>
                    <tr>
                        <th>순서</th>
                        <th>학번</th>
                        <th>이름</th>
                        <th>학과</th>
                        <th>주소</th>
                    </tr>
                </thead>
                <c:forEach var="student" items="${stdList}" varStatus="vs">
                    <tr>
                        <td>${vs.count}</td>
                        <td>${student.studentNo}</td>
                        <td>${student.studentName}</td>
                        <td>${student.departmentName}</td>
                        <td>${student.studentAddress}</td>
                    </tr>
                </c:forEach>
            </table>
            <script>
                const arr = document.querySelectorAll("tr");
                for (let i = 1; i < arr.length; i++) {
                    if ((i%2) == 0) {
                        arr[i].style.backgroundColor = "lightgray";
                    }
                }
            </script>
        </body>

        </html>