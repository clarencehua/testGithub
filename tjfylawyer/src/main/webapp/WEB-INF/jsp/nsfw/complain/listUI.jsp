<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>投诉受理管理</title>
<script type="text/javascript"
	src="${basePath }js/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
	var list_url = "${basePath}nsfw/complain_listUI.do";
	//搜索
	function doSearch() {
		//重置页号
		$("#pageNo").val(1);
		document.forms[0].action = list_url;
		document.forms[0].submit();
	}
	//受理
	function doDeal(compId) {
		document.forms[0].action = "${basePath}nsfw/complain_dealUI.do?complain.compId="
				+ compId;
		document.forms[0].submit();
	}
	//投诉统计
	function doAnnualStatistic() {
		document.forms[0].action = "${basePath}nsfw/complain_annualStatisticChartUI.do";
		document.forms[0].submit();
	}
</script>
</head>
<body class="rightBody">
	<form name="form1" action="" method="post">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>投诉受理管理</strong>
						</div>
					</div>
					<div class="search_art">
						<li>投诉标题：<!-- <s:textfield name="complain.compTitle" cssClass="s_text"  cssStyle="width:160px;"/> -->
							<input name="complain.compTitle" class="s_text"
							style="width:160px;" />
						</li>
						<li>投诉时间：<input id="startTime" name="startTime"
							cssClass="s_text" style="width:160px;" readonly="true"
							onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});" />
							- <input id="endTime" name="endTime" cssClass="s_text"
							style="width:160px;" readonly="true"
							onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});" />
						</li>
						<li>状态：<!-- <s:select name="complain.state" list="#complainStateMap" headerKey="" headerValue="全部"/> -->
							<select name="complain.state">
								<option>全部</option>
								<c:forEach items="${complainStateMap}" var="li">
									<option value="${li.key}">${li.value}</option>
								</c:forEach>
						</select>
						</li>
						<li><input type="button" class="s_button" value="搜 索"
							onclick="doSearch()" /></li>
						<li style="float:right;"><input type="button" value="统计"
							class="s_button" onclick="doAnnualStatistic()" />&nbsp;</li>

					</div>

					<div class="t_list" style="margin:0px; border:0px none;">
						<table width="100%" border="0">
							<tr class="t_tit">
								<td align="center">投诉标题</td>
								<td width="120" align="center">被投诉部门</td>
								<td width="120" align="center">被投诉人</td>
								<td width="140" align="center">投诉时间</td>
								<td width="100" align="center">受理状态</td>
								<td width="100" align="center">操作</td>
							</tr>
							<c:forEach items="${pageResult.items}" var="li"
								varStatus="status">
								<tr <c:if test="${status.index%2==0}">bgcolor="f8f8f8"</c:if>>
									<td align="center">
										<!-- <s:property value="compTitle"/> -->${li.compTitle}</td>
									<td align="center">
										<!-- <s:property value="toCompDept"/> -->${li.toCompDept}</td>
									<td align="center">
										<!-- <s:property value="toCompName"/> -->${li.toCompName}</td>
									<td align="center"><c:set var="testStr"
											value="${li.compTime}"></c:set> <c:choose>
											<c:when test="${fn:length(testStr) > 10}">
												<c:out value="${fn:substring(testStr, 0, 10)}" />
											</c:when>
										</c:choose></td>
									<td align="center">
										<!-- <s:property value="#complainStateMap[state]"/> --> <c:forEach
											items="${complainStateMap}" var="aa">
											<c:if test="${aa.key==li.state}">${aa.value}</c:if>
										</c:forEach></td>
									<td align="center"><c:if test="${li.state!='2'}">
											<a href="javascript:doDeal('${li.compId}')">受理</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>

				<jsp:include page="/common/pageNavigator.jsp" />

			</div>
		</div>
	</form>

</body>
</html>