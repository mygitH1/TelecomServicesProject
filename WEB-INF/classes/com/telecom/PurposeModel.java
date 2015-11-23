/*
 * PurposeModel.java
 */

package com.telecom;

import java.sql.*;


public class PurposeModel extends Object implements java.io.Serializable {
    
    /** Creates new PurposeModel */
    public PurposeModel() {
    }
    
    private int purpose_id;
    private String name;
    
    public void setPurpose_Id(int i)
    {
        purpose_id=i;
    }
    public void setName(String s)
    {
        name=s;
    }
    
    public int getPurpose_Id()
    {
        return purpose_id;
    }
    public String getName()
    {
        return name;
    }
    
    public boolean insert()
    {
        try
        {
           Connection con=MyDriver.getConnection(); 
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select max(purpose_id) from purpose_details");
           rs.next();
           setPurpose_Id(rs.getInt(1)+1);
           rs.close();
           st.close();
           
           PreparedStatement ps=con.prepareStatement("insert into purpose_details values(?,?)");
           ps.setInt(1,getPurpose_Id());
           ps.setString(2,getName());
           
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
           ResultSet ps=st.executeQuery("select * from purpose_details where purpose_id="+getPurpose_Id());
           if(ps.next())
           {
               setName(ps.getString(2));               
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}