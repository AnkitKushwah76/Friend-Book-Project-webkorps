<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Modal -->
	<div class="modal fade" id="deletepost" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Delete Post</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
				<form method="post" action="deletePost"autocomplete="off">
        
 		    <input type="text" hidden="true"
						id="postId" value="" name="postId">
       
				
				<h6>Do You want to Delete</h6>
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					
				 <button type="submit"  class="btn btn-primary">Delete</button>
					
			</form>	
			</div>	
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
