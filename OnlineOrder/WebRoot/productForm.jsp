<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'productForm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<script src=""></script>

  </head>
  
  
<body>
		<!--页头-->
		<div class="back_head">
			<div class="back_left">
				<a href="backdemo"><img src="images/logo.png" alt="" /></a>
				<a>后台管理系统</a>
				<a href="index"><span style="background: #1fcd75;">前台首页</span></a>
				<a href="logout"><span style="background: #ec3531" ;>退出登录</span></a>
			</div>
		</div>
		<!--主题-->
		<div class="main">
			<div class="container">
					<!--类别-->
					<div id="category_box">
					<ul id="category">
						<li>
							<a href="backdemo">订单管理</a>
						</li>
						<li id="active">
							<a href="productform" style="color: #aba530;">商品管理</a>
						</li>
						<li>
							<a href="backAddCate.jsp">增加商品</a>
						</li>
						<li>
							<a href="backuserform?str=all">用户管理</a>
						</li>
						<li>
							<a href="backuserform?str=manage">管理人员</a>
						</li>
					</ul>
				</div>
				<div id="from">
					<div class="select">
<!-- 模糊查询 -->
						<form method="post" action="productformmohu">
							高级查询 &nbsp; &nbsp; 
							商品编号:<input type="text" name="in1"/>—<input type="text" name="in2"/> 
							商品名:<input type="text" name="in3"/>
							商品价格:<input type="text" name="in4"/>
                            <input type="submit" value="搜索"/><input type="reset" value="重置"/>
						</form>
					</div>
					<h4 style="width: 10%;margin: auto;color: #aba530;">商品列表</h4>
					<table class="form_table" style="border-collapse:collapse ;">
						<tr class="table_td1">
							<td>商品编号</td>
							<td>商品名</td>
							<td>商品单价</td>
							<td>商品样式</td>
							<td>商品描述</td>
							<td>菜系</td>
							<td>类别</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						
						<c:forEach items="${pb.data }" var="cate">
						<tr>
						    <td>${cate.cate_id }</td>
							<td><a href="backcatedetail?cate_id=${cate.cate_id }&str=detail">${cate.cate_name }</a></td>
							<td>￥${cate.price }</td>
							<td><img src="images/${cate.img_path }" style="width: 90px ; height: 50px"></td>
							<td>${cate.describe }</td>
<!-- 菜系 -->
							<c:if test="${cate.type==2001 }">
								<td>川菜</td>
							</c:if>
							<c:if test="${cate.type==2002 }">
								<td>湘菜</td>
							</c:if>
							<c:if test="${cate.type==2003 }">
								<td>粤菜</td>
							</c:if>
							<c:if test="${cate.type==3001 }">
								<td>烧烤</td>
							</c:if>
							<c:if test="${cate.type==3002 }">
								<td>酒水</td>
							</c:if>
							<c:if test="${cate.type==3003 }">
								<td>烤鱼</td>
							</c:if>
							<td>${cate.speces }</td>
<!-- 商品状态 -->
							<c:if test="${cate.status==1 }">
								<td>已上架</td>
							</c:if>
							<c:if test="${cate.status==0 }">
								<td style="color: red">已下架</td>
							</c:if>
							
							<c:if test="${cate.status==1 }">
							<td>
								<a href="changecatestatus?cate_id=${cate.cate_id }&status=0" onclick="return confirm('确认是否下架？')">下架</a>
							</td>
							</c:if>
							<c:if test="${cate.status==0 }">
							<td>
								<a href="changecatestatus?cate_id=${cate.cate_id }&status=1" onclick="return confirm('确认是否上架？')">上架</a>
							</td>
							</c:if>
							
						</tr>
						</c:forEach>						
					</table>
					<h3>总共${pb.totalRows }条记录,共${pb.totalPage }页，当前第${pb.pageNo }页</h3>
    				<h3>
    					<a href="productform?pageNo=${pb.firstPage }">首页</a>
    					<a href="productform?pageNo=${pb.upPage }">上一页</a>
    					<a href="productform?pageNo=${pb.downPage }">下一页</a>
    					<a href="productform?pageNo=${pb.lastPage }">末页</a>
    				</h3>
				</div>
			</div>
		</div>
		<!--页尾-->
		<div class="footer">
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
