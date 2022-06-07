<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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

	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="<%= conPath %>/board/writeForm.jsp">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>이메일</th>
			<th>조회수</th>
		</tr>
		<%
		/**************************************************************************/
		/* 사용자 호출하는 방법 : list.jsp or list.jsp?pageNum=11 or list.jsp?pageNum=1 */ 
		final int PAGESIZE = 10 ,  BLOCKSIZE = 10; // 절대 변하지 않을 페이지 수, 페이지에 출력되는 페이지 블록 기준 (상수)
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum == null) {
			/* 파라미터가 넘어올 수도 있고 아닐 수도 있다. 안넘어오는 경우 1페이지부터 출력하도록 한다.*/
			pageNum = "1";
		}
		
		// 공식은 엑셀 도표에서 참고
		int currentPage = Integer.parseInt(pageNum); // 현재 몇 페이지인지 확인하는 변수
		int startRow = (currentPage-1) * PAGESIZE + 1; // 시작번호
		int endRow = startRow + PAGESIZE - 1; // 시작이 11이면 끝은 20으로 출력되도록
		/**************************************************************************/

		BoardDao dao = BoardDao.getInstance();
		int totalCnt = dao.getBoardTotalCnt(); // db에 등록된 글 개수! 
			
		if(totalCnt == 0) {
			out.println("<tr><td colspan='5'> 등록된 글이 없습니다. </td></tr>");
		} else {
			/**************************************************************************/		
				ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow); /* startRow, endRow*/
			/**************************************************************************/
				for(BoardDto dto : dtos) {
					// 글번호, 작성자, 글제목, 메일, 조회수
					out.println("<tr><td>" + dto.getNum() + "</td><td>" + dto.getWriter() + "</td>");
					// 글제목 <td class='left'><img src='/ch13_board/img/hot.gif'>
						// <a href='상세보기.jsp?num=1'>글제목</a></td>
					out.println("<td class='left'>");
					if(dto.getReadcount() > 10) {
						// 조회수가 10이 넘어가면
						out.println("<img src='" + conPath + "/img/hot.gif'>");
					}
					/* 수정과 삭제 후에도 원래 페이지에 남아있도록 */
					// <a href='content.jsp?num=글번호&pageNum=현페이지수'>글 제목</a>
					out.println("<a href='" + conPath + "/board/content.jsp?num="+dto.getNum()
						+"&pageNum=" + pageNum + "'>" + dto.getSubject() + "</a></td>");
					
					// 메일, 조회수
					out.println("<td>" + (dto.getEmail() != null ? dto.getEmail() : "-") + "</td><td>" + dto.getReadcount() + "</td></tr>");
				}
			}
		%>
	</table>

	<!-- ***************************************************************** -->
	<!-- 테이블을 다 뿌린 후에 페이지 리스트 출력하는 로직 구현 -->
	<div class = "paging">
		<!-- startPage endPage 얼마나 보여줄지 출력 및 이전,다음 페이지 출력 -->
		<%
			// 페이지 수, 시작페이지, 끝 페이지
			int pageCnt = (int)Math.ceil((double)totalCnt / PAGESIZE); // 14.5를 올려주는 로직 - 15.0 >>형변환 15
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		  int endPage = startPage + BLOCKSIZE - 1;
			
		  if(endPage > pageCnt) {
			  endPage = pageCnt; 
		  }
		  
		  // 이전 블럭이 있는지 없는지 확인 - 1이면 없는 것 10보다 크면 이전 페이지가 존재한다.
		  // <a href = "list.jsp?pageNum=10">이전</a>
		  // resopnse.sendRedirect로 해주어서 conPath 필요 없음
		  // 11 페이지 이상인 경우에만 실행 >> 이전블록을 누르게 되면 이전 블록의 마지막인 10페이지로 가게 된다
		  if(startPage > BLOCKSIZE) {
			  out.println("[ <a href='list.jsp?pageNum=" + (startPage-1) + "'>이전 블록</a> ]");
		  }
		  
		  for(int i = startPage; i<=endPage ; i++){
		  // 현재 페이지는 굳이 클릭해서 넘길 필요가 없다.
			  if(i == currentPage) {
				  // 페이지 수만 출력 -현재 페이지는 빨간 색으로 출력 >> <b>2</b>
				  out.println("[ <b>" + i + "</b> ]");
			  } else {
				  // a 태그를 포함한 페이지 수 출력 <a href='list.jsp?pageNum=10'>10</a>
				  out.println("[ <a href='list.jsp?pageNum=" + i + "'>" + i + "</a> ]");
			  }
		  } // for
		  
		  if(endPage < pageCnt) {
			   // 다음 블록이 있는지 여부 <a href = 'list.jsp?pageNum=다음블록 첫페이지'>다음</a>
			   out.println("[ <a href='list.jsp?pageNum=" + (endPage+1) +"'>다음</a> ]");
		   }
		  
		  // 글을 수정하고 나면 1페이지로 돌아가는 현상 수정
		  
		%>
	</div>

</body>
</html>