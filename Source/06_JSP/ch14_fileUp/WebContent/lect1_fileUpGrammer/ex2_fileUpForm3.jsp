<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>

<body>

	<form action="ex2_fileupPro3.jsp" method="post" enctype="multipart/form-data">
		<!-- get 파일첨부 불가, 파일 업로드는 반드시 post -->
		<!-- enctype 어느 폴더에 저장하는지  "application/x-www-form-urlencoded" 가 default - 같은 이름으로 덮어쓰기 되는 것 
													방지하기 위해서 enctype="multipart/form-data" 반드시!!-->
		<p>파일1 <input type="file" name="file1"></p>
		<p>파일2 <input type="file" name="file2"></p>
		<p>파일3 <input type="file" name="file3"></p>
		<input type="submit" value="파일업로드" class="btn">
	</form>

</body>
</html>