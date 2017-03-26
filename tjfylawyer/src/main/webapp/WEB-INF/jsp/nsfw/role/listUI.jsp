<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>角色管理</title>
    <script type="text/javascript">
    
    
  	//全选、全反选
	function doSelectAll(){
		// jquery 1.6 前
		//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
		//prop jquery 1.6+建议使用
		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
	}
  	//新增
  	function doAdd(){
  		document.forms[0].action = "${basePath}nsfw/role_addUI.do";
  		document.forms[0].submit();
  	}
  	//编辑
  	function doEdit(id){
  		document.forms[0].action = "${basePath}nsfw/role_editUI.do?role.roleId=" + id;
  		document.forms[0].submit();
  	}
  	//删除
  	function doDelete(id){
  		document.forms[0].action = "${basePath}nsfw/role_delete.do?role.roleId=" + id;
  		document.forms[0].submit();
  	}
  	//批量删除
  	function doDeleteAll(){
  		var delelist = new Array();
		$("input[name='selectedRow']:checked").each(function() {
			delelist.push($(this).val());
		});
		document.forms[0].action = "${basePath}nsfw/role_deleteSelected.do?id="+delelist;
		document.forms[0].submit();
  	}
  	var list_url = "${basePath}nsfw/role_listUI.do";
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
                <div class="c_crumbs"><div><b></b><strong>角色管理 </strong></div> </div>
                <div class="search_art">
                    <li>
                        角色名称：<input type="text" name="role.name"  style="width:160px">
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="120" align="center">角色名称</td>
                            <td align="center">权限</td>
                            <td width="80" align="center">状态</td>
                            <td width="120" align="center">操作</td>
                        </tr>
                       		<c:forEach items="${roleList}" var="li"
								varStatus="status">
                            <tr <c:if test="${status.index%2==0}">bgcolor="f8f8f8"</c:if> >
                                <td align="center"><input type="checkbox"
										name="selectedRow" id="selectedRow" value="${li.roleId}" /></td>
                                <td align="center">${li.name}</td>
                                <td align="center">
                                	<c:forEach items="${li.rolePrivilegeModels}" var="aa">
                                		${aa.mc}
                                	</c:forEach>
                                </td>
                                <td align="center"><c:if test="${li.state==1}">有效</c:if>
													<c:if test="${li.state==0}">无效</c:if>
                                </td>
                                <td align="center">
                                    <a href="javascript:doEdit('${li.roleId}')">编辑</a>
                                    <a href="javascript:doDelete('${li.roleId}')">删除</a>
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