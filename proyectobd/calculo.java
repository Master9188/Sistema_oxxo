
package proyectobd;
import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.net.ConnectException;
import java.sql.*;
import javax.swing.JOptionPane;
public class calculo {
    Connection con;
    PreparedStatement stmtEmpleados, stmt115, stmt116;
    ResultSet tablaEmpleados, tabla115, tabla116;
    conexion mycon = new conexion();
    double sueldo, ispt, subsidio, total, quincenal;
    String sql = "", fech="";
    int idnomina = 0;
    int op = 0;
    //para borrar y guardar
    PreparedStatement stmtcalcula;
    int sw = 0;
    
    public void menu(){
        op = Integer.parseInt(JOptionPane.showInputDialog("Dame [0] borrar nominas o [1] crear nomina"));
        
        switch(op){
            case 0:
                int idnominaborra = 0;
                idnominaborra = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de nomina que deseas que se borren: "));
                elimina(idnominaborra);
                ProyectoBD mp = new ProyectoBD();
                mp.usar1();
                break;
                        
            case 1:
                Calculo();
                ProyectoBD mt = new ProyectoBD();
                mt.usar1();
                break;
        
        }
    }
    
    public void Calculo(){
            con = mycon.conecta();
            idnomina = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de nomina que deseas crear: "));
        try {
            sql = "select idtrabajador, nombre, sueldo from trabajadores";
            stmtEmpleados = con.prepareStatement(sql);   //preparo
            tablaEmpleados = stmtEmpleados.executeQuery(); //ejecuto
            
            sql = "select * from tablasisr where idtabla=115";
            stmt115 = con.prepareStatement(sql);   //preparo
            tabla115 = stmt115.executeQuery();       //ejecuto
            
            sql = "select * from tablasisr where idtabla=116";
            stmt116 = con.prepareStatement(sql);   //preparo
            tabla116 = stmt116.executeQuery();      //ejecuto
            
            tablaEmpleados.beforeFirst();
            while(tablaEmpleados.next()){
                sueldo = tablaEmpleados.getDouble(3);
            
                tabla115.beforeFirst();
                while(tabla115.next()){
                    if (sueldo > tabla115.getDouble(3) && sueldo <= tabla115.getDouble(4)){
                        ispt = ((sueldo - tabla115.getDouble(3)) * (tabla115.getDouble(6) / 100)) +tabla115.getDouble(5);
                    }
                }
                tabla116.beforeFirst();
                while(tabla116.next()){
                    if (sueldo > tabla116.getDouble(3) && sueldo <= tabla116.getDouble(4)){
                        subsidio = ((sueldo - tabla116.getDouble(3)) * (tabla116.getDouble(6) / 100)) +tabla116.getDouble(5);
                    }
                total = ispt - subsidio;
                quincenal = total / 2;
                
            }
            //proceso 1 para tabla 115
            
            /*JOptionPane.showMessageDialog(null, "Empleados " + tablaEmpleados.getString(1) +"  " + tablaEmpleados.getString(2) + "  " 
                            + "Sueldo " + sueldo + "  " 
                            + "Ispt " + ispt + "  "
                            + "Subsidio " + subsidio + "  " 
                            + "total " + total + "  " 
                            + "quincenal " + quincenal);*/
                grabarnomina();
            }
        } catch ( SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void grabarnomina(){
        try {
            sql = "insert into nominas values(";
            sql += "\"" + idnomina + "\" , ";
            sql += "\"" + tablaEmpleados.getString(1) + "\" , ";
            sql += "\"" + tablaEmpleados.getString(2) + "\" , ";
            sql += "\"" + sueldo + "\" , ";
            sql += "\"" + ispt + "\" , ";
            sql += "\"" + subsidio + "\" , ";
            sql += "\"" + total + "\" , ";
            sql += "\"" + quincenal + "\" ) ";
            stmtcalcula = con.prepareStatement(sql);
            sw = stmtcalcula.executeUpdate();
            DesktopNotify.showDesktopMessage("BIEN", "El registro se ha creado", 1,5000);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            DesktopNotify.showDesktopMessage("ERROR", "El registro no se ha guardado con exito", 3,5000);
        }
    }
    
    public void elimina(int idnominaborra){
        try {
            con = mycon.conecta();
            sql = "delete from nominas where idnomina= '" + idnominaborra + "'";
            stmtcalcula = con.prepareStatement(sql);
            sw = stmtcalcula.executeUpdate();
            DesktopNotify.showDesktopMessage("BIEN", "Las nominas con ese Id fueron borradas con exito", 1,5000);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            DesktopNotify.showDesktopMessage("ERROR", "Las nominas con ese Id NO fueron borradas con exito", 3,5000);
        }
    }
    
    public static void main(String[] args) {
        calculo mycalculo = new calculo();
        mycalculo.menu();
    }
    
}
