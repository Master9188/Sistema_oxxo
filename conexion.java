
package DAO;

import java.sql.*;
import javax.swing.JOptionPane;
public class conexion {

    static Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    static String cadena, driver;
    
    public Connection conecta(){
         String host = "bjeg0xfrirtv7daefovy-mysql.services.clever-cloud.com";
        String port = "3306";
        String databaseName = "bjeg0xfrirtv7daefovy";
        String username = "u1p1ogmftew9rros";
        String password = "SdTALnmI8wdrzuY9VLl6";

        cadena = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
        driver = "com.mysql.jdbc.Driver";
        
        try{
            Class.forName(driver);
            System.out.println(cadena);
            con = DriverManager.getConnection(cadena, username, password);
            System.out.println(con);
            System.out.println("Conexión exitosa");
        }   
            catch(ClassNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
                catch (SQLException e1)
                {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
        return con;
    }
    
    public static void main(String[] args) {
        conexion myconexion = new conexion();
        Connection con = myconexion.conecta();
        if (con != null) {
            // La conexión se estableció con éxito.
            // Puedes intentar ejecutar una consulta aquí para asegurarte de que la conexión funcione.
        } else {
            System.out.println("Error al establecer la conexión");
        }
    }

    
}

