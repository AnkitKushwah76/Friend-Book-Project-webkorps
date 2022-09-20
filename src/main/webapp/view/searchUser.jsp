<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friends Profile Page</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
<%@include file="/view/Navbar/UserNavbar.jsp"%>

</head>
<body>


	<h1>${searchUserId.getId()}</h1>


	<br>
	<div class="d-flex justify-content-center">
		<c:if test="${searchUserId.getUserImage() !=null}">
			<img height="150" width="150" style="border-radius: 100px"
				src="../view/userProfileImg/${searchUserId.getUserImage() }" />
				
		</c:if>
	</div>
	<div class="d-flex justify-content-center">
		<h4>${searchUserId.getUserName()}</h4>
		
	</div>
	<c:if test="${searchUserId.getUserImage()!=null}">
		<div class="container mt-3">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-4">

							<a href="/followrequest?id=${searchUserId.getId()}"><button
									value=" " class="btn profile-edit-btn"
									style="background-color: #008CBA">Follow</button></a>
						</div>

					</div>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<div class="container mt-3">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</c:if>
	<div class="d-flex justify-content-center">
		<c:if test="${searchUserId.getUserImage()==null}">
			<img height="250" width="250"
				src="../view/userProfileImg/membership.png" />
		</c:if>
	</div>
</body>
</html>