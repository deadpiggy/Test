<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'single.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel='stylesheet' type='text/css' />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) 图片放大功能-->
		<script src="js/jquery.min.js"></script>
		<!----details-product-slider--->
		<!-- 图片放大功能 -->
		<link rel="stylesheet" href="css/etalage.css">
		<script src="js/jquery.etalage.min.js"></script>
		<script src="js/project.js"></script>
		<!-- 图片放大功能 -->
		<script>
			jQuery(document).ready(function($) {

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,

					show_hint: true,
					click_callback: function(image_anchor, instance_id) {
						alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
					}
				});
				// This is for the dropdown list example:
				$('.dropdownlist').change(function() {
					etalage_show($(this).find('option:selected').attr('class'));
				});

			});
			
			function demo() {
				alert( "请先登录！" );
			}
		
		</script>

	

  </head>
  
  <body>
		<!--页头-->
		<div class="header">
			<div class="container">
				<!--样式属于style.css-->
				<!--页头顶部-->
				<div class="header_top">
					<ul class="phone">
						<li class="phone_left"><i class="mobile"> </i><span>158-8111-3831</span></li>
						<li class="phone_right">各位新老顾客，欢迎您的光临！</li>
						<div class="clearfix"></div>
					</ul>
					<ul class="social">
						<li>
							<a href=""> <i class="tw"> </i> </a>
						</li>
						<li>
							<a href=""><i class="fb"> </i> </a>
						</li>
						<li>
							<a href=""><i class="rss"> </i> </a>
						</li>
						<li>
							<a href=""><i class="msg"> </i> </a>
						</li>
						<div class="clearfix"> </div>
					</ul>
					<!--购物车-->
					<ul class="shopping_cart">
			   <c:if test="${a != 1&&a != 2 }">
				   <a onclick="demo()"><li class="shop_left"><i class="cart"> </i><span>购物车</span></li></a>
				   <a  onclick="demo()"><li class="shop_right"><span>￥0.00</span></li></a>
			   </c:if>
			   <c:if test="${a == 1 }">
			   		<a href="shoppingcar"><li class="shop_left"><i class="cart"> </i><span>购物车(${listNum })</span></li></a>
				   <a><li class="shop_right"><span>￥${total }</span></li></a>
			   </c:if>
			   <c:if test="${a == 2 }">
			   		<a href="shoppingcar"><li class="shop_left"><i class="cart"> </i><span>购物车(${listNum })</span></li></a>
				   <a><li class="shop_right"><span>￥${total }</span></li></a>
			   </c:if>
			   <div class="clearfix"> </div>
			</ul>
					<div class="clearfix"></div>
				</div>
				<!--页头下面部分-->
				<div class="header_bottom">
					<!--logo图片样式属于style.css-->
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt="" /><br></a>
					</div>
					<nav class="navbar navbar-default menu" role="navigation">
						<ul class="nav navbar-nav menu1" >
							<li>
								<a href="index">首页</a>
							</li>
							<li>
								<c:if test="${a==1 }"><a href="order">个人中心</a></c:if>
								<c:if test="${a==2 }"><a href="order">个人中心</a></c:if>
								<c:if test="${a!=1&&a!=2 }"><a onclick="demo()">个人中心</a></c:if>
							</li>
							<li>
								<a>帮助中心</a>
							</li>
						</ul>
						
<!-- 登录注册按钮 -->
						<ul class="login">
						
							<c:if test="${a==1 }">
							<a>
								<li class="login_top"><i class="sign"> </i><span>${loginer.ch_name }${sexDemo }</span></li>
							</a>
							<a href="logout">
								<li class="login_bottom"><i class="register"> </i><span>注销</span></li>
							</a>
							</c:if>
							<c:if test="${a==2 }">
							<a href="backdemo">
								<li class="login_top"><i class="sign"> </i><span>${loginer.ch_name }${sexDemo }</span></li>
							</a>
							<a href="logout">
								<li class="login_bottom"><i class="register"> </i><span>注销</span></li>
							</a>
							</c:if>
							<c:if test="${a!=1&&a!=2 }">
							<a href="login.jsp">
								<li class="login_top"><i class="sign"> </i><span>登录</span></li>
							</a>
							<a href="register.jsp">
								<li class="login_bottom"><i class="register"> </i><span>注册</span></li>
							</a>
							</c:if>
									
						</ul>
						
						<div class="clearfix"></div>

					</nav>
					<div class="clearfix"></div>
					<div class="search">
						<form action="Seek" method="post" >
							<input type="text" class="text" value="输入菜品" name="seek"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '输入菜品';}"> <input
						type="submit" value="搜  索">
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="main">
			<div class="container">
				<div class="single">
					<div class="row content">
						<div class="col-md-3">
							<!--类别-->
						<div class="category_box" style="height: 400px;">
							<h3 class="cate_head">类别</h3>
							<ul class="category">
								<li>
									<span onclick="classify('早餐')">早餐</span>
									<ul class="classify" id="classify1">
										<li><a href="#">包子</a></li>
										<li><a href="#">粥</a></li>
										<li><a href="#">豆浆油条</a></li>
									</ul>
								</li>
								<li>
									<span onclick="classify('正餐')">正餐</span>
									<ul class="classify" id="classify2">
										<li><a href="selectcate?type=2001">川菜</a></li>
										<li><a href="selectcate?type=2002">湘菜</a></li>
										<li><a href="selectcate?type=2003">粤菜</a></li>
									</ul>
								</li>
								<li>
									<span onclick="classify('夜宵')">夜宵</span>
									<ul class="classify" id="classify3">
										<li><a href="selectcate?type=3001">烧烤</a></li>
										<li><a href="selectcate?type=3002">酒水</a></li>
										<li><a href="selectcate?type=3003">烤鱼</a></li>
									</ul>
								</li>
							</ul>
						</div>
							<!--菜品评论-->
						<ul class="product_reviews">
							<h3><i class="arrow"> </i><span>产品评论</span></h3>
							
							<c:forEach items="${listDis }" var="dis">
							<li>
								<ul class="review1">
									<li class="review1_img">
										<a href="single?cate_id=${dis.cate_id }">
											<img src="images/${dis.img_path }" class="img-responsive" alt="" />
										</a>
									</li>
									<li class="review1_desc">
										<h3>${dis.content }</h3>
										<p>${dis.user_name }</p>
										<p>${dis.dis_date }</p>
									</li>
									<div class="clearfix"> </div>
								</ul>
							</li>
							</c:forEach>
							
						</ul>

						<ul class="product_reviews">
							<h3><i class="arrow"> </i><span>付款方式</span></h3>
							<img src="images/payment.png" class="img-responsive" alt="" />
						</ul>
					</div>
						<div class="col-md-9">
							<div class="single_image">
								<ul id="etalage">
									<li>
										<a href="optionallink.html">
											<img class="etalage_thumb_image" src="images/${cate.img_path }" class="img-responsive" alt="" />
											<img class="etalage_source_image" src="images/${cate.img_path }" class="img-responsive" alt="" />
										</a>
									</li>
									
								</ul>
							</div>
							<div class="single_right">
								<h3>${cate.cate_name }</h3>
								<p class="m_5">${cate.describe }</p>
								<div class="price_single">
									<span class="actual1">￥ ${cate.price }</span>
									<a>click for offer</a>
								</div>

								<div class="btn_form">
									<form>
										<c:if test="${a==1 }">
											<a href="ordersingle?cate_id=${cate.cate_id }">
												<input type="button" value="立即购买">
											</a>
										</c:if>
										<c:if test="${a==2 }">
											<a href="ordersingle?cate_id=${cate.cate_id }">
												<input type="button" value="立即购买">
											</a>
										</c:if>
										<c:if test="${a!=1&&a!=2 }">
											<a onclick="demo()">立即购买</a>
										</c:if>
									</form>
								</div>
								<ul class="add-to-links">
									<li><img src="images/wish.png" alt="">
										<c:if test="${a==1 }">
											<a href="addsc?cate_id=${cate.cate_id }&num=1">添加到购物车</a>
										</c:if>
										<c:if test="${a==2 }">
											<a href="addsc?cate_id=${cate.cate_id }&num=1">添加到购物车</a>
										</c:if>
										<c:if test="${a!=1&&a!=2 }">
											<a onclick="demo()">添加到购物车</a>
										</c:if>
									</li>
								</ul>
								<div class="col-xs-12  col-sm-6  col-md-4">
									<div class="banners--small  banners--small--social">
										<a href="#" class="social"><i class="zocial-facebook"> </i>
											<span class="banners--small--text"> 分享到<br/>Facebook</span>
											<div class="clearfix"> </div>
										</a>
									</div>
								</div>
								<div class="col-xs-12  col-sm-6  col-md-4">
									<div class="banners--small  banners--small--social">
										<a href="#" class="social"><i class="zocial-twitter"> </i>
											<span class="banners--small--text"> 分享到<br/>社交网络</span>
											<div class="clearfix"> </div>
										</a>
									</div>
								</div>
								<div class="col-xs-12  col-sm-6  col-md-4">
									<div class="banners--small  banners--small--social">
										<a href="#" class="social"><i class="zocial-pin"> </i>
											<span class="banners--small--text">分享到<br>Pinterest</span>
											<div class="clearfix"> </div>
										</a>
									</div>
								</div>
							</div>
							<div class="clearfix"> </div>
							<!----product-rewies---->
							<!--该菜品评论-->
							<div class="greens_reviews">
								<h3 class="cate_head">菜品评价</h3>
								<c:forEach items="${listContent }" var="dis">
							    <div class="review">
							    	<p>${dis.content }</p>
							    	<p>&nbsp;${dis.user_name }&nbsp;${dis.dis_date }</p>
								</div>
								</c:forEach>
							</div>
							<div class="related_products">
								<h3>菜品推荐</h3>	
								<div class="row">
								
									<c:forEach items="${listThreeCate }" var="randomCate">
									<div class="col-md-4 related">
										<a href="single?cate_id=${randomCate.cate_id }">
											<img src="images/${randomCate.img_path }" class="img-responsive" style="width:270px ; height:165px"/>
										</a>
									</div>
									</c:forEach>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--页尾-->
		<div class="footer">
			<div class="container">
				<div class="footer-grid footer-grid1">
					
					<ul class="list1">
						<li>
							<a>首页</a>
						</li>
						<li>
							<a>关于我们</a>
						</li>
						<li>
							<a>登录</a>
						</li>
						<li>
							<a>联系我们</a>
						</li>
					</ul>
				</div>
				<ul class="social">
						<li>
							<a> <i class="tw"> </i> </a>
						</li>
						<li>
							<a><i class="fb"> </i> </a>
						</li>
						<li>
							<a><i class="rss"> </i> </a>
						</li>
						<li>
							<a><i class="msg"> </i> </a>
						</li>
						<div class="clearfix"> </div>
				</ul>
				</div>
				<div class="clearfix"> </div>
				<div class="copy">
					<p>
						Copyright &copy; 版权所有&nbsp;（中国）LHLPH夕阳小组投资
					</p>
				</div>
			</div>
		</div>
		<div style="display:none">
			<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
		</div>
	</body>
</html>