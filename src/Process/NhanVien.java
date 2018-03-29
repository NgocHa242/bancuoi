/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.Connect;
import java.sql.Connection;
import java.sql.Date;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NhanVien {
     public static Connection conn=Connect.getConnect();
    public static ResultSet rs =null;
    public static PreparedStatement pst =null;

 
    public static java.sql.Date jFormatDate(String date) throws ParseException
    {
        String str=null;
        if(date.indexOf("/") >0)
            str=date.replaceAll("/", "-");
        else str=date;
        String sFinal="";
        String[] s = str.split("-");
        int size=s.length;
       for(int i=size-1;i>=0;i--)
           sFinal+=s[i];
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed = format.parse(sFinal);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        return sql;
    
                
    }
    public static void InsertNhanVien(String id,String name,String gt,String cmnd, String date,String address,String number,String dantoc,String tongiao,String namePb,String nameCV) throws ParseException
    {
        int phone,chungminh;
        Date sDate;
        if(number.length()==0)
            phone=0;
        else
         phone=Integer.parseInt(number);
        if(cmnd.length()==0)
            chungminh=0;
        else chungminh=Integer.parseInt(cmnd);
       
        
       
         sDate=jFormatDate(date);
        String sql="INSERT INTO `qlns`.`nhanvien` (`idNhanVien`, `name`, `sex`, `CMND`, `Birthday`, `Address`, `phone`, `dantoc`, `tongiao`, `Phongban_id`, `ChucVu_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, gt);
            pst.setInt(4, chungminh);
            pst.setDate(5, sDate);
            pst.setString(6, address);
            pst.setString(8, dantoc);
            pst.setInt(7, phone);
            pst.setString(9, tongiao);
            pst.setString(10, namePb);
            pst.setString(11, nameCV);
            pst.execute();
           
            JOptionPane.showMessageDialog(null, "Đã thêm thành công nhân viên "+name+"");

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Kiểm tra lại dữ liệu vừa nhập !","Thông báo",1);
        }
    }
    public static void UpdateNhanVien(String id,String name,String gt,String cmnd, String date,String address,String number,String dantoc,String tongiao,String namePb,String nameCV,String idNhanVien) throws ParseException
    {
        int phone=Integer.parseInt(number);
        int chungminh=Integer.parseInt(cmnd);
        Date sDate=jFormatDate(date);
        
     
     String sql = "UPDATE `qlns`.`nhanvien` SET `idNhanVien`='"+id+"',`name`='"+name+"', `sex`='"+gt+"', `CMND`='"+chungminh+"', `Birthday`='"+sDate+"', `Address`='"+address+"',`phone`='"+phone+"', `dantoc`='"+dantoc+"', `tongiao`='"+tongiao+"', `Phongban_id`='"+namePb+"',`ChucVu_id`='"+nameCV+"' WHERE `idNhanVien`='"+idNhanVien+"'";
     try
     {
         pst=conn.prepareStatement(sql);
         pst.execute();
         JOptionPane.showMessageDialog(null, "Sửa thành công nhân viên có mã nhân viên :"+id,"Thông báo",1);
     }catch(Exception e)
     {
         JOptionPane.showMessageDialog(null, "Kiểm tra lại dữ liệu đầu vào","Thông báo",1);
     }
       
    }
    public static void DeleteNhanVien(String idNhanVien)
    {
        String sql="DELETE FROM `qlns`.`nhanvien` WHERE `idNhanVien`='"+idNhanVien+"'";
        try
        {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên có mã nhân viên"+idNhanVien,"Thông báo",1);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Không thể xóa. Cần kiểm tra lại các quan hệ liên quan","Thông báo",1);
        }
    }
    
}

