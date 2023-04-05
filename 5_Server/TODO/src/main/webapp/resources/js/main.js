const input_todo = document.getElementById("input_todo");
const sendBtn = document.getElementById("sendBtn");
const all = document.getElementById("all");
const doing = document.getElementById("doing");
const done = document.getElementById("done");
const removeAll = document.getElementById("removeAll");
const historyList2 = document.getElementById("history").children;

let todoListNum = 0;

input_todo.addEventListener("input", (e) => {
    e.target.style.height = "1px";
    e.target.style.height = (event.target).scrollHeight + "px";
});

window.addEventListener("resize", () => {
    input_todo.style.height = "1px";
    input_todo.style.height = input_todo.scrollHeight + "px";
});

sendBtn.addEventListener("click", () => {
    todoListNum++;
    const div = document.createElement("div");
    const createlistCheckBtn = document.createElement("input");
    const createlistCheckLabel = document.createElement("label");
    const createtodoText = document.createElement("div");
    const createlistRemoveBtn = document.createElement("div");
    const createlistRemoveIcon = document.createElement("i");
    
    createlistCheckBtn.setAttribute("type", "checkbox");
    createlistCheckBtn.classList.add("listCheckBtn");
    createlistCheckBtn.id = "listCheckBtn" + todoListNum;
    createlistCheckBtn.ariaLabel = "check";
    createlistCheckLabel.setAttribute("for", createlistCheckBtn.id);

    div.classList.add("list");
    createtodoText.classList.add("todoText");
    createlistRemoveBtn.classList.add("listRemoveBtn");
    createlistRemoveIcon.classList.add("fa-solid", "fa-trash");
    
    createlistRemoveBtn.append(createlistRemoveIcon);
    
    createtodoText.innerText = document.getElementById("input_todo").value;
    
    div.append(createlistCheckBtn, createlistCheckLabel, createtodoText, createlistRemoveBtn);
    
    document.getElementById("history").append(div);

    const listRemoveBtn = document.getElementsByClassName("listRemoveBtn");
    for (i of listRemoveBtn) {
        i.addEventListener("click", function() {
            this.parentElement.remove();

            const historyList = document.getElementById("history").children;
            listCount.innerText = historyList.length + "개";
        });
    }
   
    const historyList = document.getElementById("history").children;
    listCount.innerText = historyList.length + "개";
});

removeAll.addEventListener("click", () => {
    const history = document.getElementById("history");
    history.replaceChildren();

    const historyList = document.getElementById("history").children;
    listCount.innerText = historyList.length + "개";
});

all.addEventListener("click", () => {

});

doing.addEventListener("click", () => {
    console.log(historyList2);
});

done.addEventListener("click", () => {
    
});