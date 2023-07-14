<%-- 
    Document   : signUp
    Created on : Mar 6, 2023, 10:03:02 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/base.css" type='text/css'/>
        <link rel="stylesheet" href="./assets/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="./assets/font/fontawesome-free-6.3.0-web/css/all.min.css" type="text/css"/>
        <title>Booking Fail</title>
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
                    <div class="check">
                        <div class="check__icon">
                            <i class="fa-solid fa-circle-xmark" style="color: rgba(0, 0, 0, 0.3)"></i>
                        </div>
                        <div class="check__noti">
                            Đặt phòng thất bại <br>
                        </div>
                        <div>Lỗi: ${errors}</div>
                        <div>
                            <a href="home" style="text-decoration: none; color: white"><button class="check__btn btn">Trở về trang chủ</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>