package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    String account, password, name, phone, id, address;

    public User() {
        connect();
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public User(String account, String password, String name, String phone, String id, String address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.address = address;
        connect();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    Connection cnn; // Ket noi DB
    Statement stm;  // Thuc thi cau lenh SQL
    PreparedStatement pstm;
    ResultSet rs; // luu tru va xu ly du lieu

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect Success");
            }
        } catch (Exception e) {
        }
    }

    public boolean checkDuplicateAccount() {
        try {
            String strSelect = "select * from Users where account='" + account + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);   // Luu bang select duoc vao rs
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return false;
    }

    public void add() {
        try {
            String strAdd = "Insert into Users values (?, ?, ?, ?, ?, ?)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, account);
            pstm.setString(2, password);
            pstm.setString(3, name);
            pstm.setString(4, phone);
            pstm.setString(5, id);
            pstm.setString(6, address);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }
    }

    public boolean checkUser() {
        try {
            String strSelect = "select * from Users where account=? and "
                    + "password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return false;
    }

    public User getInforByAccount(String account) {
        User u = new User();
        try {
            String strSelect = "select * from Users where account='" + account + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);   // Luu bang select duoc vao rs
            while (rs.next()) {
                account = rs.getString(1);
                password = rs.getString(2);
                name = rs.getString(3);
                phone = rs.getString(4);
                id = rs.getString(5);
                address = rs.getString(6);
                u = new User(account, password, name, phone, id, address);
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return u;
    }

    public void update() {
        try {
            String strUpdate = "Update Users "
                    + "set [phone number]=?, "
                    + "id=?, "
                    + "address=? "
                    + "where account=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, phone);
            pstm.setString(2, id);
            pstm.setString(3, address);
            pstm.setString(4, account);   
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }
}
