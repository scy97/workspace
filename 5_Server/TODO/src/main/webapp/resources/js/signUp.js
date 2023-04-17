const inputMail = document.getElementById("inputMail");
const checkNum = document.getElementById("checkNum");
const inputId = document.getElementById("inputId");
const inputPw = document.getElementById("inputPw");
const confirmPw = document.getElementById("confirmPw");
const inputName = document.getElementById("inputName");

const mailMessage = document.getElementById("mailMessage");
const checkNumMessage = document.getElementById("checkNumMessage");
const inputIdMessage = document.getElementById("inputIdMessage");
const inputPwMessage = document.getElementById("inputPwMessage");
const confirmPwMessage = document.getElementById("confirmPwMessage");
const inputNameMessage = document.getElementById("inputNameMessage");

const inputMailBtn = document.getElementById("inputMailBtn");
const checkNumBtn = document.getElementById("checkNumBtn");

const checkObj = {
    "inputMail": false,
    "sendMail": false,
    "checkNum": false,
    "inputId": false,
    "inputPw": false,
    "confirmPw": false,
    "inputName": false
};

inputMail.addEventListener("input", (e) => {
    const regExp = /^[\w\-\_\.]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if (e.target.value.length == 0) {
        mailMessage.innerText = "메일 주소를 입력해주세요.";
        mailMessage.classList.remove("success", "error");
        checkObj.inputMail = false;
    }

    if (regExp.test(e.target.value)) {
        // 이메일 중복여부 구현
    } else {
        mailMessage.innerText = "메일 형식이 틀립니다.";
        checkObj.inputMail = false;
        mailMessage.classList.remove("success");
        mailMessage.classList.add("error");
    }
});

inputMailBtn.addEventListener("click", () => {
    if (checkObj.inputMail == false) {
        mailMessage.innerText = "메일 주소를 입력해주세요.";
        mailMessage.classList.remove("success");
        mailMessage.classList.add("error");
        inputMail.focus();
    } else {
        mailMessage.innerText = "인증번호가 발송되었습니다.";
        mailMessage.classList.remove("error");
        mailMessage.classList.add("success");

        // 인증번호 발송 구현
    }
});

checkNumBtn.addEventListener("click", () => {
    if (checkObj.sendMail == false) {
        checkNumMessage.innerText = "먼저 인증번호 보내기를 눌러주세요.";
        checkNumMessage.classList.remove("success");
        checkNumMessage.classList.add("error");
    }

    // 인증번호 확인 구현
});

inputId.addEventListener("input", (e) => {
    const regExp = /^[\a-z\-\_]{5,20}$/;
    
    if(!regExp.test(e.target.value)) {
        inputIdMessage.innerText = "5~20자의 영문 소문자, 숫자와 특수기호(_), (-)만 사용 가능합니다.";
        inputIdMessage.classList.remove("success", "error");
        checkObj.inputId = false;
    } else {
        // 아이디 중복 여부 구현
    }

});

inputPw.addEventListener("input", (e)=> {
    const regExp = /^(?=.*[\-\_\!\@\#])[\w\-\_\!\@\#]{6,30}$/;
    console.log(e.target.value);

    if (!regExp.test(e.target.value)) {
        inputPwMessage.innerText = "6~30자의 영어 대소문자, 숫자, 특수기호(_), (-), (!), (@), (#)를 1자 이상 포함하여 작성 해주세요.";
        inputPwMessage.classList.remove("success", "error");
        checkObj.inputPw = false;
    } else {
        inputPwMessage.innerText = "안전한 비밀번호 입니다.";
        inputIdMessage.classList.add("success");
        checkObj.inputPw = true;
    }
});

confirmPw.addEventListener("input", (e) => {
    if(e.target.value == inputPw.value && checkObj.inputPw) {
        confirmPwMessage.innerText = "비밀번호가 일치합니다.";
        confirmPwMessage.classList.remove("error");
        confirmPwMessage.classList.add("success");
        checkObj.confirmPw = true;
    } else {
        confirmPwMessage.innerText = "비밀번호가 일치하지 않습니다.";
        confirmPwMessage.classList.remove("success");
        confirmPwMessage.classList.add("error");
        checkObj.confirmPw == false;
    }
});

inputName.addEventListener("input", (e) => {
    const regExp = /^[\w가-힣\-\_]{2,30}$/;

    if (!regExp.test(e.target.value)) {
        inputNameMessage.innerText = "2~30자의 한글, 영어, 특수기호 (_), (-)만 사용 가능합니다.";
        inputNameMessage.classList.remove("success", "error");
        checkObj.inputName = false;
    } else {
        // 이름 중복 확인
    }
});

function signUpValidate() {
    let str;

    for(let key in checkObj) {
        if(!checkObj[key]) {
            switch (key) {
                case "inputMail": str="메일 주소가";
                    break;

                case "sendMail": str="인증 번호가";
                    break;
                case "checkNum": str="인증 번호가";
                    break;
                case "inputId": str="아이디가";
                    break;
                case "inputPw": str="비밀번호가";
                    break;
                case "confirmPw": str="비밀번호가";
                    break;
                case "inputName": str="이름이";
                    break;
            }

            str+= " 유효하지 않습니다.";

            alert(str);

            document.getElementById(key).focus();

            return false;
        }
    }

    return true;

}