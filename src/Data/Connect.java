/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Connect {
    public static Connection getConnect()
    {
        try
        {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qlns","root","kemkho97");
            return conn;
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Kết nối cơ sở dữ liệu thất bại","Thông báo",1);
            return null;
            
        }
    }
    
}
