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
	<!-- fileUpForm에서 업로드 후에 톰캣 폴더에 저장이 되는지 안되는지 확인 -->
<%
	String path = request.getRealPath("fileUpFolder");
	// out.print(path); // path 설정 : 톰캣 폴더 기준으로 저장된다. 내 소스 폴더에 저장되는 것이 아님!
	int maxSize = 1024 * 1024 * 10; // 최대 파일 업로드 사이즈 설정 10Mb(이력서 업로드 기준)
	String filename= ""; // 서버에 저장될 파일 이름 - null로 초기화 (첨부하지 않으면 자동으로 null로 초기화가 된다.)
	// 중복 이름이 있으면 알아서 이름을 변경해서 넣어줄 예정 - 업로더가 올린 파일명은 변경하지 않으되, 시스템에서는 rename을 해주어서 저장해준다.
	String originalFilename = ""; // 업로드한 오리지널 파일 이름 (사용자가 업로드 시 입력한 파일 이름)
	
	try{
		/* MultipartRequest(javax.servlet.http.HttpServletRequest request, java.lang.String saveDirectory, int maxPostSize, java.lang.String encoding, FileRenamePolicy policy)
		Constructs a new MultipartRequest to handle 
		the specified request, saving any uploaded files to the given directory, and limiting the upload size to the specified length. */
		
		// new DefaultFileRenamePolicy() : 같은 이름의 파일이 서버에 존재할 경우 자동으로 rename을 해준다 - 1.jpg >> 11.jpg 이런 식으로 (데이터베이스에 올리도록 하는 파일 이름)
		MultipartRequest multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());

		// fileUpForm.jsp안의 form 태그 input type name의 "file" 가져오기
		Enumeration<String> paramNames = multipartRequest.getFileNames(); // 파라미터 이름들 불러오는 작업 - paramNames는 file을 가르킨다
		String param = paramNames.nextElement(); // 파라미터 이름 "file"을 받아온다
		
		// 그 파라미터 안에 있는 file 명이 뭔지 확인 - 데이터 베이스에서도 사용할 예정
		filename = multipartRequest.getFilesystemName(param); // 시스템 상의 파라미터 이름으로 저장된 파일의 이름 101, 1011, 1012...
		originalFilename = multipartRequest.getOriginalFileName(param); // 사용자가 설정한 파일 이름
		
		System.out.println("파라미터 이름 : " + param + " / 서버에 저장된 파일 이름 : " + filename 
												+ " / 사용자가 업로드한 오리지널 파일 이름 : " + originalFilename);
		
		// 파일을 업로드 하지 않았다면? filename과 originalFilename은 null(default)
		
	} catch(IOException e) {
			System.out.println(e.getMessage());
	}
	
	
	// 서버(톰캣 안의 fileUpFolder)에 업로드한 파일을 소스폴더 안의 fileUpFolder 폴더로 파일을 복사해주도록 한다
	// 자바의 filecopy 파일 복사 로직 - step3
	InputStream is = null;
	OutputStream os = null;
	try {
		
		File serverfile = new File(path + "/" + filename);
		if(serverfile.exists()){ // 파일이 존재한다면.
		// 서버에 저장된 파일이 있는지 없는지 확인 > 첨부하지 않았을 경우에는 파일 복사를 진행하지 않는다.
			is = new FileInputStream(serverfile); // 톰캣 안에 있는 원본파일
			os = new FileOutputStream("D:/webPro/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/" + filename); // 복사될 파일 경로 - properties 들어가서 그대로 복붙
			
			// 한바이트씩 옮기는 것이 아닌 통째로 옮겨오는 로직 수행
			byte[] bs = new byte[(int)serverfile.length()]; // 서버 파일의 크기만큼 받아오는 것. - .length()가 double로 반환되기 때문에 int로 형변환
			while(true) {
				int nReadCnt = is.read(bs); // 파일의 끝이 아닐경우 읽어들인 byte 수 : nReadCnt
				if(nReadCnt == -1 ) break; // 파일의 끝(-1)이면 빠져나와라
				os.write(bs, 0, nReadCnt); // 0번째(시작인덱스)부터 nReadCnt까지 읽어들여오는 것
			} // while
					System.out.println("서버 파일 첨부 및 복사 완료");
		} // if
	} catch(Exception e) {
		// 지정한 폴더가 존재하지 않는다면 예외가 발생된다.
		System.out.println(e.getMessage());
	} finally {
		try {
			if(os!=null) os.close();
			if(is!=null) is.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} //try-catch
	} // finally
	
	
	// 파일 첨부를 했는지 안했는지 확인
	if(filename != null) {
		// 첨부 + 첨부한 이미지도 함께 출력
%>
	<h3>첨부한 오리지널 파일 이름 : <%=originalFilename %></h3>
	<h3>서버에 저장된 파일 이름: <%=path %>/<%=filename %></h3>
	<img src="<%=conPath %>/fileUpFolder/<%=filename %>" alt="첨부파일">		
<%
	} else {
		// 첨부X
		out.println("<h2>첨부 안 함 </h2>");
	}
%>

</body>
</html>