<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
   <!-- 프로젝트용 -->
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <link href="${conPath }/css/header.css" rel="stylesheet">
<style>
   @charset "UTF-8";

* {
   font-family: 'Black Han Sans', sans-serif;
   list-style : none;
   text-decoration : none;
   border-collapse : collspse;
   margin:0px;
   padding:0px;
   color:#000;
}

header .gnb{
   width:100%;
   
   overflow:hidden;
}

header .gnb ul > li {
   color:white;
   font-size :10px;
   line-height : 30px;
   
}

header .gnb a {
   
   display : block;
   padding-left : 15px;
   padding-right : 15px;
   
}
header .gnb .logo1 {
   font-size: 2em;
   color: blue;
   display : block;
   padding-left : 15px;
   padding-right : 15px;
}
header .gnb .left{
   width:400px;
   height : 30px;
   line-height :30px;
   float:left;
}
header .gnb .left li{
   float:left; 
   margin-left : 30px;
}

header .gnb .right{
   float:right; 
   width:400px;
   height : 30px;
   line-height :30px;
}
header .gnb .right li{
   float:right; 
   margin : 30px;
}
header .logo{
   text-align : center;
   boarder :1px solid gray;
   
}
</style>
</head>
<body>
<header>
   <c:if test="${empty customer and empty admin}"> <%-- 로그인 전 화면 --%>
   <div class="gnb">
        <ul class="left">
          <li><a href="${conPath }/main.do" class="logo1">교래향 </a></li>
         <li><a href="#">오시는길</a>
         <li><a href="#">메뉴보기</a>
       </ul>
        <ul class="right">
         
         <li><a href="#">후기</a></li>
          <li><a href="${conPath }/boardList.do">공지사항</a></li>
          <li><a href="${conPath }/joinView.do">회원가입</a></li>
          <li><a href="${conPath }/loginView.do">로그인</a></li>
       </ul>
   </div>
      
   </c:if>
    <c:if test="${not empty customer and empty admin}"> 사용자 모드 로그인 화면
      <div class="gnb">
         <ul class="left">
            <li><a href="${conPatn }/main.do">교래향</a></li>
            <li><a href="#">오시는길</a>
            <li><a href="#">메뉴보기</a>
         </ul>
         <ul class="right">
            
             <li><a href="#">후기</a></li>
            <li><a href="${conPath }/boardList.do">공지사항</a></li>
            <li><a href="#">정보수정</a></li>
            <li><a href="${conPath }/logout.do">로그아웃</a></li>
         </ul>
      </div>
   </c:if>
   <div class="logo">
         <img src="${conPath }/img/logo2.JPG" width=100%  height = 200px;>
      </div>
   <c:if test="${empty member and not empty admin}"> 관리자 모드 로그인 화면
      <div class="gnb">
         <ul>
            <li><a href="${conPath }/boardList.do">고객센터</a></li>
            <li><a href="${conPath }/logout.do">관리자모드나가기</a></li>
            <li><a>${admin.aName }님 &nbsp; ▶</a></li>   
         </ul>
      </div>
      <div class="logo" onclick="location.href='${conPath}/allView.do'">
         LOGO
      </div>
      <div class="lnb">
         <ul>
            <li>관리자의메뉴1<ol class="subMenu">
                     <li><a href="#">메뉴1-1</a></li>
                     <li><a href="#">메뉴1-2</a></li>
                     <li><a href="#">메뉴1-3</a></li>
                  </ol>
            </li>
            <li>관리자의메뉴2<ol class="subMenu">
                     <li><a href="#">메뉴2-1</a></li>
                     <li><a href="#">메뉴2-2</a></li>
                     <li><a href="#">메뉴2-3</a></li>
                  </ol>
            </li>
            <li>관리자의메뉴3<ol class="subMenu">
                     <li><a href="#">메뉴3-1</a></li>
                     <li><a href="#">메뉴3-2</a></li>
                     <li><a href="#">메뉴3-3</a></li>
                  </ol>
            </li>
            <li>관리자의메뉴4<ol class="subMenu">
                     <li><a href="#">메뉴4-1</a></li>
                     <li><a href="#">메뉴4-2</a></li>
                     <li><a href="#">메뉴4-3</a></li>
                  </ol>
            </li>
         </ul>
      </div>
   </c:if> 
</header>
</body>
</html>