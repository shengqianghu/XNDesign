<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>The Auto-Tuning Website Template | Home ::</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.useso.com/css?family=Anaheim' rel='stylesheet'
	type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<script type="text/javascript" src="js/modernizr.custom.53451.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.gallery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#dg-container').gallery({
			autoplay : true
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<div class="logo">
				<h1>
					<a href="to_to_index.jsp"><img src="images/logo.png" alt=""></a>
				</h1>
			</div>
			<div class="h_right">
				<div class="drp-dwn">
					<ul>
						<li>
							<h3>Select ur Language :</h3>
						</li>
						<li><select
							onChange="window.location=this.options[this.selectedIndex].value">
								<option value="">English</option>
								<option value="">German</option>
								<option value="">French</option>
						</select></li>
						<li>
							<h3 style="margin-left: 10px;">Currency :</h3>
						</li>
						<li><select
							onChange="window.location=this.options[this.selectedIndex].value">
								<option value="">US Dollar-USD</option>
								<option value="">Euro-EUR</option>
								<option value="">Indian Rupee-INR</option>
						</select></li>
					</ul>
				</div>
				<div class="header_top_right">
					<!-- ç»éå®ä¹åè¿éåºè¯¥åçåå -->
					<div class="login">
						<span><a href="login.jsp"> <img src="images/login.png"
								alt="" title="${sessionScope.customer== null ? 'Login' : sessionScope.customer.userName}">
						</a></span>
					</div>
					<div class="shopping_cart">
						<div class="cart_img">
							<img src="images/header_cart.png">
						</div>
						<div class="cart">
							<a href="shoppingcar_selectAll.action?shoppingCar.customer.id=<s:property value="#session.customer.id"/>" title="View my shopping cart"
								rel="nofollow"> <span class="cart_title">Cart</span> <span
								class="no_product">(<font id="commodity_counts">${sessionScope.commodiety_counts== null ? "empty" : sessionScope.commodiety_counts}</font>)</span>
							</a>
						</div>
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
						<input type="text" value=""> <input type="submit" value="">
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="container">
			<section id="dg-container" class="dg-container">
				<div class="dg-wrapper">
					<a href="#"><img width="480" height="360" src="images/1.jpg" alt="image1" /></a> <a
						href="#"><img width="480" height="360" src="images/2.jpg" alt="image2" /></a> <a href="#"><img
						width="480" height="360" src="images/3.jpg" alt="image3" /></a> <a href="#"><img
						width="480" height="360" src="images/4.jpg" alt="image4" /></a> <a href="#"><img
						width="480" height="360" src="images/5.jpg" alt="image5" /></a> <a href="#"><img
						width="480" height="360" src="images/6.jpg" alt="image1" /></a> <a href="#"><img
						width="480" height="360" src="images/7.jpg" alt="image2" /></a> <a href="#"><img
						width="480" height="360" src="images/8.jpg" alt="image3" /></a>
				</div>
			</section>
		</div>
		<div class="main">
			
			<s:iterator var="cur" value="cars" status="sts">
				<s:if test="#sts.index % 3 == 0">
					<div class="section group">
				</s:if>
				<!-- every single pic of car 
					we should hidden the id information
					show the pics,the car's brand 
					that's all
				-->
				<div class="grid_1_of_4 images_1_of_4">
				
				
				<form action="car_details.action" id="detail_form<s:property value="#sts.index"></s:property>">
					<s:hidden name="car.id" value="%{id}"></s:hidden>
					<a href="javascript:void(0)" onclick="document.getElementById('detail_form<s:property value="#sts.index"></s:property>').submit()"><img
						width="260" height="240" src="images/${poster}"></a> <a href="javascript:void(0)">
						<h3>
							<s:property value="brand"></s:property>
						</h3>
					</a>
				</form>
				</div>
				<s:if test="#st.index % 3 == 0">
		</div>
		</s:if>
		</s:iterator>

		<!-- <div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic1.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem Ipsum is</h3>
			</a>
		</div>
		<div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic3.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem is simply</h3>
			</a>
		</div>
		<div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic2.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem Ipsum is</h3>
			</a>
		</div>
		<div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic4.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem is simply</h3>
			</a>
		</div> -->
		<div class="clear"></div>


		<!-- <div class="section group btm">
		<div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic5.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem Ipsum is</h3>
			</a>
		</div>
		<div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic6.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem is simply</h3>
			</a>
		</div>
		<div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic7.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem Ipsum is</h3>
			</a>
		</div>
		<div class="grid_1_of_4 images_1_of_4">
			<a href="details.jsp"><img src="images/pic8.jpg"></a> <a
				href="details.jsp">
				<h3>Lorem is simply</h3>
			</a>
		</div>
		<div class="clear"></div>
	</div> -->
	
	</div>
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
			<div class="copy"></div>
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
