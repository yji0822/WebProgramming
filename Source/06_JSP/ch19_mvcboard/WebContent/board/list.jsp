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
	<!-- 글쓰기 성공, 출력 실패 경고창 -->
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	
	<c:if test="${writeResult eq SUCCESS }">
		<script>
			alert('글 쓰기 성공');
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>
			alert('글 쓰기 실패');
		</script>
	</c:if>

	<!-- 글 수정 성공, 실패 출력 -->
	<c:if test="${modifyResult eq SUCCESS }">
		<script>
			alert('글 수정 성공');
		</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>
			alert('글 수정 실패');
		</script>
	</c:if>
	<c:if test="${deleteResult eq SUCCESS }">
		<script>
			alert('글 삭제 성공');
		</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL }">
		<script>
			alert('글 삭제 실패');
		</script>
	</c:if>
	
	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="${conPath }/write_view.do">글쓰기</a></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>IP</th>
			<th>작성일</th>
			<th>조회수</th>
			
			<!--  데이터에 글이 없다고 해서 pageNum이 없는 것을 출력하면 안된다. -->
			<c:if test="${list.size() eq 0 }">
				<tr><td colspan="6">해당 페이지 글이 없습니다.</td></tr>
			</c:if>
			<c:if test="${list.size() != 0 }">
				<!--  조회수 많은 아이만 들여쓰기하는 작업 -->
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.bid }</td> 
						<td>${dto.bname }</td>
						<td class="left">
							<c:forEach var="i" begin="1" end="${dto.bindent }">
								<c:if test="${i eq dto.bindent }">
						  	└─
						  </c:if>
						  <c:if test="${i != dto.bindent }">
						  	&nbstp; &nbstp; 
						  </c:if> 
							</c:forEach> <!-- 답변글 들여쓰기 -->
							<a href="${conPath }/content_view.do?bid=${dto.bid }&pageNum=${pageNum }">
								${dto.btitle }
							</a>
							<c:if test="${dto.bhit > 10 }">
								<b> * </b>
							</c:if>					
						</td>	<!-- 글제목 -->
						<td>${dto.bip }</td>
						<td><fmt:formatDate value="${dto.bdate }" pattern="yy년MM월dd일(E)"/></td>
						<td>${dto.bhit }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tr>
	</table>
	
	<!-- 페이징 -->
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/list.do?pageNum=${startPage-1 }"> 이전 블럭 </a> ]
		</c:if>
		<!-- 쌍따옴표 꼭 넣어주어야 한다 -->
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b> ${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/list.do?pageNum=${i }">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
				[ <a href="${conPath }/list.do?pageNum=${endPage + 1 }">다음 블럭</a> ]
		</c:if>
	</div>

</body>
</html>