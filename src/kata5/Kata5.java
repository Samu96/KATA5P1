package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:.\\kata5.db");
        
        Statement st = con.createStatement();
        
        String query = "Select * from People";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            System.out.print(rs.getInt(1)+ " ");
            System.out.print(rs.getString(2)+ " ");
            System.out.print(rs.getString(3)+ " ");
            System.out.println(rs.getString(4));
        }
    }
    
}
