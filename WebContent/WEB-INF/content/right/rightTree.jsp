<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/dhead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<div class="panelBar"></div>
	<div
		style="float: left; display: block; margin: 10px; overflow: auto; width: 200px; height: 600px; border: solid 1px #CCC; line-height: 21px; background: #FFF;">
		<ul>
			<!--权限树-->
			<li>
				<ul class="tree treeFolder collapse">${strRigTree}</ul>
			</li>
			<li>
				<ul class="tree treeFolder collapse">${strRigTree2}</ul>
			</li>
			<li>
				<ul class="tree treeFolder collapse">${strRigTree3}</ul>
			</li>
			<li>
				<ul class="tree treeFolder collapse">${strRigTree4}</ul>
			</li>
		</ul>
	</div>
	<!--角色树-->
	<div
		style="float: left; display: block; margin: 10px; overflow: auto; width: 400px; height: 600px; border: solid 1px #CCC; line-height: 21px; background: #FFF;">
		<p style="display: none;" id="rightId" class="0">权限Id</p>
		<p id="text"></p>
		<ul class="tree treeFolder treeCheck expand">${roleTree}</ul>
		<input type="button" value="全选" onclick="checkAll()" /> <input
			type="button" value="反选" onclick="selectInvert()" /> <input
			type="button" value="提交" onclick="test()" />
	</div>
</body>
</html>
<script test="text/javascript">
	function findRole(rightId, obj) {
		$.ajax({
			async : false,
			type : "post",
			url : "${ctx}/right/belongToRole.do",
			data : {
				"rightId" : rightId
			},
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(json) {
				var a = '';
				for (var i = 0; i < json.data.length; i++) {
					if (i == 0) {
						a += '#';
						a += json.data[i].roleId;
					} else {
						a += ',#';
						a += json.data[i].roleId;
					}

				}
				//把已勾选的变为未勾选
				$("div[class='ckbox checked']")
						.attr("class", "ckbox unchecked");
				$("div[class='ckbox indeterminate']").attr("class",
						"ckbox unchecked");
				//将所有对应的角色勾选
				$(a).prev().prev().attr("class", "ckbox checked");
				//设置当前rightId
				$("#rightId").attr("class", rightId);
				//显示分配哪一个权限
				var text = "将 [ " + $(obj).html() + " ] 分配给以下选中的角色";
				$("#text").html(text);
			}
		});
	}

	function checkAll() {
		$("div[class='ckbox unchecked']").attr("class", "ckbox checked");
		$("div[class='ckbox indeterminate']").attr("class", "ckbox checked");
	}
	function selectInvert() {
		var checked = $("div[class='ckbox checked']");
		var unchecked = $("div[class='ckbox unchecked']");
		checked.attr("class", "ckbox unchecked");
		unchecked.attr("class", "ckbox checked");
	}

	function test() {
		var a = $("div[class='ckbox checked']").length;
		var b = $("div[class='ckbox indeterminate']").length;
		var roleId = [];
		var rightId = $("#rightId").attr("class");
		for (var i = 0; i < a + b; i++) {
			if (i < a) {
				roleId[i] = $("div[class='ckbox checked']").next().next().eq(i)
						.attr("id");
			} else {
				roleId[i] = $("div[class='ckbox indeterminate']").next().next()
						.eq(i - a).attr("id");
			}
		}
		console.log(roleId);
		if (rightId == "0") {
			alert("请选择权限");
		} else {
			if (!confirm("确认要更改权限分配吗？")) {
				return;
			}
			$
					.ajax({
						async : false,
						type : "post",
						url : "${ctx}/right/changeRoleRight.do",
						data : {
							"rightId" : rightId,
							"roleId" : roleId
						},
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						success : function(json) {
							alert("分配权限成功");
						}
					});
		}
	}
</script>
