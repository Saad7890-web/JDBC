//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;
public class Insert_data {
    public static void main(String[] args)throws ClassNotFoundException{
        //Loading the drivers
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "$qen~#dFTjK@.STC";
        String query = "INSERT INTO employees(id, name, salary) VALUES(3, 'Ebon', 120000.0);";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //connecting with the database
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection eshablished successfully");
            Statement stmt = con.createStatement();
            int rowsEffected = stmt.executeUpdate(query);
            if(rowsEffected > 0){
                System.out.println("insertion of " + rowsEffected+ " successfully");
            }else{
                System.out.println("failed");
            }

            stmt.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}