<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>Telecom Services (Enquiries)</TITLE></HEAD>
<BODY bgColor=#006699 text=#000000>
<FORM action="EnquiryByTelephoneNoControler" method=post>
<TABLE align=center border=0 cellPadding=0 cellSpacing=0 width="90%">
  <TBODY>
  <TR>
    <TD><IMG alt="" height=72 src="images/topleft.gif" width=10></TD>
    <TD bgColor=#ffffff vAlign=bottom width="100%">
      <TABLE border=0 cellPadding=0 cellSpacing=0 width="100%">
        <TBODY>
        <TR>
          <TD valign="bottom">
            <H1>
            <MARQUEE>
                    <font size="5">Telecom Services</font> 
                    </MARQUEE>
            </H1>
            <H1></H1></TD></TR>
        <TR>
          <TD>
            <TABLE border=0 cellPadding=0 cellSpacing=0>
              <TBODY>
              <TR>
                <TD><IMG alt="" height=30 
                  src="images/buttonleft.gif" width=9></TD>
                        <TD width=50 align="center" 
                vAlign=center background=images/buttonmiddle.gif class=tabs><A class=tabs 
                  href="Home.html"><font color="#FFFFFF">Home</font></A></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonright.gif" width=10></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonleft.gif" width=9></TD>
                        <TD width=100 align="center" 
                vAlign=center background=images/buttonmiddle.gif class=tabs><A class=tabs 
                  href="Applications.html"><font color="#FFFFFF">Applications</font></A></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonright.gif" width=10></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonleft.gif" width=9></TD>
                        <TD width=110 align="center" 
                vAlign=center background=images/buttonmiddle.gif class=tabs><A class=tabs 
                  href="Entries.html"><font color="#FFFFFF">Entries</font></A></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonright.gif" width=10></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonleft.gif" width=9></TD>
                        <TD width=110 align="center" 
                vAlign=center background=images/buttonmiddle.gif class=tabs><A class=tabs 
                  href="Enquiries.html"><font color="#FFFFFF">Enquiries</font></A></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonright.gif" width=10></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonleft.gif" width=9></TD>
                        <TD width=100 align="center" 
                vAlign=center background=images/buttonmiddle.gif class=tabs><A class=tabs 
                  href="Complaints.html"><font color="#FFFFFF">Complaints</font></A></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonright.gif" width=10></TD>
                <TD align="center" vAlign=center><IMG alt="" height=30 
                  src="images/buttonleft.gif" width=9></TD>
                        <TD width=100 align="center" 
                vAlign=center background=images/buttonmiddle.gif class=tabs><A class=tabs 
                  href="AboutUS.html"><font color="#FFFFFF">About 
                          US </font></A></TD>
                <TD><IMG alt="" height=30 
                  src="images/buttonright.gif" width=10></TD>
                <TD>&nbsp;</TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
    <TD><IMG alt="" height=71 src="images/topright.gif" 
  width=9></TD></TR>
  <TR>
    <TD width=10><IMG alt="" height=25 src="images/toplcorner.gif" 
      width=10></TD>
    <TD background=images/topmiddle.gif width="100%">&nbsp;</TD>
    <TD width=9><IMG alt="" height=25 src="images/toprcorner.gif" 
      width=9></TD></TR>
  <TR>
    <TD bgColor=#ffffff width=10>&nbsp;</TD>
    <TD bgColor=#ffffff vAlign=top width="100%">
      <TABLE border=0 cellPadding=0 cellSpacing=5 width="100%">
            <TR> 
              <TD vAlign=top> <div align="center"> 
                  <table width="100%" height="10" border="1" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td> <div align="center"><strong>Bill Enquiry Details</strong></div></td>
                    </tr>
                  </table>
                </div>
                </TD>
            </TR>
            <TR>
              <TD vAlign=top><table width="100%" border="0">
                  <tr> 
                    <td width="28%">&nbsp;</td>
                    <td width="72%">&nbsp;</td>
                  </tr>
                  <tr> 
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr> 
                    <td>Telephone Number</td>
                    <td> <%= request.getAttribute("phone_no")%> </td>
                  </tr>
                  <tr> 
                    <td>Bill Number</td>
                    <td> <%= request.getAttribute("billno")%> </td>
                  </tr>
                  <tr> 
                    <td>Bill Amount</td>
                    <td><%= request.getAttribute("billamount")%> </td>
                  </tr>
                  <tr> 
                    <td colspan="2"><div align="center"> </div></td>
                  </tr>
                  <tr> 
                    <td colspan="2">&nbsp;</td>
                  </tr>
                </table></TD>
            </TR>
            <TBODY>
            </TBODY>
          </TABLE></TD>
    <TD bgColor=#ffffff width=9>&nbsp;</TD></TR>
  <TR>
    <TD bgColor=#ffffff width=10><IMG alt="" height=30 
      src="images/transparent.gif" width=10></TD>
    <TD bgColor=#ffffff vAlign=top width="100%">
      <HR>
          <P align=center><font color="#0000FF"><a href="Home.html">Home</a></font><IMG alt="" 
      height=15 src="images/bullet.gif" width=15> <A class=tabs 
                  href="Applications.html">Applications</A> <IMG alt="" height=15 
      src="images/bullet.gif" width=15> <A class=tabs 
                  href="Entries.html">Entries</A> <IMG alt="" height=15 
      src="images/bullet.gif" width=15> <A class=tabs 
                  href="Enquiries.html">Enquiries</A> <IMG alt="" height=15 
      src="images/bullet.gif" width=15> <A class=tabs 
                  href="Complaints.html">Complaints</A> <IMG alt="" height=15 
      src="images/bullet.gif" width=15> <A class=tabs 
                  href="AboutUS.html">About US</A><BR>
            <BR>
          </P></TD>
    <TD bgColor=#ffffff width=9>&nbsp;</TD></TR>
  <TR>
    <TD width=10><IMG alt="" height=19 src="images/bottomleft.gif" 
      width=10></TD>
    <TD background=images/bottommiddle.gif width="100%">&nbsp;</TD>
    <TD width=9><IMG alt="" height=19 src="images/bottomright.gif" 
      width=9></TD></TR></TBODY></TABLE></FORM></BODY><!-- #EndTemplate --></HTML>