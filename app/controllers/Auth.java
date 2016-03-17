package controllers;
import models.CW_LOGIN;
import play.*;
import play.mvc.*;
import java.util.List;
import com.avaje.ebean.*;
import com.avaje.ebean.EbeanServer;
import static play.libs.Json.*;
import com.fasterxml.jackson.databind.JsonNode;
import Singleton.Singleton;

public class Auth extends Controller {

   public Result login(){
       JsonNode json = request().body().asJson();
        String user = json.get("user").textValue();
        String pwd = json.get("password").textValue();
        EbeanServer server = Ebean.getServer(null);
        CW_LOGIN login=server.find(CW_LOGIN.class)
                            .select("*")
                            .where().eq("username",user).eq("password",pwd)
                            .findUnique();
        if(login!=null)
        return ok("Login successful");
        else
        return ok("Invalid credentials");
   }
   
   /*   public Result login2() throws Exception{
            
        JsonNode json = request().body().asJson();
        String user = json.get("user").textValue();
        String pwd = json.get("password").textValue();
        Connection connection = DB.getConnection();
        Statement stmt = null;
             String query = "select SEQ,USERNAME,PASSWORD from CW_LOGIN where USERNAME='"+user+"' and password = '"+pwd+"'";
             stmt=connection.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             if (!rs.next() )
             {
                 return ok("Invalid credentials");
             }
             else
             {
                 return ok("Login successful");
             }
             }
*/
        public Result login2() throws Exception{
        
        JsonNode json = request().body().asJson();
        String user = json.get("user").textValue();
        String pwd = json.get("password").textValue();
        Singleton jdbc = Singleton.getInstance();
        int i= jdbc.login(user,pwd);
        if(i==1)
        return ok("Login Success");
        else
        return ok("Login failed - Invalid credentials");
            

        }
        




}