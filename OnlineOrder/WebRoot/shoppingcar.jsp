<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shoppingcar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
		<!-- Custom Theme files -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
		<!-- Custom Theme files -->
	
	<script>
		function updateNum( cate_id, txt, oldNum ) {
			var newNum = txt.value;
			if( confirm( "确定修改？" ) ) {
				location.href = "updatenum?cate_id="+cate_id+"&num="+newNum;
			}else {
				txt.value = oldNum;
			}
		}
	</script>
	<script src="js/project.js"></script>
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
				  	 	<a href="index" onclick="demo()"><li class="shop_left"><i class="cart"> </i><span>购物车</span></li></a>
				   		<a href="#"><li class="shop_right"><span>￥0.00</span></li></a>
			  	 		</c:if>
			   			<c:if test="${a == 1 }">
			   			<a href="shoppingcar"><li class="shop_left"><i class="cart"> </i><span>购物车(${listNum })</span></li></a>
				   		<a href="#"><li class="shop_right"><span>￥${total }</span></li></a>
			   			</c:if>
			   			<c:if test="${a == 2 }">
			   			<a href="shoppingcar"><li class="shop_left"><i class="cart"> </i><span>购物车(${listNum })</span></li></a>
				   		<a href="#"><li class="shop_right"><span>￥${total }</span></li></a>
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
						<ul class="nav navbar-nav menu1">
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
							<a>
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
							<a href="index" onclick="demo( ${a } )">
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
		<!--主题-->
		<div class="main" style="border : 0.1px solid #eae8b8">
			<div class="shopcart">
				<table border="2">
					<tr>
						<th><div style="text-align:center;">商品编号</div></th>
						<th><div style="text-align:center;">商品名称</div></th>
						<th><div style="text-align:center;">商品单价</div></th>
						<th><div style="text-align:center;">样式</div></th>
						<th><div style="text-align:center;">购买数量</div></th>
						<th><div style="text-align:center;">价格小计</div></th>
						<th><div style="text-align:center;">操作</div></th>
					</tr>
					
					<c:forEach items="${list }" var="sc">
					<tr>
						<td><div style="text-align:center;"></div>${sc.cate_id }</td>
						<td><div style="text-align:center;"></div>${sc.cate_name }</td>
						<td><div style="text-align:center;"></div>${sc.price }</td>
						<td style="width: 100px"><div style="text-align:center;"></div>
							<img src="images/${sc.picture }" style="height: 80px ; width: 100px">
						</td>
						<td><div style="text-align:center;">
							<input type="text" value="${sc.amount }" size="10px" onchange="updateNum(${sc.cate_id }, this, ${sc.amount })">
						</div></td>
						<td><div style="text-align:center;"></div>${sc.price*sc.amount }</td>
						<td>
						<div style="text-align:center;">
							<a href="deletesc?sid=${sc.sid }" onclick="return confirm('确认是否移除？')">删除</a>
						</div>
						</td>
					</tr>
					</c:forEach>
					<tr>
						<td><div style="text-align:center;">合计</div></td>
						<td colspan="6" align="right"><div style="text-align:center;">￥${total }</div></td>
					</tr>
				</table>
				<div class="shopcart_bottom">
					<a href="dropshoppingcar" onclick="return confirm('是否移除全部商品？')">
						<input type="button" value="清空购物车"/>
					</a>
					<a href="index"><input type="button" value="继续购物"/></a>
					<a href="orderfirst"><input type="button" value="生成订单"/></a>
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