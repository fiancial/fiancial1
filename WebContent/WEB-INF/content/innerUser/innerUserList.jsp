<div id="jbsxBoxInnerUserList" class="unitBox">
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
<body>

<!--页面头部-->
<div class="pageHeader">
<form rel="pagerForm" id="pagerForm" onsubmit="return divSearch(this,'jbsxBoxInnerUserList');"  action="${ctx}/innerUser/innUserList.do" method="post" target="navTab" >
  <div class="searchBar">
	  <ul class="searchContent">
				<li>
					<label>用户：</label>
					<input type="text" name="userName" value=""/>
				</li>
				<li>
					<label>登录名称：</label>
					<input type="text" name="loginName" value=""/>
				</li>
				<li><input type="submit" value="检索"></li>
	  </ul>	
  </div>
</form>
  <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${ctx}/innerUser/innUserAddPage.do" target="navTab"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="edit"  onclick="userUpd()"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a><input type="button" onclick="userpage()" value="查看"/></a></li>
			<li class="line">line</li>
		</ul>
  </div>   
</div>
<!--页面主体-->
<div class="pageContent">    
	
	<div id="w_list_print">
	<table class="form" width="100%" layoutH="90" targetType="navTab">
		<thead>
			<tr>
				<th></th>
				<th>名称</th>
				<th>性别</th>
				<th>登录名称</th>
				<th>联系电话</th>		
				<th>创建时间</th>
				<th>停用/启用</th>
				<th>分配角色</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${innUserList}" var="use"  >
			  <tr>
			  	<td><input type="radio" name="userid" value = "${use.innerUserId}" /></td>
			    <td>${use.userName}</td>
			    <td>${use.sexStr}</td>
			    <td>${use.loginName}</td>
			    <td>${use.concatPhone}</td>
			    <td>${use.createDateStr}</td>
			    <td>		   
				    <input class="${use.status}" type="button" onclick="changeStatus(${use.innerUserId},${use.status}, this)" value="${use.statusStr}" />
			    </td>
			    <td>
			    <a class="button" href="${ctx}/innerUser/userRolePage.do?innerUserId=${use.innerUserId}" mask="true" target="dialog" rel="useRole" title="为${use.userName}分配角色"><span>分配角色</span></a>
			    </td>		    
			  </tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<div class="panelBar" >
		<div class="pages">
			<span>共${pageBean.totalRows}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${pageBean.totalRows}" 
		numPerPage="${pageBean.pageSize}" pageNumShown="${pageBean.pageSize}" 
		currentPage="${pageBean.currentPage}"></div>

	</div>
</div>

</body>
</html>
<script test="text/javascript">
//停用的用户，所有信息（文字）显示为灰色
$(".2").parent().parent().attr("Style","color:#8E8E8E");

function userpage()
{
	if($("input[name='userid']:checked").length==0)
	{
		alert("请选择用户！");
		return;
	}
	var id=$("input[name='userid']:checked").val();
	navTab.openTab("userpage","${ctx}/innerUser/innUserPage.do", { title:"用户详情", fresh:true, data:{"id":id} });
}

function userUpd()
{	
	if($("input[name='userid']:checked").length==0)
	{
		alert("请选择用户！");
		return;
	}
	var id=$("input[name='userid']:checked").val();
	navTab.openTab("userUpd","${ctx}/innerUser/innUserUpdPage.do", { title:"修改用户", fresh:true, data:{"id":id} });
}

//修改用户状态 ：启用/停用
function changeStatus(innerUserId,status, obj)
{
	$.ajax({
		type:"post",
		url:"${ctx}/innerUser/changeStatus.do",
		data:{"innerUserId":innerUserId,"status":status},
		success: function (json){
			if(status==1){
				$(obj).parent().parent().attr("Style","color:#8E8E8E");
				$(obj).parent().html(" <input type='button' onclick='changeStatus("+innerUserId+",2, this)' value='启用' />");
			}
			if(status==2){
				$(obj).parent().parent().attr("Style","");
				$(obj).parent().html(" <input type='button' onclick='changeStatus("+innerUserId+",1, this)' value='停用' />");
			}
		},
		error: function(){
			alert("更改失败！");
		}
	});
}

</script>
</div>