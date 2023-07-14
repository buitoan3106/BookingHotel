<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="./assets/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/base.css" type='text/css'/>

        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                    <form action="login" method="post" class="form-items">
                        <div class="header">
                            <h2>Đăng nhập</h2>
                        </div>
                        <div class="item">
                            <label for="acc">Tên đăng nhập: <br></label>
                            <input type="text" id="acc" name="acc" required>
                        </div>
                        <div class="item">
                            <label for="pass">Mật khẩu: <br></label>
                            <input type="password" id="pass" name="pass">
                        </div>
                        <button class="btn" name="login">Đăng nhập</button>
                        <div class="register">Chưa có tài khoản? <a href="signUp.jsp">Đăng ký</a></div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
