<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <div class="pageContent">
	<form method="post" action="${ctx}/innerUser/addInnerUser.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
	
			<p>
				<label>用户名称：</label>
				<input type="text" size="30" name="userName" class="required"/>
			</p>
			<p>
				<label>用户登录名：</label>
				<input type="text" size="30" name="loginName" class="required"/>
			</p>
			<p>
				<label>用户密码：</label>
				<input type="text" size="30" name="userPwd" class="required"/>
			</p>
			<p>
				<label>用户性别：</label>
				<select name="sex" class="required combox">
					<option value="1" selected>男</option>
					<option value="2">女</option>
				</select>
			</p>
			<p>
				<label>证件类型：</label>
				<select name="certificateType" class="required combox">
					<option value="0" selected>身份证</option>
					<option value="1">工作证件</option>
					<option value="2">其它证件</option>
				</select>
			</p>
			<p>
				<label>证件编号：</label>
				<input type="text" size="30" name="certificateNo" class="required"/>
			</p>
			<p>
				<label>联系电话：</label>
				<input type="text" size="30" name="concatPhone" class="required"/>
			</p>
			<p>
				<label>紧急联系人：</label>
				<input type="text" size="30" name="emergencyConcatName" />
			</p>
			<p>
				<label>紧急联系电话：</label>
				<input type="text" size="30" name="emergencyConcatPhone" />
			</p>
			<p>
				<label>绑定登录系统：</label>
				<select name="boundSys" class="required combox">
					<option value="0" selected>所有系统</option>
					<option value="1">操盘</option>
					<option value="2">数据中心</option>
				</select>
			</p>
			<p>
				<label>可否第三方下注：</label>
				<select name="canbet" class="required combox">
					<option value="1" selected>是</option>
					<option value="0">否</option>
				</select>
			</p>
			<p></p>
			<!--角色树-->
			<div style="float:left;display:block;margin:10px;overflow:auto;width:400px;height:400px;
			border:solid 1px #CCC;line-height:21px;background:#FFF;">
				<ul class="tree treeFolder treeCheck expand">${roleTree}</ul>
				<input type="button" value="全选" onclick="checkAll()"/>
				<input type="button" value="反选" onclick="selectInvert()"/>
						
			</div>
			<p style="display: none" id="roleid">
			</p>	
		</div>
			
			
					
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="roleids()">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
</html>
<script test="text/javascript">
function checkAll()
{
	$("div[class='ckbox unchecked']").attr("class","ckbox checked");
	$("div[class='ckbox indeterminate']").attr("class","ckbox checked");
}
function selectInvert()
{
	var checked=$("div[class='ckbox checked']");
	var unchecked=$("div[class='ckbox unchecked']");
	checked.attr("class","ckbox unchecked");
	unchecked.attr("class","ckbox checked");
}
function roleids()
{
	var roleids=[];
	var a='';
	for(var i=0; i<$("div[class='ckbox checked']").length;i++)
	{
		roleids[i]=$("div[class='ckbox checked']").eq(i).next().next().attr("id");
		a+="<input name='roleId' value='"+roleids[i]+"'/>";
	}
	$("#roleid").html(a);
	return true;
}
</script>

