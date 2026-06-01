<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload File hình ảnh</title>
</head>
<body>

    <h2>Bài 4: Upload File Hình Ảnh</h2>

    <c:url value="/upload" var="url"/>
    <form action="${url}" method="post" enctype="multipart/form-data">
        Chọn ảnh: <input name="photo" type="file" accept="image/*"><br><br>
        <button type="submit">Upload</button>
    </form>

    <br>
    <p style="color: green; font-weight: bold;">${message}</p>

    <c:if test="${not empty imagePath}">
        <h3>Ảnh vừa upload:</h3>
        <img src="${pageContext.request.contextPath}${imagePath}" width="300" alt="Uploaded Image"/>
    </c:if>

</body>
</html>