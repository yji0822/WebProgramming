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

	<h3> ID : ${param.id }</h3> <!-- 같은 이름의 파라미터 두개면 앞에 있는 한개만 받아온다 -->
	<h3>좋아하는 동물의 이름은
	 ${paramValues.pets[0] }
   ${paramValues.pets[1] }
	 ${paramValues.pets[2] }
	 ${paramValues.pets[3] }
	 
	  <!-- 들어간 파라미터 값이 있니? 확인 -->
	 ${empty paramValues.pets ? "없습니다." : " " }
	</h3>
	<!-- 하나도 선택을 하지 않았을 경우에는 모든 배열의 값이 null이 들어가있게 된다. -->

	
	<%-- <%
		String id = request.getParameter("id");
		String[] pets = request.getParameterValues("pets"); // 배열로 받으면 된다. checkbox
		out.println("<h3>ID : " + id + "</h3>");
		
		out.println("<h3> 키우는 동물은 ");
		if(pets != null) {
			for(String pet : pets) {
				out.println(pet + " ");
			} // for
		} else {
			out.println("없습니다.");
		}
		out.println("</h3>");
	%> --%>
	
	
	

</body>
</html>