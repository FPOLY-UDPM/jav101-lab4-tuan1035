<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký Thành Viên</title>
</head>
<body>

    <h1>Đăng Ký</h1>

    <form action="${pageContext.request.contextPath}/dang-ky" method="post">
        Tên đăng nhập: <input type="text" name="username"><br><br>

        Mật khẩu: <input type="password" name="password"><br><br>

        Giới tính:
        <input type="radio" name="gender" value="true" checked> Nam
        <input type="radio" name="gender" value="false"> Nữ <br><br>

        <input type="checkbox" name="married" value="true"> Đã có gia đình?<br><br>

        Quốc tịch:
        <select name="nationality">
            <option value="VN">Việt Nam</option>
            <option value="US" selected>United States</option>
            <option value="JP">Nhật Bản</option>
        </select><br><br>

        Sở thích:
        <input type="checkbox" name="hobbies" value="Đọc sách"> Đọc sách
        <input type="checkbox" name="hobbies" value="Du lịch" checked> Du lịch
        <input type="checkbox" name="hobbies" value="Âm nhạc" checked> Âm nhạc
        <input type="checkbox" name="hobbies" value="Khác"> Khác <br><br>

        Ghi chú: <br>
        <textarea name="note" rows="5" cols="40">Đang tìm bạn gái</textarea><br><br>

        <hr>
        <button type="submit">Đăng ký</button>
    </form>

</body>
</html>