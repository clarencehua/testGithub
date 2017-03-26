<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>信息发布管理</title>
<script type="text/javascript">
	//全选、全反选
	function doSelectAll() {
		// jquery 1.6 前
		//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
		//prop jquery 1.6+建议使用
		$("input[name=selectedRow]").prop("checked",
				$("#selAll").is(":checked"));
	}
	//新增
	function doAdd() {
		document.forms[0].action = "${basePath}nsfw/info_addUI.do";
		document.forms[0].submit();
	}
	//编辑
	function doEdit(id) {
		document.forms[0].action = "${basePath}nsfw/info_editUI.do?info.infoId="
				+ id;
		document.forms[0].submit();
	}
	//删除
	function doDelete(id) {
		document.forms[0].action = "${basePath}nsfw/info_delete.do?info.infoId="
				+ id;
		document.forms[0].submit();
	}
	//批量删除
	function doDeleteAll() {
		var delelist = new Array();
		$("input[name='selectedRow']:checked").each(function() {
			delelist.push($(this).val());
		});
		document.forms[0].action = "${basePath}nsfw/info_deleteSelected.do?id="+delelist;
		document.forms[0].submit();	
	
	}
	//异步发布信息,信息的id及将要改成的信息状态
	function doPublic(infoId, state) {
		//1、更新信息状态
		$.ajax({
			url : "${basePath}nsfw/info_publicInfo.do",
			data : {
				"info.infoId" : infoId,
				"info.state" : state
			},
			dataType:"json",
			type : "post",
			async: true,//非异步
			success : function(msg) {
			//alert("更新信息状态失败！");
			//console.log(msg.key);
				//2、更新状态栏、操作栏的显示值
				if ("更新状态成功" == msg.key) {
				console.log("daol44444");
					if (state == 1) {//说明信息状态已经被改成 发布，状态栏显示 发布，操作栏显示 停用
					console.log("daol");
						$("#show_" + infoId).html("发布");
						$("#oper_" + infoId).html(
								'<a href="javascript:doPublic(\'' + infoId
										+ '\',0)">停用</a>');
					} else {
					console.log("daoeeeeeeel");
						$("#show_" + infoId).html("停用");
						$("#oper_" + infoId).html(
								'<a href="javascript:doPublic(\'' + infoId
										+ '\',1)">发布</a>');
					}
				} else {
					alert("更新信息状态失败！");
				}
			},
			error : function() {
				alert("更新信息状态失败！");
			}
		});
	}
	
	var list_url = "${basePath}nsfw/info_listUI.do";
  	//搜索
  	function doSearch(){
  		//重置页号
  		$("#pageNo").val(1);
  		document.forms[0].action = list_url;
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
							<b></b><strong>信息发布管理</strong>
						</div>
					</div>
					<div class="search_art">
						<li>信息标题：<!-- <s:textfield name="info.title" cssClass="s_text"
								id="infoTitle" cssStyle="width:160px;" /> -->
								<input type="text" name="info.title" id="infoTitle" value="${info.title}" style="width:160px">
						</li>
						<li><input type="button" class="s_button" value="搜 索"
							onclick="doSearch()" /></li>
						<li style="float:right;"><input type="button" value="新增"
							class="s_button" onclick="doAdd()" />&nbsp; <input type="button"
							value="删除" class="s_button" onclick="doDeleteAll()" />&nbsp;</li>
					</div>

					<div class="t_list" style="margin:0px; border:0px none;">
						<table width="100%" border="0">
							<tr class="t_tit">
								<td width="30" align="center"><input type="checkbox"
									id="selAll" onclick="doSelectAll()" /></td>
								<td align="center">信息标题</td>
								<td width="120" align="center">信息分类</td>
								<td width="120" align="center">创建人</td>
								<td width="140" align="center">创建时间</td>
								<td width="80" align="center">状态</td>
								<td width="120" align="center">操作</td>
							</tr>
							<c:forEach items="${pageResult.items}" var="li" varStatus="status">
								<tr <c:if test="${status.index%2==0}">bgcolor="f8f8f8"</c:if>>
									<td align="center"><input type="checkbox"
										name="selectedRow" id="selectedRow" value="${li.infoId}" /></td>
									<td align="center">${li.title}</td>
									<td align="center">
										<!-- <s:property value="#infoTypeMap[type]"/> -->
									</td>
									<td align="center">${li.creator}</td>
									<td align="center"><c:set var="testStr"
											value="${li.createTime}"></c:set> <c:choose>
											<c:when test="${fn:length(testStr) > 10}">
												<c:out value="${fn:substring(testStr, 0, 10)}" />
											</c:when>
											</c:choose>
											<td id="show_${li.infoId}" align="center"><c:if
													test="${li.state==1}">发布</c:if> <c:if test="${li.state==0}">停用</c:if>
											</td>
											<td align="center"><span id="oper_${li.infoId}">
													<c:if test="${li.state=='1'}">
														<a href="javascript:doPublic('${li.infoId}',0)">停用</a>
													</c:if> <c:if test="${li.state=='0'}">
														<a href="javascript:doPublic('${li.infoId}',1)">发布</a>
													</c:if> </span> <a href="javascript:doEdit('${li.infoId}')">编辑</a> <a
												href="javascript:doDelete('${li.infoId}')">删除</a>
											</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<jsp:include page="/common/pageNavigator.jsp"/>

			</div>
		</div>
	</form>

</body>
</html>