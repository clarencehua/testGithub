<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="c_pate" style="margin-top: 5px;">
        <c:if test="${pageResult.totalCount>0}">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
                 	总共<!--  <s:property value="pageResult.totalCount"/> --> ${pageResult.totalCount}条记录，当前第 <!-- <s:property value="pageResult.pageNo"/> -->${pageResult.pageNo} 页，
                 	共 <!-- <s:property value="pageResult.totalPageCount"/> --> ${pageResult.totalPageCount}页 
                 	<c:if test="${pageResult.pageNo > 1}">
                 	        &nbsp;&nbsp;<a href="javascript:doGoPage(${pageResult.pageNo-1})">上一页</a>
              	    </c:if>
              	    <c:if test="${pageResult.pageNo < pageResult.totalPageCount}">
                            &nbsp;&nbsp;<a href="javascript:doGoPage(${pageResult.pageNo+1})">下一页</a>
                    </c:if>        
					到&nbsp;<input id="pageNo" name="pageNo" type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value="${pageResult.pageNo}" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>
		</c:if><c:if test="${pageResult.totalCount<0}">暂无数据！</c:if>
        </div>
		<script type="text/javascript">
		//翻页
		function doGoPage(pageNo){
			document.getElementById("pageNo").value = pageNo;
			document.forms[0].action=list_url;
			document.forms[0].submit();
		}
		</script>