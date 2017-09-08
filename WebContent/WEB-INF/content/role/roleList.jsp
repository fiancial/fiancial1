<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp" %>
<div id="jbsxBoxRoleList" class="unitBox">
<div class="pageHeader">
	<form rel="pagerForm" id="pagerForm" onsubmit="return divSearch(this,'jbsxBoxRoleList');" action="${ctx}/role/roleList.do" method="post">
	<input type="hidden" name="pageNum" value="1" /> 
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>角色：</label>
				<input type="text" name="roleName" value=""/>
			</li>
			<li><input type="submit" value="检索"></li>
		</ul>	
	</div>
	</form>
	<div class="panelBar">
		<ul class="toolBar">
			<li class=""><a class="add" href="${ctx}/role/toRoleAddPage.do" mask="true" target="dialog" mask="true" title="新增角色"><span>添加</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
</div>

<div class="pageContent">    
	
	<div id="w_list_print">
	<table class="form" width="100%" layoutH="90" targetType="navTab">
		<thead>
			<tr>
				<th>角色</th>
				<th>上级</th>
				<th>类型</th>
				<th>描述</th>
				<th>修改</th>
				<th>停用/启用</th>
				<th>分配权限</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${roleList}" var="rol"  >
			  <tr>
			    <td>${rol.roleName}</td>
			    <td>${rol.parentName}</td>
			    <td>${rol.roleTypeString}</td>
			    <td>${rol.roleDesc}</td>
			    <td>
			    	<a  class="common-img"
					    href="${ctx}/role/toRoleUpdatePage.do?id=${rol.roleId }" 
					    target="dialog" mask="true" title="修改${stu.stuName }信息">
					   <img alt="修改" src="${ctx}\images\edit.png">
					</a>
			    </td>
			    <td>		   
				    <input type="button" class="${rol.roleState}"  onclick="switchState(${rol.roleId},${rol.roleState}, this)" value="${rol.roleStateString}" />
			    </td>
			    <td>
			    <a class="button" href="${ctx}/role/chooseright.do?roleId=${rol.roleId}" mask="true" target="dialog" rel="dlg_page8" title="为${rol.roleName}分配权限"><span>分配权限</span></a>
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
</div>
<script type="text/javascript">
function  switchState(roleid,rolestate, obj){
	  $.ajax({
		 async:false,
		 type :"post",
		 url  :"${ctx}/role/changeRoleState.do",
		 data :{"roleId":roleid ,"roleState":rolestate} ,
		 contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
		 success : function(json) {	
			 if(json.data[0]==1){
				 alert("不可停用使用中的角色");
				 return;
			 }
			//原来是启用的，变为停用，字体变灰色，按钮变为“启用”
			  if(rolestate==1){	
				  $(obj).parent().parent().attr("Style","color:#8E8E8E");
				  $(obj).parent().html("<input type='button' onclick='switchState("+roleid+",2, this)' value='启用'/>");				  
				  }
			//原来是停用的，变为启用，字体恢复默认，按钮变为“停用”
			  if(rolestate==2){	
				  $(obj).parent().parent().attr("Style","");
				  $(obj).parent().html("<input type='button' onclick='switchState("+roleid+",1, this)' value='停用'/>");
				  }
		 }
	  });
	 
}
function chooseright(roleid)
{
	alert("adv");
	$.ajax({
		async:false,
		type :"post",
		url  :"${ctx}/role/chooseright.do",
		data :{"roleId":roleid},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
		 success : function(json) {
				console.log(json);
				navTab.reload();	
				
		 }
	});
}
//停用的角色，所有信息（文字）显示为灰色
$(".2").parent().parent().attr("Style","color:#8E8E8E")
</script>
