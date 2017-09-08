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
		method="post" action="${ctx}/right/rightAdd.do"
		class="pageForm required-validate"
		id="createRightForm">
		<div class="pageFormContent" layouth="56" style="height: 200px; overflow: auto;">
			<dl>
				<dt>权限名称：</dt>
				<dd>
					<input type="text" name="rightName" maxlength="20" class="required" />
				</dd>
			</dl>
			<dl>
				<dt>权限编码：</dt>
				<dd>
					<input type="text" name="rightCode" maxlength="20" class="required" />
				</dd>
			</dl>
			<dl>
				<dt>访问路径：</dt>
				<dd>
					<input type="text" name="accessPath" maxlength="20" class="required" />
				</dd>
			</dl>
			<dl>
				<dt>权限描述：</dt>
				<dd>
					<input type="text" name="rightDesc" maxlength="40" class="required" />
				</dd>
			</dl>
			<dl>
				<dt>资源类型：</dt>
				<dd>
				<label><input type="radio" name="sourceType" value = "1" />功能菜单</label>
				<label><input type="radio" name="sourceType" value = "2" />按钮</label>
				</dd>
			</dl>
			<p></p>
			<dl>
				<dt>权限类型：</dt>
				<dd>		
				<label><input type="radio" name="rightType" value = "1" />类型一</label>
				<label><input type="radio" name="rightType" value = "2" />类型二</label>
				<label><input type="radio" name="rightType" value = "3" />类型三</label>
				<label><input type="radio" name="rightType" value = "4" />类型四</label>
				</dd>
			</dl>
			<p></p>
			<p></p>
			<dl>
				<dt>上级权限：</dt>
				<dd>
				<input type="text" name="parentId" maxlength="40" class="required" />
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
