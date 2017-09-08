<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<!--角色树-->
	<div style="float:left;display:block;margin:10px;overflow:auto;width:400px;height:600px;
	border:solid 1px #CCC;line-height:21px;background:#FFF;">
		<ul class="tree treeFolder treeCheck expand">${roleTree}</ul>
		<input type="button" value="全选" onclick="checkAll()"/>
		<input type="button" value="反选" onclick="selectInvert()"/>		
		<input type="button"  value="提交" onclick="test('${innerUserId}')"/>
	</div>	
</body>
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

function test(innerUserId)
{
	var roleId=[];
	for(var i=0; i<$("div[class='ckbox checked']").length; i++)
	{	
		roleId[i]=$("div[class='ckbox checked']").next().next().eq(i).attr("id");
	}

		$.ajax({
			async:false,
			type :"post",
			url  :"${ctx}/innerUser/assignRole.do",
			data :{"innerUserId":innerUserId,"roleId":roleId},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			success : function(json) {
				alert("分配角色成功");
			}
		});	
}
</script>
