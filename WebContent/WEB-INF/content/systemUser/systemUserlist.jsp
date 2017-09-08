<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp" %>
<div id="jbsxBoxsystemUser" class="unitBox">
<div class="pageHeader">
	<form rel="pagerForm" id="pagerForm" onsubmit="return divSearch(this,'jbsxBoxsystemUser');" action="${ctx}/systemUser/systemUserlist.do" method="post">
	<input type="hidden" name="pageNum" value="1" /> 
		<div class="searchBar">
				<ul>
					<li>
						<span>用户姓名</span>
						<input type="text" name="userName"  style="width:120px;margin-left: 20px;">
							
						<input type="submit" value="查询"  style="width:100px;margin-left: 100px;margin-top: 10 ">
					</li>
				</ul>			
	</div>
	<div class="pageHeader">
	<ul >
		<li>

			<a class="edit" id="che" href=""  target="dialog" external="false" rel="systemUserlist"  title="查看">
			<input type="button" value="查看" style="height:25px; width:150px;" ></a>
		  
		</li>
	</ul>
  </div> 	
	
	</form>
	
	<div class="panelBar">
		<ul class="toolBar">
			<li class=""><a class="add" href="${ctx}/systemUser/toAddSystemPage.do" target="dialog" mask="true" title="新增系统用户"><span>添加</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
</div><!--  -->

<div class="pageContent" style="margin-top: 10px">    
	
	<%-- <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${ctx}/core/userManager.initCreateUser.do"  width="650" height="300" target="dialog" mask="true" title="新增内部用户" ><span>添加</span></a></li>
		</ul>
	</div> --%>

	<div id="w_list_print">
	<table class="form" width="100%" targetType="navTab">
		<thead>
			<tr>
				<th></th>
				<th>ID</th>
				<th>电话</th>
				<th>用户姓名</th>
				<th>备注</th>
				<th>渠道</th>
				<th>用户类型</th>
				<th>状态</th>
				<th>创建人</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${systemUser }" var="systemUser">
			  <tr>
			  <td><input name="id" id="check" type="radio" onclick="SystemUser();" value="${systemUser.id }"></td>
			  	<td>${systemUser.id }</td>
			  	 <td> ${systemUser.telePhone }</td>
			  	   <td>${systemUser.userName }</td>
			  	    <td>${systemUser.remark }</td>
			  	     <td>${systemUser.channel }</td>
			  	      <td>${systemUser.userType }</td>
					  	   <td>
						  	  	<c:choose>
						  	    <c:when test="${systemUser.isavail == 1}">
						  	    	启用
						  	    </c:when>
						  	    <c:when test="${systemUser.isavail == 0}">
						  	    	停用
						  	    </c:when>
						  	 	 </c:choose>
					  	  </td>
			  	    		<td>${systemUser.createdby }</td>
			  	    <td>
			  	    	<a class="common-img"
			  	    		href="${ctx}/systemUser/toUpdSystemUserPage.do?id=${systemUser.id }&pageNum=${pageBean.currentPage}"
			  	    		target="dialog" mask="true" title="修改${systemUser.id }信息">
					   		<img alt="修改" src="${ctx}\images\edit.png">
			  	    	</a>
			  	    </td>
			  	    <td><a onclick="delSystemUser('${systemUser.id }')" class="f1"> <img alt="删除" src="${ctx}\images\rong.png"></a></td>
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
<script type="text/javascript">

  function delSystemUser(id){
  	  alert(id);
	  if(!confirm("确认删除系统用户吗")){
		  return ;
	  }
		  $.ajax({
		  async:false,
		  type : "get",
		  url  : "${ctx}/systemUser/delSystemUser.do",
		  data : {"id":id},
		  cache: false,
		  contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		  success : function(json){
			  navTab.reload();
		  }
	  });
  }
  
/* function xz(){
		  var ids = "";
	  $("#dxbox input[type=checkbox]").each(function(){
		  if(this.checked){
			  ids = ids+","+$(this).val();
		  }
		});
	  if(ids == ""){
		  alert("请选择一条数据");
		  return;
	  }else if(ids.lastIndexOf(",") > 0){
		  alert("只能查看一条数据");
		  return;
	  }
	  ids = ids.substring(1, ids.length);
	  $("#look").attr("href",$("#look").attr("href")+"?scScoreCardNo="+ids); 
	  $("#book").attr("href",$("#book").attr("href")+"?scScoreCardNo="+ids);
	  	 alert('blacklistId')
		  document.getElementById('d').value(); 
  } */
//判断单选框是否选中
function SystemUser(){

    var id = $("input[type='radio']:checked").val();
    var url = "${ctx}/systemUser/toCheckSystemUser.do?id="+id;
    $("#che").attr("href",url);
    if(id==null){
    	return true;
    }
}

	 
</script>

