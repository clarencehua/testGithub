<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>

	<head>
		<title>律师证件读取</title>
		<meta charset="UTF-8" />
		<script src="${basePath}resources/js/jquery.js" type="text/javascript"></script>
		<script src="${basePath}resources/js/jquery.dataTables.js"></script>
		<link rel="stylesheet" type="text/css" href="${basePath}resources/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}resources/css/jquery.dataTables.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}resources/css/test.css" />

	<style type="text/css">
	 .dataTables_wrapper .dataTables_length {
    	margin-top:-28px;
    }
    .dataTables_wrapper .dataTables_filter {
    	margin-top: -28px;
	    
    }
	</style>
	</head>

	<body id="header">
	<div class="container">
		<div class="header_main">
			<div class="header_text" style="font-size:40px;">案件信息</div>
		</div>
      <div class="news-box" style="width:1200px;margin-left:-90px;">
		<table id="p_table" border="0" cellspacing="0" cellpadding="0">
            <thead>
                <tr>
					<th >序号</th>
					<th>案件名</th>
					<th>案件名称</th>
					<th>立案日期</th>
				</tr>
            </thead>
            <tbody>
              <c:forEach items="${requestScope.list}" var="li" varStatus="status">
							<tr style="background-color: #f9f9f9;">
								<td style="border: 1px solid #c5c5c5;border-top: none;">${status.count}</td>
								<td>${li.ah}</td>
								<td>${li.ajmc}</td>
								<td>${fn:substring(li.larq,0,10)}</td>
							</tr>
						</c:forEach>
            </tbody>
        </table>
	  </div>
	</div>	
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

	</body>

</html>