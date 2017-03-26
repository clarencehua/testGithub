<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>用户管理</title>
<%@include file="/common/header.jsp"%>
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
		document.forms[0].action = "${basePath}nsfw/user_addUI.do";
		document.forms[0].submit();
	}
	//编辑
	function doEdit(id) {
		document.forms[0].action = "${basePath}nsfw/user_editUI.do?user.id="
				+ id;
		document.forms[0].submit();
	}
	//删除
	function doDelete(id) {
		document.forms[0].action = "${basePath}nsfw/user_delete.do?user.id="
				+ id;
		document.forms[0].submit();
	}
	//批量删除
	function doDeleteAll() {
		var delelist = new Array();
		$("input[name='selectedRow']:checked").each(function() {
			delelist.push($(this).val());
		});
		document.forms[0].action = "${basePath}nsfw/user_deleteSelected.do?id="+delelist;
		document.forms[0].submit();
	}
	//导出用户列表
	function doExportExcel() {
		window.open("${basePath}nsfw/user_exportExcel.do");
	}
	//导入
	function doImportExcel() {
		document.forms[0].action = "${basePath}nsfw/user_importExcel.do";
		document.forms[0].submit();
	}
	
	var list_url = "${basePath}nsfw/user_listUI.do";
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
	<form name="form1" action="" method="post"
		enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>用户管理</strong>
						</div>
					</div>
					<div class="search_art">
						<li>用户名：<input type="text" name="user.name"  style="width:160px">
						</li>
						<li><input type="button" class="s_button" value="搜 索"
							onclick="doSearch()" />
						</li>
						<li style="float:right;"><input type="button" value="新增"
							class="s_button" onclick="doAdd()" />&nbsp; <input type="button"
							value="删除" class="s_button" onclick="doDeleteAll()" />&nbsp; <input
							type="button" value="导出" class="s_button"
							onclick="doExportExcel()" />&nbsp; <input name="userExcel" id="userExcel"
							type="file" /> <input type="button" value="导入" class="s_button"
							onclick="doImportExcel()" />&nbsp;</li>
					</div>

					<div class="t_list" style="margin:0px; border:0px none;">
						<table width="100%" border="0">
							<tr class="t_tit">
								<td width="30" align="center"><input type="checkbox"
									id="selAll" onclick="doSelectAll()" />
								</td>
								<td width="140" align="center">用户名</td>
								<td width="140" align="center">帐号</td>
								<td width="160" align="center">所属部门</td>
								<td width="80" align="center">性别</td>
								<td align="center">电子邮箱</td>
								<td width="100" align="center">操作</td>
							</tr>
							<c:forEach items="${pageResult.items}" var="li"
								varStatus="status">
								<tr <c:if test="${status.index%2==0}">bgcolor="f8f8f8"</c:if>>
									<td align="center"><input type="checkbox"
										name="selectedRow" id="selectedRow" value="${li.id}" />
									</td>
									<td align="center">${li.name}</td>
									<td align="center">${li.account}</td>
									<td align="center">${li.dept}</td>
									<td align="center"><c:if test="${li.gender==true}">男</c:if>
										<c:if test="${li.gender==false}">女</c:if>
									</td>
									<td align="center">${li.email}</td>
									<td align="center"><a href="javascript:doEdit('${li.id}')">编辑</a>
										<a href="javascript:doDelete('${li.id}')">删除</a></td>
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