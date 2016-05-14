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
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="js/Calculation.js"></script>
<script type="text/javascript" src="js/car.js"></script>

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
      <div class="page">
        <!-- 这里就是增加的地方  应该很多地方那个样式都会发生一点变化 这样真的不好 -->
        
        <div class="gwc" style=" margin:auto;">
	<table cellpadding="0" cellspacing="0" class="gwc_tb1">
		<tr>
			<td class="tb1_td1"><input id="Checkbox1" type="checkbox"  class="allselect"/></td>
			<td class="tb1_td1">Picture</td>
			<td class="tb1_td3">Brand</td>
			<td class="tb1_td4">size</td>
			<td class="tb1_td5">count</td>
			<td class="tb1_td6">money</td>
			<td class="tb1_td7">operation</td>
		</tr>
	</table>
	<s:iterator value="shoppingCarList" var="shoppingCar">
	<table cellpadding="0" cellspacing="0" class="gwc_tb2">
		<tr>
			<td class="tb2_td1"><input type="checkbox" value="1" name="<s:property value="#shoppingCar.id"/>" class="newslist-1" /></td>
			<td class="tb2_td2"><a href="#"><img src="images/<s:property value="#shoppingCar.car.poster"/>"/></a></td>
			<td class="tb2_td3"><a href="#"><s:property value="#shoppingCar.car.brand"/></a></td>
			<td class="tb1_td4"><s:property value="#shoppingCar.carSize.size.size"/></td>
			<td class="tb1_td5">
			<input type="hidden" class="money" value="<s:property value="#shoppingCar.car.money"/>">
				<input id="min1" name="" onclick="min1(this)"  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
				<input id="text_box1" name="" type="text" value="<s:property value="#shoppingCar.quantity"/>" style=" width:30px; text-align:center; border:1px solid #ccc;" />
				<input id="add1" name="" onclick="add(this)" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
			</td>
			<td class="tb1_td6"><label id="total1" class="tot" style="color:#ff5500;font-size:14px; font-weight:bold;"><s:property value="#shoppingCar.car.money"/>$</label></td>
			<td class="tb1_td7"><a href="#">Delete</a></td>
		</tr>
	</table> 
	
	</s:iterator>
		   
	<!---商品加减算总数---->
	<script type="text/javascript">
	$(function () {
		var t = $("#text_box1");
		
		$("#Checkbox1").click(function(){
			var ch=this.checked;
			$(".newslist-1").each(function(){
				this.checked=ch;
			});
		});
		
		$(".newslist-1").click(function(){
			if(!this.checked){
				$("#Checkbox1").attr("checked","");
			}else{
				allMoney();
				$("#jz1").css("display", "none");
				$("#jz2").css("display", "block");
			}
		});
		
		$("#jz2").click(function(){
			var ids="";
			var quans="";
			if(isSubmit()){
				$(".newslist-1").each(function(){
					if(this.checked){
						ids= ids+$(this).attr("name")+",";
					    quans=quans+$(this).parent().parent().children(".tb1_td5").children("#text_box1").val()+",";
					}
				});
				location.href="shoppingcar_addToBusiness.action?ids="+ids+"&quantities="+quans;
			}else{
				alert("Please check the Car !!!");
			}
		});
	})
	
	function allMoney(){
		var moneys=0;
		$(".newslist-1").each(function(){
			if(this.checked){
				var money=$(this).parent().parent().children(".tb1_td5").children(".money").val();
			    var quans=$(this).parent().parent().children(".tb1_td5").children("#text_box1").val();
			    moneys=moneys+parseInt(quans)*parseInt(money);
			}
		});
		$("#zong1").html(moneys.toFixed(2));
	}
	
	function isSubmit(){
		var len=$(".newslist-1:checked").length;
		if(len!=0){
			return true;
		}else{
			return false;
		}
	}
	
	function add(obj){
		var value=$(obj).prev().val();
		$(obj).prev().val(parseInt(value)+1);
		allMoney();
	}
	
	function min1(obj){
		var value=$(obj).next().val();
		if(parseInt(value)>1){
		$(obj).next().val(parseInt(value)-1);
		}
		allMoney();
	}
	</script>
	<!---总数---->
	
	<table cellpadding="0" cellspacing="0" class="gwc_tb3">
		<tr>
			<td class="tb1_td1"></td>
			<td class="tb3_td1">
			</td>
			<td class="tb3_td2"> </td>
			<td class="tb3_td3">Total:<span>$</span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></span></td>
			<td class="tb3_td4"><span id="jz1">Buy</span><a href="javascript:void(0)" style=" display:none;"  class="jz2" id="jz2">Buy</a></td>
		</tr>
	</table>

</div>


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