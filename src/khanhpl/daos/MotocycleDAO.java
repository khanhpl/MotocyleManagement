/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhpl.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import khanhpl.dtos.MotocycleDTO;
import khanhpl.utils.MyConnection;

/**
 *
 * @author Admin
 */
public class MotocycleDAO {

    public Vector<MotocycleDTO> getMotocycleItems() throws ClassNotFoundException, SQLException {
        Vector<MotocycleDTO> motocycleData = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MyConnection.getConnection();
            String sql = "select motocycleID, model, year, condition, price, quantity, warranty, brandID from TblBike";
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            motocycleData = new Vector();
            while (rs.next()) {
                String motocycleID = rs.getString("motocycleID");
                String model = rs.getString("model");
                Date year = rs.getDate("year");
                String condition = rs.getString("condition");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String warranty = rs.getString("warranty");
                String brandID = rs.getString("brandID");
                MotocycleDTO motoDTO = new MotocycleDTO(motocycleID, model, year, condition, price, quantity, warranty, brandID);
                motocycleData.add(motoDTO);
            }
        } finally {
            if (rs != null) {
                pst.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return motocycleData;
    }

    public boolean motoSave(String motocycleID, String model, Date year, String condition, float price, int quantity, String warranty, String brandID) throws ClassNotFoundException, SQLException {
        boolean chkmotoSave = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MyConnection.getConnection();
            String sql = "insert into TblBike values(?,?,?,?,?,?,?,?)";
            pst = con.prepareCall(sql);
            pst.setString(1, motocycleID);
            pst.setString(2, model);
            pst.setDate(3, year);
            pst.setString(4, condition);
            pst.setFloat(5, price);
            pst.setInt(6, quantity);
            pst.setString(7, warranty);
            pst.setString(8, brandID);
            int result = pst.executeUpdate();
            if (result > 0) {
                chkmotoSave = true;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return chkmotoSave;
    }
    
    public boolean motoUpdate(String motocycleID, String model, Date year, String condition, float price, int quantity, String warranty, String brandID) throws ClassNotFoundException, SQLException {
        boolean chkmotoSave = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MyConnection.getConnection();
            String sql = "update TblBike set model=?, year=?, condition=?, price=?, "
                    + "quantity=?, warranty=?, brandID=? where motocycleID=? ";
            pst = con.prepareCall(sql);
            pst.setString(8, motocycleID);
            pst.setString(1, model);
            pst.setDate(2, year);
            pst.setString(3, condition);
            pst.setFloat(4, price);
            pst.setInt(5, quantity);
            pst.setString(6, warranty);
            pst.setString(7, brandID);
            int result = pst.executeUpdate();
            if (result > 0) {
                chkmotoSave = true;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return chkmotoSave;
    }
    
    public boolean deleteMoto(String motoID) throws ClassNotFoundException, SQLException{
        boolean chkDeleteMoto = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MyConnection.getConnection();
            String sql = "Delete from TblBike where motocycleID = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, motoID);
            int result = pst.executeUpdate();
            if (result > 0) {
                chkDeleteMoto = true;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            
            if (con != null) {
                con.close();
            }
        }
        return chkDeleteMoto;
    }
    
    public boolean checkCurMotoID(String motoID) throws ClassNotFoundException, SQLException{
        boolean chkCurMotoID = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MyConnection.getConnection();
            String sql = "Select model from TblBike where motocycleID=?";
            pst = con.prepareCall(sql);
            pst.setString(1, motoID);
            rs = pst.executeQuery();
            if (rs.next()) {
                chkCurMotoID = true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            
            if (pst != null) {
                pst.close();
                
            }
            if (con != null) {
                con.close();
            }
        }
        return chkCurMotoID;
    }
}
