<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-Page</title>
<%@include file="/view/Navbar/base.jsp" %>
</head>
<body>
   <section>
	 <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action=login  method="post">
                            <h3 class="text-center text-info">Login</h3>
                            
                            <div class="alert alert-danger">
                             ${error}
                            </div>
                            <%
                             String  logout=(String)session.getAttribute("logout");
                           if(logout !=null)
                           {%>
                          
           						<div class="alert alert-danger">
                            <%=logout%>
                            </div>
           						<%
                           	session.removeAttribute("logout");
                           }
                           
                           %>
                            <!-- <div if="param.logout" class="alert alert-danger">
                             You have been  logged out
                            </div> --> 
                            
                            
                            <div class="form-group">
                                <label for="username" class="text-info">Email:</label><br>
                                <input type="text" name="userEmail" id="username" class="form-control" placeholder="Enter Email Address">
                            </div>
                            
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="userPassword" id="password" class="form-control" placeholder="Enter Password">
                            </div>
                             <div class="form-group">
                                <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                            
                                <div id="register-link" class="text-right">
                                <a href="/signup/" class="text-info">Register here</a>
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </section>
</body>
</html>