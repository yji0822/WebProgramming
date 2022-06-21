<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">

</head>

<body>

	<!-- 회원가입이 되었으면 알람창 뜨게 해주는 로직 추가 -->
	<c:set var="SUCCESS" value="1" ></c:set>
	<c:set var="FAIL" value="1" ></c:set>
	<c:if test="${joinResult eq SUCCESS }">
		<script>alert('회원가입 성공');</script>
	</c:if>
	<c:if test="${joinReslut eq FAIL }">
		<script>alert('회원가입 실패');</script>
	</c:if>
	
	<table>
		<tr>
			<th>번호</th><th>id</th><th>pw</th><th>이름</th><th>생일</th><th>가입일</th>
		</tr>
			<c:if test="${memberList.size() eq 0 }">
				<tr><th colspan="6">가입한 회원이 없습니다.</th></tr>
			</c:if>
			<c:if test="${memberList.size() != 0 }">
				<!-- arraylist 안에 있는 것 출력 -->
				<c:set var="i" value="1"/>
				<c:forEach var="member" items="${memberList }">
					<tr>
						<!-- getId를 호출해서 가져오는 것이다! -->
						<td>${i }</td>
						<td>${member.id }</td>
						<td>${member.pw }</td>	
						<td>${member.name }</td>
						<td><fmt:formatDate value="${member.birth }" pattern="MM월 dd일"/></td>
						<td>${member.rdate }</td>
					</tr>
					<!-- 변수 재설정 / 아래 코드를 작성해주지 않으면 +1이 되지 않는다.-->
					<c:set var="i" value="${i+1 }"/>
				</c:forEach>
			</c:if>
	</table>
	
		<h2><a href="${conPath }/memberJoin_view.do">회원가입</a></h2>

</body>
</html>