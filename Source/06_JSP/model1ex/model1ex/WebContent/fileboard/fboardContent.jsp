<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	
	<style>
		#content_form{
			height: 570px; 
			padding-top:30px;
			/*height : 630이 되도록 */
		}
	</style>

</head>

<body>

		<jsp:include page="../main/header.jsp"/>
		
		<div id="content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			
			FileboardDao fbDao = FileboardDao.getInstance();
			fbDao.hitUp(fnum);
			FileboardDto fbDto = fbDao.getBoard(fnum); 
		%>
		<table>
			<caption>글 상세 보기</caption>
			<tr>
				<th>글 번호</th>
				<td><%=fbDto.getFnum() %></td>
			</tr>	
			<tr>
				<th>글 제목</th>
				<td><%=fbDto.getFsubject() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<!-- mailto: // 주소창이 뜨게 된다
					이 사람한테 메일을 쓸 수 있는 팝업창이 뜬다. null인 경우에는 그냥 창만 뜨도록 한다 -->
					<%=fbDto.getCname() %> : <%=fbDto.getCid() %>
					(<a href="mailto:<%=fbDto.getCemail() != null ? fbDto.getCemail() : "" %>">
					<%=fbDto.getCemail() != null ? fbDto.getCemail() : "-" %></a> )
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
				<%
					if(fbDto.getFfilename() == null) {
						out.println("첨부파일 없음");
					} else {
						out.println("<a href='../fileboardUpload/" + fbDto.getFfilename() +"'>"
								+fbDto.getFfilename() + "</a>");
					}
				%>
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td><pre><%=fbDto.getFcontent() %></pre></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><pre><%=fbDto.getFrdate() %></pre></td>
			</tr>	
			<tr>
				<th>조회수</th>
				<td><pre><%=fbDto.getFhit() %></pre></td>
			</tr>	
			<tr>
				<th>IP</th>
				<td><pre><%=fbDto.getFip() %></pre></td>
			</tr>	

			<!-- 삭제도 내가 쓴 글만 삭제 가능. 수정도 내가 쓴 글만 수정 가능. 답글도 로그인한 상태일때만 가능하다. 
			비로그인 시 : 목록 버튼이랑 -->					
			<tr>
				<!-- 목록/수정/답변/삭제 -->
				<td colspan="2">
					<button onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">목록</button>
					<!-- 수정은  -->
					<%
						// 세션값 받아오는 작업
						String cid = null;
						CustomerDto customer = (CustomerDto)session.getAttribute("customer");
						if(customer!=null) {
							// customer가 null이 아닐때만
							cid = customer.getCid(); // 세션에 있는 id
						}
						// fbDto.cid는 null일 수가 없다. 비교를 fbDto로 진행
						if(fbDto.getCid().equals(cid)){
					%>
							<button onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">수정</button>
					<%}%>
					<!-- customer는 session에 있는 customer이다. -->
					<%if(customer != null) { %>
							<button onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">답변</button>
					<%} %>
					<button onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">삭제</button>
				</td>
			</tr>
		</table>
		
		</div>
		
		<jsp:include page="../main/footer.jsp"/>
		

</body>
</html>