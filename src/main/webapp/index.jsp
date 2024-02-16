<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<center>
    <h2>TRANG CHỦ</h2>
    <button type="submit" ><a href="/book">Move To Book</a></button>
    <button type="submit" ><a href="/category">Move To Category</a></button>
    <button type="submit" ><a href="/bookcategory">Move To BookCategory</a></button>
</center>
<br>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Book_Name</th>
            <th>Author</th>
            <th>Category</th>
        </tr>
        <c:forEach items="${list}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.name}</td>
                <td>${b.author}</td>
                <td>
                    <c:forEach items="${b.categories}" var="c">
                        <span>${c.name}</span> &nbsp;
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
