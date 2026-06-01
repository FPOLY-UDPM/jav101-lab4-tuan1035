<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- ĐÂY LÀ DÒNG QUAN TRỌNG: Phải dùng URI java.sun.com dành cho Tomcat 9 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập FPoly</title>
</head>
<body>
    <h2>Trang Đăng Nhập</h2>

    <%-- c:url giúp tự động chèn Context Path của dự án vào hành động của form --%>
    <c:url value="/account/login" var="url"/>

    <form action="${url}" method="post">
        <label>Username: </label>
        <input name="username" type="text" required><br><br>

        <label>Password: </label>
        <input name="password" type="password" required><br><br>

        <button type="submit">Login</button>
    </form>

    <br>
    <%-- Hiển thị thông báo (Enter..., Login successfully hoặc Invalid...) từ Servlet truyền sang --%>
    <p style="color: blue; font-weight: bold;">${message}</p>
</body>
</html>