<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style>
progress {
	display: none;
}
</style>
<script>
	$(document).ready(function(){
	var progress = $("progress").val();
	$('button').click(function(){
		fileupload();
	}); 
    function fileUpload(){ 
	 var xhr = new XMLHttpRequest();
	 xhr.upload.onloadstart = function(){
		 progress = 0;
		 $('progress').css('display','inline');
		 xhr.upload.onprogress = function (e){
			 progress = e.loaded / e.total;
			 
			
		};
		xhr.upload.onload = function(e) {
			$('progress').css('display','none');
				
		};
	xhr.onreadystatechange = function() {
		if(xhr.readyState ==4 && xhr.status == 200) {
		 $('div').html(xhr.responseText)
			
			
		};
		
	};
		
	}


	xhr.open("POST","upload.jsp",true);
	xhr.setRequestHeader("X-File-Name",
			encodeURIComponent($('input').prop('files')[0].name));
	
	xhr.send($('input').prop(files)[0]);
	}

	});
</script>
</head>
<body>

</body>
</html>