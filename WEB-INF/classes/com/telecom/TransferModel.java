/*
 * TransferModel.java
 */

package com.telecom;
import java.sql.*;

public class TransferModel {
    
    /** Creates a new instance of TransferModel */
    public TransferModel() {
    }
    
    private int req_id;
    private int phone_no;
    private String name;
    private String present_address;
    private String new_address;
    private int bank_details_id;
    private String status;
    
    public void setReq_id(int s)
    {
        req_id=s;
    }
    public void setPhone_no(int s)
    {
        phone_no=s;
    }
    public void setName(String s)
    {
        name=s;
    }
    public void setPresent_address(String s)
    {
        present_address=s;
    }
    public void setNew_address(String s)
    {
        new_address=s;
    }
    public void setBankDeatilsID(int i)
    {
        bank_details_id=i;
    }
    public void setStatus(String s)
    {
        status=s;
    }
    
    
    public int getReq_id()
    {
                    return req_id;
    }
    public int getPhone_no()
    {
                    return phone_no;
    }
    public String getName()
    {
                    return name;
    }
    public String getPresent_address()
    {
                    return present_address;
    }
    public String getNew_address()
    {
                    return new_address;
    }
    public int getBankDeatilsID()
    {
                    return bank_details_id;
    }
    public String getStatus()
    {
                    return status;
    }
    
    public boolean insert()
    {
        try
        {
           Connection con=MyDriver.getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select max(req_id) from phone_transfer_request");
           rs.next();
           setReq_id(rs.getInt(1)+1);
           rs.close();
           st.close();
           
           PreparedStatement ps=con.prepareStatement("insert into phone_transfer_request values(?,?,?,?,?,?,?)");
           ps.setInt(1,getReq_id());
           ps.setInt(2,getPhone_no());
           ps.setString(3,getName());
           ps.setString(4,getPresent_address());
           ps.setString(5,getNew_address());
           ps.setInt(6,getBankDeatilsID());
           ps.setString(7,getStatus());
           
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
           ResultSet ps=st.executeQuery("select * from phone_transfer_request where req_id="+getReq_id());
           if(ps.next())
           {
               setPhone_no(ps.getInt(2));
               setName(ps.getString(3));
               setPresent_address(ps.getString(4));
               setNew_address(ps.getString(5));
               setBankDeatilsID(ps.getInt(6));
               setStatus(ps.getString(7));
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}