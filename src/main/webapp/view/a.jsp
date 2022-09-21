<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.*"%>
<%@page import="com.webkorps.model.UserPost"%>
<%@page import="com.webkorps.model.User"%>
<%@page import="com.webkorps.model.Following"%>
<%@page import="com.webkorps.model.UserFollowers"%>
<%@page import="com.webkorbs.dto.UserProfileDto"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/view/Navbar/UserNavbar.jsp"%>
<%@include file="/view/deletePost.jsp"%>
<link href="/view/css/stylepro.css" rel="stylesheet" type="text/css">
<%@page isELIgnored="false"%>
<title>this is about page</title>



</head>
<body>
<%
		String userName1 = (String) session.getAttribute("userName");

	UserProfileDto profile = (UserProfileDto) request.getAttribute("userprofileDto");

	ArrayList<UserPost> posts = (ArrayList<UserPost>) profile.getGetAllPost();
	ArrayList<Following> following = (ArrayList<Following>) profile.getUserFollowing();
	ArrayList<UserFollowers> followers = (ArrayList<UserFollowers>) profile.getUserFollowers();
	/* ArrayList<Comments> Comments = (ArrayList<Comments>) profile.getComments(); */

	User user = (User) profile.getUser();
	%>
	
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
						<%
							if (profile.getCountPost() >= 0) {
						%>

						<li><span class="profile-stat-count"><%=profile.getCountPost()%></span>
							Posts</li>
						<%
							}
						%>


						<%
							if (profile.getCountFollowers() >= 0) {
						%>
						<li><p style="margin-left: 20px">
								<a data-toggle="modal" data-target="#Followers"
									class="nav-link "> <span class="profile-stat-count"><%=profile.getCountFollowers()%></span>
									Followers
								</a></li>
						<%
							}
						%>




						<%
							if (profile.getCountFollowing() >= 0) {
						%>
						<li><p style="margin-left: 20px">
								<a data-toggle="modal" data-target="#following"
									class="nav-link "> <span class="profile-stat-count "><%=profile.getCountFollowing()%></span>
									Following
								</a></li>
						<%
							}
						%>
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


