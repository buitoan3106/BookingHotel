<%-- 
    Document   : signUp
    Created on : Mar 6, 2023, 10:03:02 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Room"%>
<%@page import="Model.Reservation"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/base.css" type='text/css'/>
        <link rel="stylesheet" href="./assets/css/style.css" type="text/css"/>
        <title>Update Information</title>
    </head>
    <body>
        <div class="home">
            <header class="header">
                <nav class='navbar'>
                    <h1 class='navbar__tittle'>Booking.com</h1>
                    <h1 class='navbar__label'>landbCorporation</h1>
                </nav>
            </header>

            <div class='main'>
                <div class='main__welcome'>
                    <h2 class="signature">BĐT</h2>
                    <div>
                        <h2>Welcome<br></h2>
                        <h2>to DB Hotel</h2>
                        <p>Rất hân hạn được phục vụ các bạn !!</p>
                    </div>
                </div>
                <div class='main__login'>
                    <form action="updateUser" method="post" class="form-items signUp" style="margin: 30px 30px">
                        <div class="header">
                            <h2>Chỉnh sửa thông tin</h2>
                        </div>
                        <div class="item">
                            <label for="acc">Tên đăng nhập: <br></label>
                            <input type="text" id="acc" name="acc" value="${acc}" required readonly>
                        </div>
                        <div class="item" style="margin-bottom: 35px">
                            <h4>Thông tin cần chỉnh sửa</h4>
                        </div>
                        <div class="item">
                            <label for="num">Số điện thoại: <br></label>
                            <input type="text" id="num" name="num" required>
                        </div>
                        <div class="item">
                            <label for="id">Số CCCD: <br></label>
                            <input type="text" id="id" name="id" required>
                        </div>
                        <div class="item">
                            <label for="add">Địa chỉ: <br></label>
                            <input type="text" id="add" name="add" required>
                        </div>
                        <button class="btn" name="update">Cập Nhật</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
