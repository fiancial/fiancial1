<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		method="post" action="${ctx}/systemUser/toSystemUserlistAdd.do"
		class="pageForm required-validate"
		id="createStuForm">
		<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
			<input type="hidden" name="pageNum" value="${pageNum }">
			<p>
				<label>ID：</label>
				<input id="" name="id" readonly="readonly"  size="30" type="text">
			</p>	
			<p>
			<label >账户期满：</label>
				<select id="" name="accountExpired" style="width: 171px; left: 130px; ">
					<option value="0" selected="selected">0</option>
					<option value="1">1</option>
				</select>
			</p>
			<p>
			<label >账户锁定：</label>
				<select id="" name="accountLocked" style="width: 171px; left: 130px; ">
					<option value="0" selected="selected">0</option>
					<option value="1">1</option>
				</select>
			</p>
			<p>
			<label >资格证书期满：</label>
				<select id="" name="credentialsExpired" style="width: 171px; left: 130px; ">
					<option value="0" selected="selected">0</option>
					<option value="1">1</option>
				</select>
			</p>
			<p>
			<label >账户启用：</label>
				<select id="" name="accountEnabled" style="width: 171px; left: 130px; ">
					<option value="1" selected="selected">1</option>
					<option value="0">0</option>
				</select>
			</p>
			<p>
				<label>账户启用：</label>
				<input id="name_9145" name="accountEnabled" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>密码：</label>
				<input id="name_9145" name="password" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>密码提示：</label>
				<input id="name_9145" name="passwordHint" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>电话：</label>
				<input id="name_9145" name="telePhone" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>用户姓名：</label>
				<input id="name_9145" name="userName" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>完整姓名：</label>
				<input id="name_9145" name="fullName" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>版本：</label>
				<input id="name_9145" name="version" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>EP_ID：</label>
				<input id="name_9145" name="epId" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>CREATEDTIME：</label>
				<input name="cheatedtime" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>最后登录时间：</label>
				<input name="lastLoginTime" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>识别数字：</label>
				<input id="name_9145" name="identifyNum" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>备注：</label>
				<input id="name_9145" name="remark" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>最后更新时间：</label>
				<input name="lastupdatedtime" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>最后更新人：</label>
				<input id="name_9145" name="lastupdatedby" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>期满时间：</label>
				<input name="expiredTime" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>城市系统ID：</label>
				<input id="name_9145" name="citysysid" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
				<p>
				<label>渠道：</label>
				<input id="name_9145" name="channel" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>登录密码错误次数：</label>
				<input id="name_9145" name="errorNum" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
			<label >是否需要短信验证：</label>
				<select id="" name="isphonecheck" style="width: 171px; left: 130px; ">
					<option value="1" selected="selected">1</option>
					<option value="0">0</option>
				</select>
			</p>
			<p>
				<label>激活时间：</label>
				<input name="activateTime" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>用户类型：</label>
				<input id="name_9145" name="userType" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>电话信息：</label>
				<input id="name_9145" name="phoneMsg" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>电话发送时间：</label>
				<input name="phoneSendTime" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
			<label >是否能查看隐藏信息：</label>
				<select id="" name="isuser" style="width: 171px; left: 130px; ">
					<option value="0" selected="selected">0</option>
					<option value="1">1</option>
				</select>
			</p>
			<p>
				<label>所属商户：</label>
				<input id="name_9145" name="orgMerchant" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属仓库：</label>
				<input id="name_9145" name="orgWarehouse" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
				<p>
				<label>所属物流商：</label>
				<input id="name_9145" name="orgLogistics" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属供应商：</label>
				<input id="name_9145" name="orgProvIder" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属渠道：</label>
				<input id="name_9145" name="orgChannel" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
				<p>
				<label>所属开通类型：</label>
				<input id="name_9145" name="orgOpenType" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属城市：</label>
				<input id="name_9145" name="orgCity" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>用户所属组织机构：</label>
				<input id="name_9145" name="orgCompany" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
			<label >状态：</label>
				<select id="" name="isavail" style="width: 171px; left: 130px; ">
					<option value="1" selected="selected">1</option>
					<option value="0">0</option>
				</select>
			</p>
			<p>
				<label>密码标示：</label>
				<input id="name_9145" name="pwdflag" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>路径域：</label>
				<input id="name_9145" name="urlDomain" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>密码更新时间：</label>
				<input name="pwdUpdTime" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>社会渠道网点关联：</label>
				<input id="name_9145" name="branchId" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>email：</label>
				<input id="name_9145" name="email" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>创建人：</label>
				<input id="name_9145" name="createdby" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
			<label >是否有效：</label>
				<select id="" name="isenabled" style="width: 171px; left: 130px; ">
					<option value="1" selected="selected">是</option>
					<option value="0">否</option>
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
</div>
</div></div>
			</div>
		</div>

	<div id="taskbar" style="left: 0px; display: none; top: 220px; width: 1920px;">
	<div class="taskbarContent">
		<ul></ul>
	</div>
	<div class="taskbarLeft taskbarLeftDisabled" style="display:none;">taskbarLeft</div>
	<div class="taskbarRight" style="display:none;">taskbarRight</div>
</div></div>

<div style="height: 160px;" id="splitBarProxy"></div>
<!--拖动效果-->
<div class="resizable"></div>
</body>
</html>

