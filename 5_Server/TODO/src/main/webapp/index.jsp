<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ToDo List</title>
        <link rel="stylesheet" href="resources/css/index.css">
    </head>

    <body>
        <main>
            <section id="loginSection">
                <article id="logo">
                    <img src="${contextPath}/resources/images/check-solid.svg">
                    <span>ToDo</span>
                </article>

                <form action="member/login" method="post" class="loginForm">
                    <input type="text" name="inputId" id="inputId" placeholder="아이디" autofocus required>
                    <input type="password" name="inputPw" id="inputPw" placeholder="패스워드" required>

                    <article id="signUp-find-area">
                        <div>
                            <a href="#">회원가입</a>
                            <span>&nbsp;|&nbsp;</span>
                            <a href="#">ID/PW찾기</a>
                        </div>

                        <div>
                            <button id="loginBtn">로그인</button>
                        </div>
                    </article>
                </form>
            </section>
        </main>

        <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    </body>

    </html>