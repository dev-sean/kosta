var xhr = null; //XMLHttpRequest ��ü - ��� �������� ������ �ִ�
function getRequest() {
    //������ �Ǻ� - jQuery������ �⺻ ���̺귯���� ����!
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
    xhr.onreadystatechange = callback; // ������ ������ �����ϴ� �Լ� ����
    xhr.open(method, url, async);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //���� ��û ������

    xhr.send((method === "POST") ? param : null);
}
