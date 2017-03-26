<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${basePath }js/ueditor/lang/zh-cn/zh-cn.js"></script>

    <script>
   		window.UEDITOR_HOME_URL = "${basePath }js/ueditor/";
    	var ue = UE.getEditor('editor');
    </script>

</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}nsfw/info_edit.do" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong>&nbsp;-&nbsp;修改信息</div></div>
    <div class="tableH2">修改信息</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">信息分类：</td>
            <td><select name="info.type" id="info_type">
            		<c:forEach  var="li" items="${xxfl}">
            			<option value="${li.key}"<c:set var="qq" value="${info.type}"></c:set> <c:if test="${info.type==qq}">selected = "selected"</c:if>>${li.value} </option>
            		</c:forEach>
            	</select> </td>
            <td class="tdBg" width="200px">来源：</td>
            <td><input type="text" name="info.source" value="${info.source}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息标题：</td>
            <td colspan="3"><input type="text" name="info.title" value="${info.title}" cssStyle="width:90%"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息内容：</td>
            <td colspan="3"><textarea id="editor" name="info.content" value="${info.content}" style="width:90%;height:160px;" ></textarea></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td colspan="3"><textarea name="info.memo" rows="3" cols="90">${info.memo} </textarea></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">创建人：</td>
            <td>
                <input type="text" readonly="readonly" value="${sessionScope.SYS_USER.name }" >
            	<input type="text" hidden="true" name="info.creator" value="${sessionScope.SYS_USER.name }"/>
            </td>
            <td class="tdBg" width="200px">创建时间：</td>
            <td>
            	<input type="text" readonly="readonly" name="info.createTime" name="info.createTime" value="${info.createTime}" >
            </td>
        </tr>
    </table>
    <input hidden="true" name="info.infoId" value="${info.infoId}" >
    <input hidden="true" name="info.state" value="1" >
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>