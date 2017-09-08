<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <div class="pageContent">
	<form method="post" action="${ctx}/innerUser/updInnUser.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p style="display:none">
				<input name="innerUserId" value="${user.innerUserId}" />
			</p>
			<p>
				<label>用户名称：</label>
				<input type="text" size="30" name="userName" value="${user.userName}" class="required"/>
			</p>
			<p>
				<label>用户登录名：</label>
				<input type="text" size="30" name="loginName" value="${user.loginName}" class="required"/>
			</p>
			<p>
				<label>用户密码：</label>
				<input type="text" size="30" name="userPwd" />
			</p>
			<p>
				<label>用户性别：</label>
				<select name="sex" class="required combox">					
					<c:choose>
					    <c:when test="${user.sex == 1 }">
					    	<option value="1" selected>男</option>
					    	<option value="2">女</option>
					    </c:when>
					    <c:when test="${user.sex == 2}">
					    	<option value="1" >男</option>
					    	<option value="2" selected>女</option>
					    </c:when>
				    </c:choose>			
				</select>
			</p>
			<p>
				<label>证件类型：</label>
				<select name="certificateType" class="required combox">
					<c:choose>
					    <c:when test="${user.certificateType == 0}">
					    	<option value="0" selected>身份证</option>
					    	<option value="1">工作证件</option>
							<option value="2">其它证件</option>
					    </c:when>
					    <c:when test="${user.certificateType == 1}">
					    	<option value="0">身份证</option>
							<option value="1" selected>工作证件</option>
							<option value="2">其它证件</option>
					    </c:when>
					    <c:when test="${user.certificateType == 2}">
					    	<option value="0">身份证</option>
							<option value="1">工作证件</option>
							<option value="2" selected>其它证件</option>
					    </c:when>
				    </c:choose>		
					
				</select>
			</p>
			<p>
				<label>证件编号：</label>
				<input type="text" size="30" name="certificateNo" value="${user.certificateNo}" class="required"/>
			</p>
			<p>
				<label>联系电话：</label>
				<input type="text" size="30" name="concatPhone" value="${user.concatPhone}" class="required"/>
			</p>
			<p>
				<label>紧急联系人：</label>
				<input type="text" size="30" name="emergencyConcatName" value="${user.emergencyConcatName}"/>
			</p>
			<p>
				<label>紧急联系电话：</label>
				<input type="text" size="30" name="emergencyConcatPhone" value="${user.emergencyConcatPhone}"/>
			</p>
			<p>
				<label>绑定登录系统：</label>
				<select name="boundSys" class="required combox">
					<c:choose>
						<c:when test="${user.boundSys == 0 }">
					    	<option value="0" selected>所有系统</option>
							<option value="1">操盘</option>
							<option value="2">数据中心</option>
					    </c:when>
					    <c:when test="${user.boundSys == 1 }">
					    	<option value="0">所有系统</option>
							<option value="1" selected>操盘</option>
							<option value="2">数据中心</option>
					    </c:when>
					    <c:when test="${user.boundSys == 2}">
					    	<option value="0">所有系统</option>
							<option value="1">操盘</option>
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
					    	<option value="0">否</option>
					    </c:when>
					    <c:when test="${user.canbet == 0}">
					    	<option value="1">是</option>
					    	<option value="0" selected>否</option>
					    </c:when>
				    </c:choose>	
				</select>
			</p>
		</div>	
					
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</html>