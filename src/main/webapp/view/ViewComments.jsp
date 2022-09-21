<%@page import="org.apache.jasper.tagplugins.jstl.core.Remove"%>
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
%>

 <div class="page-content page-container" id="page-content">
    <div class="padding">
        <div class="row container d-flex justify-content-center">

          <div class="offset-lg-4 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">All Comments <span>
                  </span></h4>
                  <p class="card-description">
                  <%
                    String check=(String)session.getAttribute("check");
                    
                  %>
                  <%
                    if(check.equals("false")){
                  %>
                  <a href="showAllFollowersPost"
							class="btn profile-edit-btn">Back</a>
							<%}
                  else{%>
							<a href="showUserProfile"
							class="btn profile-edit-btn">Back</a>
					<%}
          		session.removeAttribute("succMsg");
					%>
					</p>
                  <div class="table-responsive">
                    <table class="table ">
                      <thead>
                        <tr>
                          <th>Image</th>
                          <th>UserName</th>
                          <th>Comments</th>
                          
                        </tr>
                      </thead>
                      <tbody>
                      <%
                      
              		if (comments.size() > 0) {
              		   for (int i = 0; i < comments.size(); i++) {
              			%>
                        <tr>
                          <td><img height="50" width="50"
					  style="border-radius: 100px"
					src="../view/userProfileImg/<%=comments.get(i).getUser().getUserImage()%>" /></th>
                    </td>
                          <td><%=comments.get(i).getUser().getUserName()%></td>
                          <td><%=comments.get(i).getComment()%></td>
                        </tr>
                        <%} 
                        }%>
                        
                      </tbody>
                    </table>
                    
                    
                    
                  </div>
                </div>
              </div>
            </div>
            
            </div>
              </div>
            </div>
</body>
</html> 