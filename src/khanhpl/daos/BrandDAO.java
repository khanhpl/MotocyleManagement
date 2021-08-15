/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhpl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import khanhpl.dtos.BrandDTO;
import khanhpl.utils.MyConnection;

/**
 *
 * @author Admin
 */
public class BrandDAO {

    public Vector<BrandDTO> getBrandItems() throws ClassNotFoundException, SQLException {
        Vector<BrandDTO> vctBrandItems = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MyConnection.getConnection();
            String sql = "select brandID, brandName, country, description from TblBrand";
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            vctBrandItems = new Vector<>();
            while (rs.next()) {
                String brandID = rs.getString("brandID");
                String brandName = rs.getString("brandName");
                String country = rs.getString("country");
                String description = rs.getString("description");
                BrandDTO brand = new BrandDTO(brandID, brandName, country, description);
                vctBrandItems.add(brand);
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return vctBrandItems;
    }

    public boolean saveBrand(String brandID, String brandName, String country, String desciption) throws ClassNotFoundException, SQLException {
        boolean chkSave = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MyConnection.getConnection();
            String sql = "insert into TblBrand values(?,?,?,?)";
            pst = con.prepareCall(sql);
            pst.setString(1, brandID);
            pst.setString(2, brandName);
            pst.setString(3, country);
            pst.setString(4, desciption);
            int result = pst.executeUpdate();
            if (result > 0) {
                chkSave = true;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return chkSave;
    }

    public boolean updateBrand(String brandID, String brandName, String country, String description) throws ClassNotFoundException, SQLException {
        boolean chkUpdateBrand = false;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = MyConnection.getConnection();
            String sql = "update TblBrand set brandName =?, country=?, description=? where brandID=?";
            pst = con.prepareCall(sql);
            pst.setString(1, brandName);
            pst.setString(2, country);
            pst.setString(3, description);
            pst.setString(4, brandID);
            int result = pst.executeUpdate();
            if (result > 0) {
                chkUpdateBrand = true;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return chkUpdateBrand;
    }

    public boolean checkCurBrandID(String brandID) throws ClassNotFoundException, SQLException {
        boolean chkCur = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MyConnection.getConnection();
            String sql = "Select brandName from TblBrand where brandID=?";
            pst = con.prepareCall(sql);
            pst.setString(1, brandID);
            rs = pst.executeQuery();
            if (rs.next()) {
                chkCur = true;
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return chkCur;
    }

    public boolean deleteBrand(String brandID) throws SQLException, ClassNotFoundException {
        boolean chkDeleteBrand = false;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MyConnection.getConnection();
            String sql = "Delete from TblBrand where brandID = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, brandID);
            int result = pst.executeUpdate();
            if (result > 0) {
                chkDeleteBrand = true;
            }
        } finally {
            if (pst != null) {
                pst.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return chkDeleteBrand;
    }

    public HashMap getCbxBrandData() throws ClassNotFoundException, SQLException {
        Map<String, Integer> hmBrand = null;
        int pos = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MyConnection.getConnection();
            String sql = "Select brandID from TblBrand";
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            hmBrand = new HashMap<>();
            while (rs.next()) {
                String brandID = rs.getString("brandID");
                hmBrand.put(brandID, pos);
                pos++;

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
        return (HashMap) hmBrand;
    }
}
