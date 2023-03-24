console.log("main.js loaded");

// function load() {content.addEventListener("load", function () {
//     const content = document.getElementById("content");
//     $.ajax({
//         url: "member/searchAll",
//         type: "POST",
//         dataType: "JSON",

//         success: function (member) {
//             console.log(member);

//             if (member != null) {
//                 const tr = document.createElement("tr");

//                 const td1 = document.createElement("td");
//                 td1.innerText = member.memberNo;

//                 const td2 = document.createElement("td");
//                 td2.innerText = member.memberEmail;

//                 const td3 = document.createElement("td");
//                 td3.innerText = member.memberNickname

//                 tr.append(td1, td2, td3);

//                 content.append(tr);
//             }
//         },

//         error: function () {
//             console.log("AJAX Error");
//             console.log("code : " + request.status);
//         }
//     })
// });
// };

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
}, 3000);

const input = document.querySelectorAll("input");

console.log(input);

document.getElementById("input").addEventListener("click", function() {
    $.ajax({
        url: "member/input",
        data: {"email" : input[0].value, "pw" : input[1].value, 
        "nickname" : input[2].value, "phone" : input[3].value, 
        "addr" : input[4].value},
        type: "POST",
        dataType: "JSON",
    
        success: function(result) {
            console.log(result);
        },
    
        error: function() {
            console.log("fail");
            console.log("code : " + request.status);
        }
    })
});

