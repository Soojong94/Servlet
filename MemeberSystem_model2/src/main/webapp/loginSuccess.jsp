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


	<%-- Web Page �� (Nick)�� ȯ���մϴ�! �� ����ϼ��� --%>
	<%
	
	MemberDTO info = (MemberDTO) session.getAttribute("info");
	
	
	%>
	<h1 align = "center"><%=info.getNick() %> �� ȥ���ɼ���</h1>
	
	<a href = "LogoutService">�α׾ƿ�</a>
	
	
	
</body>
</html>