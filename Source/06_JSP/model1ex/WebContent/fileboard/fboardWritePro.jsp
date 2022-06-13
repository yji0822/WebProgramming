<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
	} //파일 하나 받아오기 완료..
	
	
	
	// 파라미터 정보들 받아오기
	String pageNum = mRequest.getParameter("pageNum");
	int fnum = Integer.parseInt(mRequest.getParameter("fnum"));
	
	// 데이터 베이스에 있는 순서대로 하나하나 받아오자
	String cid=((CustomerDto)session.getAttribute("customer")).getCid();
	String fsubject = mRequest.getParameter("fsubject");
	String fcontent = mRequest.getParameter("fcontent");
	String fpw = mRequest.getParameter("fpw");
	/* ffilename은 받아온 것이 있다. */
	int fref = Integer.parseInt(mRequest.getParameter("fref")); // 원글 : 0, 답변글 : 원글정보
	int fre_step = Integer.parseInt(mRequest.getParameter("fre_step")); // 원글 : 0, 답변글 : 원글의 fref
	int fre_level = Integer.parseInt(mRequest.getParameter("fre_level")); // 원글 : 0, 답변글 : 원글의 fref
	String fip = request.getRemoteAddr();
	
	FileboardDto fbDto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, 0,
													fref, fre_step, fre_level, fip, null);
	// public FileboardDto(int fnum, String cid, String fsubject, String fcontent, String ffilename, String fpw, int fhit,
	//		int fref, int fre_step, int fre_level, String fip, Date frdate)
	// 저장
	FileboardDao fbDao = FileboardDao.getInstance();
	int result;
	
	if(fnum == 0) {
		// 원글 쓰기
		result = fbDao.insertBoard(fbDto);
	} else {
		// 답변글 쓰기
		result = fbDao.reply(fbDto);
	}
	
	if(result == FileboardDao.SUCCESS) {
	%>
		<script>
			alert('글 입력 성공!');
			/*원글인지 아닌지 모르니까 무조건 pageNum 넘겨준다*/
			location.href = 'fboardList.jsp?pageNum=<%=pageNum%>';
		</script>
	<%} else { %>
		<script>
			alert('글쓰기 실패');
			history.back(-1);
		</script>
	<%} %>
	%>

</body>
</html>