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
import khanhpl.utils.MyConnection;

/**
 *
 * @author Admin
 */
public class UserDAO {
    public static boolean checkLogin(String userID, String password) throws ClassNotFoundException, SQLException {
        boolean ckLogin = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            con = MyConnection.getConnection();
            String sql = "select fullName from TblUser where userID=? and password=?";
            pst = con.prepareCall(sql);
            pst.setString(1, userID);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
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

        return ckLogin;
    }
}
