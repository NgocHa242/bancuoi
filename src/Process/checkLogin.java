/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class checkLogin {
    public static Connection conn=null;
    public static PreparedStatement pst=null;
    public static ResultSet rs=null;
    public static String testConect()
    {
        try
        {
            conn=Connect.getConnect();
            return "Kết nối cơ sở dữ liệu thành công";
            
        }catch(Exception e)
        {
            return "Kết nối thất bại";
            
        }
    }
    public static ResultSet Login(String user,String password)
    {
        try
        {
        String sql="SELECT * FROM qlns.user where name=? and password=?";
        pst=conn.prepareStatement(sql);
        pst.setString(1, password);
        pst.setString(2, user);
        return rs=pst.executeQuery();
        }catch(Exception e)
        {
            return null;
        }
    }
    
}
