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

	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사</th><th>입사일</th><th>급여</th><th>상여</th><th>부서</th>
		</tr>
		<!-- 잘못쳐도 빈스트링으로 들어올 것 -->
		<c:if test="${emps.size() eq 0 }">
			<tr><td colspan="8">등록된 사원이 없습니다.</td>
		</c:if>
		<!-- else 조건문이 없어서 새로 작성해주어야 한다. / 확장for문 사용 : emps를 출력할건데 이름은 emp로!
		조건 : 급여가 2000 이상인 사람에게 사람이름에 hot, 최고 직책인 사람에게 hot 뿌려주는 작업 
		getter를 알아서 찾아와주는 EL! -->
		<c:if test="${emps.size() != 0 }">
			<c:forEach items="${emps }" var="emp">
				<tr>
					<td>${emp.empno }</td>
					<td>
						<!-- hot을 뿌려야 할지 말지 -->
						<c:if test="${emp.sal > 2000 }">
							<img src="${conPath }/img/hot.gif	">
						</c:if>
						<c:if test="${emp.mgr eq 0 }">
							<b style="color:navy;">${emp.ename }</b>
						</c:if>
						<c:if test="${emp.mgr != 0 }">
							${emp.ename }
						</c:if>
					</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy년 MM월 dd일 (E) hh:mm:ss(a)"/></td>
					<td><fmt:formatNumber value="${emp.sal }" groupingUsed="true"/></td> 
					<!-- 세자리마다 , 를 찍어주는 것 -->
					<td>${emp.comm eq 0 ? " - " : emp.comm }</td>
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>