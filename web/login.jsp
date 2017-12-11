<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="login/js/jquery-1.12.4.min.js"></script>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    <script type="text/javascript">
        //异步校验用户名
        $(function(){
            $("#username").focus(function(){
                $("#spanid").empty();
            })

            //给用户输入栏绑定一个失去焦点事件
            $("#username").blur(function(){
                var value = $("#username").val();
                //把用户输入的值，改成json的数据格式
              //  alert(value)
                var param = {"username":value};//"{"uname":value}" 是字符串

                //异步请求代码
                var url = "/loginservice";
                $.get(url,param,function(data){

                    //data :1 或者2
                    if(data==1){//用户名已经存在，请输入新的用户名
                        $("#spanid").html("<font color='red'>用户名已经存在，请输入新的用户名</font>");
                    }else if(data==2){//用户名可以使用
                        $("#spanid").html("<font color='green'>用户名可以使用</font>");
                    }
                });

            });

        });


    </script>

    <title>登录到云中手的日常</title>

    <!-- Bootstrap core CSS -->
    <link href="login/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="login/yunzhs/signin.css" rel="stylesheet">
</head>

<body >

<div class="container" >

    <form action="/logining" class="form-signin" method="post">

        <h3 class="form-signin-heading">雲中手的日常</h3>
        <div class="form-group input-group">
            <span class="glyphicon glyphicon-user input-group-addon "></span>
            <label for="username" class="sr-only">Email address</label>
            <input type="username" id="username" name="username" class="form-control" placeholder="昵称/手机号/邮箱" required autofocus>

        </div>
        <div class="form-group ">
            <span id="spanid"></span>
        </div>
        <!--<label for="inputTel" class="sr-only">tel</label>-->
        <!--<input type="tel"  id="inputTel" class="form-control" placeholder="Tel" required >-->
        <div class="form-group input-group">
            <span class="glyphicon glyphicon-lock input-group-addon"></span>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="6-16位的密码" required>
        </div>
        <div class="g-recaptcha" data-sitekey="6LdZ4DsUAAAAABaezyFxxmCiTvlx9-01fK8gJp_a"></div>
        <%--<div  class="row form-group">--%>
            <%--<div class="col-lg-3 imgtop"> <img src="http://localhost:8080/code" id="imgID" onclick="checkimg();" alt="无法显示图片"></div>--%>

            <%--<div class="col-lg-9">  <input type="text" id="verify" name="verify" class="form-control" placeholder="输入左侧的验证码" required></div>--%>

        <%--</div>--%>
        <div class="checkbox imgtop">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit" > 登陆</button>
    </form>

</div> <!-- /container -->
</body>
<script type="text/javascript">
    function checkimg() {
        var imgobj=document.getElementById("imgID");
        console.log(2);
        imgobj.src="http://localhost:8080/code?time="+new Date().toLocaleString();
    }
    function subit() {
        var con=document.getElementById("verify");
        console.log(con.value);
        var a="<%=request.getSession().getAttribute("servercode")%>"
        console.log(a);
        if(con.value!=a){ con.disabled='1'; alert("请输入正确的验证码")}
        else {con.disabled='0';}

    }
</script>

</html>
