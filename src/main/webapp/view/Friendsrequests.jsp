<%@page import="com.webkorps.model.Notifications"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/view/Navbar/UserNavbar.jsp"%>

<link href="/view/css/stylepro.css" rel="stylesheet" type="text/css">

<%
	ArrayList<Notifications> user = (ArrayList<Notifications>) request.getAttribute("request");
if (user.size() > 0) {
%>

<div class="container mt-5">
	<div class="row">
		<h1 class="text-center text-primary">Friend Requests</h1>
		<%
			for (int i = 0; i < user.size(); i++) {
		%>

		<div class="col-md-3">
			<div class="row mt-5">
				<div class="col-md-6">
					<%
						if (user.get(i).getSendUserRequest().getUserImage() != null) {
					%><img
						alt=""
						src="../view/userProfileImg/<%=user.get(i).getSendUserRequest().getUserImage()%>"
						height="200" width="200" style="border-radius: 800px">
					<%
						} else {
					%>
					<img alt="" src="../view/userProfileImg/profile.png" height="100"
						width="100" style="border-radius: 800px">
					<%
						}
					%>
					<div>
						<label class="text-center text-dark">Name : <%=user.get(i).getSendUserRequest().getUserName()%></label>
					</div>
					
						<%
							if (user.get(i).getAccept() == false) {
						%><%-- <a
							href="acceptrequest?userId=<%=user.get(i).getSendUserRequest().getId()%>">    Confirm</a> --%>
						<div class="profile-user-settings">

							<a
								href="acceptrequest?userId=<%=user.get(i).getSendUserRequest().getId()%>">
								<button class="btn profile-edit-btn">Confirm</button>
							</a>
						</div>

						<%
							}
						%>
					
					<%-- <h6>
						<%
							if (user.get(i).getAccept() == false) {
						%><a
							href="/follower/declinerequest?userId=<%=user.get(i).getSendUserRequest().getId()%>">Decline</a>
						<%
							}
						%>
							--%>
					</h6>
				
						<%-- <a
							href="/follower/followback?userId=<%=user.get(i).getSendUserRequest().getId()%>">Follow
							Back</a> --%>
							<br><br>
							
				     	<div class="">

							<a
								href="followbackUser?userId=<%=user.get(i).getSendUserRequest().getId()%>"">
								<button class="btn profile-edit-btn">FollowBack</button>
							</a>
						</div>		
							
				

				</div>
			</div>
		</div>

		<%
			}
		%>
	</div>
</div>
<%
	} 
else {
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


