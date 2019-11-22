package be.uliege.uce.smartgps.decode.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import be.uliege.uce.smartgps.decode.utilities.Constants;

public class ConectionDataBase {
	
   

    public Connection conectionMySQL() {
        Connection conn = null;

        try {
            Class.forName(Constants.driver);
            conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
        } catch (ClassNotFoundException | SQLException e) {
        	System.err.println(e.getMessage());
        	return null;
        }

        return conn;
    }

}
