/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.uliege.uce.smartgps.decode.main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author GMoncayo
 */
public class A {
    
    public static void main(String[] args) {
        
        String date1 = "Jan 22, 2019 5:52:29 PM";
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa");
        
        String date2 = "Feb 1, 2019 14:03:26";
        
        SimpleDateFormat formatter1 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
        
        
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        
        
        
        try {
            Date date = formatter.parse(date1);
            System.out.println(date);
            
            System.out.println(newFormat.format(date));
            
            date = formatter1.parse(date2);
            System.out.println(date);
            
            System.out.println(newFormat.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        
        Date f = new Date();
        
        
        
        Timestamp fecha;
        
        
    }
    
}
