<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <footer> footer </footer>

    <c:if test="${!empty sessionScope.message}">
            <script>
                alert("${message}");
            </script>

            <c:remove var="message" scope="session" />
        </c:if>