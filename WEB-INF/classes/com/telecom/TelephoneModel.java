/*
 * TelephoneModel.java
 */

package com.telecom;
import java.sql.*;

public class TelephoneModel {
    
    /** Creates a new instance of TelephoneModel*/
    public TelephoneModel() {
    }
     
    private int req_id,phone_no;
	    
    public void setReq_Id(int i)
    {
        req_id=i;
    }
    public void setPhoneNo(int i)
    {
        phone_no=i;
    }
    
    public int getReq_Id()
    {
        return req_id;
    }
    public int getPhoneNo()
    {
        return phone_no;
    }
/*    
    public boolean insert()
    {
        try
        {
           Connection con=MyDriver.getConnection(); 
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select max(telephone_no) from telephone_details");
           rs.next();
           setComp_Id(rs.getInt(1)+1);
           rs.close();
           st.close();
           
           PreparedStatement ps=con.prepareStatement("insert into complaints values(?,?,?,?,?)");
           ps.setInt(1,getComp_Id());
		   ps.setString(2,getSubject());
           ps.setInt(3,getPhoneNo());
		   ps.setString(4,getClientName());
		   ps.setString(5,getMessage());
           
           int i=ps.executeUpdate();
           if (i==1)
            return true;
        }
        catch(Exception e)
        {e.printStackTrace();}
        return false;
    }
*/    
    public void load()
    {
        try
        {
           Connection con=MyDriver.getConnection();
           Statement st=con.createStatement();
           ResultSet ps=st.executeQuery("select * from telephone_details where telephone_no="+getPhoneNo());
           if(ps.next())
           {
				setReq_Id(ps.getInt(2));
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}