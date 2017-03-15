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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
	<script src="js/project.js"></script>
	<script src="">
		function demo() {
			alter( "请先登录！" );
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
						<li class="phone_right">购买商品范围在￥100元以上免配送费</li>
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
			   <a href="shopCart.html"><li class="shop_left"><i class="cart"> </i><span>购物车</span></li></a>
			   <a href="#"><li class="shop_right"><span>￥0.00</span></li></a>
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
							<li class="active">
								<a href="index.html">首页</a>
							</li>
							<li>
								<a href="personage.html">个人中心</a>
							</li>
							<li>
								<a href="contact.html">联系我们</a>
							</li>
						</ul>
						<ul class="login">
							<a href="account.html">
								<li class="login_top"><i class="sign"> </i><span>登录</span></li>
							</a>
							<a href="register.html">
								<li class="login_bottom"><i class="register"> </i><span>注册</span></li>
							</a>
						</ul>
						<div class="clearfix"></div>

					</nav>
					<div class="clearfix"></div>
					<div class="search">
						<input type="text" class="text" value="输入菜品" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '输入菜品';}">
						<input type="submit" value="搜  索">
					</div>
				</div>
			</div>
		</div>
		<!--主题-->
		<div class="main">
			<div class="container">
				<div class="banner">
					<img src="images/banner.jpg" class="img-responsive" alt="" />
				</div>
				<div class="row content">
					<div class="col-md-3 content_top">
						<!--类别-->
						<div class="category_box" style="height: 400px;">
							<h3 class="cate_head">类别</h3>
							<ul class="category">
								<li>
									<span onclick="classify('早餐')">早餐</span>
									<ul class="classify" id="classify1">
										<li><a href="#">湘菜</a></li>
										<li><a href="#">粤菜</a></li>
										<li><a href="#">川菜</a></li>
									</ul>
								</li>
								<li>
									<span onclick="classify('正餐')">正餐</span>
									<ul class="classify" id="classify2">
										<li><a href="#">湘菜</a></li>
										<li><a href="#">粤菜</a></li>
										<li><a href="#">川菜</a></li>
									</ul>
								</li>
								<li>
									<span onclick="classify('夜宵')">夜宵</span>
									<ul class="classify" id="classify3">
										<li><a href="#">湘菜</a></li>
										<li><a href="#">粤菜</a></li>
										<li><a href="#">川菜</a></li>
									</ul>
								</li>
							</ul>
						</div>
						<!--菜品评论-->
						<ul class="product_reviews">
							<h3><i class="arrow"> </i><span>产品评论</span></h3>
							<li>
								<ul class="review1">
									<li class="review1_img"><img src="images/pic1.jpg" class="img-responsive" alt="" /></li>
									<li class="review1_desc">
										<h3><a href="#">评论</a></h3>
										<p>名字与日期</p>
									</li>
									<div class="clearfix"> </div>
								</ul>
							</li>
							<li>
								<ul class="review1">
									<li class="review1_img"><img src="images/pic2.jpg" class="img-responsive" alt="" /></li>
									<li class="review1_desc">
										<h3><a href="#">评论</a></h3>
										<p>名字与日期</p>
									</li>
									<div class="clearfix"> </div>
								</ul>
							</li>
							<li>
								<ul class="review1">
									<li class="review1_img"><img src="images/pic3.jpg" class="img-responsive" alt="" /></li>
									<li class="review1_desc">
										<h3><a href="#">评论</a></h3>
										<p>名字与日期</p>
									</li>
									<div class="clearfix"> </div>
								</ul>
							</li>
							<div class="but">
								<a href="#">更多评论<i class="but_arrow"> </i></a>
							</div>
						</ul>

						<ul class="product_reviews">
							<h3><i class="arrow"> </i><span>付款方式</span></h3>
							<img src="images/payment.png" class="img-responsive" alt="" />
						</ul>
					</div>
					<div class="col-md-9">
						<ul class="feature">
							<h3><i class="arrow"> </i><span>今天的特色餐</span></h3>
						</ul>
						<ul class="feature_grid">
							<li class="grid1"><img src="images/剁椒鱼.jpg" class="img-responsive" alt="" />
								<p>描述</p>
								<div class="price">价格:
									<span class="actual">$12.00</span>
								</div>
								<div class="but1">
									<a href="#">立即购买</a>
								</div>
							</li>
							<li class="grid1"><img src="images/豆豉荷包蛋.jpg" class="img-responsive" alt="" />
								<p>描述</p>
								<div class="price">价格:
									<span class="actual">$12.00</span>
								</div>
								<div class="but1">
									<a href="#">立即购买</a>
								</div>
							</li>
							<li class="grid2"><img src="images/口味茄子煲.jpg" class="img-responsive" alt="" />
								<p>描述</p>
								<div class="price">价格:
									<span class="actual">$12.00</span>
								</div>
								<div class="but1">
									<a href="#">立即购买</a>
								</div>
							</li>
							<div class="clearfix"> </div>
						</ul>
						<ul class="feature">
							<h3><i class="arrow"> </i><span>大众菜品</span></h3>
						</ul>
<!-- 主菜单 -->
						<ul class="feature_grid">
							<c:forEach items="${list }" var="cate">
							<li class="grid1"><img src="images/${cate.img_path }" class="img-responsive" alt="" />
								<p>${cate.describe }</p>
								<div class="price">价格:
									<span class="actual">￥ ${cate.price }</span>
								</div>
								<div class="but1">
									<a href="#">立即购买</a>
								</div>
							</li>
							</c:forEach>
							<div class="clearfix"> </div>
						</ul>
<!-- 主菜单 -->						

						<ul class="dc_pagination dc_paginationA dc_paginationA06">
							<li>
								<a href="#" class="current">1</a>
							</li>
							<li>
								<a href="#">2</a>
							</li>
							<li>
								<a href="#">3</a>
							</li>
							<li>
								<a href="#">4</a>
							</li>
							<li>
								<a href="#">5</a>
							</li>
							<li>
								<a href="#">...</a>
							</li>
							<li>
								<a href="#">19</a>
							</li>
							<li>
								<a href="#">20</a>
							</li>
							<li>
								<a href="#" class="previous">Next></a>
							</li>
							<li>
								<a href="#" class="next">Last>></a>
							</li>
						</ul>
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
							<a href="index.html">首页</a>
						</li>
						<li>
							<a href="">关于我们</a>
						</li>
						<li>
							<a href="account.html">登录</a>
						</li>
						<li>
							<a href="contact.html">联系我们</a>
						</li>
					</ul>
				</div>
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
