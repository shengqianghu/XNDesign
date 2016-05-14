<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML>
<html>
<head>
<title>The Auto-Tuning Website Template | Contact :: </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.useso.com/css?family=Anaheim' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="wrap">
  <div class="header">
    <div class="logo">
      <h1><a href="index.jsp"><img src="images/logo.png" alt=""></a></h1>
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
         <img src="images/login.png" alt="" title="login">
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
        <li class="active"><a href="index.jsp">Home</a></li>
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
      <div class="section group1">
        <div class="col span_1_of_3">
          <div class="contact_info">
            <h3>Find Us Here</h3>
            <div class="map">
              <iframe width="100%" height="175" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
              <br>
              <small><a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265" style="color: #5A5A5A;text-align:left;font-size:12px">View Larger Map</a></small> </div>
          </div>
          <div class="company_address">
            <h3>Company Information :</h3>
            <p>500 Lorem Ipsum Dolor Sit,</p>
            <p>22-56-2-9 Sit Amet, Lorem,</p>
            <p>USA</p>
            <p>Phone:(00) 222 666 444</p>
            <p>Fax: (000) 000 00 00 0</p>
            <p>Email: <span>info(at)mycompany.com</span></p>
            <p>Follow on: <span>Facebook</span>, <span>Twitter</span></p>
          </div>
        </div>
        <div class="col span_2_of_3">
          <div class="contact-form">
            <h3>Contact Us</h3>
            <form method="post" action="contact-post.jsp">
              <div> <span>
                <label>NAME</label>
                </span> <span>
                <input name="userName" type="text" class="textbox">
                </span> </div>
              <div> <span>
                <label>E-MAIL</label>
                </span> <span>
                <input name="userEmail" type="text" class="textbox">
                </span> </div>
              <div> <span>
                <label>MOBILE</label>
                </span> <span>
                <input name="userPhone" type="text" class="textbox">
                </span> </div>
              <div> <span>
                <label>SUBJECT</label>
                </span> <span>
                <textarea name="userMsg"> </textarea>
                </span> </div>
              <div> <span>
                <input type="submit" value="Send me">
                </span> </div>
            </form>
          </div>
        </div>
        <div class="clear"></div>
      </div>
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
