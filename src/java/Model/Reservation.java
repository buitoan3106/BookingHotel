package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Reservation {

    String id, gid, rid, checkIn, checkOut, tprice;

    public Reservation() {
        connect();
    }

    public Reservation(String gid, String rid, String checkIn, String checkOut) {
        this.gid = gid;
        this.rid = rid;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        connect();
    }

    public Reservation(String id, String gid, String rid, String checkIn, String checkOut, String tprice) {
        this.id = id;
        this.gid = gid;
        this.rid = rid;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.tprice = tprice;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getTprice() {
        return tprice;
    }

    public void setTprice(String tprice) {
        this.tprice = tprice;
    }
    Connection cnn; // Ket noi DB
    Statement stm;  // Thuc thi cau lenh SQL
    PreparedStatement pstm;
    ResultSet rs, rs2; // luu tru va xu ly du lieu

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect Success");
            }
        } catch (Exception e) {
        }
    }

    public void add() {
        try {
            String strAdd = "insert into Reservations(guest_id, room_id, [start_date], [end_date], total_price) "
                    + "values (?, ?, ?, ?, (select datediff(day, '" + checkIn + "', '" + checkOut + "'))*(select price from Rooms where room_id=" + rid + "))";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, gid);
            pstm.setString(2, rid);
            pstm.setDate(3, Date.valueOf(checkIn));
            pstm.setDate(4, Date.valueOf(checkOut));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }
    }

    public boolean checkRoomEmpty(String checkIn, String checkOut, String rid) {
        try {
            String strSelect = "select start_date, end_date from Reservations where room_id='" + rid + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);   // Luu bang select duoc vao rs
            while (rs.next()) {
                String start_date = String.valueOf(rs.getDate(1));
                String end_date = String.valueOf(rs.getDate(2));
                if (checkIn.compareTo(start_date) >= 0 && checkIn.compareTo(end_date) <= 0) {
                    return false;
                }
                if (checkOut.compareTo(start_date) >= 0 && checkIn.compareTo(end_date) <= 0) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("checkRoomEmpty: " + e.getMessage());
        }
        return true;
    }

    public ArrayList<Reservation> getListBookingByAccount(String account) {
        ArrayList<Reservation> data = new ArrayList<>();
        try {
            String strSelect = "select * from Reservations where guest_id='" + account + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);   // Luu bang select duoc vao rs
            while (rs.next()) {
                String rid = String.valueOf(rs.getInt(3));
                String checkIn = String.valueOf(rs.getDate(4));
                String checkOut = String.valueOf(rs.getDate(5));
                String price = String.valueOf(rs.getInt(6));

                Reservation r = new Reservation("", account, rid, checkIn, checkOut, price);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListReservations: " + e.getMessage());
        }

        return data;
    }

    public void remove(String rid, String checkIn) {
        try {
            String strDelete = "Delete from Reservations where room_id='" + rid + "' and start_date='" + checkIn + "'";
            pstm = cnn.prepareStatement(strDelete);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("DeleteReservation: " + e.getMessage());
        }
    }

    public ArrayList<Room> findRoomEmpty(String type, String checkIn, String checkOut) {
        ArrayList<Room> roomData = new ArrayList<>();
        try {
            String strSelect = "select * from Rooms where type=" + type;
            if (type.equals("4")) {
                strSelect = "select * from Rooms";
            }
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs2 = stm.executeQuery(strSelect);   // Luu bang select duoc vao rs2 để phân biệt với rs sau khi dùng hàm checkRoomEmpty
            while (rs2.next()) {
                String rid = String.valueOf(rs2.getInt(1));
                String rtype = String.valueOf(rs2.getInt(3));
                String des = rs2.getString(4);
                String price = String.valueOf(rs2.getInt(5));
                if (checkRoomEmpty(checkIn, checkOut, rid)) {
                    Room r = new Room(rid, "", rtype, des, price);
                    roomData.add(r);
                }
            }
        } catch (Exception e) {
            System.out.println("getListReservations: " + e.getMessage());
        }

        return roomData;
    }

    public ArrayList<Reservation> getListReservation() {
        ArrayList<Reservation> data = new ArrayList<>();
        try {
            String strSelect = "select * from Reservations";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String rsId = String.valueOf(rs.getInt(1));
                String gid = rs.getString(2);
                String rid = String.valueOf(rs.getInt(3));
                String checkIn = String.valueOf(rs.getDate(4));
                String checkOut = String.valueOf(rs.getDate(5));
                String tprice = String.valueOf(rs.getInt(6));
                Reservation rs = new Reservation(rsId, gid, rid, checkIn, checkOut, tprice);
                data.add(rs);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());
        }

        return data;
    }
}
