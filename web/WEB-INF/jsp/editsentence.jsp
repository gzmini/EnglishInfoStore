<%--
  Created by IntelliJ IDEA.
  User: gzmini
  Date: 2021/3/6
  Time: 10:44 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditeSentence</title>
    <script type="text/javascript">
        function updatecheck(){
            if(confirm("Sure Update?")){
                document.updatesentence.action = "UpdateSentence";
                document.updatesentence.submit();
            }}
    </script>
</head>
<body>
<form name="updatesentence" method="POST" action="">
    <table border="1">
        <tr valign="middle" align="center">
            <td valign="middle" align="center">Sentence:<textarea name="sentence" cols="100" rows="10">${sentence}</textarea><input type="hidden" name="id" value="${id}"/></td>
            <td><input type="button" value="Update Sentence" onclick="return updatecheck()"/></td>
        </tr>
    </table>
</form>
<br>
<a href=".">Return</a>
</body>
</html>
