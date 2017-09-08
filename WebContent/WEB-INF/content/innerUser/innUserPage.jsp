<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <div class="pageContent">
	<form method="post" action="/innerUser/UpdInnerUser.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
	
			<p>
				<label>用户名称：</label>
				<input type="text" size="30" value="${user.userName}" readonly="readonly"/>
			</p>
			<p>
				<label>用户登录名：</label>
				<input type="text" size="30" value="${user.loginName}" readonly="readonly"/>
			</p>
			<p>
				<label>用户密码：</label>
				<input type="text" size="30" value="${user.userPwd}" readonly="readonly"/>
			</p>
			<p>
				<label>用户性别：</label>
				<select name="type" class="required combox">
					<c:choose>
					    <c:when test="${user.sex == 1 }">
					    	<option value="1" selected>男</option>
					    </c:when>
					    <c:when test="${user.sex == 2}">
					    	<option value="2" selected>女</option>
					    </c:when>
				    </c:choose>			
				</select>
			</p>
			<p>
				<label>证件类型：</label>
				<select name="${user.certificateType}" class="required combox">
					<c:choose>
					    <c:when test="${user.certificateType == 0}">
					    	<option value="0" selected>身份证</option>
					    </c:when>
					    <c:when test="${user.certificateType == 1}">
					    	<option value="1" selected>工作证件</option>
					    </c:when>
					    <c:when test="${user.certificateType == 2}">
					    	<option value="2" selected>其它证件</option>
					    </c:when>
				    </c:choose>		
					
					
					
				</select>
			</p>
			<p>
				<label>证件编号：</label>
				<input type="text" size="30" value="${user.certificateNo}" readonly="readonly"/>
			</p>
			<p>
				<label>联系电话：</label>
				<input type="text" size="30" value="${user.concatPhone}" readonly="readonly"/>
			</p>
			<p>
				<label>紧急联系人：</label>
				<input type="text" size="30" value="${user.emergencyConcatName}" readonly="readonly"/>
			</p>
			<p>
				<label>紧急联系电话：</label>
				<input type="text" size="30" value="${user.emergencyConcatPhone}" readonly="readonly"/>
			</p>
			<p>
				<label>绑定登录系统：</label>
				<select name="boundsys" class="required combox" readonly="readonly">
					<c:choose>
						<c:when test="${user.boundSys == 0 }">
					    	<option value="0" selected>所有系统</option>
					    </c:when>
					    <c:when test="${user.boundSys == 1 }">
					    	<option value="1" selected>操盘</option>
					    </c:when>
					    <c:when test="${user.boundSys == 2}">
					    	<option value="2" selected>数据中心</option>
					    </c:when>
				    </c:choose>	
				</select>
			</p>
			<p>
				<label>可否第三方下注：</label>
				<select name="canbet" class="required combox">
					<c:choose>
					    <c:when test="${user.canbet == 1 }">
					    	<option value="1" selected>是</option>
					    </c:when>
					    <c:when test="${user.canbet == 0}">
					    	<option value="0">否</option>
					    </c:when>
				    </c:choose>	
				</select>
			</p>
		</div>	
					
		<div class="formBar">
			<ul>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">确认</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</html>
