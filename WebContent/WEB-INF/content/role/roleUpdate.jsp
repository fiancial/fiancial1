<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/WEB-INF/content/public/manager.jsp" %>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body>
<div id="container-margin" style="height: auto;overflow: auto;background-color: white">			
	<div class="pageContent" style="width: 200px;">
	<form
		onsubmit="return validateCallback(this, dialogAjaxDone);"
		method="post" action="${ctx}/role/roleUpdate.do"
		class="pageForm required-validate"
		id="createRightForm">
		<div class="pageFormContent" layouth="56" style="height: 200px; overflow: auto;">
			<input type = "hidden" name = "roleId" value = "${role.roleId}">
			<dl>
				<dt>角色名称：</dt>
				<dd>
					<input type="text" name="roleName" maxlength="20" class="required" value = "${role.roleName}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>角色描述：</dt>
				<dd>
					<input type="text" name="roleDesc"   maxlength="40" class="required" value = "${role.roleDesc}"/>
				</dd>
			</dl>
			<dl>
				<dt>角色上级：</dt>
				<dd>
					<select class="combox" name="parentId" ref="w_combox_city" refUrl="demo/combox/city_{value}.html">
						<c:if test="${role.parentId==-1}">
							<option value="-1" selected>无上级</option>
						</c:if>					
					<c:forEach items="${roleList}" var="rol">								
						<c:if test="${rol.roleName==role.parentName }">
							<option value="${rol.roleId} " selected>${rol.roleName}</option>
						</c:if>
						<c:if test="${rol.roleName!=role.parentName }">
							<option value="${rol.roleId} " >${rol.roleName}</option>
						</c:if>
					</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>角色类型：</dt>
				<dd>
					<c:if test= "${role.roleType == 1}" >
						<label><input class="ab" type="radio" name="roleType" value = "1" checked = "checked"/>操盘系统</label>
						<label><input class="ab" type="radio" name="roleType" value = "2" />数据中心 </label>
						<label><input class="abc" type="radio" name="roleType" value = "3" />管理中心</label>				
					</c:if>
					<c:if test="${role.roleType == 2}">
						<label><input class="ab" type="radio" name="roleType" value = "1" />操盘系统</label>
						<label><input class="ab" type="radio" name="roleType" value = "2" checked = "checked"/>数据中心 </label>
						<label><input class="abc" type="radio" name="roleType" value = "3" />管理中心</label>				
					</c:if>
					<c:if test="${role.roleType == 3}">
						<label><input class="ab" type="radio" name="roleType" value = "1" />操盘系统</label>
						<label><input class="ab" type="radio" name="roleType" value = "2" />数据中心 </label>
						<label><input class="abc" type="radio" name="roleType" value = "3" checked = "checked"/>管理中心</label>				
					</c:if>
					
				</dd>
			</dl>
		</div>
		
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
	</div>
</div>
<script type="text/javascript" defer="defer">
</script>
</body>
</html>