<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/common/header.jsp"%>

<title>角色管理</title>
</head>
<body class="rightBody">
	<form id="form" name="form" action="${basePath }nsfw/role_add.do"
		method="post" enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>角色管理</strong>&nbsp;-&nbsp;新增角色
						</div>
					</div>
					<div class="tableH2">新增角色</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="200px">角色名称：</td>
							<td><input type="text" name="role.name" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">角色权限：</td>
							<td><input type="checkbox" name="privilegeIds"
								value="spaces" id="privilegeIds-1"> 
								<label
								for="privilegeIds-1" class="checkboxLabel">我的空间</label> <input
								type="checkbox" name="privilegeIds" value="zxxx"
								id="privilegeIds-2"> <label for="privilegeIds-2"
								class="checkboxLabel">在线学习</label> <input type="checkbox"
								name="privilegeIds" value="nsfw" id="privilegeIds-3"> <label
								for="privilegeIds-3" class="checkboxLabel">纳税服务</label> <input
								type="checkbox" name="privilegeIds" value="xzgl"
								id="privilegeIds-4"> <label for="privilegeIds-4"
								class="checkboxLabel">行政管理</label> <input type="checkbox"
								name="privilegeIds" value="hqfw" id="privilegeIds-5"> <label
								for="privilegeIds-5" class="checkboxLabel">后勤服务</label></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">状态：</td>
							<td>
							<label><input type="radio" name="role.state"value="1" />有效</label> 
							<label><input type="radio" name="role.state" value="0" />无效</label>
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