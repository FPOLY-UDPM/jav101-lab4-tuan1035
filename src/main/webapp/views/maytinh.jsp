<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Máy tính cơ bản</title>
</head>
<body>
    <h2>Máy Tính Đơn Giản</h2>

    <form method="post" id="calcForm">
        Số a: <input type="text" name="a" required><br><br>
        Số b: <input type="text" name="b" required><br><br>

        <button type="submit" onclick="document.getElementById('calcForm').action='${pageContext.request.contextPath}/tinhadd'">Cộng</button>
        <button type="submit" onclick="document.getElementById('calcForm').action='${pageContext.request.contextPath}/tinhsub'">Trừ</button>
    </form>

    <br>
    <h3>Kết quả: ${message}</h3>
</body>
</html>