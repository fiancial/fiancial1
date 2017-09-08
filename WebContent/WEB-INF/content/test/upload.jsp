<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
#upload_img img{
	width: 200px;
	height: 200px;
}
</style>
</head>
<body> 
 
	<form  id="uploadForm" action="${ctx}/upload/uploadimg.do" method="POST" enctype="multipart/form-data">
		<p>File: <input type="file" name="file"  /></p>
		<br>
		<br>
		<p>Desc: <input type="text" name="desc"  /></p>
		<br>
		<br>
		<p>name: <input type="text" name="name"  /></p>	
		<br>
		<br>
		<br>
		<p>select: <select name="select">
			<option value="a">A</option>
			<option value="b">B</option>
		</select></p>	
		<br>
		
	    <p><a href="${ctx}/upload/export.do">下载</a></p> 
	    <br>
		<!-- <input type="submit" value="Submit"/> -->
	    <input type="button" value="Submit"  onclick="ajaxpost();"/>  
	</form>
	<div  id="upload_img"></div>
	
	<script type="text/javascript" defer="defer">
	function ajaxpost(){
		  //$("#uploadForm")[0]这里用jquery封装后十个数组对象，是以加上下标取出form的数据
		  var formData=new FormData($("#uploadForm")[0]);
		 
		 // getformJson($("#uploadForm").serializeArray());
		  $.ajax({
			  url: '/ssm/upload/uploadimg.do' ,  
	        type: 'POST',  
	        data: formData,  
	        async: false,  
	        cache: false,  
	        contentType: false,  
	        processData: false,  
	        success:function(returndata){
	      	  alert(returndata.url);
	      	  //回显
	      	  $("#upload_img").html("<img src="+returndata.url+">");
	        },
	        error:function(returndata){
	        	 alert(returndata);
	      	  alert("error");
	        }
	        
		  });
		  
	}
	 
 function getformJson(data){
		
		
		var values = {};
	    for (var item in data) {
	        values[data[item].name] = data[item].value;
	    }
	    return JSON.stringify(values); 
//		  var arr=[],arrI="{"; 
//		  for(var i in data){
//			  arrI+=data[i].name;
//			  arrI+=":'";
//			  arrI+=data[i].value;
//			  arrI+="'";
//			  if(i==data.length-1){
//				  break;
//			  }
//			  arrI+=",";
//		  }
//		  arrI+="}";
		  
	}
	</script>
</body>
</html>