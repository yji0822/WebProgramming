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

	<form action="ex2_bookRegisterPro.jsp" method="post" enctype="multipart/form-data">

		<table>

			<caption>책등록</caption>
			<tr>
				<th>책제목</th>
				<!-- 데이터베이스 제약조건에 맞춰 maxlength 설정 / 보통은 name과 parameter와 일치 시켜준다. -->
				<td><input type="text" name="btitle" maxlength="33" required="required"></td>
			</tr>
			<tr>
				<th>책가격</th>
				<td><input type="number" name="bprice" min="0" maxlength="9999999" required="required"></td>
			</tr>
			<tr>
				<th>책이미지</th>
				<!-- 빈태그로 이름을 받고 싶으면 dto랑 이름을 다르게 해야한다. -->
				<td><input type="file" name="bimage1"></td>
			</tr>
			<tr>
				<th>책이미지</th>
				<td><input type="file" name="bimage2"></td>
			</tr>
			<tr>
				<th>책소개</th>
				<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<th>할인율</th>
				<td><input type="number" name="bdiscount" min="0" max="100" value="0"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="책등록" class="btn">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>