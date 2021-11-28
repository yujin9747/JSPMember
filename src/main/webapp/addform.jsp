<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Member</title>
</head>
<body>

<h1>Add a Member</h1>
<form action="add_ok.jsp" method="post" enctype="multipart/form-data">
<table>
<tr><td>User ID :</td><td><input type="text" name="userid"/></td></tr>
<tr><td>User Name :</td><td><input type="text" name="username"/></td></tr>
<tr><td>Password :</td><td><input type="text" name="password"/></td></tr>
<tr><td>Email :</td><td><input type="text" name="email"/></td></tr>
<tr><td>Photo :</td><td><input type="file" name="photo"></td></tr>
<tr><td>Detail :</td><td><textarea cols="50" rows="5" name="detail"></textarea></td></tr>
<tr><td><a href="list.jsp">View All Members</a></td><td align="right"><input type="submit" value="Add a Member"/></td></tr>
</table>
</form>

</body>
</html>

