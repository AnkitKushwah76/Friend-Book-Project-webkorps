<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.webkorbs.dto.UserProfileDto"%>
    <%@page import="java.util.*"%>
     <%@page import="com.webkorps.model.Following"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UserProfileDto profilefollowing = (UserProfileDto) request.getAttribute("userprofileDto");
ArrayList<Following> getallfollowing = (ArrayList<Following>) profilefollowing.getUserFollowing();

%>

<!-- Modal -->
<div class="modal fade" id="following" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">All Following </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
      
      
      <%
					if (getallfollowing.size() > 0) {
					for (int i = 0; i < getallfollowing.size(); i++) {
				%>
      <span><img class="myProfilePicture"
					src="../view/userProfileImg/<%=getallfollowing.get(i).getFollowing().getUserImage()%>">


					<h6><%=getallfollowing.get(i).getFollowing().getUserName()%></h6>
      
      <%
	       }	
	       
	       		
		} else {
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<img alt="" src="../view/userProfileImg/membership.png">
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
      </div>
    
      
     
</body>
</html>
