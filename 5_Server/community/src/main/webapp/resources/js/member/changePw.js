const checkObj = {
    "newPw": false,
    "newPwConfirm": false
};
const currentPw = document.getElementById("currentPw");
const newPw = document.querySelector(".myPage-row>input[name='newPw']");
const newPwConfirm = document.querySelector(".myPage-row>input[name='newPwConfirm']");
const currentPwMessage = document.getElementById("currentPwMessage");
const newPwMessage = document.getElementById("newPwMessage");
const newPwConfirmMessage = document.getElementById("newPwConfirmMessage");

// 비밀번호 유효성 검사
newPw.addEventListener("input", function () {

    if (newPw.value.length == 0) {
        newPwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.";
        newPwMessage.classList.remove("confirm", "error");

        checkObj.newPw = false; // 유효 X 기록
        return;
    }

    const regExp = /^[\w!@#_-]{6,30}$/;

    if (regExp.test(newPw.value)) { // 비밀번호 유효

        checkObj.newPw = true; // 유효 O 기록

        if (newPwConfirm.value.length == 0) { // 비밀번호 유효, 확인 작성 X
            newPwMessage.innerText = "유효한 비밀번호 형식입니다.";
            newPwMessage.classList.add("confirm");
            newPwMessage.classList.remove("error");

        } else { // 비밀번호 유효, 확인 작성 O
            checkPw(); // 비밀번호 일치 검사 함수 호출()
        }

    } else {
        newPwMessage.innerText = "비밀번호 형식이 유효하지 않습니다.";
        newPwMessage.classList.add("error");
        newPwMessage.classList.remove("confirm");

        checkObj.newPw = false; // 유효 X 기록
    }
});


// 비밀번호 확인 유효성 검사

// 함수명() : 함수 호출(수행)
// 함수명   : 함수에 작성된 코드 반환
newPwConfirm.addEventListener("input", checkPw);
// -> 이벤트가 발생 되었을 때 정의된 함수를 호출하겠다


function checkPw() { // 비밀번호 일치 검사
    // 비밀번호 / 비밀번호 확인이 같을 경우
    if (newPw.value == newPwConfirm.value) {
        newPwConfirmMessage.innerText = "비밀번호가 일치합니다.";
        newPwConfirmMessage.classList.add("confirm");
        newPwConfirmMessage.classList.remove("error");

        checkObj.newPwConfirm = true; // 유효 O 기록

    } else {
        newPwConfirmMessage.innerText = "비밀번호가 일치하지 않습니다.";
        newPwConfirmMessage.classList.add("error");
        newPwConfirmMessage.classList.remove("confirm");

        checkObj.newPwConfirm = false; // 유효 X 기록
    }
}

// 수정하기 버튼 클릭 시 유효성 검사가 완료 되었는지 확인하는 함수
function changePwValidate() {

    // checkObj 있는 모든 속성을 반복 접근하여
    // false가 하나라도 있는 경우에는 form태그 기본 이벤트 제거

    let str;

    for (let key in checkObj) { // 객체용 향상된 for문

        // 현재 접근 중인 key의 value가 false인 경우
        if (!checkObj[key]) {

            switch (key) {
                case "newPw": str = "새 비밀번호가"; break;
                case "newPwConfirm": str = "새 비밀번호 확인이"; break;
            }

            str += " 유효하지 않습니다.";

            alert(str);

            document.getElementById(key).focus();

            return false; // form태그 기본 이벤트 제거
        }
    }

    return true; // form태그 기본 이벤트 수행

}