<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>The Auto-Tuning Website Template | 404 :: </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.useso.com/css?family=Anaheim' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/validate.js"></script>
<script type="text/javascript">

$(function(){
	$("#repassword").blur(function(){
		checkRepassword();
	});
	
	$("#tel").blur(function(){
		checkTel();
	});
	
	$("#submitForm").submit(function(){
		return checkRepassword()&&checkTel();
	});
})

function checkTel(){
	var tel=$("#tel").val().trim();
	if(!(tel.isTel()||tel.isMobile())){
		alert("The tel is not right !!!");
		return false;
	}else{
		return true;
	}
}

function checkRepassword(){
	var pass=$("#password").val().trim();
	var repass=$("#repassword").val().trim();
	if(!isEquals(pass,repass)){
		alert("The password is not equals to repassword!!");
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
<div class="wrap">
  <div class="header">
    <div class="logo">
      <h1><a href="to_to_index.jsp"><img src="images/logo.png" alt=""></a></h1>
    </div>
    <div class="h_right">
      <div class="drp-dwn">
        <ul>
          <li>
            <h3>Select ur Language :</h3>
          </li>
          <li>
            <select onChange="window.location=this.options[this.selectedIndex].value">
              <option value="">English</option>
              <option value="">German</option>
              <option value="">French</option>
            </select>
          </li>
          <li>
            <h3 style="margin-left: 10px;">Currency :</h3>
          </li>
          <li>
            <select onChange="window.location=this.options[this.selectedIndex].value">
              <option value="">US Dollar-USD</option>
              <option value="">Euro-EUR</option>
              <option value="">Indian Rupee-INR</option>
            </select>
          </li>
        </ul>
      </div>
      <div class="header_top_right">
        <div class="login">
         <span><a href="login.jsp">
         <img src="images/login.png" alt="" title="${sessionScope.customer== null ? 'Login' : sessionScope.customer.userName}">
         </a></span>
          </div>
        <div class="shopping_cart">
          <div class="cart_img"> <img src="images/header_cart.png"> </div>
          <div class="cart"> <a href="shoppingcar_selectAll.action?shoppingCar.customer.id=<s:property value="#session.customer.id"/>" title="View my shopping cart" rel="nofollow"> <span class="cart_title">Cart</span> <span class="no_product">(<font id="commodity_counts">${sessionScope.commodiety_counts== null ? "empty" : sessionScope.commodiety_counts}</font>)</span> </a> </div>
        </div>
        <div class="clear"></div>
      </div>
    </div>
    <div class="clear"></div>
    <div class="h_main">
      <ul class="nav">
        <li class="active"><a href="to_index.jsp">Home</a></li>
        <li><a href="maintain.jsp">Maintains</a></li>
        <li><a href="repair.jsp">Repairs</a></li>
        <li><a href="contact.jsp">Contact</a></li>
      </ul>
      <div class="search">
        <form>
          <input type="text" value="">
          <input type="submit" value="">
        </form>
      </div>
      <div class="clear"></div>
    </div>
  </div>
  <div class="main">
    <div class="main1">
      <form class="form-4" id="submitForm" action="user_regist.action" method="post">
        <h1>Register</h1>
        <p>
          <label for="login">Username or email</label>
          <input type="text" name="customer.userName"   placeholder="Username or email" required>
        </p>
        <p>
          <label for="password">Password</label>
          <input type="password" name='customer.password' id="password" placeholder="Password" required>
        </p>
        <p>
          <label for="password">RePassword</label>
          <input type="password" name='repassword' id="repassword" placeholder="Password" required>
        </p>
        <p>
          <label for="login">Name</label>
          <input type="text" name="customer.name" placeholder="Your real Name" required>
        </p>
        <p>
          <label for="login">sex</label>
          <input type="radio" name="customer.sex" checked="checked" value="Man" />Man
          <input type="radio" name="customer.sex" value="Woman" />Woman
        </p>
        <p>
          <label for="login">Phone</label>
          <input type="text" name="customer.phone" id="tel"  placeholder="PhoneNumber" required>
        </p>
        <p>
          <input type="submit"  value="Regist" onclick="">
        </p>
      </form>
​​       </div>
  </div>
  <div class="footer">
    <div class="f_left">
      <div class="f_nav">
        <ul>
          <li><a href="">about us</a></li>
          <li><a href="">site map</a></li>
          <li><a href="">customer Service</a></li>
          <li><a href="">search terms</a></li>
          <li><a href="">contact us</a></li>
        </ul>
      </div>
      <div class="copy">
      </div>
    </div>
    <div class="social-icons">
      <ul>
        <li class="icon1"><a href="#" target="_blank"> </a></li>
        <li class="icon2"><a href="#" target="_blank"> </a></li>
        <li class="icon3"><a href="#" target="_blank"> </a></li>
        <li class="icon4"><a href="#" target="_blank"> </a></li>
        <div class="clear"></div>
      </ul>
    </div>
    <div class="clear"></div>
  </div>
</div>
</body>
</html>