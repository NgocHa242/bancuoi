/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.Connect;
import static Main.QLNS_NhanVien1.conn;
import static Main.QLNS_NhanVien1.idPhongban;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class UpdateCombobox {
    public static Connection conn=Connect.getConnect();
    public static ResultSet rs= null;
    public static PreparedStatement pst = null;
  
    public static void LoadDataComBoBox(String sql,JComboBox combobox, String bien)
    {
        try
        {
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) // nếu combox có dữ liệu
            {
                combobox.addItem(rs.getString(bien));
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Không có nội dung ","Thông báo",1);
        }
        
    }
    public static void getIDDataCBB(String sql, JComboBox cbb, String id, String bien)
    {
      try
       {
           PreparedStatement pst= conn.prepareStatement(sql);
           pst.setString(1 , (String)cbb.getSelectedItem());
           ResultSet rs = pst.executeQuery();
           while(rs.next())
           {
               //co tu ten roi thy bay gio minh se luu tam duoc cai id cua no ra de sau nay minh lay so sanh voi id 
               bien =rs.getString(id);
               
           } 
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "Thông báo lỗi ");
       }
        
    }
    
}
