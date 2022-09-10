<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/view/Navbar/UserNavbar.jsp" %>
<link href="/view/css/stylepro.css" rel="stylesheet" type="text/css">
<%@page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>this is about  page</title>
</head>
<body>
 <h1>hello</h1>
    
     <%
    String userName1=(String)session.getAttribute("userName");
  %>
    <div>
    
    </div>
    <div class="center">
    <div class="container ">
   
     
		<div class="profile">

			<div class="profile-image">

				<!-- <img src="https://images.unsplash.com/photo-1513721032312-6a18a42c8763?w=152&h=152&fit=crop&crop=faces" alt="">
 -->     
 
 
           <img src="../view/userProfileImg/${findByUser.getUserImage()}"  style="height:200px; width:200px; margin-left:250px">
			</div>

			<div class="profile-user-settings" >

				<h1 class="profile-user-name">${findByUser.getUserName()}</h1>

			<a href="updateUserProfile"><button class="btn profile-edit-btn">Edit Profile</button></a>

				<button class="btn profile-settings-btn" aria-label="profile settings"><i class="fas fa-cog" aria-hidden="true"></i></button>

			</div>

			<div class="profile-stats">

				<ul>
					<li><span class="profile-stat-count">164</span> posts</li>
					<li><span class="profile-stat-count">188</span> followers</li>
					<li><span class="profile-stat-count">206</span> following</li>
				</ul>

			</div>
              
              <div class="profile-stats1">
              
                 <ul>
                     <li><span class="profile-stat-count">FavoriteSongs:-</span> ${findByUser.getFavoriteSongs()}</li><br>
                     <li><p style="margin-left:420px"><span class="profile-stat-count" >FavoriteBooks:-</span> ${findByUser.getFavoriteBooks()}</li><br>
                     <li><p style="margin-left:420px"><span class="profile-stat-count">FavoritePlaces:-</span> ${findByUser.getFavoritePlaces()}</li>
                 </ul>
              </div>
              
		</div> 
		</div>
		
</body>
</html>