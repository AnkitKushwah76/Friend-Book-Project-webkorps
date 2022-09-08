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
                    <div id="login-box" class="col-md-15">
                        <form  enctype="multipart/form-data" id="login-form" class="form" action=UpdateUserProfile method="post">
                            <h3 class="text-center text-info">Update-UserProfile</h3>
                            
                            
                            <div class="form-group">
                                <label for="username" class="text-info">FavoriteBooks</label><br>
                                <input type="text" value=${favoriteBooks1} name="favoriteBooks" id="username" class="form-control" placeholder="Enter FavoriteBooks">
                            </div>
                            
                            <div class="form-group">
                                <label for="password" class="text-info">FavoriteSongs</label><br>
                                <input type="text" value="${favoriteSongs}" name="favoriteSongs" id="password" class="form-control" placeholder="Enter FavoriteSongs">
                            </div>
                            
                            <div class="form-group">
                                <label for="password" class="text-info">FavoritePlaces</label><br>
                                <input type="text" value=${favoritePlaces} name="favoritePlaces" id="password" class="form-control" placeholder="FavoritePlaces">
                            </div>
                            
                            
                            
                            <div class="form-group">
                                <label for="password" class="text-info">UserImage</label><br>
                                <input type="file" name="userImage1" id="password" class="form-control" 	>
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