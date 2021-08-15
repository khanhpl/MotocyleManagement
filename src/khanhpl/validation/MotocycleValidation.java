/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhpl.validation;

import java.sql.Date;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import khanhpl.daos.MotocycleDAO;

/**
 *
 * @author Admin
 */
public class MotocycleValidation {

    public boolean checkMotoID(String motoID) throws ClassNotFoundException, SQLException {
        boolean chkMotoID = false;
        MotocycleDAO motoDAO = new MotocycleDAO();

        boolean chkCurMotoID = motoDAO.checkCurMotoID(motoID);

        if ((!chkCurMotoID) && (motoID.length()>0) && (motoID.length()<=10)) {
            chkMotoID = true;
        }
        return chkMotoID;
    }

    public boolean checkModel(String model) {
        boolean chkModel = false;
        if ((model.length() > 0) && (model.length() <= 50)) {
            chkModel = true;
        }
        return chkModel;
    }

    public boolean checkYear(String yearStr) {
        boolean chkYear = false;
        if (yearStr.length() <= 0) {
            chkYear = false;
        } else {
            try {
                Date year = Date.valueOf(yearStr);
                chkYear = true;
            } catch (IllegalArgumentException e) {
                chkYear = false;
            } 
        }
        return chkYear;
    }

    public boolean checkCondition(String condition) {
        boolean chkCondition = false;
        if ((condition.length() > 0) && (condition.length() <= 50)) {
            chkCondition = true;
        }
        return chkCondition;
    }

    public boolean checkPrice(String priceStr) {
        boolean chkPrice = false;
        if (priceStr.length() <= 0) {
            chkPrice = false;
        } else {
            try {
                Float price = Float.parseFloat(priceStr);
                chkPrice = true;
            } catch (NumberFormatException e) {
                chkPrice = false;
            }
        }
        return chkPrice;
    }

    public boolean checkQuantity(String quantityStr) {
        boolean chkQuantity = false;
        if (quantityStr.length() <= 0) {
            chkQuantity = false;
        } else {
            try {
                int quantity = Integer.parseInt(quantityStr);
                chkQuantity = true;
            } catch (NumberFormatException e) {
                chkQuantity = false;
            }
        }
        return chkQuantity;
    }

    public boolean checkWarranty(String warranty) {
        boolean chkWarranty = false;
        if ((warranty.length() >= 0) && (warranty.length() <= 50)) {
            chkWarranty = true;
        }
        return chkWarranty;
    }

    public boolean checkBrandName(int brandPos) {
        boolean chkBrandName = false;
        if (brandPos >= 0) {
            chkBrandName = true;
        }
        return chkBrandName;
    }
}
