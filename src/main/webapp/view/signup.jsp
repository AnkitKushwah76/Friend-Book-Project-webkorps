
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>signup page</title>
<link href="/view/css/style.css" rel="stylesheet" type="text/css">
<%@include file="/view/Navbar/base.jsp"%>
<link href="/view/css/a.css" rel="stylesheet" type="text/css">




</head>
<body>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-6 offset-md-3">

					<div class="my-card mt-5">

						<div class="contatiner text-center">
							<img style="width: 80px;" src="/view/img/membership.png" />
						</div>

						<h1 class="text-center">Signup Here !!</h1>

						<span id="errMsg"></span>
						<h2 class="text-center text-success">${sucessfull}</h2>
						<form name="form1" action="/register" method="post"
							onsubmit="return checkCaptcha()">

							<!--  name-field -->


							<div class="form-group">
								<label for="name_field">Your Name</label> <input type="text"
									name="fullName" ;
									class="form-control "
									id="name_field" aria-describedby="emailHelp"
									placeholder="Enter Name" required />



							</div>

							<!--  email-field -->

							<div class="form-group">
								<label for="email_field">Your Email</label> <input type="email"
									name="userEmail" class="form-control" id="email_field"
									aria-describedby="emailHelp" placeholder="Enter email" required />

							</div>
							<!--  password-field -->

							<div class="form-group">
								<label for="password_field">Your Password</label> <input
									name="userPassword" type="password" class="form-control"
									id="password_field" aria-describedby="emailHelp"
									placeholder="Enter password" required>




								<div class="form-group">
									<label for="email_field">Captcha</label> 
									<img src="${pageContext.request.contextPath}/captcha">
									<br>
									<input type="text"
										name="captchanam" class="form-control" id="email_field"
										aria-describedby="emailHelp" placeholder="Enter captcha"
										style="margin-top: 5px;" required />
										<br>
					           <h5 class="text-center text-danger">${error}</h5>
								</div>
                                  
								<div class="container text-center">

									<button  onsubmit="checkCaptcha"  type="submit" class="btn bg-primary  text-white">Submit</button>
									<button type="reset" class="btn btn-warning  ">Reset</button>
								</div>
						</form>

					</div>
				</div>

			</div>

		</div>
	</section>


	<script type="text/javascript">
		var captcha, chars;

         
		function checkCaptcha() {
			var check = document.getElementById("captcha").value;
			if (captcha == check) {
				//alert("Valid Captcha!!! Success");
				return true;
				//document.getElementById("CaptchaEnter").value = "";
			} else {
				// alert("InValid Captcha!!! Please Try Again");
				document.getElementById("errMsg").innerHTML = "Invalid captcha";
				return false;
				//document.getElementById("CaptchaEnter").value = "";
			}

		}
	</script>
</body>
</html>
