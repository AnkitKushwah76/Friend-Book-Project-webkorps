<%@page import="com.webkorps.model.Comments"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/view/Navbar/UserNavbar.jsp"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>this is about page</title>
</head>
<body>


	<%
		ArrayList<Comments> comments = (ArrayList<Comments>) request.getAttribute("getallComments");

	if (comments.size() > 0) {
	%>
	<h1 class="text-center"> <span><a href="showAllFollowersPost"><button
							class="btn profile-edit-btn">Back</button></a>
	</span>All Comments</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Image</th>
				<th scope="col">UserName</th>
				<th scope="col">Comments</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < comments.size(); i++) {
			%>

			<tr>
				<th scope="row"><img height="50" width="50"
					style="border-radius: 100px"
					src="../view/userProfileImg/<%=comments.get(i).getUser().getUserImage()%>" /></th>
				<td><%=comments.get(i).getUser().getUserName()%></td>
				<td><%=comments.get(i).getComment()%></td>

			</tr>

		</tbody>
	</table>

	<%
		}
	}else {%>
               
			<div class="container mt-5">
			
				<div class="row">
				
					<div class="col-md-4"></div>
					<div class="col-md-4">
					
						<img alt="" src="../view/userProfileImg/membership.png">
						<span><a href="showAllFollowersPost"><button
							class="btn profile-edit-btn">Back</button></a>
					</div>
					<div class="col-md-4"></div>
					
				</div>
			</div>


			<%}%>
		</div>

</body>
</html> 