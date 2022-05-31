<%@page import="com.cn.model.member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>会员管理</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
</head>
<div class="w">
	<div class="header">
		<div class="header_left">超市管理系统</div>
		<div class="header_right">
			<a href="login.jsp" target="_self">退出</a>
		</div>
	</div>
	<div class="center">
		<div class="center_left">
			<ul>
				<li><a href="index.jsp" target="_self">商品管理</a></li>
				<li><a href="salelist.jsp" target="_self">清单管理</a></li>
				<!-- <li><a href="stock_list.jsp" target="_self">库存管理</a></li> -->
				<li><a href="emp.jsp" target="_self">职工管理</a></li>
				<li><a href="member.jsp" target="_self" style="color: #1375F7">会员管理</a></li>
				<li><a href="emp.jsp" target="_self">供应商管理</a></li>
			</ul>
		</div>
		<div class="center_right">
			<!-- search搜索模块 -->
			<div class="search">
				<form action="findmembyid" method="post">
					<input type="search" name="memid" id="memid" placeholder="输入会员编号">
					<button>搜索</button>
				</form>
			</div>
			<div class="xinjian">
				<a onclick="showLayer('#layer')"><button>新建</button></a>
				<form id="layer" action="insertmem" method="post">
					<fieldset>
						<legend>职工信息表单</legend>
						<p>
							会员编号：<input id="inp1" type=text name="memid" />
						</p>
						<p>
							会员姓名：<input type=text name="memname" />
						</p>
						<p>
							会员电话：<input id="inp2" type=text name="memtel" />
						</p>
						<p>
							会员充值：<input type=text name="memjifen" />
						</p>
						<p>
							<a onclick="hideLayer('#layer')"><button
									style="width: 50px; height: 28px; margin-left: 200px; margin-top: 0px"
									type=reset>关闭</button></a>
							<button id="btn1"
								style="width: 50px; height: 28px; margin-left: 280px; margin-top: 0px"
								type=submit>新建</button>
						</p>
						<input id="msg1">
					</fieldset>

				</form>
			</div>
			<div class="suoyou">
				<form action="findallmem" method="post">
					<button>显示所有</button>
				</form>
			</div>
			<div class="content">
				<table border="1">
					<tr>
						<th>会员编号</th>
						<th>会员姓名</th>
						<th>会员电话</th>
						<th>会员充值</th>
						<th>操作</th>
						<th>操作</th>
					</tr>
					<%
						List list = null;
					list = (List) request.getAttribute("list");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							member u = new member();
							u = (member) list.get(i);
							int id = u.getMemid();
					%>
					<tr>
						<td>
							<%
								out.print(id);
							%>
						</td>
						<td>
							<%
								out.print(u.getMemname());
							%>
						</td>
						<td>
							<%
								out.print(u.getMemtel());
							%>
						</td>
						<td>
							<%
								out.print(u.getMemjifen());
							%>
						</td>
						<td><a onclick="showLayer('#layer1')"><button
									type='button' onclick='test(this)'
									value=<%out.print(id);
out.print(",");
out.print(u.getMemname());
out.print(",");
out.print(u.getMemtel());
out.print(",");
out.print(u.getMemjifen());%>
									style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;">编辑</button></a>
							<form id="layer1" action="updatemem" class="bianji" method="post">
								<fieldset>
									<legend>职工信息表单</legend>
									<p>
										会员编号：<input type="text" readonly="readonly" name="new_memid"
											value="" id="new_memid" />
									</p>
									<p>
										会员姓名：<input type=text name="new_memname" value=""
											id="new_memname" />
									</p>
									<p>
										会员电话：<input type=text name="new_memtel" value=""
											id="new_memtel" />
									</p>
									<p>
										会员充值：<input type=text name="new_memjifen" value=""
											id="new_memjifen" />
									</p>
									<p>
										<a onclick="hideLayer('#layer1')"><button
												style="width: 50px; height: 28px; margin-left: 200px; margin-top: 0px"
												type=reset>关闭</button></a>
										<button
											style="width: 50px; height: 28px; margin-left: 280px; margin-top: 0px"
											type=submit>保存</button>
									</p>
								</fieldset>

							</form></td>
						<td>
							<form action="delmembyid" method="post">
								<button
									style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;"
									type=submit value=<%out.print(id);%> name="memid">删除</button>
							</form>
						</td>
					</tr>
					<%
						}
					}
					%>
					${error }
				</table>

			</div>
		</div>
	</div>
	<div class="footer">
		<p>Group5 版权所有：rg1801B Copyright © 2000-2020 XINHUANET.com All
			Rights Reserved.</p>
		<p>本站所使用的内容均为rg1801BGroup5原创，未经协议授权禁止下载使用。</p>

		<p>系统简介 | 公司官网 | 联系我们 | 我要链接 | 版权声明 | 法律顾问 | 广告服务 | 技术服务中心 |
			违法和不良信息举报电话：（010）63070940 京ICP证010042号</p>

		<p>京公网安备：11000002000015号 | 网上传播视听节目许可证(0103020) | 中国互联网视听节目服务自律公约
			| 可信网站认证</p>
	</div>



</div>
<!-- 引入jquery核心文件 -->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	//在此书写你的jquery代码
	function showLayer(id) {
		var left = ($(window).width() - $(id).width()) / 2;
		var top = ($(window).height() - $(id).height()) / 2;

		$(id).css({
			"top" : top,
			"left" : left,
			"display" : "block"
		});
	}
	function test(ha) {
		var str = ha.value.split(",");
		$("#new_memid").attr("value", str[0]);
		$("#new_memname").attr("value", str[1]);
		$("#new_memtel").attr("value", str[2]);
		$("#new_memjifen").attr("value", str[3]);
	}
	function hideLayer(id) {
		$(id).css({
			"display" : "none"
		});
	}
	
	//有效性判断
	var m1=0;
	var m2=0;
	var inp1=document.getElementById("inp1");
	var inp2=document.getElementById("inp2");
	var btn1=document.getElementById("btn1");
	var msg1=document.getElementById("msg1");
	btn1.disabled="disabled";
/* 	btn1.onclick=function(){
		// console.log(inp1.value.length);
		alert("登录成功"), ;
		// msg.value="1111";
	} */
	inp1.onblur=function(){
		console.log(inp1.value.length);
		if(inp1.value.length == 8){
			msg1.value="职工编号满足";
			m1=1;
		}
		else{
			m1=0;
			msg1.value="职工编号不满足8位";
			btn1.disabled="disabled";
		}
		// console.log(inp1.value);
		// btn.disabled="disabled";
	}
	inp2.onblur=function(){
		if(inp2.value.length == 11){
			msg1.value="职工电话满足";
			m2=1;
		}
		else{
			m2=0;
			msg1.value="职工电话不满足11位";
			btn1.disabled="disabled";
		}
		// console.log(inp1.value);
		// btn.disabled="disabled";
	}
	
	setInterval(()=>{
		if(m1 == 1 && m2 == 1){
			msg1.value="输入格式正确";
			btn1.disabled="";
		}
	},500);
</script>
</body>
</html>