<%--
  Created by IntelliJ IDEA.
  User: gzmini
  Date: 2021/3/6
  Time: 8:20 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SearchList</title>
    <script type="text/javascript">
        function SearchCheck()
        {
            if (document.Search.searchkeyword.value=="")
            {
                alert("Search Content is Empty!");
                return false;
            }
            else
            {
                document.Search.action = "SearchWord";
                document.Search.submit();
            }
        }
    </script>
</head>
<body>
<table width="800" border="1" cellspacing="1" cellpadding="0">
    <tr>
        <td align="center">Word</td>
        <td align="center">Describe</td>
        <td align="center">Newtime</td>
        <td align="center">SearchCounts</td>
        <td align="center">Action</td>
    </tr>
    <c:forEach items="${searchlist}" var="data">
        <tr>
            <td align="center">
                    ${data.wordname}
            </td>
            <td>
                    ${data.worddescribe}
            </td>
            <td align="center">
                    ${data.newtime}
            </td>
            <td align="center">
                    ${data.searchnum}
            </td>
            <td align="center">
                <a href="EditWord?id=${data.id}">修改</a>
                <a href="DeleteWord?id=${data.id}" onclick='return confirm("Sure Delete?")'>删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form name="Search" method="POST" action="" onsubmit="return SearchCheck()">
    <input type="text" name="searchkeyword" />
    <input type="radio" name="language" value="E" checked="checked"/>英文
    <input type="radio" name="language" value="C" />注释
    <input type="button" value="Search" onclick="return SearchCheck()"/>
</form>
<br>
<a href=".">Return</a>
</body>
</html>
