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
	
	<div id = "content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			
			// dto를 부르기 위해서 dao를 호출
			FileboardDao fbDao = FileboardDao.getInstance();
			FileboardDto fbDto = fbDao.getBoard(fnum);
			
			System.out.println(fbDto + "글 수정 들어갑니다.");
		%>
			
			<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
				<!-- hidden : pageNum, dbfilename
				파일첨부한 것을 수정 안하고 싶을때는? 첨부를 안하겠지? 파일이 null이면 원래 파일을 수정 안하고 그대로.(기존 데이터 베이스에 있는 것을 그대로 넘겨준다) -->
				<input type="hidden" name="pageNum" value="<%=pageNum %>">
				<input type="hidden" name="dbfilename" 
									value="<%=fbDto.getFfilename() == null ? "" : fbDto.getFfilename() %>"> 
				
				<table>
					<caption>글 수정</caption>
					<tr>
						<th>글 번호</th>
						<td><input type="text" name="fnum" value="<%=fnum %>" readonly="readonly"></td>
					</tr> 
					<tr>
						<th>글 제목</th>
						<td><input type="text" name="fsubject" value="<%=fbDto.getFsubject() %>" autofocus="autofocus" required="required"></td>
					</tr> 
					<tr>
					<!-- input type="file"은 value값이 들어가지 않는다. value를 넣어도 화면에 보이지 않는다.-->
						<th>첨부 파일</th>
						<td>
							<input type="file" name="ffilename" style="width:30%;">
							<%
								if(fbDto.getFfilename() != null) {
									out.println("첨부파일 : " +fbDto.getFfilename());
								} else {
									out.println("첨부파일 없음");
								}
							%>
						</td>
					</tr> 
					<tr>
						<th>본문</th>
						<td>
							<textarea rows="5" cols="20" name="fcontent"><%=fbDto.getFcontent() %></textarea>
						</td>
					</tr>
					<tr>
						<th>삭제용 비번</th>
						<td><input type="password" name="fpw" value="<%=fbDto.getFpw() %>" required="required"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="글 수정" class="btn">
							<input type="reset" value="이전" class="btn" onclick="history.go(-1)">
							<input type="button" value="목록" class="btn" onclick="location='fboardList.jsp?pageNum=<%=pageNum %>'">
						</td>
					</tr>
				</table>
			</form>
		
	</div>
	
	<jsp:include page="../main/footer.jsp"/>

</body>
</html>