<html>
<head>
<title>Captcha Code Generator</title>
<link href="/view/css/a.css" rel="stylesheet" type="text/css">
<%@include file="/view/Navbar/base.jsp" %>


</head>
<body>
<center>
<h1>Captcha Code Generator and Validator</h1>
<div class="container">
  <form name="form1">
    <input type="text" id="captchaTxtArea" name="text" value=""><br/>
    <input type="text" id="CaptchaEnter" placeholder="Enter The Captcha Code"><br/>
    <input type="button" value="REFRESH" id="refreshbtn" onclick="genNewCaptcha()">
    <input type="button" value="CHECK" id="checkbtn" onclick="checkCaptcha()">

  </form>
</div>
</center>

<script type="text/javascript">
  var captcha, chars;

  function genNewCaptcha(){
    chars = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    captcha = chars[Math.floor(Math.random() * chars.length )];
    for(var i=0; i<6; i++){
      captcha = captcha + chars[Math.floor(Math.random() * chars.length )];
    }
    form1.text.value = captcha;
  }

  function checkCaptcha(){
    var check = document.getElementById("CaptchaEnter").value;
    if(captcha == check){
      alert("Valid Captcha!!! Success");
      document.getElementById("CaptchaEnter").value = "";
    }else{
      alert("InValid Captcha!!! Please Try Again");
      document.getElementById("CaptchaEnter").value = "";
    }

    genNewCaptcha();
  }
</script>
</body>
</html>