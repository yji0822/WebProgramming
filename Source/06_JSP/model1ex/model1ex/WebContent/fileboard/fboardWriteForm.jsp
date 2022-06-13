<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
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
		if(session.getAttribute("customer") == null) {
			response.sendRedirect(conPath+"/customer/loginForm.jsp");
		}
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		int fnum = 0; // 글번호는 0으로 초기화
		
		FileboardDto fbDto = new FileboardDto(); // 빈 Dto 객체 - fnum, fref, fre_step, fre_level은 0
		
		if(request.getParameter("fnum") != null) {
			// 답글 쓰러 왔음
			fnum = Integer.parseInt(request.getParameter("fnum"));
			FileboardDao fbDao = FileboardDao.getInstance();
			fbDto = fbDao.getBoard(fnum); // 원글에 대한 정보 (fref, fre_step, fre_level이 필요)
		}
		%>
		
		<!-- 사용자로부터  -->		
		<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
				<input type="hidden" name="pageNum" value="<%=pageNum %>">
				<input type="hidden" name="fnum" value="<%=fnum %>">
				<input type="hidden" name="fref" value="<%=fbDto.getFref() %>">
				<input type="hidden" name="fre_step" value="<%=fbDto.getFre_step() %>">
				<input type="hidden" name="fre_level" value="<%=fbDto.getFre_level() %>">
		
		<table>
			<caption><%=fnum == 0 ? "글쓰기" : "답변글쓰기" %></caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="fsubject" required="required" autofocus="autofocus"
							value="<%
								if(fbDto.getFsubject() != null) {
									out.print("[답] " + fbDto.getFsubject());
								}
							%>"></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="ffilename"></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><textarea rows="5" cols="20" name="fcontent"></textarea></td>
			</tr>
			<tr>
				<th>삭제비번</th>
				<td><input type="password" name="fpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value='<%=fnum == 0 ? "글 쓰기" : "답글 쓰기" %>' class="btn">
					<input type="reset" value="다시 쓰기" class="btn">
					<input type="button" value="목록" class="btn"
								onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">
 				</td>
			</tr>
			
		</table>
		</form>
	</div>
	
	<jsp:include page="../main/footer.jsp"/>

</body>
</html>