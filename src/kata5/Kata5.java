package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
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
        query = "CREATE TABLE IF NOT EXISTS MAIL ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'mail' TEXT NOT NULL)";
        st.execute(query);
        
        
        String filename = new String(".\\src\\Kata5\\emails.txt");
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        String mail;
        while((mail=reader.readLine())!= null){
            if(!mail.contains("@"))continue;
            query= "INSERT INTO MAIL (mail) VALUES ('"+ mail +"')";
            st.execute(query);
            
        }
        
        rs.close();
        st.close();
        con.close();
        
    }
    
}
