<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>用户管理</title>
<script type="text/javascript"
	src="${basePath }js/datepicker/WdatePicker.js"></script>
</head>
<body class="rightBody">
	<form id="form" name="form" action="${basePath}nsfw/user_add.do"
		method="post">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>用户管理</strong>&nbsp;-&nbsp;新增用户
						</div>
					</div>
					<div class="tableH2">新增用户</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="200px">所属部门：</td>
							<%--  <td><s:select name="user.dept" list="#{'部门A':'部门A','部门B':'部门B' }"/></td> --%>
							<td><select name="user.dept" id="selectDept">
								<option value="部门A">部门A</option>
								<option value="部门B">部门B</option>
							</select></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">头像：</td>
							<td><input type="file" name="headImg" id="headImg"/></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">用户名：</td>
							<!-- <td><s:textfield name="user.name" /></td> -->
							<td><input type="text" name="user.name"/></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">帐号：</td>
							<td><!-- <s:textfield name="user.account" /> --><input type="text" name="user.account"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">密码：</td>
							<td><!-- <s:textfield name="user.password" /> --><input type="text" name="user.password"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">性别：</td>
							<%-- <td><s:radio list="#{'true':'男','false':'女'}" name="user.gender"/></td> --%>
							<td><label><input type="radio" name="user.gender" value="true" checked="checked"/>男</label> 
								<label><input type="radio" name="user.gender" value="false"/>女</label>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">角色：</td>
							<td>
								<c:forEach items="${roleList}" var="li">
									<input type="checkbox" name="userRoleIds" value="${li.roleId}" 
									/><label for="userRoleIds" class="checkboxLabel">${li.name}</label>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">电子邮箱：</td>
							<td><!-- <s:textfield name="user.email" /> --><input type="text" name="user.email"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">手机号：</td>
							<td><!-- <s:textfield name="user.mobile" /> --><input type="text" name="user.mobile"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">生日：</td>
							<td><input type="text" id="birthday" name="user.birthday"
									readonly="true"
									onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" />
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">状态：</td>
							<%-- <td><s:radio list="#{'1':'有效','0':'无效'}" name="user.state" value="1"/></td> --%>
							<td>
							<label><input type="radio" name="user.state" value="1"/>有效</label> 
							<label><input type="radio" name="user.state" value="0"/>无效</label>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">备注：</td>
							<td><!-- <s:textarea name="user.memo" cols="75" rows="3" /> -->
							<textarea rows="3" cols="75" name="user.memo"></textarea>
							</td>
						</tr>
					</table>
					<div class="tc mt20">
						<input type="submit" class="btnB2" value="保存" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>