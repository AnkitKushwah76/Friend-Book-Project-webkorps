<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.webkorps.model.UserPost"%>
<%@page import="com.webkorps.model.User"%>
<%@page import="com.webkorps.model.Following"%>
<%@page import="com.webkorbs.dto.UserProfileDto"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/view/Navbar/UserNavbar.jsp"%>
<link href="/view/css/stylepro.css" rel="stylesheet" type="text/css">
<%@page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title>this is about page</title>
</head>
<body>


	<%
		String userName1 = (String) session.getAttribute("userName");

	UserProfileDto profile = (UserProfileDto) request.getAttribute("userprofileDto");
	ArrayList<UserPost> posts = (ArrayList<UserPost>) profile.getGetAllPost();
	ArrayList<Following> following = (ArrayList<Following>) profile.getUserFollowing();

	User user = (User) profile.getUser();
	%>




	<div></div>
	<div class="center">
		<div class="container ">


			<div class="profile">

				<div class="profile-image">

					<!-- <img src="https://images.unsplash.com/photo-1513721032312-6a18a42c8763?w=152&h=152&fit=crop&crop=faces" alt="">
 -->


					<img src="../view/userProfileImg/${findByUser.getUserImage()}"
						style="height: 200px; width: 200px; margin-left: 250px">
				</div>

				<div class="profile-user-settings">

					<h1 class="profile-user-name">${findByUser.getUserName()}</h1>

					<a href="updateUserProfile"><button
							class="btn profile-edit-btn">Edit Profile</button></a>

					<button class="btn profile-settings-btn"
						aria-label="profile settings">
						<i class="fas fa-cog" aria-hidden="true"></i>
					</button>

				</div>

				<div class="profile-stats">

					<ul>
						<c:if test="${userprofileDto.getCountPost()>0}">
							<li><span class="profile-stat-count">${userprofileDto.getCountPost()}</span>
								Posts</li>

						</c:if>
						<c:if test="${userprofileDto.getCountFollowers()>0}">
							<li><p style="margin-left: 20px">
									<span class="profile-stat-count">${userprofileDto.getCountFollowers()}</span>
										Followers</li>
						</c:if>




						<c:if test="${userprofileDto.getCountFollowing() >0}">
							<li><p style="margin-left: 20px">
									<a data-toggle="modal" data-target="#exampleModa2"
										class="nav-link "> <span class="profile-stat-count ">${userprofileDto.getCountFollowing()}</span>
										Following
									</a></li>
						</c:if>
					</ul>

				</div>

				<div class="profile-stats1">

					<ul>
						<li><p style="margin-left: 420px">
								<span class="profile-stat-count">FavoriteSongs:-</span>
								${findByUser.getFavoriteSongs()}
							</p></li>
						<br>
						<li><p style="margin-left: 420px">
								<span class="profile-stat-count">FavoriteBooks:-</span>
								${findByUser.getFavoriteBooks()}</li>
						<br>
						<li><p style="margin-left: 420px">
								<span class="profile-stat-count">FavoritePlaces:-</span>
								${findByUser.getFavoritePlaces()}</li>
					</ul>
				</div>

			</div>
		</div>
</body>
</html>





<h1 class="text-center">Upload Posts</h1>
<%
	if (posts.size() > 0) {
	for (int i = 0; i < posts.size(); i++) {
%>


<div class="container">

	<div class="gallery">

		<div class="gallery-item" tabindex="2">

			<img height="300" width="300"
				src="../view/PostImage/<%=posts.get(i).getImage()%>"
				class="gallery-image" alt="">

			<ul class="list-group list-group-flush">
				<h6>
					Description :
					<%=posts.get(i).getDescription()%></h6>

			</ul>

		</div>
		<%
			}
		%>
	</div>

	<%
		} else {
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<img alt="" src="../view/userProfileImg/noresult.png">
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%
		}
	%>
</div>







<!--  Following Modal -->


	<div class="modal fade" id="exampleModa2" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabe2">All Following</h5>
				</div>
	
				<%
					if (following.size() > 0) {
					for (int i = 0; i < following.size(); i++) {
				%>
	
				<table class="table">
					<thead class="thead-dark">
						<tr>
	
							<th scope="col">Image</th>
							<th scope="col">Name</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
	
	
						<tr>
							<td><img class="myProfilePicture"
								src="../view/PostImage/<%=following.get(i).getFollowing().getUserImage()%>" />
	
							</td>
							<td><span><%=following.get(i).getFollowing().getFullName()%></span></td>
							</td>
							<td>
								<button class="btn btn-danger btn-sm"></button>
								<button class="btn btn-primary btn-sm"></button>
	
							</td>
	
						</tr>
	
					</tbody>
				</table>
	
	
	
			</div>
		</div>
	</div>
	<%
		}
	%>
	<%
		} else {
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<img alt="" src="../view/userProfileImg/noresult.png">
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%
		}
	%>
	</div>
	
	<!--  Following Modal -->
	
	
	
	
<!--  Followers  Modal -->


	<div class="modal fade" id="exampleModa3" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabe2">All Following</h5>
				</div>
	
				<%
					if (following.size() > 0) {
					for (int i = 0; i < following.size(); i++) {
				%>
	
				<table class="table">
					<thead class="thead-dark">
						<tr>
	
							<th scope="col">Image</th>
							<th scope="col">Name</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
	
	
						<tr>
							<td><img class="myProfilePicture"
								src="../view/PostImage/<%=following.get(i).getFollowing().getUserImage()%>" />
	
							</td>
							<td><span><%=following.get(i).getFollowing().getFullName()%></span></td>
							</td>
							<td>
								<button class="btn btn-danger btn-sm"></button>
								<button class="btn btn-primary btn-sm"></button>
	
							</td>
	
						</tr>
	
					</tbody>
				</table>
	
	
	
			</div>
		</div>
	</div>
	<%
		}
	%>
	<%
		} else {
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<img alt="" src="../view/userProfileImg/noresult.png">
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%
		}
	%>
	</div>
	
	<!--  Followers  Modal -->
	
	
	
	
	



















