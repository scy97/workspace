console.log("main.js loaded.");

function load() {
    console.log("function loaded");

    const content = document.getElementById("content");
    $.ajax({
        url: "member/searchAll",
        type: "POST",
        dataType: "JSON",

        success: function (member) {
            content.innerHTML = "";

            $(member).each(function () {
                console.log(this);

                if (this != null) {
                    const tr = document.createElement("tr");

                    const td1 = document.createElement("td");
                    td1.innerText = this.memberNo;

                    const td2 = document.createElement("td");
                    td2.innerText = this.memberEmail;

                    const td3 = document.createElement("td");
                    td3.innerText = this.memberNickname;

                    tr.append(td1, td2, td3);

                    content.append(tr);
                }

            });
        },

        error: function () {
            console.log("AJAX Error");
            console.log("code : " + request.status);
        }
    })
};

window.onload = load;

setInterval(() => {
    load()
}, 10000);

const input = document.querySelectorAll("#inputData>input");

console.log(input);

document.getElementById("input").addEventListener("click", function () {
    $.ajax({
        url: "member/input",
        data: {
            "email": input[0].value, "inputPw": input[1].value,
            "nickname": input[2].value, "phone": input[3].value,
            "addr": input[4].value
        },
        type: "POST",
        dataType: "JSON",

        success: function (result) {
            console.log(result);
        },

        error: function () {
            console.log("fail");
            console.log("code : " + request.status);
        }
    })
});

// 회원 정보 조회 비동기 통신(AJAX)
document.getElementById("select1").addEventListener("click", function () {
    const input = document.getElementById("in1");
    const div = document.getElementById("result1");

    // AJAX 코드 작성(jQuery 방식)
    $.ajax({
        url: "member/selectOne",
        data: { "memberEmail": input.value },
        type: "POST",
        dataType: "JSON", // dataType: 응답 데이터 형식을 지정
        // -> "JSON"으로 지정 시 자동으로 JS 객체로 변환
        success: function (member) {
            console.log(member);

            // 1) div에 작성된 내용 모두 삭제
            div.innerHTML = "";

            if (member != null) { // 회원 정보 존재 O

                // 2) ul 요소 생성
                const ul = document.createElement("ul");

                // 3) li 요소 생성 * 5 + 내용 추가
                const li1 = document.createElement("li");
                li1.innerText = "이메일 : " + member.memberEmail;

                const li2 = document.createElement("li");
                li2.innerText = "닉네임 : " + member.memberNickname;

                const li3 = document.createElement("li");
                li3.innerText = "전화번호 : " + member.memberTel;

                const li4 = document.createElement("li");
                li4.innerText = "주소 : " + member.memberAddress;

                const li5 = document.createElement("li");
                li5.innerText = "가입일 : " + member.enrollDate;

                // 4) ul에 li를 순서대로 추가
                ul.append(li1, li2, li3, li4, li5);

                // 5) div에 ul 추가
                div.append(ul);

            } else { // 회원 정보 존재 X

                // 1) h4 요소 생성
                const h4 = document.createElement("h4");

                // 2) 내용 추가
                h4.innerText = "일치하는 회원이 없습니다";

                // 3) 색 추가
                h4.style.color = "red";

                // 4) div에 추가
                div.append(h4);
            }
        },

        error: function () {
            console.log("AJAX 에러 발생");
            console.log("상태코드 : " + request.status); // 404, 500
        }
    })
});