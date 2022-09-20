console.log("this is  script file")

const toggleSidebar=()=>{
  if($(".sidebar").is(":visible"))
	  {
	     //true 
	  //band karna hai
	  
	  $(".sidebar").css("display","none");
	  $(".content").css("margin-left","0%");
	  
	  }
  else{
	  //false
	  //show karna hai 
	  

	  $(".sidebar").css("display","block");
	  $(".content").css("margin-left","20%");
  }
	
};
function mySearch() {
	var name = $("#search").val();
	if(name!="")
	{
	
		
	$.ajax({
		url : "/search?name="+name,
		type : "get",
		success : function(result) {
			console.log(name);
			$('tr').remove(".rex");
			$("#box").show();
			for(i=0;i<result.length;i++)
			{
			console.log(result[i].userName);
	$('#searchbox').append('<tr class="rex"><td><a href="/searchdata?search='+result[i].userName+'"><img height="30" width="30" style="border-radius:100px" src="../view/userProfileImg/'+result[i].userImage+'"/> '+ result[i].userName + '</a></td></tr>');
			}
		},
	    error:function(result){
	    	console.log(result);
	    }
	});
	}
	else{
		$('tr').remove(".rex");
		$("#box").hide();
		}
}


function getComments(postId){
		$.ajax({
			url:"http://localhost:8080/getComments?postId="+postId,
					success:function(result){
						var s="";
						var comments=result.comments;
						console.log(comments)
						for(var i=0;i<comments.length;i++)
						{
							if(comments[i].user.image!=null){
								s=s+'<div class="row">'
								+'<div class="col-md-4">'
								+'<img src="../../images/'+comments[i].user.image+'" height="50" width="50" style="border-radius: 800px">'
								+'</div>'
								+'<div class="col-md-4">'+comments[i].user.name+'</div>'
								+'<div class="col-md-4">'+comments[i].comment+'</div>'
								+'</div>'
							}
							else{
								s=s+'<div class="row">'
								+'<div class="col-md-4">'
								+'<img src="../../images/profile.png" height="50" width="50" style="border-radius: 800px">'
								+'</div>'
								+'<div class="col-md-4">'+comments[i].user.name+'</div>'
								+'<div class="col-md-4">'+comments[i].comment+'</div>'
								+'</div>'
							}
						}
						$("#modalBody").html(s);
					} 
		});
	}





