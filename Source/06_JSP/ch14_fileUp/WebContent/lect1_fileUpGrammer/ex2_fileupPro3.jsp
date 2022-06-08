<%@page import="java.util.Arrays"%>
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

<%
	String conPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>

<body>

	<%
		String path = request.getRealPath("fileUpFolder"); // 반드시 소스폴더에 넣어놓은 이름과 동일하게
		int maxSize = 1024 * 1024 * 10; // 최대 업로드 용량 : 10mb - 크기가 넘어갈 경우 예외처리
		// 파일이 3개이기 때문에 배열로 받아온다
		// 파라미터의 파일을 첨부하지 않으면 null로 들어오는데 그냥 빈스트링으로 초기화
		String[] filename = { "", "", "" };
		String[] originalFilename = { "", "", "" };
		
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());

			// 받아오는 순서가 끝 파일부터 받아온다. file3, file2, file1	
			Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름들 불러오는 것
			int idx = 0;
			while (paramNames.hasMoreElements()) { // 다음 파일이 존재하는지 확인
				String param = paramNames.nextElement(); // 다음 파라미터 이름 받아옴 - 몇번부터 받아올지는 라이브러리에 따라 다르다.
				filename[idx] = mRequest.getFilesystemName(param); // 그 파라미터 이름으로 저장된 파일을 받아온다.
				originalFilename[idx] = mRequest.getOriginalFileName(param); // 사용자가 첨부할때 설정한 파일 원래 이름을 받아온다.

				// 순서가 어떻게 들어오는지 확인해보는 로직
				System.out.println(idx + "번째 파라미터 : " + param + "저장 파일 : " + filename[idx] + "원래 파일 이름 : " + originalFilename[idx]);
				idx++;
			} // while
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // try-catch 

		// 서버에 저장된 파일을 소스폴더로 복사
		for (String f : filename) {
			// null이 있을 수도 있고 없을 수도 있다.
			if (f != null) {
				// null값이 없을때만 copy 진행
				InputStream is = null;
				OutputStream os = null;
				try {

			File serverfile = new File(path + "/" + f);
			if (serverfile.exists()) { // 파일이 존재한다면.
				// 서버에 저장된 파일이 있는지 없는지 확인 > 첨부하지 않았을 경우에는 파일 복사를 진행하지 않는다.
				is = new FileInputStream(serverfile); // 톰캣 안에 있는 원본파일
				os = new FileOutputStream("D:/webPro/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/" + f); // 복사될 파일 경로 - properties 들어가서 그대로 복붙

				// 한바이트씩 옮기는 것이 아닌 통째로 옮겨오는 로직 수행
				byte[] bs = new byte[(int) serverfile.length()]; // 서버 파일의 크기만큼 받아오는 것. - .length()가 double로 반환되기 때문에 int로 형변환
				while (true) {
					int nReadCnt = is.read(bs); // 파일의 끝이 아닐경우 읽어들인 byte 수 : nReadCnt
					if (nReadCnt == -1)
						break; // 파일의 끝(-1)이면 빠져나와라
					os.write(bs, 0, nReadCnt); // 0번째(시작인덱스)부터 nReadCnt까지 읽어들여오는 것
				} // while
				System.out.println("서버 파일 첨부 및 복사 완료");
			} // if
				} catch (Exception e) {
			// 지정한 폴더가 존재하지 않는다면 예외가 발생된다.
			System.out.println(e.getMessage());
			} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} //try-catch
		} // finally
			
		} //if
	} // 확장 for문
	%>

	<%=Arrays.toString(filename)%>
	<%=Arrays.toString(originalFilename)%>
	
	
	<!-- 라이브러리 마다 첨부파일을 어떤 순서로 받아오는지 모른다. -->
	<h2>파일1 첨부 내용</h2>
	<h5><%=path %> / <%=filename[2]%></h5>
	<img src="<%=conPath %>/fileUpFolder/<%=filename[2] %>" alt="첫번째 첨부 파일">

	<h2>파일2 첨부 내용</h2>
	<h5><%=path %> / <%=filename[1]%></h5>
	<img src="<%=conPath %>/fileUpFolder/<%=filename[1] %>" alt="두번째 첨부 파일">
	
	<h2>파일3 첨부 내용</h2>
	<h5><%=path %> / <%=filename[0]%></h5>
	<img src="<%=conPath %>/fileUpFolder/<%=filename[0] %>" alt="세번째 첨부 파일">
</body>
</html>