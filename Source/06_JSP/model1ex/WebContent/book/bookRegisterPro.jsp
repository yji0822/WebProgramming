<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>>
<%@page import="java.sql.Date"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/bookstyle.css" rel="stylesheet">
</head>

<body>

	<jsp:include page="../main/header.jsp"/>
	<%
		// 한글 인코딩 처리 = multioartRequest 객체 생성 - 첨부된 파일명 get - 그 외 파라미터에서 입력된 정보 get - insert
		request.setCharacterEncoding("utf-8");
		// 빈태그로 받을 수 있지만 안받을 것
		
		// 파일첨부 하기 위한 multipart 불러오기 위한 작업
		String path = request.getRealPath("bookImg");
		int maxSize = 1024*1024*5; // 최대 업로드 용량이 5Mb
		String[] image = {"",""}; // 서버에 저장된 파일명의 저장소
		// 변수가 유효해야 한다. - try 절 위에 선언만 해준다. 
		MultipartRequest mRequest = null;
		
		// multipartForm으로 들어온 것이 있어야지 에러가 발생이 안된다.
		try {
			// multipartRequest 객체 생성 - 파일을 저장하고 파일이름을 불러오기 위해서..
			// 서버에 저장된 파일명을 가져오는 것(get)
			// MultipartRequest에 request를 적어주면 파라미터를 받아올 수 없음. - mRequest로 불러와야 한다.
			mRequest = new MultipartRequest(request, path, maxSize, 
					                            "utf-8", new DefaultFileRenamePolicy());
			// 서버에 저장한 파일명 불러오기
			// 파라미터 이름 받아오기 = Enumeration
			Enumeration<String> paramNames = mRequest.getFileNames(); // 파일명이 아닌 파라미터 이름을 받아오는 함수 getFileNames()
			int idx = 0;
			while(paramNames.hasMoreElements()) {
				// 지금 가르키는 것 중에서 다른 요소가 있는지 확인
				String param = paramNames.nextElement(); // image2를 호출 >> image1 호출
				image[idx] = mRequest.getFilesystemName(param); // 서버에 파일을 첨부하고 첨부하고난 뒤의 파일명 저장 >> 서버에 있는 파일명 저장!
				// 위의 소스 코드에서 파일을 첨부를 안했다면 null로 들어오게 한다.
				idx++; // 0방에서 ++ 해줘서 다음방을 불러올 수 있도록 한다.
			} // while
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 서버에 저장된 파일명(폴더는 bookImg)을 소스 폴더의 bookImg 폴더로 복사
		for(String img : image) {
			//0방부터 img에 copy
			if(img != null) {
				// 파일이 첨부되었다면
				InputStream is = null;
				OutputStream os = null;
				File serverFile = new File(path + "/" + img);
				try {
					// 여기까지 왔다는 것은 파일이 첨부되어 있다는 의미
					// 스트림 객체 생성
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:/webPro/source/06_JSP/model1ex/WebContent/bookImg/" + img); // 폴더를 받아오고 뒤에 / 꼭 써주기
					// 통째로 불러들이기 위해서 사용하는 byte
					byte[] bs = new byte[(int)serverFile.length()]; // maxsize가 5mb이기 때문에 int로 받아주어도 된다.
					while(true) {
						int readbyteCnt = is.read(bs);
						if(readbyteCnt == -1) {
							break;
						}
						os.write(bs, 0, readbyteCnt); // 서버에 첨부된 파일 가져오기(복사하기) 완료
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				} finally {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} // finally
			}// if
		} // for
		
		
		
		// 파일첨부 외 파라미터에서 입력된 정보를 가져옴 (get)
		// dto에서 가져올 것들 받아오기
		int bid = 0;
		String btitle = mRequest.getParameter("btitle");
		int    bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1 = image[1] == null ? "noImg.png" : image[1]; // 위의 소스코드 참고 
		String bimage2 = image[0] != null ? image[0] : "NOTHING.JPG";  // 파일 첨부를 하면 출력해주고 아니면 출력 x
		String bcontent = mRequest.getParameter("bcontent");
		int    bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		Date brdate = null;
		
		// request.get이 안된다.
		// DB에 가져온 정보들 inset 하는 작업
		BookDao bDao = BookDao.getInstance();
		BookDto book = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
		int result = bDao.insertBook(book);
		if(result == BookDao.SUCCESS) { %>
		<script>
			alert('책 등록 성공');
			location.href="booklist.jsp";
		</script>
		<% } else { %>
		<script>
			alert('책 등록 성공');
			location.href="bookRegister.jsp";
		</script>
		<%}%>
	
	<!-- 출력 -->
	<h3>책 이름 : <%=btitle %></h3>
	<h3>책 대표 이미지 <%=path%>/<%=bimage1 %></h3>
	
	<img src = "<%=conPath %>/bookImg/<%=bimage1%>" alt="대표">
	<h3>책 이미지2 : <%=path + "/" + bimage2%></h3>
	<img src="../bookImg/<%=bimage2 %>">
	<h3>책 설명</h3>
	<pre><%=bcontent %></pre>
	<h3>책 가격 : <del><%=bprice%></del> <%=bprice*(100-bdiscount)/100 %>원</h3>
	<h3>할인율 : <%=bdiscount %></h3>
	
	<!-- <a href="ex3_list_board.jsp">책 전체 리스트(게시판 스타일)</a>
	<a href="ex3_list_boardp.jsp">책 리스트(paging 게시판 스타일)</a>
	<a href="ex3_list_product.jsp">책 전체 리스트(쇼핑몰 스타일)</a> -->
	<a href="booklist.jsp">책 리스트(paging 추가된 쇼핑몰 스타일)</a>
	
	<jsp:include page="../main/footer.jsp"/>
	
</body>
</html>