<%@page import="com.cn.model.salelist"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>清单管理</title>
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
				<li><a href="salelist.jsp" target="_self" style="color: #1375F7">清单管理</a></li>
				<!-- <li><a href="stock_list.jsp" target="_self">库存管理</a></li> -->
				<li><a href="emp.jsp" target="_self">职工管理</a></li>
				<li><a href="member.jsp" target="_self">会员管理</a></li>
				<li><a href="emp.jsp" target="_self">供应商管理</a></li>
			</ul>
		</div>
		<div class="center_right">
			<!-- search搜索模块 -->
			<div class="search">
				<form action="findsalebyid" method="post">
					<input type="search" name="saleid" id="" placeholder="输入会员编号">
					<button>搜索</button>
				</form>
			</div>
			<div class="xinjian">
				<a onclick="showLayer('#layer')"><button>新建</button></a>
				<form id="layer" action="insertsale" method="post">
					<fieldset style="height: 200px">
						<legend>销售清单</legend>
						<p>
							会员编号：<input id="inp1" type=text name="saleid" />
						</p>
						<p>
							商品名称：<input type=text name="salename" />
						</p>
						<p>
							商品数量：<input type=text name="salenum" />
						</p>
						<p>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp总金额：<input type=text name="total" />
						</p>
						<p>
							创建日期：<input type=text name="date" />
						</p>
						<p>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp收银员：<input type=text
								name="funder" />
						</p>
						<p>
							<a onclick="hideLayer('#layer')"><button
									style="width: 50px; height: 28px; margin-left: 200px; margin-top: 0px"
									type=reset>关闭</button></a>
							<button id="btn1"
								style="width: 50px; height: 28px; margin-left: 280px; margin-top: 0px"
								type=submit>新建</button>
						</p>
						<input id="msg1" >
					</fieldset>
				</form>
			</div>
			<div class="suoyou">
				<form action="findallsale" method="post">
					<button>显示所有</button>
				</form>
			</div>
			<div class="content">
				<table border="1">
					<tr>
						<th>会员编号</th>
						<th>商品名称</th>
						<th>商品数量</th>
						<th>总金额</th>
						<th>创建日期</th>
						<th>收银员</th>
						<th>操作</th>
						<th>操作</th>
					</tr>
					<%
						List list = null;
					list = (List) request.getAttribute("list");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							salelist u = new salelist();
							u = (salelist) list.get(i);
							int id = u.getSaleid();
					%>
					<tr>
						<td>
							<%
								out.print(id);
							%>
						</td>
						<td>
							<%
								out.print(u.getSalename());
							%>
						</td>
						<td>
							<%
								out.print(u.getSalenum());
							%>
						</td>
						<td>
							<%
								out.print(u.getTotal());
							%>
						</td>
						<td>
							<%
								out.print(u.getDate());
							%>
						</td>
						<td>
							<%
								out.print(u.getFunder());
							%>
						</td>
						<td><a onclick="showLayer('#layer1')"><button
									type='button' onclick='test(this)'
									value=<%out.print(id);
out.print(",");
out.print(u.getSalename());
out.print(",");
out.print(u.getSalenum());
out.print(",");
out.print(u.getTotal());
out.print(",");
out.print(u.getDate());
out.print(",");
out.print(u.getFunder());%>
									style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;">编辑</button></a>
							<form id="layer1" action="updatesale" class="bianji" method="post">
								<fieldset style="height: 200px">
									<legend>销售清单</legend>
									<p>
										会员编号：<input type="text" readonly="readonly" name="new_saleid"
											value="" id="new_saleid" />
									</p>
									<p>
										商品名称：<input type=text name="new_salename" value="" id="new_salename" />
									</p>
									<p>
										商品数量：<input type=text name="new_salenum"
											value="" id="new_salenum" />
									</p>
									<p>
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp总金额：<input type=text name="new_total" value=""
											id="new_total" />
									</p>
									<p>
										创建日期：<input type=text name="new_date" value=""
											id="new_date" />
									</p>
									<p>
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp收银员：<input type=text
											name="new_funder" value="" id="new_funder" />
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
							<form action="delsalebyid" method="post">
								<button
									style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;"
									type=submit value=<%out.print(id);%> name="saleid">删除</button>
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
		$("#new_saleid").attr("value", str[0]);
		$("#new_salename").attr("value", str[1]);
		$("#new_salenum").attr("value", str[2]);
		$("#new_total").attr("value", str[3]);
		$("#new_date").attr("value", str[4]);
		$("#new_funder").attr("value", str[5]);

	}
	function hideLayer(id) {
		$(id).css({
			"display" : "none"
		});
	}
	
	
	var m1=0;
	var inp1=document.getElementById("inp1");
	var btn1=document.getElementById("btn1");
	var msg1=document.getElementById("msg1");
	btn1.disabled="disabled";
	inp1.onblur=function(){
		console.log(inp1.value.length);
		if(inp1.value.length == 8){
			msg1.value="会员编号满足";
			m1=1;
		}
		else{
			m1=0;
			msg1.value="会员编号不满足8位";
			btn1.disabled="disabled";
		}
	}
	setInterval(()=>{
		if(m1 == 1 ){
			msg1.value="输入格式正确";
			btn1.disabled="";
		}
	},500);
	
	
</script>
</body>
</html>