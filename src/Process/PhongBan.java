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
public class PhongBan {
    public static Connection conn=Connect.getConnect();
    public static ResultSet rs =null;
    public static PreparedStatement pst =null;
    
    public static void InsertPB(String idPhongban,String name,String Address,String number)
    {
        int phone = Integer.parseInt(number);
        
        String sql="INSERT INTO `qlns`.`phongban` (`idPhongban`, `name`, `Address`, `Phone`) VALUES (?,?,?,?)";
        try
        {
            pst=conn.prepareStatement(sql);
            pst.setString(1, idPhongban);
            pst.setString(2, name);
            pst.setString(3, Address);
            pst.setInt(4, phone);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Thêm thành công id"+idPhongban+"","Thông báo",1);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Dữ liệu đã có. Vui lòng kiểm tra lại","Thông báo",1);
        }
    }
    public static void UpdatePB(String idPhongban,String name,String Address,String number, String id)
    {
        int phone = Integer.parseInt(number);
        String sql="UPDATE `qlns`.`phongban` SET `idPhongban`='"+idPhongban+"', `name`='"+name+"', `Address`='"+Address+"', `Phone`='"+phone+"' WHERE `idPhongban`='"+id+"'";
        try
        {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sửa thành công Mã phòng ban "+id,"Thông báo",1);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Mã phòng ban "+id+" có thể đã tồn tại. Vui lòng kiểm tra lại","Thông báo",1);
        }
    }
    public static void DeletePB(String idPhongban)
    {
        String sql="DELETE FROM `qlns`.`phongban` WHERE `idPhongban`='"+idPhongban+"'";
        try
        {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công Mã Phòng Ban"+idPhongban,"Thông Báo",1);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Mã Phòng Ban"+idPhongban+" có thể được sử dụng ở 1 nơi khác. Vui lòng kiểm tra lại","Thông Báo",1);
        }
    }
    
}
