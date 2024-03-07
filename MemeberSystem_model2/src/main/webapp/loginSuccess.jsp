<%@page import="com.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body >


	<%-- Web Page 에 (Nick)님 환영합니다! 를 출력하세요 --%>
	<%
	
	MemberDTO info = (MemberDTO) session.getAttribute("info");
	
	
	%>
	<h1 align = "center"><%=info.getNick() %> 님 혼저옵서예</h1>
	
	<a href = "LogoutService">로그아웃</a>
	
	
	
</body>
</html>