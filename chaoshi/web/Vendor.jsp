<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/31
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.cn.model.emp"%>
<%@page import="java.util.List"%>
<%@ page import="com.cn.model.Vendor" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>供应商管理</title>
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
                <li><a href="emp.jsp" target="_self" >职工管理</a></li>
                <li><a href="member.jsp" target="_self">会员管理</a></li>
                <li><a href="Vendor.jsp" target="_self"style="color:#1375F7">供应商管理</a></li>
            </ul>
        </div>
        <div class="center_right">
            <!-- search搜索模块 -->
            <div class="search">
                <form action="Find_Ve_id" method="post">
                    <input type="search" name="ve_id" id="" placeholder="输入供应商编号">
                    <button>搜索</button>
                </form>
            </div>
            <div class="xinjian">
                <a onclick="showLayer('#layer')"><button>新建</button></a>
                <form id="layer" action="In_Ve" method="post">
                    <fieldset>
                        <legend>供应商信息表单</legend>
                        <p>
                            供应商编号：<input id="inp1" type=text name="ve_id" />
                        </p>
                        <p>
                            供应商名称：<input type=text name="ve_name" />
                        </p>
                        <p>
                            供应商电话：<input id="inp2" type=text name="ve_tel" />
                        </p>
                        <p>
                            供应商地址：<input type=text name="ve_address" />
                        </p>
                        <p>
                            <a onclick="hideLayer('#layer')"><button
                                    style="width: 50px; height: 28px; margin-left: 200px; margin-top: 0px"
                                    type=reset>关闭</button></a>
                            <button id="btn1" style="width: 50px; height: 28px; margin-left: 280px; margin-top: 0px"
                                    type=submit>新建</button>
                        </p>
                        <input id="msg1">
                    </fieldset>

                </form>
            </div>
            <div class="suoyou">
                <form action="Find_Ve_all" method="post">
                    <button>显示所有</button>
                </form>
            </div>
            <div class="content">
                <table border="1">
                    <tr>
                        <th>供应商编号</th>
                        <th>供应商名称</th>
                        <th>供应商电话</th>
                        <th>供应商地址</th>
                        <th>操作</th>
                        <th>操作</th>
                    </tr>
                    <%
                        List list = null;
                        list = (List) request.getAttribute("list");
                        if (list != null) {
                            for (int i = 0; i < list.size(); i++) {
                                Vendor vendor = new Vendor();
                                vendor = (Vendor) list.get(i);
                                int id = vendor.getVe_id();
                    %>
                    <tr>
                        <td>
                            <%
                                out.print(id);
                            %>
                        </td>
                        <td>
                            <%
                                out.print(vendor.getVe_name());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(vendor.getVe_tel());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(vendor.getVe_address());
                            %>
                        </td>
                        <td><a onclick="showLayer('#layer1')"><button
                                type='button' onclick='test(this)'
                                value=<%out.print(id);
out.print(",");
out.print(vendor.getVe_name());
out.print(",");
out.print(vendor.getVe_tel());
out.print(",");
out.print(vendor.getVe_address());%>
                                        style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;">编辑</button></a>
                            <form id="layer1" action="Update_Ve" class="bianji" method="post">
                                <fieldset>
                                    <legend>供应商信息表单</legend>
                                    <p>
                                        供应商编号：<input type="text"  name="new_ve_id" value="" id="new_ve_id" />
                                    </p>
                                    <p>
                                        供应商名称：<input type=text  name="new_ve_name" value="" id="new_ve_name" />
                                    </p>
                                    <p>
                                        供应商电话：<input type=text name="new_ve_tel"
                                                    value="" id="new_ve_tel" />
                                    </p>
                                    <p>
                                        供应商地址：<input type=text name="new_ve_address" value=""
                                                    id="new_ve_address" />
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
                            <form action="Del_Ve_id" method="post">
                                <button style="width: 45px; height: 28px; background-color: #1375F7; font-size: 13px; color: #fff;"
                                        type=submit value=<%out.print(id);%> name="ve_id">删除</button>
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
        var left = ($(window).width() - $(id).width()) / 2;//获得浏览器宽度
        var top = ($(window).height() - $(id).height()) / 2;

        $(id).css({
            "top" : top,//距离顶部的距离
            "left" : left,
            "display" : "block"//属性规定元素应该生成框的类型，块级元素，带有换行符
        });
    }
    function test(ha) {
        var str = ha.value.split(",");//字符串分割到数组中，分隔符是，
        $("#new_empid").attr("value", str[0]);//是空值
        $("#new_empname").attr("value", str[1]);
        $("#new_emptel").attr("value", str[2]);
        $("#new_emppos").attr("value", str[3]);
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
            msg1.value="供应商编号满足";
            m1=1;
        }
        else{
            m1=0;
            msg1.value="供应商编号不满足8位";
            btn1.disabled="disabled";
        }
        // console.log(inp1.value);
        // btn.disabled="disabled";
    }
    inp2.onblur=function(){
        if(inp2.value.length == 11){
            msg1.value="供应商电话满足";
            m2=1;
        }
        else{
            m2=0;
            msg1.value="供应商电话不满足11位";
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