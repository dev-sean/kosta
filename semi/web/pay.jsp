
<%@page contentType="text/html" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>����������</title>
    <script type="text/javascript" src="https://api.paygate.net/ajax/common/OpenPayAPI.js"> </script>

    <script type="text/javascript">

        function getPGIOresult() {
            var replycode = document.PGIOForm.elements['replycode'].value;
            var replyMsg = document.PGIOForm.elements['replyMsg'].value;
            displayStatus(getPGIOElement('ResultScreen'));
            alert(replycode + replyMsg);
        }

        function isValidURL(url){
            var RegExp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;

            if(RegExp.test(url)){
                return true;
            }else{
                return false;
            }
        }
        function memberredirecturl(data){
            if(!isValidURL(data.memberRedirecturl)){
                var replycode = document.PGIOForm.elements['replycode'].value;
                var replyMsg = document.PGIOForm.elements['replyMsg'].value;
                displayStatus(getPGIOElement('ResultScreen'));
                alert(replycode + replyMsg);
            }else{
                document.PGIOForm.action = data.memberRedirecturl;
                document.PGIOForm.method="POST";
                document.PGIOForm.submit();
            }
        }


        function getPGIOresult() {
            var script = document.createElement("script");
            script.setAttribute("type","text/javascript");

            /*DEV*/
            //script.setAttribute("src","https://service.paygate.net/memberredirect.jsp?callback=memberredirecturl&mid="+document.PGIOForm.mid.value+"");

            /*staging*/
            script.setAttribute("src","https://service.paygate.net/memberredirect.jsp?callback=memberredirecturl&mid="+document.PGIOForm.mid.value+"");

            document.getElementsByTagName("head").item(0).appendChild(script);
        }

        var isMobile = {
            Android: function() {
                return navigator.userAgent.match(/Android/i);
            },
            BlackBerry: function() {
                return navigator.userAgent.match(/BlackBerry/i);
            },
            iOS: function() {
                return navigator.userAgent.match(/iPhone|iPad|iPod/i);
            },
            Opera: function() {
                return navigator.userAgent.match(/Opera Mini/i);
            },
            Windows: function() {
                return navigator.userAgent.match(/IEMobile/i);
            },
            any: function() {
                return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
            }
        };

        if(!isMobile.any()) {
            //check PC
            document.write('<style>#centered{width:320px;background-color: #fff;}</style>');
        }


        function bindEvent(el, eventName, eventHandler) {
            if (el.addEventListener){
                el.addEventListener(eventName, eventHandler, false);
            } else if (el.attachEvent){
                el.attachEvent('on'+eventName, eventHandler);
            }
        }
        // ...
        bindEvent(window, 'resize', function () {
            var width = document.body.clientWidth;
            if(width <= 320){
                document.getElementById("centered").style.width="100%";
                document.getElementById("centered").style.minWidth="320px";
            }else{
                document.getElementById("centered").style.width="320px";
            }
        });
    </script>
</head>
<body>
<body bgcolor=ffffff>
    <div id="centered">
    <div id="PGIOscreen">
    </div>
</div>

<form name="PGIOForm">
    <hr>
    <table border=0 cellpadding=0>
        <tr>
            <th>ReceiptToName</th>
            <th name=receipttoname value="�����">�����</th>
        </tr>
        <tr> </tr>
        <tr></tr>
        <tr>
            <th>MID</th>
            <th><input type="hidden" name=mid id='mid' value="paygatekr">paygatekr</th>
        </tr>
        <tr>
            <th>GoodName</th>
            <th name=goodname value="�׽�Ʈ">�׽�Ʈ</th>

        </tr>
        <tr>
            <th>Price</th>
            <th><input type="hidden" name=unitprice value="1000" size=7>1000��</th>
            <!--<th name=unitprice value="1000" size=7>1000��</th><div name=goodcurrency value="WON"></div>-->
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <th>PayMethod</th>
            <td><select name=paymethod>
                <option value=""></option>
                <option value="card" selected="selected">CARD</option>
                <option value=801>PHONE</option>
            </select></td>
        </tr>
        <tr>
            <td>hashresult</td> <td><input type="text" name=hashresult value=''></td>
        </tr>
    </table>
</form>
<hr>
<input type=button value="OpenPay API" onclick="javascript:doTransaction(document.PGIOForm);"><br>
</body>
</html>