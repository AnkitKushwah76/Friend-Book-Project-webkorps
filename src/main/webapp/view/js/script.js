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
/*$('#searchbox').append('<tr class="rex"><td><a href="/searchdata?search='+result[i].userName+'"><img height="30" width="30" style="border-radius:100px" src="../view/userProfileImg/'+result[i].profilephoto+'"/>   '+ result[i].userName + '</a></td></tr>');
*/
	$('#searchbox').append('<tr class="rex"><td><a href="/searchdata?search='+result[i].userName+'">'+ result[i].userName + '</a></td></tr>');
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