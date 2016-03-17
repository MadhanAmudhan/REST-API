package Singleton;
import play.*;
import play.mvc.*;
import java.util.List;
import play.db.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
public class Singleton extends Controller{
    
    private static Singleton jdbc;
    private  Singleton(){}
    
    public static Singleton getInstance(){
        if(jdbc==null)
        {
            jdbc = new Singleton();
        }
        return jdbc;
    }
        
    public int login(String userName,String password) throws Exception
    {
      Connection connection = DB.getConnection();
      Statement stmt = null;
             String query = "select SEQ,USERNAME,PASSWORD from CW_LOGIN where USERNAME='"+userName+"' and password = '"+password+"'";
             stmt=connection.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             if (!rs.next() )
             {
                 return 0;
             }
             else
             {
                 return 1;
             }  
    }
    
}