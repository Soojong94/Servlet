<%@page import="com.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원목록보기</h2>
	<table border="1px">
		<thead>
			<tr>

				<th>No.</th>
				<th>ID</th>
				<th>PW</th>
				<th>NICK</th>
				<th>PHONE</th>

			</tr>
		</thead>

		<tbody>
			<%
			ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) request.getAttribute("list");

			
			for (int i = 0; i < list.size(); i++) {
				out.print("<tr>");
				out.print("<td>" + (i + 1) + "</td>");
				out.print("<td>" + list.get(i).getId() + "</td>");
				out.print("<td>" + list.get(i).getPw() + "</td>");
				out.print("<td>" + list.get(i).getNick() + "</td>");
				out.print("<td>" + list.get(i).getPhone() + "</td>");
				out.print("</tr>");
			}
			%>
		</tbody>
	</table>



</body>
</html>