/*
 * ConnectionDetailsModel.java
 */

package com.telecom;

import java.sql.*;

public class ConnectionDetailsModel implements java.io.Serializable {
    
    private int reg_id;
    private String name;
    private String password;
    private int gender;
    private String address;
    private int purpose;
    private int facility;
    private int dd_id;
    private String confirmed;
    
    /** Creates a new instance of ConnectionDetailsModel */
    public ConnectionDetailsModel() {
    }
    
    public void setReq_id(int s) {
        reg_id=s;
    }
    public void setName(String s) {
        name=s;
    }
    public void setPassword(String s) {
        password=s;
    }
    public void setGender(int s) {
        gender=s;
    }
    public void setAddress(String s) {
        address=s;
    }
    public void setPurpose(int s) {
        purpose=s;
    }
    public void setFacility(int s) {
        facility=s;
    }
    public void setDD_id(int s) {
        dd_id=s;
    }
    public void setConfirmed(String s) {
        confirmed=s;
    }
    
    
    public int getReq_id() {
        return reg_id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public int getGender() {
        return gender;
    }
    public String getAddress() {
        return address;
    }
    public int getPurpose() {
        return purpose;
    }
    public int getFacility() {
        return facility;
    }
    public int getDD_id() {
        return dd_id;
    }
    public String getConfirmed() {
        return confirmed;
    }
    
    public boolean update()
    {
        try
        {
           Connection con=MyDriver.getConnection(); 
           PreparedStatement ps=con.prepareStatement("update new_connections_details set purpose=?,facility=? where req_id=?");

           ps.setInt(1,getPurpose());
           ps.setInt(2,getFacility());
           ps.setInt(3,getReq_id());
           System.out.println(getReq_id());
           int i=ps.executeUpdate();
           if (i==1)
            return true;
        }
        catch(Exception e)
        {e.printStackTrace();}
        return false;
    }
    
    public boolean insert()
    {
        try
        {
           Connection con=MyDriver.getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select max(req_id) from new_connections_details");
           rs.next();
           setReq_id(rs.getInt(1)+1);
           rs.close();
           st.close();
           
           PreparedStatement ps=con.prepareStatement("insert into new_connections_details values(?,?,?,?,?,?,?,?,?)");
           ps.setInt(1,getReq_id());
           ps.setString(2,getName());
           ps.setString(3,getPassword());
           ps.setInt(4,getGender());
           ps.setString(5,getAddress());
           ps.setInt(6,getPurpose());
           ps.setInt(7,getFacility());
           ps.setInt(8,getDD_id());
           ps.setString(9,getConfirmed());
           
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
           ResultSet ps=st.executeQuery("select * from new_connections_details where req_id="+getReq_id());
           if(ps.next())
           {
               setName(ps.getString(2));
               setPassword(ps.getString(3));
               setGender(ps.getInt(4));
               setAddress(ps.getString(5));
               setPurpose(ps.getInt(6));
               setFacility(ps.getInt(7));
               setDD_id(ps.getInt(8));
               setConfirmed(ps.getString(9));
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}