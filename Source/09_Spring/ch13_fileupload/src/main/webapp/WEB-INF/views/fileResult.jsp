<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

	<h2> 파일 업로드 결과 : ${fileResult }</h2>
	<p> file1 : ${filenames[0] } </p>
	<p> file2 : ${filenames[1] } </p>
	<p> file3 : ${filenames[2] } </p>
	
	<!-- 파일을 첨부를 했을지 안했을지 모르기 때문에 filenames가 빈스트링인지 아닌지 부터 먼저 확인을 해주어야 한다. -->
	<c:if test="${not empty filenames[0] }">
		<img src="upload/${filenames[0] }">
	</c:if>
	<c:if test="${empty filenames[0] }">
		첫번째 첨부파일 첨부 안 함
	</c:if>
	<c:if test="${not empty filenames[1] }">
		<img src="upload/${filenames[1] }">
	</c:if>
	<c:if test="${empty filenames[1] }">
		두번째 첨부파일 첨부 안 함
	</c:if>
	<c:if test="${not empty filenames[2] }">
		<img src="upload/${filenames[2] }">
	</c:if>
	<c:if test="${empty filenames[2] }">
		세번째 첨부파일 첨부 안 함
	</c:if>
			
</body>
</html>