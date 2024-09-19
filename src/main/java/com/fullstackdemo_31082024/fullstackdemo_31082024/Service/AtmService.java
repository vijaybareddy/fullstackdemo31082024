package com.fullstackdemo_31082024.fullstackdemo_31082024.Service;

import com.fullstackdemo_31082024.fullstackdemo_31082024.expcetion.AtmCreationFailedException;
import com.fullstackdemo_31082024.fullstackdemo_31082024.expcetion.InvalidCreadentialsException;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Account;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Atm;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class AtmService {
    public String createAtm(Atm atm) throws Exception{
        String cardnumber=null;
        try{
            Connection connection=DBConnection.getConnection();
            Statement stmt=connection.createStatement();

            cardnumber=UUID.randomUUID().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // MySQL datetime format
            String formattedExpireDate = sdf.format(atm.getExpiry());

            String query="insert into bank.atm values("
                    + "'" + cardnumber + "'"+","
                    + "'" + atm.getCvv() + "'"+","
                    + "'" + atm.getPin() + "'"+","
                    + "'" +formattedExpireDate + "'"+","
                    + "'" + atm.getAccountNumber() + "'"
                    + ")";
            int status = stmt.executeUpdate(query);

            if (status==1) {
                System.out.println("Accout is created" + cardnumber);

            } else {
                //it will throw new exception
                throw new AtmCreationFailedException("Account Creation is failed " + atm.getPin());

            }
        } catch(Exception ex) {
            System.out.println("Exception Occured "+ex);
            throw ex;//rethrowing the existing exception using throws.
            // throw-> it will throw the exception and it will create new exception and it will rethrow the exception even checked or unchecked or custom exceptions
            //throws-> to handle the re-throw the Exception.
        }
        return cardnumber;

    }


    public boolean validateAtmLogin(String cardnumber, String pin) throws Exception {
        String query = "SELECT * FROM bank.atm WHERE cardnumber = ? AND pin = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, cardnumber);
            preparedStatement.setString(2, pin);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    System.out.println("logined successfully ");
                    return true;
                } else {
                    throw new InvalidCreadentialsException("Invalid card number or PIN.");
                }
            }
        } catch (Exception ex) {
            // Consider using a logging framework instead of System.out.println
            System.out.println("Exception occurred: " + ex);
            throw ex;
        }
}




}