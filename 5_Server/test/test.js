const btn = document.getElementById("btn");
const content = document.getElementById("content");

btn.addEventListener("click", () => {
    content.classList.toggle("open");
});