<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
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
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>

<body>
	<%
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024 * 1024 * 5; // 업로드 제한 용량 : 5mb
		String ffilename = null; // 첨부파일이 서버에 저장된 이름
		MultipartRequest mRequest = null;
		
		// 자바에서는 반드시 try-catch / IOException
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames(); 
			// 어차피 첨부파일은 하나!
			String param = params.nextElement(); //파라미터
			ffilename = mRequest.getFilesystemName(param); // 이값이 null이 아니면 새로운 파일이  첨부되었다는 의미
			
			if(ffilename != null) {
				// 서버에 소스 폴더로 파일 복사
				InputStream is = null;
				OutputStream os = null;
				
				try {
					File serverFile = new File(path+"/"+ffilename);
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:/webPro/source/06_JSP/model1ex/WebContent/fileboardUpload/"+ffilename);
					
					byte[] bs = new byte[(int)serverFile.length()];
					int readByteCnt;
					while((readByteCnt = is.read(bs))!= -1){
						os.write(bs, 0, readByteCnt); // 파일복사 완료
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				} finally {
					if(os != null) os.close();
					if(is != null) is.close();
				}
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		} //파일 하나 받아오기 완료......
		
		// 파라미터 정보들 받아오기
		String pageNum = mRequest.getParameter("pageNum");
		String dbfilename = mRequest.getParameter("dbfilename");
		int fnum = Integer.parseInt(mRequest.getParameter("fnum"));
		
		// 업데이트 하기 전에 받아와야 할것
		// MultipartRequest 로 받아오면 이후에 모든 request를 mrequest로 받아온다
		String fsubject = mRequest.getParameter("fsubject");
		// ffilename이 비어있으면 db에 저장된 이름 그대로를 출력하고 아닌 경우에는 새로 파일 이름을 저장해준다.
		ffilename = (ffilename== null? dbfilename : ffilename);
		String fcontent = mRequest.getParameter("fcontent");
		String fpw = mRequest.getParameter("fpw");
		String fip = request.getRemoteAddr(); //getRemoteAddr()은 ip주소를 불러오는 함수이므로 request로 받아온다
		
		// dto에 받아온 입력값들 넣어주는 작업 - 수정할거 아니면 0이나 null 넣기 // 자동으로 불러오고 싶다면 수정용 dto를 만들어주면 된다.
		FileboardDto fbDto 
			= new FileboardDto(fnum, null, fsubject, fcontent, ffilename, fpw, 0, 0, 0, 0, fip, null);
		
		FileboardDao fbDao = FileboardDao.getInstance();
		int result = fbDao.updateBoard(fbDto);
		if(result == FileboardDao.SUCCESS) {
		%>
			<script>
				alert('글 수정 완료');
				location.href='fboardList.jsp?pageNum=<%=pageNum%>';
			</script>
		<%} else {%>
			<script>
				alert('글 수정 실패. 입력하신 내용들을 다시 확인하여 주세요.');
				history.go(-1);
			</script>
		<%}%>
	%>
	

</body>
</html>