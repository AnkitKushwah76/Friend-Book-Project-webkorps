

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserProfile</title>
<%@include file="/view/Navbar/UserNavbar.jsp" %>

</head>
<body>
   <section>
	 <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form  enctype="multipart/form-data" id="login-form" class="form" action=AddPost method="post">
                            <h3 class="text-center text-info">Add Post Here ..!!</h3>
                            
                             <h3>${sucessMsg}</h3>
                           
                             <div class="form-group">
                                <label for="password" class="text-info">Upload Post:</label><br>
                                <input type="file" name="userImage1" id="password" class="form-control" 	>
                            </div>
                            
                            <div class="form-group">
                                <label for="password" class="text-info">Add Description:</label><br>
                                <input type="text" name="description" id="password" class="form-control" placeholder=" Enter Description">
                            </div>
                              <div class="form-group">
                              
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
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