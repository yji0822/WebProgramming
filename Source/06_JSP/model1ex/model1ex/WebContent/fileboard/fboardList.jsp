<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="java.util.ArrayList"%>
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
	<!-- 몇등부터 몇등까지 가져와! >> 현재페이지가 몇인지에 따라 달라진다 startRow endRow 가지고 온 뒤에 for문 돌리고 -->
	<jsp:include page="../main/header.jsp"/>
	
	<div id ="content_form">
	<!-- 로그인을 한 경우에만 글쓰기기 버튼이 추가되도록 한다. -->
		<table>
			<tr>
				<td colspan="7">
				<!-- 글쓰기 띄울지 말지 여부는 세션을 받아와서 확인을 한다. -->
				<%
					if(session.getAttribute("customer") != null) {%>
						<!-- 원글쓰기 -->
						<a href="fboardWriteForm.jsp">글쓰기</a> 
				<%}%>
				</td>
			</tr>

			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>글제목</th>
				<th>메일</th>
				<th>IP</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- startRow & endRow 공식  / 답변글, 들여쓰기, hot 출력 / 첨부파일이 있으면 출력해주는 로직 -->
			<%
			// fboardList.jsp or fboardList.jsp?pageNum=2
				String pageNum = request.getParameter("pageNum");
				if(pageNum == null) pageNum = "1"; // pageNum 값이 없으면 1페이지로 세팅
				
				int currentPage = Integer.parseInt(pageNum); // currentPage가 현재 페이지를 가지고 있다.
				
				//startRow endRow 시작
				final int PAGESIZE = 10, BLOCKSIZE = 10;
				int startRow = (currentPage-1) * PAGESIZE + 1;
				int endRow = startRow + PAGESIZE - 1;
				
				FileboardDao fbDao = FileboardDao.getInstance();
				ArrayList<FileboardDto> dtos = fbDao.listBoard(startRow, endRow);
				
				if(dtos.size() == 0) {
					// dtos.isEmpty()
					out.println("<tr><td colspan='7'> 글이 존재하지 않습니다.</td></tr>");
				} else {
					for(FileboardDto d : dtos){
					%>
					<!-- 간단하지 않으니 그냥 스크립트릿을 제거하고 넣어주도록 한다. -->
					<!-- 글번호, 작성자, 제목(제일 복잡), 메일, ip, 작성일, 조회수 -->
					<tr>
						<td><%=d.getFnum() %></td> <!-- 글번호 -->
						<td><%=d.getCname() %></td> <!-- 작성자 id가 아닌 작성자 이름이 들어오도록 -->
						<td class="left">
							<!-- 글쓰기 left로 정렬이 되도록 -->
							<% if(d.getFre_level() > 0) { %>
							<!-- level이 0이면 그대로, 그 이후로는 1개씩 들여쓰기 -->
								<!--들여쓰기 공간 확보 -->
								<img src="<%=conPath %>/img/level.gif" width="<%=d.getFre_level() * 10 %>" height="10">
								<img src="<%=conPath %>/img/re.gif">
							<%} %>
							<% if(d.getFhit() > 10) {%>
								<!-- 글 조회수 10개가 넘어가면 hit! -->
								<img src ="<%=conPath %>/img/hot.gif">
							<%} %>
								<!-- 상세보기로 가는 것 -->
								<a href="fboardContent.jsp?fnum=<%=d.getFnum() %>&pageNum=<%=pageNum%>"><%=d.getFsubject() %></a>
								<%if(d.getFfilename() != null){ %>
									<img src="<%=conPath %>/img/fileup.jpg" height="10">
								<%} %>
						</td>
						<td><%=d.getCemail()==null ? "-" : d.getCemail() %></td>
						<td><%=d.getFip() %></td>
						<td><%=d.getFrdate() %></td>
						<td><%=d.getFhit() %></td>
					</tr>
					
				<%} // for
			} // if-esle %>
		</table>
		
		<div class="paging">
		<%
			int totCnt = fbDao.getFileboardCnt(); // 글 수
			int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 페이지 수
			int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			
			if(endPage > pageCnt) endPage = pageCnt;
			
			// 이전블록 뿌릴지 말지
			if(startPage > BLOCKSIZE) {
				// 이전 블록이 존재하는 경우 - index.jsp로 들어올 수 있는 경우에는 경로에 conpath를 넣어주도록 한다.
			%>
				[ <a href="<%=conPath %>/fileboard/fboardList.jsp?pageNum=<%=startPage-1%>">이전 블록</a> ]	
		<%}
			for(int i=startPage ; i <= endPage ; i++) {
				if(i == currentPage) {
					out.println("<b>" + i + "</b>");
				} else {
					out.println("<a href='" + conPath + "/fileboard/fboardList.jsp?pageNum="+i+"'>" + i + "</a>");
				} // if-else
			} // for
			
			if(endPage < pageCnt) {
		%>
			[ <a href="<%=conPath %>/fileboard/fboardList.jsp?pageNum=<%=endPage+1%>">다음 블록</a> ]				
		<%}%>
		</div>
		
	</div>
	
	<jsp:include page="../main/footer.jsp"/>

</body>
</html>