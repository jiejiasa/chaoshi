<%@page import="com.cn.model.stock_list"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>库存管理</title>
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
				<!-- <li><a href="stock_list.jsp" target="_self"
					style="color: #1375F7">库存管理</a></li> -->
				<li><a href="emp.jsp" target="_self">职工管理</a></li>
				<li><a href="member.jsp" target="_self">会员管理</a></li>
			</ul>
		</div>
		<div class="center_right">
			<!-- search搜索模块 -->
			<div class="search">
				<form action="findslbyid" method="post">
					<input type="search" name="sl_id" id="" placeholder="输入库存单编号">
					<button>搜索</button>
				</form>
			</div>
			<div class="xinjian">
				<a onclick="showLayer('#layer')"><button>新建</button></a>
				<form id="layer" action="insertsl" method="post">
					<fieldset>
						<legend>库存信息表单</legend>
						<p>
							库存单编号：<input id="inp1" type=text name="sl_id" />
						</p>
						<p>
							库存单名称：<input type=text name="sl_name" />
						</p>
						<p>
							&nbsp&nbsp&nbsp商品数量：<input type=text name="goods_number" />
						</p>
						<p>
							&nbsp&nbsp&nbsp商品进价：<input type=text name="goods_price" />
						</p>
						<p>
							供应商名称：<input type=text name="supplier_name" />
						</p>
						<!-- <p>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp入库人：<input type=text
								name="ruku_name" />
						</p> -->
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
				<form action="findallsl" method="post">
					<button>显示所有</button>
				</form>
			</div>
			<div class="content">
				<table border="1">
					<tr>
						<th>库存单编号</th>
						<th>库存单名称</th>
						<th>商品数量</th>
						<th>商品进价</th>
						<th>供应商名称</th>
						<!-- <th>入库人</th> -->
						<th>操作</th>
						<th>操作</th>
					</tr>
					<%
						List list = null;
					list = (List) request.getAttribute("list");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							stock_list u = new stock_list();
							u = (stock_list) list.get(i);
							int id = u.getSl_id();
					%>
					<tr>
						<td>
							<%
								out.print(id);
							%>
						</td>
						<td>
							<%
								out.print(u.getSl_name());
							%>
						</td>
						<td>
							<%
								out.print(u.getGoods_number());
							%>
						</td>
						<td>
							<%
								out.print(u.getGoods_price());
							%>
						</td>
						<td>
							<%
								out.print(u.getSupplier_name());
							%>
						</td>
						<%-- <td>
							<%
								out.print(u.getRuku_name());
							%>
						</td> --%>
						<td><a onclick="showLayer('#layer1')"><button
									type='button' onclick='test(this)'
									value=<%out.print(id);
out.print(",");
out.print(u.getSl_name());
out.print(",");
out.print(u.getGoods_number());
out.print(",");
out.print(u.getGoods_price());
out.print(",");
out.print(u.getSupplier_name());
%>
									style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;">编辑</button></a>
							<form id="layer1" action="updatesl" class="bianji" method="post">
								<fieldset>
									<legend>库存信息表单</legend>
									<p>
										库存单编号：<input type="text" readonly="readonly"  name="new_id" value="" id="new_id" />
									</p>
									<p>
										库存单名称：<input type=text name="new_name" value="" id="new_name" />
									</p>
									<p>
										&nbsp&nbsp&nbsp商品数量：<input type=text name="new_number"
											value="" id="new_number" />
									</p>
									<p>
										&nbsp&nbsp&nbsp商品进价：<input type=text name="new_price" value=""
											id="new_price" />
									</p>
									<p>
										供应商名称：<input type=text name="new_sname" value=""
											id="new_sname" />
									</p>
									<!-- <p>
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp入库人：<input type=text
											name="new_ruku" value="" id="new_ruku" />
									</p> -->
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
							<form action="delslbyid" method="post">
								<button
									style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;"
									type=submit value=<%out.print(id);%> name="sl_id">删除</button>
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
		$("#new_id").attr("value", str[0]);
		$("#new_name").attr("value", str[1]);
		$("#new_number").attr("value", str[2]);
		$("#new_price").attr("value", str[3]);
		$("#new_sname").attr("value", str[4]);
	/* 	$("#new_ruku").attr("value", str[5]); */

	}
	function hideLayer(id) {
		$(id).css({
			"display" : "none"
		});
	}
	
	var m1=0;
	var m2=0;
	var inp1=document.getElementById("inp1");
	var btn1=document.getElementById("btn1");
	var msg1=document.getElementById("msg1");
	btn1.disabled="disabled";
	inp1.onblur=function(){
		console.log(inp1.value.length);
		if(inp1.value.length == 8){
			msg1.value="账号满足";
			m1=1;
		}
		else{
			m1=0;
			msg1.value="库存单编号不满足8位";
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