/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhpl.validation;

import java.sql.SQLException;
import khanhpl.daos.BrandDAO;

/**
 *
 * @author Admin
 */
public class BrandValidation {
    public boolean checkBrandID(String brandID) throws ClassNotFoundException, SQLException{
        boolean chkBrandID = false;
        BrandDAO brandDAO = new BrandDAO();
        boolean chkCur = brandDAO.checkCurBrandID(brandID);
        if ((brandID.length()>0) && (brandID.length()<=10) && (!chkCur)) {
            chkBrandID = true;
        }
        return chkBrandID;
    }
    
    public boolean chkBrandName (String brandName){
        boolean chkBrandName = false;
        if ((brandName.length()>0) && (brandName.length()<=50)) {
            chkBrandName = true;
        }
        return chkBrandName;
    }
    
    public boolean chkCountry (String country){
        boolean chkCountry = false;
        if ((country.length()>0) && (country.length()<=50)) {
            chkCountry = true;
        }
        return chkCountry;
    }
    
    public boolean chkDescription(String description){
        boolean chkDescription = false;
        if (description.length() <= 200) {
            chkDescription = true;
        }
        return chkDescription;
    }
    
}
