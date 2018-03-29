/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author MyPC
 */
public class QuanLyNhanSu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
         SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse("20110210");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        System.out.println(sql);
        String date="11/11/1995";
        String b = null;
        int sz=date.length();
        if(date.indexOf("/")>0)
            b=date.replaceAll("/", "-");
        System.out.println(b);
            
            
        String date2="11-11-1995";
        String d=date.replaceAll("/", "-");
        System.out.println(d);
      
        String sFinal="";
        String[] s = date.split("/");
        int size=s.length;
       for(int i=size-1;i>=0;i--)
           sFinal+=s[i];
           
        System.out.println(sFinal);
        
  
        
   
    }
 
}
