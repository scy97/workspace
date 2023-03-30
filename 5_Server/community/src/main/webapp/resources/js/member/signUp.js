// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    "memberEmail": false,
    "memberPw": false,
    "memberPwConfirm": false,
    "memberNickname": false,
    "memberTel": false,
    "sendEmail": false,
};

// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");

memberEmail.addEventListener("input", function () {

    // 입력이 되지 않은 경우
    if (memberEmail.value.length == 0) {
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";
        emailMessage.classList.remove("confirm", "error");

        checkObj.memberEmail = false; // 유효 X 기록
        return;
    }

    // 입력이 된 경우
    const regExp = /^[\w\-\_\.]{4,}@[\w\-\_]+(\.\w+){1,3}$/;
    if (regExp.test(memberEmail.value)) { // 유효한 경우
        // 이메일 중복 검사(ajax) 진행 예정
        $.ajax({
            url: "emailDupCheck",
            // 필수속성 url
            // 현재 주소 : /community/member/signUp
            // 상대 경로 : /community/member/emailDupCheck

            data: { "memberEmail": memberEmail.value },
            // data 속성 : 비동기 통신 시 서버로 전달한 값을 작성(JS 객체 형식)
            // -> 비동기 통신 시 input에 입력된 값을
            // "memberEmail" 이라는 key값(파라미터)으로 전달

            success: function (result) {
                // 비동기 통신(ajax)가 오류 없이 요청 / 응답 성공한 경우

                // 매개변수 result : servlet에서 출력된 result 값이 담겨있음.
                console.log(result);

                if (result == 1) { // 중복 O
                    emailMessage.innerText = "이미 사용중인 이메일 입니다.";
                    emailMessage.classList.add("error");
                    emailMessage.classList.remove("confirm");
                    checkObj.memberEmail = false;
                } else { // 중복 X
                    emailMessage.innerText = "사용 가능한 이메일 입니다.";
                    emailMessage.classList.add("confirm");
                    emailMessage.classList.remove("error");
                    checkObj.memberEmail = true; // 유효 O 기록
                }
            },

            error: function () {
                // 비동기 통신(ajax)중 오류가 발생한 경우
                console.log("에러 발생");
            }
        });

    } else {
        emailMessage.innerText = "이메일 형식이 유효하지 않습니다.";
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");

        checkObj.memberEmail = false; // 유효 X 기록
    }

});

// 정규표현식


// 인증번호 보내기
const sendBtn = document.getElementById("sendBtn");

sendBtn.addEventListener("click", function () {

    if (checkObj.memberEmail) { // 유효한 이메일이 작성되어 있을 경우에만 메일 보내기
        $.ajax({
            url: "sendEmail",
            data: { "inputEmail": memberEmail.value },
            success: function (result) {
                console.log("이메일 발송 성공");
                console.log(result);

                // 인증 버튼이 클릭되어 정상적으로 메일이 보내졌음을
                checkObj.sendEmail = true;
            },

            error: function () {
                console.log("이메일 발송 실패");
            }
        });
    }
});

const memberPw = document.getElementById("memberPw");
const pwMessage = document.getElementById("pwMessage");
const pwRegExp = /^[\w!@#_-]{6,30}$/;


const memberPwConfirm = document.getElementById("memberPwConfirm");

memberPwConfirm.addEventListener("input", function () {
    if (memberPwConfirm.value.length == 0) {
        pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.";
        pwMessage.classList.remove("confirm", "error");

        checkObj.memberPwConfirm = false;
        return;
    } else if (memberPw.value == memberPwConfirm.value && pwRegExp.test(memberPw.value)) {
        pwMessage.innerText = "비밀번호가 일치합니다.";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

        checkObj.memberPwConfirm = true;
    } else if (pwRegExp.test(memberPw.value) == false) {
        pwMessage.innerText = "비밀번호 형식이 유효하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPwConfirm = false;
    } else {
        pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPwConfirm = false;
    }
});

memberPw.addEventListener("input", function () {
    if (memberPw.value.length == 0) {
        pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.";
        pwMessage.classList.remove("confirm", "error");

        checkObj.memberPw = false;
        return;
    } else if (memberPw.value == memberPwConfirm.value && pwRegExp.test(memberPw.value)) {
        pwMessage.innerText = "비밀번호가 일치합니다.";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

        checkObj.memberPw = true;
    } else if (pwRegExp.test(memberPw.value) == false && memberPwConfirm.value.length > 0) {
        pwMessage.innerText = "비밀번호 형식이 유효하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPw = false;
    } else if ((memberPw.value == memberPwConfirm.value) == false && memberPwConfirm.value.length > 0) {
        pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPw = false;
    } else {
        pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.";
        pwMessage.classList.remove("confirm", "error");

        checkObj.memberPw = false;
    }
});

const signUpbtn = document.getElementById("signUp-btn");

signUpbtn.addEventListener("click", function () {

});