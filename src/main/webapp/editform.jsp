<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.crud.dao.MemberDAO, com.crud.bean.MemberVO"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	MemberDAO memberDAO = new MemberDAO();
	String id=request.getParameter("id");	
	MemberVO u=memberDAO.getOne(Integer.parseInt(id));
	request.setAttribute("vo", u) ;
%>

<h1>Edit Form</h1>
<form action="edit_ok.jsp" method="post" enctype = "multipart/form-data">
<table>
<tr><td>User ID :</td><td><input type="text" name="userid" value="${vo.getUserid()}"/></td></tr>
<tr><td>User name :</td><td><input type="text" name="username" value="${vo.getUsername()}" /></td></tr>
<tr><td>Email address :</td><td><input type = "text"  name="email" value="${vo.getEmail()}"/></td></tr>
<tr><td>Photo :</td><td><input type="file" name = "photo" value = "${vo.getPhoto()}">
					<c:if test ="${vo.getPhoto() ne ''}"><br/>
					<img src = "${pageContext.request.contextPath }/upload/${vo.getPhoto() }"></c:if></td></tr>
<tr><td>Introduce myself :</td><td><textarea cols="50" rows="5" name="detail">${vo.getDetail()}</textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Member"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>