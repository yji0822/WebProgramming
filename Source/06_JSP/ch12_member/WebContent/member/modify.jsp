<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<script src="<%=conPath%>/js/modify.js"></script>
</head>

<body>

	<!-- 선언부로 변수들 선언! -->
	<%! String id, name, phone1, phone2, phone3, gender, email, address; 
			Timestamp birth; %>
	<%
		MemberDto member = (MemberDto)session.getAttribute("member");
	// member == null 로그인 상태가 아님
		if(member == null) {
			// 로그인 상태가 아니라 정보수정 할  수 없도록 - modify.jsp에서 실행했을 경우를 위해서 넣어준 로직
			response.sendRedirect("login.jsp"); 
		} else {
			// 비밀번호는 세션에서 안받아왔기 때문에 받아오지 않는다.
			id = member.getId();
			name= member.getName();
			phone1 = member.getPhone1();
			phone2 = member.getPhone2();
			phone3 = member.getPhone3();
			gender = member.getGender();
			email = member.getEmail();
			address = member.getAddress();
			birth = member.getBirth();
		}
	%>		
	
	<form action="modifyOk.jsp" method="post" name="modify_frm" onsubmit="return infoConfirm()">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="<%= id %>" readonly="readonly"></td>
 			</tr>
 			<tr>
 				<th>현 비밀번호</th>
				<!-- 현 비밀번호를 반드시 입력할 수 있도록 / ☆ old비밀번호랑 세션에 있는 비밀번호가 같은지 확인 -->
 				<td><input type="password" name="oldPw" required="required"></td>
 			</tr>
 			<tr>
 				<th>새 비밀번호</th>
 				<!-- 반드시 pw로 name을 정해주어야 한다. / modify 진행 -->
 				<td><input type="password" name="pw" placeholder="비밀번호 수정이 싫으면 입력 하지 않아도 됨"></td>
 			</tr>
 			<tr>
 				<th>새 비밀번호 확인</th>
 				<td><input type="password" name="pwChk"></td>
 			</tr>
 			<tr>
 				<th>이름</th>
 				<td><input type="text" name="name" value="<%= name%>" required="required"></td>
 			</tr>
 			<tr>
 				<th>전화번호</th>
 				<td><select name ="phone1">
 							<!-- 기존에 저장되어 있는 정보들이 selected가 되어있도록 -->
 							<option></option>
 							<option <% if("010".equals(phone1)){
 													out.print("selected='selected'");
 											}%>>010</option>
 											
 							<option <% if("02".equals(phone1)){
 													out.print("selected='selected'");
 											}%>>02</option>
 											
 							<option <% if("031".equals(phone1)){
 													out.print("selected='selected'");
 											}%>>031</option>
 											
 							<option <% if("032".equals(phone1)){
 													out.print("selected='selected'");
 											}%>>032</option>
 						</select> - 
 						<!-- null 값이 들어가기 시작 : 값이 들어가 있으면 넣어주고 아니면 빈스트링 값을 저장하는 삼항연산자 -->
 						<input type="text" name="phone2" value='<%=phone2!=null? phone2:"" %>' size="2"> - 
 						<input type="text" name="phone3" value='<%=phone3!=null? phone3:"" %>' size="2">
 				</td>
 			</tr>
 			<tr>
 				<th>성별</th>
 				<td>
 					<% if("m".equals(gender)){ %>
 						<input type="radio" name="gender" value="m" checked="checked"> 남 
 						<input type="radio" name="gender" value="f"> 여 
 					<%} else if("f".equals(gender)) { %>
 						<input type="radio" name="gender" value="m"> 남 
 						<input type="radio" name="gender" value="f" checked="checked"> 여 
 					<%} else { %>
 						<input type="radio" name="gender" value="m"> 남 
 						<input type="radio" name="gender" value="f"> 여 
 					<%} %>
 			</tr>
 			<tr>
 				<th>이메일</th>
 				<td><input type="email" name="email" value='<%=email == null ? "" : email %>'></td>
 			</tr>
 			<tr>
 				<th>생일</th>
 				<td><input type="date" name="tempbirth" value='<%=birth == null ? "" : birth.toString().substring(0,10) %>'></td>
 			</tr>
 			<tr>
 				<th>주소</th>
 				<td><input type="text" name="address" value='<%=address == null ? "" : address %>'></td>
 			</tr>
 			<tr>
 				<td colspan="2">
 					<input type="submit" value="정보수정">
 					<input type="reset" value="취소" onclick="history.back()">
 					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
 				</td>
 			</tr>
		</table>
	</form>

</body>
</html>