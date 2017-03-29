<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>年度投诉统计图</title>
</head>
<script type="text/javascript"
	src="${basePath }js/fusioncharts/fusioncharts.js"></script>
<script type="text/javascript"
	src="${basePath }js/fusioncharts/fusioncharts.charts.js"></script>
<script type="text/javascript"
	src="${basePath }js/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript">
	//加载完dom元素后，执行
	$(document).ready(doAnnualStatistic());
	//根据年份统计投诉数
	function doAnnualStatistic() {
		//1、获取年份
	  var year = $("#year option:selected").val();
	  if(year == "" || year == undefined){
		  year = "${curYear}";//默认当前年份
	  }
	  //2、根据年份统计
	  $.ajax({
		  url:"${basePath }/nsfw/complain_getAnnualStatisticData.do",
		  data:{"year":year},
		  type: "post",
		  dataType:"json",
		  success: function(data){
			  if(data != null && data != "" && data != undefined){
				  var revenueChart = new FusionCharts({
				        "type": "line",
				        "renderAt": "chartContainer",
				        "width": "600",
				        "height": "400",
				        "dataFormat": "json",
				        "dataSource":  {
				          "chart": {
				            "caption": year + " 年度投诉数统计图",
				            "xAxisName": "月  份",
				            "yAxisName": "投  诉  数",
				            "theme": "fint"
				         },
				         "data": data.chartData
				      }

				  });
				revenueChart.render();
			  } else {
				  alert("统计投诉数失败！");
			  }
		  },
		  error: function(){alert("统计投诉数失败！");}
	  });
	}
</script>
<body>
	<br>
	<!-- <s:select id="year" list="{2015}" onchange="doAnnualStatistic()"></s:select> -->
	<select id="year" onchange="doAnnualStatistic()">
		<option value="">请选择年份</option>
		<c:forEach var="li" items="${yearList}">
		<option value="${li}">${li}</option>	
		</c:forEach>
	</select>
	<br>
	<div id="chartContainer"></div>
</body>
</html>
