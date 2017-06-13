<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用Ajax提交</title>
<script type="text/javascript">
	//创建 XMLHttpRequest 对象
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//XHR向服务器发送请求
	xmlhttp.open("POST", "BlogServlet", true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	xmlhttp.send("fname=Bill&lname=Gates");

	function loadXMLDoc() {

	}
</script>

</head>

<body>
	<div id="myDiv">
		<h3>Let AJAX change this text</h3>
	</div>
	<button type="button" onclick="loadXMLDoc()">Change Content</button>
	<!-- 博客名：
	<input type="text" id="blogname" name="blogcontent">
	<br /> 博客内容：
	<input type="text" id="blogcontent" name="blogcontent">
	<br />
	<input type="button" value="点击我">
	</form> -->
</body>
</html>
