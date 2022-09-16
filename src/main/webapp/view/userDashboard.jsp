<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/view/Navbar/UserNavbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>this is about page</title>
</head>
<body>
	<%
		String succMsg = (String) session.getAttribute("succMsg");
	if (succMsg != null) {
	%>
	<h4 class="text-center text-sucess">
		<%=succMsg%>
	</h4>
	<%
		session.removeAttribute("succMsg");
	}
	%>

     
</body>
</html>