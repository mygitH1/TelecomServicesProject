/*
 * DemandDraftModel.java
 */

package com.telecom;

import java.sql.*;


public class DemandDraftModel extends Object implements java.io.Serializable {
    
    /** Creates new DemandDraftModel */
    public DemandDraftModel() {
    }
    
    private int dd_id;
    private String name;
    private String branch;
    private String date;
    private double amount;
    private String draft_no;
    
    public void setDD_id(int e)
    {
        dd_id=e;
    }
    public void setName(String e)
    {
        name=e;
    }
    public void setBranch(String e)
    {
        branch=e;       
    }
    public void setDate(String e)
    {
        date=e;
    }
    public void setAmount(double d)
    {
        amount=d;
    }
    public void setDraft_no(String s)
    {
        draft_no=s;
    }
    
    public int getDD_id()
    {
        return dd_id;
    }
    public String getName()
    {
        return name;
    }
    public String getBranch()
    {
        return branch;       
    }
    public String getDate()
    {
        return date;
    }
    public double getAmount()
    {
        return amount;
    }
    public String getDraft_no()
    {
        return draft_no;
    }
    
    public boolean remove()
    {
        try 
        {
           Connection con=MyDriver.getConnection(); 
           PreparedStatement ps=con.prepareStatement("delete demand_draft_details where dd_id=?");
           ps.setInt(1,getDD_id());
           
           int i=ps.executeUpdate();
           if (i==1)
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean insert()
    {
        try
        {
           Connection con=MyDriver.getConnection(); 
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select max(dd_id) from demand_draft_details");
           rs.next();
           setDD_id(rs.getInt(1)+1);
           rs.close();
           st.close();
           
           PreparedStatement ps=con.prepareStatement("insert into demand_draft_details values(?,?,?,?,?,?)");
           ps.setInt(1,getDD_id());
           ps.setString(2,getName());
           ps.setString(3,getBranch());
           ps.setString(4,getDate());
           ps.setDouble(5,getAmount());
           ps.setString(6,getDraft_no());
           
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
           ResultSet ps=st.executeQuery("select * from demand_draft_details where dd_id="+getDD_id());
           if(ps.next())
           {
               setName(ps.getString(2));
               setBranch(ps.getString(3));
               setDate(ps.getString(4));
               setAmount(ps.getDouble(5));
               setDraft_no(ps.getString(6));               
           }
       }
        catch(Exception e)
        {e.printStackTrace();}
    }
}