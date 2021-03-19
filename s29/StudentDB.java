/*
Slip no 29-2
Write a menu driven java program for the following:
Insert
Update
Delete
Search
Display
Exit
Consider Student (rno, sname, per) table for this.

*/

import java.io.*;
import java.sql.*;

class StudentDB
{
  static Connection cn;
  static Statement st;
  static ResultSet rs;
  static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  
  public static void main(String args[])
  {
        int r,k,ch,per;
        String sn;
        
        try
            {
       			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                cn=DriverManager.getConnection("jdbc:odbc:Anu");
	            st=cn.createStatement();
           
                do
               	{
                	System.out.println("1. Insert ");
                    System.out.println("2. Update ");
                    System.out.println("3. Delete ");
                    System.out.println("4. Display ");
                    System.out.println("5. Exit ");
                    
                    System.out.println("Enter Ur Choice");
                    ch=Integer.parseInt(br.readLine());
                    
                    switch(ch)
                   	{
                    	case 1:
                              	System.out.println("Enter the rno");
                                r=Integer.parseInt(br.readLine());
                                    
                               	System.out.println("Enter the sname");
                                sn=br.readLine();
                                                                       
                               	System.out.println("Enter percentage");
                                per=Integer.parseInt(br.readLine());
                                
                                String str="insert into student values(" + r + ",'"+ sn + "'," + per +")";
                                k=st.executeUpdate(str);
                                
                                if(k>0)
                                {
                                	System.out.println("Record Is Added");
                                }
                                
                                break;
                                
						case 2:
                                System.out.println("Enter the rno");
                                r=Integer.parseInt(br.readLine());
                                                                       
                                System.out.println("Enter the sname");
                                sn=br.readLine();
                                                                        
                                String ss="update student set sname='" + sn + "' where rno=" + r;
                                k=st.executeUpdate(ss);
                                                                        
                                if(k>0)
                                {
                                	System.out.println("Record Is Updated");
                                }
                                
                                break;
                                                
						case 3:
                                System.out.println("Enter the rno");
                                r=Integer.parseInt(br.readLine());
                                
                                String sd="delete from student where rno=" +r;
                               	k=st.executeUpdate(sd);
                                                                        
                              	if(k>0)
                                {
                                	System.out.println("Record Is Deleted");
                                }
                                
                                break;


                      	case 4:
                                rs=st.executeQuery("select *  from student");
                                                                        
                                while(rs.next())
                                {
                                	System.out.println(rs.getInt("rno") + "\t" + rs.getString("sname")+"\t"+rs.getInt("per"));
                                }
                                
                                break;
                                               
                       	case 5:
                               	System.exit(0);
                       }
                  }while(ch!=5);
               }
                                                
               catch(Exception et)
               {
               	System.out.println(et);
               }
       }
}
		