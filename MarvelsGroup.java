package marvelsgroup;


import java.sql.*;
import java.util.*;

public class MarvelsGroup {
    static Connection conn = null;
    static String URL = "jdbc:mysql://localhost:3306/MarvelsDB";
    public static void main(String[] args) 
    {
        
        Scanner x=new Scanner(System.in);
        try
        {
            
            conn=DriverManager.getConnection(URL,"root","root");
            if(conn!=null)
                System.out.println("Connection zhala re!");
            String input=null;
            String qry="select * from customers";
            Statement st=null;
            st=conn.createStatement();
//            try
//            {
                int no;
                String naav;
                ResultSet rs = st.executeQuery(qry);
                while(rs.next())
                {
                    no=rs.getInt("cust_id");
                    naav=rs.getString("name");
                    System.out.println("ID : "+no+" \tNAME : "+naav);
                }
//            }
//            catch(SQLException r)
//            {
//                System.out.println("Result set gandlay bhava!");
//                input=null;
//            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    public static Connection returnconn()
    {
        return conn;
    }
}
