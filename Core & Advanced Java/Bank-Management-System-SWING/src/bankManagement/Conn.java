package bankManagement;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;

//Steps are: Register Driver, Create Connection, Create Statement, Execute Query, Close Connection
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","ansh123");
            s = c.createStatement();


        } catch (Exception e){
            System.out.println(e);

        }

    }
}
