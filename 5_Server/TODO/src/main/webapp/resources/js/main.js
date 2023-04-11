const inputText = document.getElementById("inputText");
const addBtn = document.getElementById("addBtn");
const historyList = document.getElementById("historyList");
const all = document.getElementById("all");
const doing = document.getElementById("doing");
const done = document.getElementById("done");
const removeAll = document.getElementById("removeAll");
const listCount = document.getElementById("listCount");

let todoListNum = 0;

function addList(no, text, check) {
    const div = document.createElement("div");
    const createListCheckBtn = document.createElement("input");
    const createListCheckLabel = document.createElement("label");
    const createTodoText = document.createElement("div");
    const createListRemoveBtn = document.createElement("div");

    createListCheckBtn.setAttribute("type", "checkbox");
    createListCheckBtn.id = "listCheckBtn" + todoListNum;
    createListCheckBtn.classList.add("listCheckBtn");
    createListCheckLabel.setAttribute("for", createListCheckBtn.id);

    createTodoText.classList.add("todoText");
    createListRemoveBtn.classList.add("listRemoveBtn");

    createTodoText.innerText = text;

    div.append(createListCheckBtn, createListCheckLabel, createTodoText, createListRemoveBtn);
    div.id = no;

    if (check == 'Y') {
        createListCheckBtn.checked = true;
    }
    else {
        createListCheckBtn.checked = false;
    }

    document.getElementById("historyList").append(div);

    listCount.innerText = todoListNum + "개";

    inputText.value = "";
}

function load(option) {
    console.log("fn loaded");

    $.ajax({
        url: "list/" + option,
        dataType: "JSON",

        success: function (list) {
            todoListNum = 0;
            historyList.innerHTML = "";

            $(list).each(function () {
                console.log(this.listNo, this.listText, this.listCheck);
                todoListNum++;
                console.log(todoListNum);
                addList(this.listNo, this.listText, this.listCheck);
            })

            const listRemoveBtn = document.getElementsByClassName("listRemoveBtn");
            for (i of listRemoveBtn) {
                i.addEventListener("click", function () {
                    $.ajax({
                        url: "list/remove",
                        data: { "listNo": this.parentElement.id },

                        success: function () {
                            load("all");
                        },

                        error: function () {
                            console.log("AJAX 에러 발생");
                            console.log("상태코드 : " + request.status);
                        }

                    })
                });
            }

            const listCheckBtn = document.getElementsByClassName("listCheckBtn");
            for (i of listCheckBtn) {
                i.addEventListener("change", function () {
                    $.ajax({
                        url: "list/check",
                        data: { "listNo": this.parentElement.id, "listCheck": this.checked },

                        success: function () {
                            load("all");
                        },

                        error: function () {
                            console.log("AJAX 에러 발생");
                            console.log("상태코드 : " + request.status);
                        }
                    })
                });
            }

        },

        error: function () {
            console.log("AJAX 에러 발생");
            console.log("상태코드 : " + request.status);
        }
    })
}

window.onload = load("all");

inputText.addEventListener("input", (e) => {
    e.target.style.height = "27px";
    e.target.style.height = (e.target).scrollHeight + "px";
});

window.addEventListener("resize", () => {
    inputText.style.height = "27px";
    inputText.style.height = inputText.scrollHeight + "px";
});

addBtn.addEventListener("click", () => {
    inputText.focus();
    if ((inputText.value).trim().length > 0) {

        $.ajax({
            url: "list/add",
            data: { "inputText": inputText.value },

            success: function () {
                console.log("asd");
                load("all");
            },

            error: function () {
                console.log("AJAX 에러 발생");
                console.log("상태코드 : " + request.status);
            }
        })

        const historyList = document.getElementById("historyList").children;
        listCount.innerText = historyList.length + "개";
    } else {
        alert("해야 할 일을 입력해주세요.");
        inputText.value = null;
    }
});

all.addEventListener("click", () => {
    load("all");
});

doing.addEventListener("click", () => {
    // $.ajax({
    //     url: "list/doing",
    //     dataType: "JSON",


    // })
});

done.addEventListener("click", () => {

});