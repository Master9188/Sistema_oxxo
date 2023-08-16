
package proyectobd;
import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.net.ConnectException;
import java.sql.*;
import javax.swing.JOptionPane;
public class aguinaldo {
    Connection con;
    PreparedStatement stmtEmpleados, stmt115, stmt116;
    ResultSet tablaEmpleados, tabla115, tabla116;
    conexion mycon = new conexion();
    double sueldo,aguinaldo,preaguinaldo;
    String sql = "";
    int diastrabajados = 0;
    int op = 0;
    double sdiario;
    int idaguinaldo,idaguiborrar;
    //para borrar y guardar
    PreparedStatement stmtaguinaldo;
    int sw = 0;
    
    
    
    public void menu(){
        op = Integer.parseInt(JOptionPane.showInputDialog("Dame " + "\n" + "[0] si deseas borrar un aguinaldo " + "\n" +"[1] crear aguinaldo"));
        
        switch(op){
            case 0:
                
                idaguiborrar = Integer.parseInt(JOptionPane.showInputDialog("Dame el Id del aguinaldo que deseas que se borren: "));
                elimina(idaguiborrar);
                ProyectoBD mp = new ProyectoBD();
                mp.usar1();
                break;
                        
            case 1:
                Calculoaguinaldo();
                ProyectoBD mt = new ProyectoBD();
                mt.usar1();
                break;
        
        }
    }
    
    
    
    
    public void Calculoaguinaldo(){
            con = mycon.conecta();
            int idTrabajadorElegido = Integer.parseInt(JOptionPane.showInputDialog("Dame el Id del trabajador para calcular su aguinaldo: "));
            
            idaguinaldo = Integer.parseInt(JOptionPane.showInputDialog("Dame el Id de aguinaldo: "));
            diastrabajados = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de dias trabajados: "));
        try {
            
            sql = "select idtrabajador, nombre, sueldo, fechaini from trabajadores where idtrabajador = ?";
            stmtEmpleados = con.prepareStatement(sql);
            stmtEmpleados.setInt(1, idTrabajadorElegido);
            tablaEmpleados = stmtEmpleados.executeQuery();
            
            sql = "select diasaguinaldo, diasaño, division, fechaactual from tablaagui";
            stmt115 = con.prepareStatement(sql);   //preparo
            tabla115 = stmt115.executeQuery();       //ejecuto
            
            
            tablaEmpleados.beforeFirst();
            while(tablaEmpleados.next()){
                sueldo = tablaEmpleados.getFloat(3);
                
                tabla115.beforeFirst();
                while(tabla115.next()){
                        preaguinaldo = tabla115.getDouble(3) * diastrabajados;
                        
                }      
                sdiario = sueldo / 30;
                aguinaldo = preaguinaldo * sdiario;
            
            
            JOptionPane.showMessageDialog(null, "Id trabajador: " + tablaEmpleados.getInt(1) +" " +
                    "Nombre:" + tablaEmpleados.getString(2) + " " + "Sueldomes: " + sueldo
                    + " " + " Sueldo diario: " + sdiario +" Aguinaldo: " + aguinaldo);
                grabaraguinaldo();
            }
        } catch ( SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void grabaraguinaldo(){
        try {
            sql = "insert into aguinaldo values(";
            sql += "\"" + idaguinaldo + "\" , ";
            sql += "\"" + tablaEmpleados.getString(1) + "\" , ";
            sql += "\"" + tablaEmpleados.getString(2) + "\" , ";
            sql += "\"" + sueldo + "\" , ";
            sql += "\"" + aguinaldo + "\" , ";
            sql += "\"" + diastrabajados + "\" ) ";
            stmtaguinaldo = con.prepareStatement(sql);
            sw = stmtaguinaldo.executeUpdate();
            DesktopNotify.showDesktopMessage("BIEN", "El registro se ha creado", 1,5000);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            DesktopNotify.showDesktopMessage("ERROR", "El registro no se ha guardado con exito", 3,5000);
        }
    }
    
    public void elimina(int idnominaborra){
        try {
            con = mycon.conecta();
            sql = "delete from aguinaldo where idaguinaldo= '" + idaguiborrar + "'";
            stmtaguinaldo = con.prepareStatement(sql);
            sw = stmtaguinaldo.executeUpdate();
            DesktopNotify.showDesktopMessage("BIEN", "Las nominas con ese Id fueron borradas con exito", 1,5000);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            DesktopNotify.showDesktopMessage("ERROR", "Las nominas con ese Id NO fueron borradas con exito", 3,5000);
        }
    }
    
    public static void main(String[] args) {
        aguinaldo myaguinaldo = new aguinaldo();
        myaguinaldo.menu();
    }
}
