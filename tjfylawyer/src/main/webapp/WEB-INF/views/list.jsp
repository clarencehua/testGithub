<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css"></link> 
	<script src="${basePath}resources/js/jquery.dataTables.js"></script>
	<link rel="stylesheet" type="text/css" href="${basePath}resources/css/jquery.dataTables.css" />
<!-- 	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

</head>
<style type="text/css">
.navbar-brand {
	float: left;
	height: 50px;
	padding: 15px 15px;
	font-size: 29px;
	line-height: 20px;
}

</style>
<body>
	<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">刷卡記録</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 刷卡</a></li>
    </ul>
  </div>
</nav>
<div class="news-box" style="width:95%;margin-left:37px;">
<table id="p_table" class="table">
	
	<thead>
		<tr>
			<th>序号</th>
			<th>刷卡日期</th>
			<th>姓名</th>
			<th>律师证号</th>
		</tr>
	</thead>
	<tbody>
		 <c:forEach items="${requestScope.list}" var="li" varStatus="status">
							<tr style="background-color: #f9f9f9;">
								<td style="border: 1px solid #c5c5c5;border-top: none;">${status.count}</td>
								<td>${fn:substring(li.date,0,10)}</td>
								<td>${li.xm}</td>
								<td>${li.lawyerid}</td>
							</tr>
						</c:forEach>
	</tbody>
</table>
</div>
</body>
<script type="text/javascript">
		$(document).ready(function() {
			$('#p_table').dataTable({
				"aLengthMenu" : [ [5,9,  -1 ], [ 5, 9, "所有" ] ],
				"iDisplayLength" : 9,
				 //"scrollY" : 180, 
				/* "bAutoWidth" : true,//自动宽度 */
				/* "scrollX" : true, */
				"cell-border":1,
				"oLanguage" : {
					"sSearch" : "搜索:",
					"sLengthMenu" : "每页显示条数： _MENU_ ",
					"sZeroRecords" : "抱歉， 没有找到",
					"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
					"sInfoEmpty" : "没有数据",
					"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
					"oPaginate" : {
						"sFirst" : "首页",
						"sPrevious" : " ",
						"sNext" : " ",
						"sLast" : "尾页",
					},
					"sZeroRecords" : "没有检索到数据",
				},
			}) 
		});
	</script>
</html>
