<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Minitest_3</title>
</head>
<body>
<center>
    <h2>Add New Book_Category</h2>
    <h3>
        <a href="bookcategory">Return Category List</a>
    </h3>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID_Book:</th>
                <td>
                    <input type="text" name="id_book" size="45"/>
                </td>
            </tr>
            <tr>
                <th>ID_Category:</th>
                <td>
                    <input type="text" name="id_category" size="45"/>
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
