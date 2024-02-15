<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Minitest_3</title>
</head>
<body>
<center>
    <h2>Add New Book</h2>
    <h3>
        <a href="book">Return Book List</a>
    </h3>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Book Name:</th>
                <td>
                    <input type="text" name="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Book Author:</th>
                <td>
                    <input type="text" name="author" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
