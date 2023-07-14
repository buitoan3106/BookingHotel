package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoomType {
    String tid, tname;

    public RoomType() {
        connect();
    }

    public RoomType(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
        connect();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public String getNameById(String ntype) {
        try {
            String strSelect = "select * from Room_type where type_id='" + ntype + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);   // Luu bang select duoc vao rs
            while (rs.next()) {
                tname = rs.getString(2);
                return tname;
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return "";
    }
    
}
