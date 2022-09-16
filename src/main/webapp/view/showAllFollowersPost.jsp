<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/view/Navbar/UserNavbar.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.webkorps.model.UserPost"%>
<%@page import="com.webkorps.model.User"%>
<%@page import="com.webkorps.model.UserFollowers"%>
<%@page import="com.webkorbs.dto.UserProfileDto"%>

<!DOCTYPE html>
<html>
<head>

<link href="/view/css/stylepro.css" rel="stylesheet" type="text/css">
<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		UserProfileDto userfollowersdto = (UserProfileDto) request.getAttribute("showAllFollowers");

	ArrayList<UserFollowers> userfollowers = (ArrayList<UserFollowers>) userfollowersdto.getUserFollowers();
	%>

	<h1><%=userfollowersdto.getCountPostLike()%></h1>

	<h1 class="text-center">All Upload Posts</h1>
	<%
		ArrayList<UserPost> followersposts = (ArrayList<UserPost>) userfollowersdto.getGetAllFollowerPost();

	if (followersposts.size() > 0) {
		for (int i = 0; i < followersposts.size(); i++) {
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-lg-4 offset-lg-5">

				<div class="col-md-3">
					<div class="card" style="width: 15rem;">
						<samp>
							<img height="50" width="50" style="border-radius: 100px"
								src="../view/userProfileImg/<%=followersposts.get(i).getUser().getUserImage()%>" />
							<samp>
								<h6><%=followersposts.get(i).getUser().getUserName()%></h6>
							</samp>
						</samp>
						<img height="300" width="300"
							src="../view/PostImage/<%=followersposts.get(i).getImage()%>"
							class="card-img-top">
						<ul class="list-group list-group-flush">
							<h6>
								Description :
								<%=followersposts.get(i).getDescription()%>
							</h6>
						</ul>
										<%-- <a href="postLike?postId=<%=followersposts.get(i).getId()%>"><button
							class="btn profile-edit-btn">like</button></a>
							 --%>
							
							<%-- <%
							if(<%=followersposts.get(i).getId()%>==1)
							%> --%>
							
							
							
						
						<span><button class="p-1 fa fa-heart-o" style="color: red"
								onClick="adddislike(<%=followersposts.get(i).getId()%>)"
								id="like<%=followersposts.get(i).getId()%>"></button></span> <span><%=followersposts.get(i).getPostlike().size()%></span>
						
				</div>

			</div>
		</div>
	</div>
	</div>

	<%
		}
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

	</div>
	</div>
</body>
</html>





</script>

<script>
var i=0;
	function adddislike(id){
	
		console.log("ID : "+id)
		if(i==0){
			
			console.log("if");
			$ ("#like"+id).removeClass("fa fa-heart-o");
			 $("#like"+id).addClass("fa fa-heart");
			 i=1;
				
					$.ajax({
						url:"/postLike?postId="+id,
						method:"get",
						success : function(result){
								location.reload();
								console.log("success");
								
							},
							error : function(result){
								console.log("fail");
								
							}
					});
				
		
			 
			 
		}
		else{
			
			console.log("else");
			$("#like"+id).removeClass("fa fa-heart");
			 $("#like"+id).addClass("fa fa-heart-o");
			 i=0;	
		}
	}
	
</script>




























