// 회원 프로필 이미지 변경(미리보기)

const inputImage = document.getElementById("input-image");

if(inputImage != null) { // inputImage 요소가 화면에 존재할 때
    // input type="file" 요소는 파일이 선택될 때 change 이벤트 발생

    inputImage.addEventListener("change", function() {
        // 파일 목록에서 첫번째 파일 객체를 선택
        // files : input type="file"만 사용가능한 속성으로
        // 선택된 파일 목록(배열)을 반환
        
        // this : 이벤트가 발생한 요소 (input type="file")
        if (this.files[0] != undefined) { // 파일이 선택되었을 때
            const reader = new FileReader();
            // 자바스크립트의 FileReader
            // - 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체

            reader.readAsDataURL(this.files[0]);
            // FileReader.readAsDataURL(파일)
            // - 지정된 파일의 내용을 읽기 시작함.
            // - 읽어오는게 완료되면 result 속성에 data에
            // 읽어온 파일의 위치를 나타내는 URL이 포함된다.
            // -> 해당 URL을 이용해서 브라우저에서 이미지를 볼 수 있다.

            reader.onload = function(e) {
                // e : 이벤트 발생 객체
                // e.target : 이벤트가 발생한 요소 -> FileReader
                // e.target.result : FileReader가 읽어온 파일의 URL

                // 프로필 이미지의 src 속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profile-image");

                profileImage.setAttribute("src", e.target.result);
                // -> setAttribute() 호출 시 중복되는 속성이 존재하면 덮어쓰기

                document.getElementById("delete").value = 0;
                // 새로운 이미지가 선택되었기 때문에 1 -> 0(안눌러짐 상태)로 변경
            }
        }
    });
}

// 프로필 이미지 옆 X버튼 클릭 시
document.getElementById("delete-image").addEventListener("click", function() {
    // 0 : 안눌러짐
    // 1 : 눌러짐

    const del = document.getElementById("delete");
    
    if(del.value == 0) { // 눌러지지 않은 경우
        // 1) 프로필 이미지를 기본 이미지로 변경
        document.getElementById("profile-image").setAttribute("src", contextPath + "/resources/images/user.png");

        // 2) input type="file"에 저장된 값(value)에 "" 대입
        document.getElementById("input-image").value = "";

        del.value = 1;
    }
});

// 이미지 선택 확인
function profileValidate() {
    const inputName = document.getElementById("input-image");

    const del = document.getElementById("delete"); // hidden 타입

    if (inputImage.value == "" && del.value == 0) {
        // 파일선택 X   /   X를 누르지도 않았다
        // -> 아무것도 안하고 변경버튼만 클릭한 경우
        alert("이미지를 선택한 후 변경 버튼을 클릭해주세요.");
        return false;
    }

    return true;
};