/*
 * TempConnectionDetailsModel.java
 */

package com.telecom;

import java.sql.*;

public class TempConnectionDetailsModel implements java.io.Serializable {
    
    private int reg_id;
    private String name;
    private String password;
    private int gender;
    private String address;
    private int purpose;
    private int facility;
    private int dd_id;
    private String confirmed,from_date,to_date;
    
    /** Creates a new instance of TempConnectionDetailsModel*/
    public TempConnectionDetailsModel() {
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
	public void setFromDate(String s) {
        from_date=s;
    }
	public void setToDate(String s) {
        to_date=s;
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
	public String getFromDate() {
        return from_date;
    }
	public String getToDate() {
        return to_date;
    }
    
    public boolean update()
    {
        try
        {
           Connection con=MyDriver.getConnection(); 
           PreparedStatement ps=con.prepareStatement("update temp_connections_details set purpose=?,facility=? where req_id=?)");

           ps.setInt(1,getPurpose());
           ps.setInt(2,getFacility());
           ps.setInt(3,getReq_id());
           
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
           ResultSet rs=st.executeQuery("select max(req_id) from temp_connections_details");
           rs.next();
           setReq_id(rs.getInt(1)+1);
           rs.close();
           st.close();
           
           PreparedStatement ps=con.prepareStatement("insert into temp_connections_details values(?,?,?,?,?,?,?,?,?,?,?)");
           ps.setInt(1,getReq_id());
           ps.setString(2,getName());
           ps.setString(3,getPassword());
           ps.setInt(4,getGender());
           ps.setString(5,getAddress());
           ps.setInt(6,getPurpose());
           ps.setInt(7,getFacility());
           ps.setInt(8,getDD_id());
           ps.setString(9,getConfirmed());
		   ps.setString(10,getFromDate());
		   ps.setString(11,getToDate());
           
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
           ResultSet ps=st.executeQuery("select * from temp_connections_details where req_id="+getReq_id());
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
			   setFromDate(ps.getString(10));
			   setToDate(ps.getString(11));
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}