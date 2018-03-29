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
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class UpdateTable {
    public static PreparedStatement pst=null; // biến thực thi csdl
    public static ResultSet rs =null;// kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    public static Connection conn=Connect.getConnect();// lấy từ lớp cơ bản kết nối data
    
    // hàm nạp dữ liệu cho bảng 
    public static void LoadData(String sql, JTable tb)
    {
        try
        {
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
            // ngya cho này là đã nạp dữ liệu dạng bảng mà mình truyền vào
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e, "Thông báo lỗi",1);
        }
    }
    // hàm đổ dữ liệu từ bảng ra textfield
    public static ResultSet ShowData(String sql)
    {
        try
        {
            pst=conn.prepareStatement(sql);
            return pst.executeQuery();
            // trả về 1 dòng dữ liệu đọc được 
            
        }catch(Exception e)
        {
            return null;
            //JOptionPane.showMessageDialog(null,e, "Thông báo lỗi",1);
        }
    }
    
    
}
