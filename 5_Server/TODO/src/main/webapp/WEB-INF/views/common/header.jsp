<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <header>
            <section id="menu">
                <img src="${contextPath}/resources/images/bars-solid.svg" id="menuBtn">
            </section>

            <section id="logo">
                <a href="${contextPath}/main"> <img src="${contextPath}/resources/images/check-solid.svg"> <span>ToDo</span>
                </a>
            </section>

            <section id="search">
                <img src="${contextPath}/resources/images/magnifying-glass-solid.svg" id="searchBtn">
            </section>
        </header>