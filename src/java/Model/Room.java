package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Room {

    String id, name, type, des, price;

    public Room() {
        connect();
    }

    public Room(String id, String name, String type, String des, String price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.des = des;
        this.price = price;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public ArrayList<Room> getListRoom() {
        ArrayList<Room> data = new ArrayList<>();
        try {
            String strSelect = "select * from Rooms";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);   // Luu bang select duoc vao rs
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                String des = rs.getString(4);
                String price = rs.getString(5);
                Room r = new Room(id, name, type, des, price);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }

        return data;
    }
}
