<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="resources/css/index.css">
    </head>

    <body>
        <main>
            <section id="loginSection">
                <div>login</div>

                <form action="member/login" method="post" class="loginForm">
                    <input type="text" id="inputId" name="inputId" placeholder="아이디">
                    <input type="password" id="inputPw" name="inputPw" placeholder="패스워드">

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
    </body>

    </html>