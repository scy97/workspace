const agree = document.getElementById("agree");

function secessionValidate() {
    if (agree.checked) {
        return true;
    } else {
        alert("약관에 동의해주세요.");
        agree.focus();
        return false;
    }
}