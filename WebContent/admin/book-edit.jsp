<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mgr.css"/>
  </head>  
  <body>
    <div id="container">
    	<div id="header"><h1>智远教育--图书网后台管理系统</h1></div>
    	<div id="info">张三，您好！&nbsp;&nbsp;<a href="admin-user-login.jsp">登出</a></div>
    	<div class="menu">
    		<ul>
    			<li><a href="admin-home.jsp">首页</a></li>
    			<li><a href="category-mgr.jsp">图书分类管理</a></li>
    			<li><a href="book-mgr.jsp">图书管理</a></li>
    			<li><a href="#">购书订单管理</a></li>
    		</ul>	
    	</div>
    	<div id="main">
			<div class="section-left">    	
				<h2>编辑图书信息</h2>
				<form action="${pageContext.request.contextPath}/BookInfoController?op=update" method="post">
					<p>图书id：<input type="text" name="id" value=""  /></p>
					<p>图书书名：<input type="text" name="bookName" value=""  /></p>
					<p>图书作者：<input type="text" name="author" value=""  /></p>
					<p>图书分类：
						<select name="categoryId">									
							<option value="1">仙侠</option>	
							<option value="2">历史</option>	
							<option value="3">小说</option>	
							<option value="4">玄幻</option>
						</select>
					</p>
					<p>图书售价：<input type="text" name="price" value="66.0" /></p>
					<p>图书出版社：<input type="text" name="publisher" value="金城出版社"  /></p>  
					<p>当前图片：<img width="150" height="90" src="${pageContext.request.contextPath}/static/photo/fzdxl.jpg" /></p> 
					<p>图书图片：<input type="file" name="photo"  /></p>    				 				
					<p><input type="submit" value=" 修 改 "  />&nbsp;</p>					
				</form>
			</div>
			<div class="section-right"></div>			
			<div class="cf"></div>
		</div>  	
		<div id="footer"><p>版权所有&copy;智远教育</p></div>
	</div>
  </body>
</html>
