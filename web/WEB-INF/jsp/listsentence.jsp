<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%--
  Created by IntelliJ IDEA.
  User: gzmini
  Date: 2021/3/5
  Time: 10:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListSentence</title>
</head>
<body>
<a href=".">Return</a><br/>
<table width="1200" border="1" cellspacing="1" cellpadding="0">
    <c:forEach items="${esl}" var="data">
        <tr>
            <td width="94%">
                    ${data.sentence}
            </td>
            <td align="center" width="6">
                <a href="EditSentence?id=${data.id}">修改</a>
                <a href="DeleteSentence?id=${data.id}" onclick='return confirm("Sure Delete?")'>删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/EnglishInfoSpring/listSentence?currentpageid=1">FirstPage</a>    <a href="/EnglishInfoSpring/listSentence?currentpageid=${cpi}-1">PrevPage</a>    <a href="/EnglishInfoSpring/listSentence?currentpageid=${cpi}">NextPage</a>    <a href="/EnglishInfoSpring/listSentence?currentpageid=2">LastPage</a><br/>
<a href=".">Return</a>
</body>
</html>
