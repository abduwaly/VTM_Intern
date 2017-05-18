import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc_test {

    public static void main(String[] args) {
        Connection con;
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/vtm";
        String user = "root";
        String password = "123456";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = con.createStatement();
            String sql = "select * from tab_user";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getString("empNo")+","+rs.getString("empName"));
            }
            con.close();

        } catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();

        }catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
    }

}