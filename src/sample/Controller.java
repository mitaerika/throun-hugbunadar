package sample;

//packages for database connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Controller {
    public static void main( String[] args )
            throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:2D.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS R");
            stmt.executeUpdate("DROP INDEX IF EXISTS RINDEX");
            stmt.executeUpdate("CREATE TABLE R(key integer primary key,value double)");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO R VALUES(?,?)");
            ResultSet r = stmt.executeQuery(
                    "SELECT * FROM booking"
            );
            r.next();
            System.out.println("Niðurstaða leitar: "+r.getInt(1));
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(conn != null)
                    conn.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
}
