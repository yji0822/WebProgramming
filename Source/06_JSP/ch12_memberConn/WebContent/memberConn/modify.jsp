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
	<script src="<%=conPath %>/js/modify.js"></script>
</head>
<body>
	<%! String id, name, phone1, phone2, phone3, gender, email, address;
		Timestamp birth;
	%>
	
	<%
		MemberDto member = (MemberDto)session.getAttribute("member");
		if(member == null) {
			// 현재 modify.jsp 파일에서 바로 실행했을 경우, 로그인이 되어있지 않은 상태로
			// 로그인 후 이 창에 접속할 수 있도록 한다.
			response.sendRedirect("login.jsp");
		} else {
			// 회원가입시 입력했던 정보들을 가져온다.
			id = member.getId();
			name = member.getName();
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
					<td><input type="text" name="id" value="<%=id %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>현비밀번호</th>
					<!-- 비밀번호를 변경하고자 한다면 무조건 기존에 설정한 비밀번호를 입력할 수 있도록 한다. -->
					<td><input type="password" name="oldPw" required="required"></td>
				</tr>
				<tr>
					<th>새비밀번호</th>
					<td><input type="password" name="pw" placeholder="변경을 원하지 않을 시 공란"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="pwChk"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
					<!-- 회원가입 시, selected문으로 입력 받았던 phone1을 불러오는 로직. 값이 같다면 선택되어 지도록ㄴ -->
						<select name="phone1">
							<option></option>
							<option <%if("010".equals(phone1)){
								out.print("selected='selected'");
							} %>>010</option>
							<option <%if("02".equals(phone1)) {
								out.print("selected='selected'");
							} %>>02</option>
							<option <%if("031".equals(phone1)) {
								out.print("selected='selected");
							} %>>031</option>
							<option <%if("032".equals(phone1)){
								out.print("selected='selected'");
							} %>>032</option>
						</select> - 
						<input type="text" name="phone2" value='<%=phone2 != null ? phone2 :"" %>' size="2"> - 
						<input type="text" name="phone3" value='<%=phone3 != null ? phone3 : "" %>' size="2">
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
					<!-- 성별은 회원가입 시 선택 사항. 라디오버튼이기 때문에 한번 클릭하면 무조건 선택을 해야한다. -->
					<% if("m".equals(gender)) { %>
						<!-- 가입 시 남자를 체크한 경우 -->
						<input type="radio" name="gender" value="m" checked="checked"> 남
						<input type="radio" name="gender" value="f"> 여	
					<% } else if("f".equals(gender)){ %>
						<!-- 가입 시 여자를 체크한 경우 -->
						<input type="radio" name="gender" value="m"> 남
						<input type="radio" name="gender" value="f" checked="checked"> 여 
					<%} else {%>
						<!-- 가입 시 아무것도 체크하지 않았다면  -->
						<input type="radio" name="gender" value="m"> 남
						<input type="radio" name="gender" value="f"> 여
					<%} %>
					</td>
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
					<td><input type="text" name="address" value='<%=address == null ?  "" : address %>'></td>
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