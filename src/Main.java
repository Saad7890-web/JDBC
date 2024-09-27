//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;
public class Main {
    public static void main(String[] args)throws ClassNotFoundException{
        //Loading the drivers
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "$qen~#dFTjK@.STC";
        String query = "select * from employees;";
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
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("=============================================");
                System.out.println("ID: "+ id);
                System.out.println("Name: " + name);
                System.out.println("Salary: "+ salary);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}