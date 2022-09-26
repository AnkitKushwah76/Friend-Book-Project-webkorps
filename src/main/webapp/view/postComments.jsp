<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>
<body>
<!-- Modal -->
<div class="modal fade" id="comments" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Add Comments </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
       
			<form  autocomplete="off">
        
 		<!-- <input type="text" placeholder="Enter Comment" name="comment" id="comment"> -->
 		<textarea  name="w3review" rows="3" cols="40" 
 		placeholder="Enter Comment" name="comment" id="comment"></textarea>
 		<input type="text" hidden="true"
						id="postId" value="" name="postId">
						
       <button 	onclick="addcommets()"   type="button"  class="btn btn-primary" data-dismiss="modal">Send</button>
       </form>
      </div>
      <div class="modal-footer">
        <button  type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
</body>
</html>
<script type="text/javascript">

function addcommets() {
	let comment = $("#comment").val();
	let postId = $("#postId").val();
	console.log(comment);
	console.log(postId);
	$.ajax({
		type : "GET",
		url : "/addComments?comment=" + comment + "&postId=" + postId,
		success : function(data) {
			console.log("done");
			$("#comment").val("");
				 
		},
		error : function(data) {
			console.log("error");

		}
	});
	
}

</script>
