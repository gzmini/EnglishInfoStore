<%--
  Created by IntelliJ IDEA.
  User: gzmini
  Date: 2021/3/6
  Time: 10:19 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditWord</title>
    <script type="text/javascript">
        function updatecheck(){
            if(confirm("Sure Update?")){
                document.updateword.action = "UpdateWord";
                document.updateword.submit();
            }}
    </script>
</head>
<body>
<form name="updateword" method="POST"  action="">
    <table border="1">
        <tr valign="middle" align="center">
            <td>WordName：${wordname}<input type="hidden" name="id" value="${id}"/></td>
            <td valign="middle" align="center">WordDescribe:<textarea name="worddescribe" cols="40" rows="10">${worddescribe}</textarea></td>
            <td><input type="button" name="updatesubmit" value="Update Word" onclick="return updatecheck()"/></td>
        </tr>
    </table>
</form>
<br>
<a href=".">Return</a>
</body>
</html>
