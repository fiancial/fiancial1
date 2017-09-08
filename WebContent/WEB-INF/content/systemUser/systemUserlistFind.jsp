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
		method="post" action="${ctx}/systemUser/toCheckSSystemUser.do"
		class="pageForm required-validate"
		id="createStuForm">
		<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
			<input type="hidden" name="pageNum" value="${pageNum }">
			<p>
				<label>ID：</label>
				<input id="" value="${su.id }" name="id" readonly="readonly"  size="30" type="text">
			</p>	
			<p>
			<label >账户期满：</label>
				<select id="" name="accountExpired" style="width: 171px; left: 130px; ">
					<c:choose>
						  	    <c:when test="${su.accountExpired   == 0}">
						  	    	<option value="${su.accountExpired }">0</option>
						  	    </c:when>
						  	    <c:when test="${su.accountExpired  == 1}">
						  	    	<option value="${su.accountExpired }">1</option>
						  	    </c:when>
					</c:choose>
				</select>
			</p>
			<p>
			<label >账户锁定：</label>
				<select id="" name="accountLocked" style="width: 171px; left: 130px; ">
					<c:choose>
						  	    <c:when test="${su.accountLocked   == 0}">
						  	    	<option value="${su.accountLocked }">0</option>
						  	    </c:when>
						  	    <c:when test="${su.accountLocked  == 1}">
						  	    	<option value="${su.accountLocked }">1</option>
						  	    </c:when>
					</c:choose>
				</select>
			</p>
			<p>
			<label >资格证书期满：</label>
				<select id="" name="credentialsExpired" style="width: 171px; left: 130px; ">
					<c:choose>
						  	    <c:when test="${su.credentialsExpired   == 0}">
						  	    	<option value="${su.credentialsExpired }">0</option>
						  	    </c:when>
						  	    <c:when test="${su.credentialsExpired  == 1}">
						  	    	<option value="${su.credentialsExpired }">1</option>
						  	    </c:when>
					</c:choose>
				</select>
			</p>
			<p>
			<label >账户启用：</label>
				<select id="" name="accountEnabled" style="width: 171px; left: 130px; ">
					<c:choose>
						  	    <c:when test="${su.accountEnabled   == 1}">
						  	    	<option value="${su.accountEnabled }">1</option>
						  	    </c:when>
						  	    <c:when test="${su.accountEnabled  == 0}">
						  	    	<option value="${su.accountEnabled }">0</option>
						  	    </c:when>
					</c:choose>
				</select>
			</p>
			<p>
				<label>账户启用：</label>
				<input id="name_9145" value="${su.accountEnabled }" readonly="readonly" name="accountEnabled" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>密码：</label>
				<input id="name_9145" value="${su.password }" readonly="readonly" name="password" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>密码提示：</label>
				<input id="name_9145" value="${su.passwordHint }" readonly="readonly" name="passwordHint" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>电话：</label>
				<input id="name_9145" value="${su.telePhone }" readonly="readonly" name="telePhone" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>用户姓名：</label>
				<input id="name_9145" value="${su.userName }" readonly="readonly" name="userName" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>完整姓名：</label>
				<input id="name_9145" value="${su.fullName }" readonly="readonly" name="fullName" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>版本：</label>
				<input id="name_9145" value="${su.version }" readonly="readonly" name="version" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>EP_ID：</label>
				<input id="name_9145" value="${su.epId }" readonly="readonly" name="epId" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>CREATEDTIME：</label>
				<input name="cheatedtime" value="${su.cheatedtime }" readonly="readonly" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>最后登录时间：</label>
				<input name="lastLoginTime" value="${su.lastLoginTime }" readonly="readonly" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>识别数字：</label>
				<input id="name_9145" value="${su.identifyNum }" readonly="readonly" name="identifyNum" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>备注：</label>
				<input id="name_9145" value="${su.remark }" readonly="readonly" name="remark" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>最后更新时间：</label>
				<input name="lastupdatedtime" value="${su.lastupdatedtime }" readonly="readonly" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>最后更新人：</label>
				<input id="name_9145" value="${su.lastupdatedby }" readonly="readonly" name="lastupdatedby" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>期满时间：</label>
				<input name="expiredTime" value="${su.expiredTime }" readonly="readonly" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>城市系统ID：</label>
				<input id="name_9145" value="${su.citysysid }" readonly="readonly" name="citysysid" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
				<p>
				<label>渠道：</label>
				<input id="name_9145" value="${su.channel }" readonly="readonly" name="channel" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>登录密码错误次数：</label>
				<input id="name_9145" value="${su.errorNum }" readonly="readonly" name="errorNum" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
			<label >是否需要短信验证：</label>
				<select id="" name="isphonecheck" style="width: 171px; left: 130px; ">
					<c:choose>
						  	    <c:when test="${su.isphonecheck  == 1}">
						  	    	<option value="${su.isphonecheck}">1</option>
						  	    </c:when>
						  	    <c:when test="${su.isphonecheck == 0}">
						  	    	<option value="${su.isphonecheck }">0</option>
						  	    </c:when>
					</c:choose>
				</select>
			</p>
			<p>
				<label>激活时间：</label>
				<input name="activateTime" value="${su.activateTime }" readonly="readonly" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>用户类型：</label>
				<input id="name_9145" value="${su.userType }" readonly="readonly" name="userType" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>电话信息：</label>
				<input id="name_9145" value="${su.phoneMsg }" readonly="readonly" name="phoneMsg" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>电话发送时间：</label>
				<input name="phoneSendTime" value="${su.phoneSendTime }" readonly="readonly" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
			<label >是否能查看隐藏信息：</label>
				<select id="" name="isuser" style="width: 171px; left: 130px; ">
					<c:choose>
						  	    <c:when test="${su.isuser  == 1}">
						  	    	<option value="${su.isuser}">1</option>
						  	    </c:when>
						  	    <c:when test="${su.isuser == 0}">
						  	    	<option value="${su.isuser }">0</option>
						  	    </c:when>
					</c:choose>
				</select>
			</p>
			<p>
				<label>所属商户：</label>
				<input id="name_9145" value="${su.orgMerchant }" readonly="readonly" name="orgMerchant" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属仓库：</label>
				<input id="name_9145" value="${su.orgWarehouse }" readonly="readonly" name="orgWarehouse" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
				<p>
				<label>所属物流商：</label>
				<input id="name_9145" value="${su.orgLogistics }" readonly="readonly" name="orgLogistics" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属供应商：</label>
				<input id="name_9145" value="${su.orgProvIder }" readonly="readonly" name="orgProvIder" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属渠道：</label>
				<input id="name_9145" value="${su.orgChannel }" readonly="readonly" name="orgChannel" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
				<p>
				<label>所属开通类型：</label>
				<input id="name_9145" value="${su.orgOpenType }" readonly="readonly" name="orgOpenType" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>所属城市：</label>
				<input id="name_9145" value="${su.orgCity }" readonly="readonly" name="orgCity" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>用户所属组织机构：</label>
				<input id="name_9145" value="${su.orgCompany }" readonly="readonly" name="orgCompany" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
			<label >状态：</label>
				<select id="" name="isavail" style="width: 171px; left: 130px; ">
					<c:choose>
						  	    <c:when test="${su.isavail  == 1}">
						  	    	<option value="${su.isavail}">启用</option>
						  	    </c:when>
						  	    <c:when test="${su.isavail == 0}">
						  	    	<option value="${su.isavail }">禁用</option>
						  	    </c:when>
					</c:choose>
				</select>
			</p>
			<p>
				<label>密码标示：</label>
				<input id="name_9145" value="${su.pwdflag }" readonly="readonly" name="pwdflag" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>路径域：</label>
				<input id="name_9145" value="${su.urlDomain }" readonly="readonly" name="urlDomain" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>密码更新时间：</label>
				<input name="pwdUpdTime" value="${su.pwdUpdTime }" readonly="readonly" class="date textInput readonly valid" datefmt="yyyy/MM/dd HH:mm:ss" mindate="2000-01" maxdate="2020-06" readonly="true" type="text">
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>社会渠道网点关联：</label>
				<input id="name_9145" value="${su.branchId }" readonly="readonly" name="branchId" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>email：</label>
				<input id="name_9145" value="${su.email }" readonly="readonly" name="email" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
				<label>创建人：</label>
				<input id="name_9145" value="${su.createdby }" readonly="readonly" name="createdby" class="required textInput" size="30" type="text">
			<label style="width: 171px; left: 130px;" class="alt" for="name_9145"></label>
			</p>
			<p>
			<label >是否有效：</label>
				<select id="" name="isenabled"   style="width: 171px; left: 130px; ">
				<c:choose>
						  	    <c:when test="${su.isenabled  == 1}">
						  	    	<option value="${su.isenabled }">是</option>
						  	    </c:when>
						  	    <c:when test="${su.isavail == 0}">
						  	    	<option value="${su.isenabled }">否</option>
						  	    </c:when>
				</c:choose>
				</select>
			</p>	
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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

