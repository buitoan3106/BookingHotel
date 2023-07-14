<%-- 
    Document   : signUp
    Created on : Mar 6, 2023, 10:03:02 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/base.css" type='text/css'/>
        <link rel="stylesheet" href="./assets/css/style.css" type="text/css"/>
        <title>Sign Up</title>
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
                    <form action="register" method="post" class="form-items signUp" style="margin: 20px 30px">
                        <div class="header" style="margin-bottom: 20px">
                            <h2>Đăng ký</h2>
                        </div>
                        <div class="item">
                            <label for="acc">Tên đăng nhập: <br></label>
                            <input type="text" id="acc" name="acc" required>
                        </div>
                        <div class="item">
                            <label for="pass">Mật khẩu: <br></label>
                            <input type="password" id="pass" name="pass" required>
                        </div>
                        <div class="item">
                            <label for="repass">Nhập lại mật khẩu: <br></label>
                            <input type="password" id="repass" name="repass" required>
                        </div>
                        <div class="item">
                            <label for="name">Họ và tên: <br></label>
                            <input type="text" id="name" name="name" required>
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
                        <button class="btn" name="signUp">Đăng ký</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
