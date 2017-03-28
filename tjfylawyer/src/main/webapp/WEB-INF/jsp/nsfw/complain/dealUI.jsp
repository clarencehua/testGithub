<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>投诉受理管理</title>
</head>
<body class="rightBody">
	<form id="form" name="form" action="${basePath }nsfw/complain_deal.do"
		method="post" enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>投诉受理管理</strong>&nbsp;-&nbsp;投诉受理
						</div>
					</div>
					<div class="tableH2">
						投诉详细信息<span style="color:red;">(<c:forEach
								items="${complainStateMap}" var="aa">
								<c:if test="${aa.key==complain.state}">${aa.value}</c:if>
							</c:forEach> )</span>
					</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" align="center">投诉人信息</td>
						</tr>
						<tr>
							<td class="tdBg" width="250px">是否匿名投诉：</td>
							<td>
							 <c:if
									test="${complain.isNm==true}">匿名投诉</c:if> <c:if
									test="${complain.isNm==false}">非匿名投诉</c:if></td>
						</tr>
						<tr>
							<td class="tdBg">投诉人单位：</td>
							<td>
								 <c:if test="${complain.isNm==false}">${complain.compCompany}</c:if>
							</td>
						</tr>
						<tr>
							<td class="tdBg">投诉人姓名：</td>
							<td>
								<c:if test="${complain.isNm==false}">${complain.compName}</c:if>
							</td>
						</tr>
						<tr>
							<td class="tdBg">投诉人手机：</td>
							<td>
								 <c:if test="${complain.isNm==false}">
									<c:set var="testStr" value="${complain.compMobile}"></c:set>
									<c:choose>
										<c:when test="${fn:length(testStr) > 10}">
											
												<c:out value="${fn:substring(testStr, 0, 3)}****${ fn:substring(testStr, 7,11)}"/>
										</c:when>
									</c:choose>
								</c:if></td>
						</tr>
						<tr>
							<td colspan="2" align="center">投诉信息</td>
						</tr>
						<tr>
							<td class="tdBg">投诉时间：</td>
							<td>
								<c:set var="testStr" value="${complain.compTime}"></c:set> <c:choose>
									<c:when test="${fn:length(testStr) > 10}">
										<c:out value="${fn:substring(testStr, 0, 10)}" />
									</c:when>
								</c:choose></td>
						</tr>
						<tr>
							<td class="tdBg">被投诉部门：</td>
							<td>
							${complain.toCompDept}
							</td>
						</tr>
						<tr>
							<td class="tdBg">被投诉人：</td>
							<td>
							${complain.toCompName}
							</td>
						</tr>
						<tr>
							<td class="tdBg">投诉标题：</td>
							<td>
							${complain.compTitle}
							</td>
						</tr>
						<tr>
							<td class="tdBg">投诉内容：</td>
							<td>${complain.compContent}
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">受理信息</td>
						</tr>
						<tr>
							<td colspan="2">
									<c:forEach items="${complain.complainReplies}" var="li"
								varStatus="status">
									<fieldset style="border: solid 1px #c0c0c0;margin-top:5px;">
										<legend style="color:green;font-weight:bold;">
											回复
											${status.index}
											&nbsp;
										</legend>
										<div
											style="width:100%; text-align:center;color:#ccc;maring-top:5px;">
											回复部门：
										
											${li.replyDept}
											&nbsp;&nbsp; 回复人：
											${li.replyer}
											&nbsp;&nbsp; 回复时间：
											${li.replyTime}
										</div>
										<div
											style="width:100%;maring-top:10px;font-size:13px;padding-left:5px;">
											${li.replyContent}
										</div>
									</fieldset>
								</c:forEach></td>
						</tr>
						<tr>
							<td colspan="2" align="center">受理操作</td>
						</tr>
						<tr>
							<td class="tdBg">回复部门：</td>
							<td>	<input type="text" readonly="readonly" value="${sessionScope.SYS_USER.dept}" name="complainReply.replyDept"/>
							</td>
						</tr>
						<tr>
							<td class="tdBg">回复人：</td>
							<td>	<input type="text" readonly="readonly" value="${sessionScope.SYS_USER.name}" name="complainReply.replyName"/>
							</td>
						</tr>

						<tr>
							<td class="tdBg" width="200px">回复内容：</td>
							<td>
							<textarea rows="8" cols="90" name="complainReply.replyContent"></textarea>
							</td>
						</tr>
					</table>
					<input type="text" name="complain.compId" value="${complain.compId}" hidden="true"/>
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