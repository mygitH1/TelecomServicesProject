/*
 * CancellationModel.java
 */

package com.telecom;
import java.sql.*;

public class CancellationModel {
    
    /** Creates a new instance of CancellationModel */
    public CancellationModel() {
    }
     
    private int req_id,cancle_id,phone_no;
    
    public void setReq_Id(int i)
    {
        req_id=i;
    }
    public void setCancle_Id(int i)
    {
        cancle_id=i;
    }
    public void setPhoneNo(int i)
    {
        phone_no=i;
    }
    
    public int getReq_Id()
    {
        return req_id;
    }
    public int getCancle_Id()
    {
        return cancle_id;
    }
    public int getPhoneNo()
    {
        return phone_no;
    }
    
    
    public boolean insert()
    {
        try
        {
           Connection con=MyDriver.getConnection(); 
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select max(cancle_id) from phone_cancellation");
           rs.next();
           setCancle_Id(rs.getInt(1)+1);
           rs.close();
           st.close();
           
           PreparedStatement ps=con.prepareStatement("insert into phone_cancellation values(?,?,?)");
           ps.setInt(1,getCancle_Id());
           ps.setInt(2,getReq_Id());
           ps.setInt(3,getPhoneNo());
           
           int i=ps.executeUpdate();
           if (i==1)
            return true;
        }
        catch(Exception e)
        {e.printStackTrace();}
        return false;
    }
    
    public void load()
    {
        try
        {
           Connection con=MyDriver.getConnection();
           Statement st=con.createStatement();
           ResultSet ps=st.executeQuery("select * from phone_cancellation where cancle_id="+getCancle_Id());
           if(ps.next())
           {
               setReq_Id(ps.getInt(2));
               setPhoneNo(ps.getInt(3));
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}