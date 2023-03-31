// 닉네임 유효성 검사
const checkInfo = {
    "memberNickname": false,
    "memberTel": false
}

const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input", function () {
    if (memberNickname.value.length == 0) {
        nicknameMessage.innerText = "닉네임을 입력해 주세요.";
        nicknameMessage.classList.remove("confirm", "error");

        checkInfo.memberNickname = false; // 유효 X 기록
        return;
    }

    const regExp = /^[a-zA-Z0-9가-힣]{2,10}$/;

    if (regExp.test(memberNickname.value)) { // 유효한 경우


        // ****** 닉네임 중복 검사(ajax) 진행 예정 ******

        //     /community/member/nicknameDupCheck
        $.ajax({
            url: "nicknameDupCheck",  // 필수 작성 속성
            data: { "memberNickname": memberNickname.value }, // 서버로 전달할 값(파라미터)
            type: "GET", // 데이터 전달 방식(기본값 GET)

            success: function (res) { // 비동기 통신 성공 시(에러 발생 X)

                // 매개변수 res : Servlet에서 응답으로 출력된 데이터가 저장

                if (res == 0) { // 닉네임 중복 X
                    nicknameMessage.innerText = "사용 가능한 닉네임 입니다.";
                    nicknameMessage.classList.add("confirm");
                    nicknameMessage.classList.remove("error");
                    checkInfo.memberNickname = true; // 유효 O 기록

                } else { // 닉네임 중복 O
                    nicknameMessage.innerText = "이미 사용중인 닉네임 입니다.";
                    nicknameMessage.classList.add("error");
                    nicknameMessage.classList.remove("confirm");
                    checkInfo.memberNickname = false; // 유효 O 기록
                }
            },

            error: function () { // 비동기 통신 중 에러가 발생한 경우
                console.log("에러 발생");
            }
        });


    } else {
        nicknameMessage.innerText = "닉네임 형식이 유효하지 않습니다.";
        nicknameMessage.classList.add("error");
        nicknameMessage.classList.remove("confirm");

        checkInfo.memberNickname = false; // 유효 X 기록
    }
});

// 전화번호 유효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

// ** input 이벤트 **
// -> 입력과 관련된 모든 동작(key관련, mouse관련, 붙여넣기)
memberTel.addEventListener("input", function () {

    // 입력이 되지 않은 경우
    if (memberTel.value.length == 0) {
        telMessage.innerText = "전화번호를 입력해주세요.(- 제외)";

        //telMessage.classList.remove("confirm");
        //telMessage.classList.remove("error");
        telMessage.classList.remove("confirm", "error");

        checkInfo.memberTel = false; // 유효하지 않은 상태임을 기록

        return;
    }

    // 전화번호 정규식
    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if (regExp.test(memberTel.value)) { // 유효한 경우
        telMessage.innerText = "유효한 전화번호 형식입니다.";
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");

        checkInfo.memberTel = true; // 유효한 상태임을 기록

    } else { // 유효하지 않은 경우
        telMessage.innerText = "전화번호 형식이 올바르지 않습니다.";
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");

        checkInfo.memberTel = false; // 유효하지 않은 상태임을 기록
    }
});


// 수정하기 버튼 클릭 시 유효성 검사가 완료 되었는지 확인하는 함수
function infoValidate() {

    // checkInfo에 있는 모든 속성을 반복 접근하여
    // false가 하나라도 있는 경우에는 form태그 기본 이벤트 제거

    let str;

    for (let key in checkInfo) { // 객체용 향상된 for문

        // 현재 접근 중인 key의 value가 false인 경우
        if (!checkInfo[key]) {

            switch (key) {
                case "memberNickname": str = "닉네임이"; break;
                case "memberTel": str = "전화번호가"; break;
            }

            str += " 유효하지 않습니다.";

            alert(str);

            document.getElementById(key).focus();

            return false; // form태그 기본 이벤트 제거
        }
    }

    return true; // form태그 기본 이벤트 수행

}