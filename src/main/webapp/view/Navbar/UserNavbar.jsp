<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<link href="/view/css/style.css" rel="stylesheet" type="text/css">

<title >UserNavbar</title>
<link href="view/css/style.css" rel="stylesheet" />
</head>
<body>
	<!-- this is Navbar -->


  <%
    String userName=(String)session.getAttribute("userName");
  %>

	<nav class=" fixed-top navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">Friend-Book </a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto text-uppercase">

           <li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
           
				<li class="nav-item active"><a class="nav-link" ><%=userName%>
						<span class="sr-only">(current)</span>
				</a></li>


				<li class="nav-item"><a class="nav-link " href="#"
					tabindex="-1" aria-disabled="true"> <span
					      ></span></a></li>


				<!-- <li class="nav-item"><a class="nav-link " href="logout"
					tabindex="-1" aria-disabled="true">Logout</a></li> -->
					
			<li class="nav-item"> <a data-toggle ="modal"
		data-target="#exampleModal" class="nav-link ">Logout</a></li>


			</ul>

		</div>
	</nav>

	<!-- 	End Navbar -->


	<!--  this is sidebar -->
	<div class="sidebar mt-2">

      <span onclick="toggleSidebar()" class="crossBtn">&times;</span>
		<a href="#"  class="item"><i class="fa-solid fa-house"> </i>Home</a> 
		<a href="#"  class="item"><i class="fas fa-id-card-alt"></i> ViewContacts</a>
			 <a href="#"   class="item"><i class="fas fa-pencil-alt"></i> Add Contacts</a>
			  <a href="showUserProfile" class="item"><i class="fas fa-user-circle"> </i>Your Profile</a> 
			  <a href="#" class="item"><i class="fas fa-cogs"></i> Settings</a>
			   <!-- <a href="#" href="logout" class="item"><i class="fas fa-sign-out-alt"></i> Logout</a>
			    -->
			   <a data-toggle ="modal"
		data-target="#exampleModal" class="item"><i class="fas fa-sign-out-alt"></i>Logout</a>
		
		<div class="divider"></div>
	</div>
	<!-- end sidebar -->



	<!-- content area -->
	<div class="content mt-5">
	<i onclick="toggleSidebar()" class="fas fa-bars m-3"> </i>
	
	  <!--  message box -->
	  
	  
	  <%-- <div  th:if="${session.message}" class="container">
	  <div th:classappend="${'alert-'+session.message.type}"  class="alert text-center"  role="alert">
         
       <span th:text="${session.message.content}"></span> 
       
    </div>
    <th:block th:text="${#session.removeAttribute('message')}"></th:block>
    </div> --%>
    
   <!--  end message box -->
   
   
		<div replace="content"></div>


	</div>

	<!--  end content area -->



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


	<script src="/view/js/script.js"></script>
	
	
	
	
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
				<h6>Do You want to Logout</h6>
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="/logout" class="btn btn-primary">Logout </a> </div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	<!-- logout popup -->
	
</body>
</html>