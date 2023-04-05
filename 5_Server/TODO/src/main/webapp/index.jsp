<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>ToDo Lsit</title>

            <link rel="stylesheet" href="./ToDo.css">
            <script src="https://kit.fontawesome.com/144bd71f16.js" crossorigin="anonymous"></script>
        </head>

        <body>
            <main>
                <header>
                    <section id="menu">
                        <i class="fa-solid fa-bars" id="menuBtn" class="button"></i>
                    </section>

                    <section id="logo">
                        <a href="#">
                            <i class="fa-solid fa-check"></i>
                            <span>ToDo</span>
                        </a>
                    </section>

                    <section id="search">
                        <i class="fa-solid fa-magnifying-glass" id="searchBtn" class="button"></i>
                    </section>
                </header>

                <section id="content">
                    <fieldset>
                        <section>
                            <form action="#">
                                <textarea id="input_todo" rows="1" placeholder="해야 할 일을 입력해주세요." autofocus></textarea>
                                <!-- <div id="sendBtn"><i class="fa-solid fa-plus"></i></div> -->
                                <button><i class="fa-solid fa-plus"></i></button>
                            </form>
                        </section>

                        <section id="history">
                            <div>
                                <input type="checkbox" class="listCheckBtn" id="listCheckBtn1" aria-label="check">
                                <label for="listCheckBtn1"></label>
                                <div class="todoText">
                                    test
                                </div>
                                <div class="listRemoveBtn">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </section>

                        <section id="option">
                            <section>
                                <div id="listCount">0개</div>
                            </section>
                            <section>
                                <div id="all">전체</div>
                                <div id="doing">진행중</div>
                                <div id="done">완료</div>
                            </section>
                            <section>
                                <div id="removeAll">전체 삭제</div>
                            </section>
                        </section>

                    </fieldset>
                </section>

                <footer>
                    footer
                </footer>
            </main>
            <script src="./ToDo.js"></script>
        </body>

        </html>