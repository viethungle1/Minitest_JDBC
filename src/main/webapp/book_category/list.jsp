<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Minitest_3</title>
</head>
<body>
<center>
    <h1>Category Manager</h1>
    <h2>
        <a href="/bookcategory?action=create">Add New Category</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID_Book</th>
            <th>ID_Category</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td><c:out value="${list.id_book}"/></td>
                <td><c:out value="${list.id_category}"/></td>
                <td>
                    <a href="/bookcategory?action=delete&id=${list.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <button type="submit" ><a href="/">Back</a></button>
            </td>
        </tr>
    </table>
</div>
</body>
</html>