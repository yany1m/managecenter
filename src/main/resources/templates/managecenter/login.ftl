<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登陆-ManageCenter</title>

<link rel="stylesheet" href="css/bootstrap.min.css">


<body>

<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form id="form" >
                <h2 class="text-center">欢迎</h2>
                <label for="userName" class="sr-only">用户名</label>
                <input type="username" id="username" name="username" class="form-control" placeholder="用户名" required autofocus>
                <label for="password" class="sr-only">密码</label>
                <br>
                <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
                <label for="verifyCode" class="sr-only">验证码</label>
                <br>
                <div >
				<input type="verifycode" id="verifycode" name="verifycode" class="form-control" placeholder="验证码" style="width:84%;float:left" required> 
				<img id="imageCode" src="/managecenter/getVerifyCode" style="padding-left:5px;padding-right:5px;cursor: pointer;" align="absmiddle" onclick="changeCode()"/>
				</div>              
                <input type="hidden" id="username1">  
                <input type="hidden" id="password1">  
                <button class="btn btn-lg btn-primary btn-block"  style="margin-top:20px" type="submit">登陆</button>
            </form>
        </div>
    </div>
</div>
<!-- /container -->


<script src="js/jquery-3.1.0.min.js"></script>
<script src="js/bootstrap.min.js" ></script>
<script src="js/cookie/jquery_cookie.js" ></script>
<script src="js/security.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 $("#form").submit(function(event){
	    event.preventDefault();
	          
        //使用RSA进行加密
        var key = RSAUtils.getKeyPair('${exponent}', '', '${modulus}'); 
        $("#username1").val(RSAUtils.encryptedString(key, $("#username").val()));
        $("#password1").val(RSAUtils.encryptedString(key, $("#password").val()));
     
 		$.ajax({             
                 type: "post",
                 url:"/managecenter/loginIn",
                 data:"username="+$("#username1").val()+"&password="+$("#password1").val()+"&verifycode="+$("#verifycode").val(),
                 dataType : "json",
                 error: function(request) {
                     alert("Connection error");
                 },
                 success: function(data) {               	                	
                	if(data.code=="0"){
 						window.location.href="/managecenter/index";
                	}else{
                		alert(data.body);
                		window.location.href="/managecenter/login";
                	}
 				}
 			});
 		});

	 //判断之前是否有设置cookie，如果有，则设置【记住我】选择框
	 if($.cookie('username')!=undefined){  
	        $("#rememberMe").attr("checked", true);  
	    }else{  
	        $("#rememberMe").attr("checked", false);  
	    }  
	
	 //读取cookie  
	 if($('#rememberMe:checked').length>0){  
	        $('#username').val($.cookie('username'));  
	        $('#password').val($.cookie('password'));  
	    }  
	 
	 //监听【记住我】事件 
	 $("#rememberMe").click(function(){  
	       
	    });  
});
	function changeCode(){
		$.ajax({
			url:"/managecenter/getVerifyCode",
			success: function(data) {  
				$("#imageCode").attr("src","/managecenter/getVerifyCode?t="+Math.random());
			}
		});
	}
</script>
</body>
</html>