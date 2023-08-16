
package proyectobd;
import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.net.ConnectException;
import java.sql.*;
import javax.swing.JOptionPane;

public class ventas {
    
    int sw = 0;
    Connection con;
    PreparedStatement stmtinventario;
    ResultSet tablaEmpleados;
    int idproducto, cantidad;
    conexion mycon = new conexion();

    public void menu() {
        int op = Integer.parseInt(JOptionPane.showInputDialog("Dame " + "\n" + "[0] si deseas salir " + "\n" + "[1] crear venta"));

        switch (op) {
            case 0:
                ProyectoBD mp = new ProyectoBD();
                mp.usar1();
                break;

            case 1:
                venta();
                ProyectoBD mt = new ProyectoBD();
                mt.usar1();
                break;
        }
    }

    public void venta() {
        idproducto = Integer.parseInt(JOptionPane.showInputDialog("Dame el Id del producto a vender: "));
        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Dame la cantidad que vendio: "));
        try {
            con = mycon.conecta();

            String sql = "SELECT Idproducto, nombre, costo, cantidad FROM inventario WHERE Idproducto = ?";
            stmtinventario = con.prepareStatement(sql);
            stmtinventario.setInt(1, idproducto);
            tablaEmpleados = stmtinventario.executeQuery();

            tablaEmpleados.beforeFirst();
            while (tablaEmpleados.next()) {
                int cInventario = tablaEmpleados.getInt("cantidad");
                int total = cInventario - cantidad;

                JOptionPane.showMessageDialog(null, "Id producto: " + tablaEmpleados.getInt("Idproducto") + " " +
                        "En inventario: " + cInventario + " " + "Vendidos: " + cantidad
                        + " " + " Queda en inventario: " + total);

                actualizarInventario(idproducto, cantidad);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            // Cerrar la conexión y el PreparedStatement para liberar recursos
            try {
                if (tablaEmpleados != null) {
                    tablaEmpleados.close();
                }
                if (stmtinventario != null) {
                    stmtinventario.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void actualizarInventario(int idProducto, int cantidadVendida) {
        try {
            con = mycon.conecta();

            String sql = "UPDATE inventario SET cantidad = cantidad - ? WHERE Idproducto = ?";
            stmtinventario = con.prepareStatement(sql);
            stmtinventario.setInt(1, cantidadVendida);
            stmtinventario.setInt(2, idProducto);

            int filasActualizadas = stmtinventario.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "El inventario se ha actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto en el inventario.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el inventario: " + e.getMessage());
        } finally {
            // Cerrar el PreparedStatement y la conexión para liberar recursos
            try {
                if (stmtinventario != null) {
                    stmtinventario.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }}
    
        
    
    public static void main(String[] args) {
        ventas myventa = new ventas();
        myventa.menu();
    }
    
}
