var xhr = null; //XMLHttpRequest 객체 - 모든 브라우저가 가지고 있는
function getRequest() {
    //브라우저 판별 - jQuery에서는 기본 라이브러리로 제공!
    if (window.ActiveXObject) {//IE
        xhr = new ActiveXOvejct("Microsoft.XMLHTTP");
    } else {
        xhr = new XMLHttpRequest();
    }
}

function sendRequest(url, param, callback, method, async) {
    getRequest();
    method = (method.toLowerCase() === "get") ? "GET" : "POST";
    param = (param === null || param === "") ? null : param;
    if (method === "GET" && param !== null) {
        url = url + "?" + param;
    }
    xhr.onreadystatechange = callback; // 서버의 응답이 도착하는 함수 지정
    xhr.open(method, url, async);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //서버 요청 보내기

    xhr.send((method === "POST") ? param : null);
}
