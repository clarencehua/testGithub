<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>用户管理</title>
<script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
 <script type="text/javascript">
	var vResult = false;
    	//校验帐号唯一
    	function doVerify(){
    		//1、获取帐号
    		var account = $("#account").val();
    		if(account != ""){
    			//2、校验 
    			$.ajax({
    				url:"${basePath}nsfw/user_verifyAccount.do",
    				data: {"user.account": account, "user.id": "${user.id}"},
    				dataType:"json",
    				type: "post",
    				async: false,//非异步
    				success: function(msg){
    					if("true"!= msg.key){
    						//帐号已经存在
    						alert("帐号已经存在。请使用其它帐号！");
    						//定焦
    						$("#account").focus();
    						vResult = false;
    					} else {
    						vResult = true;
    					}
    				}
    			});
    		}
    	}
    	//提交表单
    	function doSubmit(){
    	console.log("2222222");
    		var name = $("#name");
    		if(name.val() == ""){
    			alert("用户名不能为空！");
    			name.focus();
    			return false;
    		}
    		var password = $("#password");
    		if(password.val() == ""){
    			alert("密码不能为空！");
    			password.focus();
    			return false;
    		}
    		//帐号校验
    		doVerify();
    		if(vResult){
	    		//提交表单
	    		document.forms[0].submit();
    		}
    	}
    	
	</script>
</head>
<body class="rightBody">
	<form id="form" name="form" action="${basePath }nsfw/user_edit.do"
		method="post">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>用户管理</strong>&nbsp;-&nbsp;编辑用户
						</div>
					</div>
					<div class="tableH2">编辑用户</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="200px">所属部门：</td>
							<td><select name="user.dept" id="selectDept">
								<option <c:if test="${user.dept=='部门A'}">selected="selected"</c:if> value="部门A">部门A</option>
								<option <c:if test="${user.dept=='部门B'}">selected="selected"</c:if> value="部门B">部门B</option>
							</select></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">头像：</td>
							<td><c:if
									test="%{user.headImg != null && user.headImg != ''}"/>
									<img
										src=""
										width="100" height="100" />
									<s:hidden name="user.headImg" />
								 <input type="file" name="headImg" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">用户名：</td>
							<td><input type="text" name="user.name" id="name" value="${user.account}"/></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">帐号：</td>
							<td><input type="text" name="user.account" id="account" value="${user.account}" onchange="doVerify()"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">密码：</td>
							<td><input type="text" name="user.password" id="password" value="${user.password}"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">性别：</td>
							<td>
							<label><input type="radio" name="user.gender" value="true" <c:if test="${user.gender=='true'}">checked="checked"</c:if>/>男</label> 
							<label><input type="radio" name="user.gender" value="false" <c:if test="${user.gender=='false'}">checked="checked"</c:if> />女</label>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">角色：</td>
							<td>
								<c:forEach items="${roleList}" var="li">
									<input type="checkbox" name="userRoleIds" value="${li.roleId}" 
											 <c:forEach items="${roleIds}" var="aa">
												<c:if test="${li.roleId==aa}">checked="true"</c:if>
											</c:forEach> 										
									/><label for="userRoleIds" class="checkboxLabel">${li.name}</label>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">电子邮箱：</td>
							<td><input type="text" name="user.email" value="${user.email}"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">手机号：</td>
							<td><input type="text" name="user.mobile" value="${user.mobile}" />
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">生日：</td>
							<td><input type="text" id="birthday" name="user.birthday" value="${user.birthday}"
									readonly="true"
									onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});">
									<s:param name="value">
										<s:date name="user.birthday" format="yyyy-MM-dd" />
									</s:param>
								</input></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">状态：</td>
							<td>
							<label><input type="radio" name="user.state"  <c:if test="${user.state=='1'}">checked="checked"</c:if> value="1"/>有效</label> 
							<label><input type="radio" name="user.state" <c:if test="${user.state=='0'}">checked="checked"</c:if> value="0"/>无效</label>
							</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">备注：</td>
							<td><!-- <s:textarea name="user.memo" cols="75" rows="3" /> -->
							<textarea rows="3" cols="75" name="user.memo" >${user.memo}</textarea>
							</td>
						</tr>
					</table>
					<input type="hidden" name="user.id" value="${user.id}" >
					<div class="tc mt20">
						<input type="button" class="btnB2" value="保存"  onclick="doSubmit()"/>
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>