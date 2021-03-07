<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>EnglishInfoStoreApp</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->

</head>

<body>

<form method="POST" action="NewWord">
<table border="1">
  <tr valign="middle" align="center">
    <td>
      WordName：<input type="text" name="wordname" />
    </td>
    <td valign="middle" align="center">
      WordDescribe:<textarea name="worddescribe" cols="40" rows="10"></textarea>
    </td>
    <td>
      <input type="submit" value="New Word"/>
    </td>
  </tr>
</table>
</form>

<form method="POST" action="SearchWord">
  <input type="text" name="searchkeyword" />
  <input type="radio" name="language" value="E" checked="checked"/>英文
  <input type="radio" name="language" value="C" />注释
<input type="submit" value="Search"/>
</form>

<form method="POST" action="NewSentence">
<table border="1">
  <tr valign="middle" align="center">
    <td valign="middle" align="center">Sentence:<textarea name="sentence" cols="83" rows="10"></textarea></td>
    <td><input type="submit" value="New Sentence"/><br/><a href="ListSentence">句子列表</a></td>
  </tr>
</table>
</form>
</body>
</html>
