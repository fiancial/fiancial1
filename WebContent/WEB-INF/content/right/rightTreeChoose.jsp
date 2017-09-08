<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

		<div style=" float:left; display:block; margin:10px;   width:350px; height:240px; overflow:scroll; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			<ul>
				<li><ul class="tree treeFolder treeCheck expand" >${chooseRightTree1}</ul></li>
				<li><ul class="tree treeFolder treeCheck expand" >${chooseRightTree2}</ul></li>
				<li><ul class="tree treeFolder treeCheck expand" >${chooseRightTree3}</ul></li>
				<li><ul class="tree treeFolder treeCheck expand" >${chooseRightTree4}</ul></li>		
			</ul>
		</div>
	
		<div class="formBar">
			<ul>				
				<li><div class="buttonActive"><div class="buttonContent"><input type="button" value="提交" onclick="submit(${roleInfo.roleId})"/></div></div></li>				
			</ul>
		</div>

 <script type="text/javascript">
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
	function submit(id){
		if(!confirm("确定分配权限？")){
			return;
		}
		 var a = [];
		 for(var i=0;i<$("div[class='ckbox checked']").next().next().length;i++)
		 {
			a[i]= $("div[class='ckbox checked']").eq(i).next().next().attr("value");
		 }
		 if(a.length==0)
		 {
			 a[0]=0;
		 }		 
		 $.ajax({
				async:false,
				type : "post",
				url :   "${ctx}/role/changeRoleRight.do",
				data : {"roleIds":id,"rightId":a},
				cache : false,
				contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
				success : function(json) {						
					$.pdialog.closeCurrent();
				}
		   }); 		 
	}
</script>

