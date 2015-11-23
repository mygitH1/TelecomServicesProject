/*
 * ComplaintsModel.java
 */

package com.telecom;
import java.sql.*;

public class ComplaintsModel {
    
    /** Creates a new instance of ComplaintsModel*/
    public ComplaintsModel() {
    }
     
    private int comp_id,phone_no;
	private String subject,client_name,message;
    
    public void setComp_Id(int i)
    {
        comp_id=i;
    }
    public void setPhoneNo(int i)
    {
        phone_no=i;
    }
    public void setSubject(String i)
    {
        subject=i;
    }
	public void setClientName(String i)
    {
        client_name=i;
    }
	public void setMessage(String i)
    {
        message=i;
    }
    
    public int getComp_Id()
    {
        return comp_id;
    }
    public int getPhoneNo()
    {
        return phone_no;
    }
	public String getSubject()
    {
        return subject;
    }
	public String getClientName()
    {
        return client_name;
    }
	public String getMessage()
    {
        return message;
    }
    
    
    public boolean insert()
    {
        try
        {
           Connection con=MyDriver.getConnection(); 
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select max(comlaint_id) from complaints");
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
    
    public void load()
    {
        try
        {
           Connection con=MyDriver.getConnection();
           Statement st=con.createStatement();
           ResultSet ps=st.executeQuery("select * from phone_cancellation where comlaint_id="+getComp_Id());
           if(ps.next())
           {
				//setComp_Id(ps.getInt(1));
				setSubject(ps.getString(2));
				setPhoneNo(ps.getInt(3));
				setClientName(ps.getString(4));
				setMessage(ps.getString(5));
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}