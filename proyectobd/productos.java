
package proyectobd;

import java.awt.GridLayout;
import javax.swing.*;
import java.sql.*;
import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class productos {
    JFrame fr11;
    JPanel pan11, pan12, pan13,pan14,pan15,pan16,pan17;
    JLabel lbl11, lbl12,lbl13,lbl14,lbl15,lbl17;
    JButton btn11,btn12,btn13,btn14,btn15,btn16;
    JTextField txt11,txt12,txt13,txt14,txt15,txt16,txt17;
    String cantidad;
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0,swu = 0;
    String sql ="";
    
    conexion mycon = new conexion();
    
    
    public productos(){
        con = mycon.conecta();
        
        fr11 = new JFrame("PRODUCTOS");
        
        lbl11 = new JLabel("ID producto   ");
        lbl12 = new JLabel("Nombre        ");
        lbl13 = new JLabel("Costo         ");
        lbl14 = new JLabel("Caducidad     ");
        lbl15 = new JLabel("Idproveedor   ");
        lbl17 = new JLabel("Cantidad      ");
        txt11 = new JTextField(25);
        txt12 = new JTextField(25);
        txt13 = new JTextField(25);
        txt14 = new JTextField(25);
        txt15 = new JTextField(5);
        txt16 = new JTextField(20);
        txt17 = new JTextField(10);
        
        btn11 = new JButton("Nuevo");
        btn12 = new JButton("Guardar");
        btn13 = new JButton("Modificar");
        btn14 = new JButton("Borrar");
        btn15 = new JButton("Consulta");
        btn16 = new JButton("Salir");
        
        
        
        pan11 = new JPanel(); pan12 = new JPanel(); pan13 = new JPanel();
        pan14 = new JPanel(); pan15 = new JPanel(); pan16 = new JPanel();
        pan17 = new JPanel();
    }
    
    public void usar(){
        fr11.setLayout(new GridLayout(7, 1));
        pan11.add(lbl11); pan11.add(txt11);
        pan12.add(lbl12); pan12.add(txt12);
        pan13.add(lbl13); pan13.add(txt13);
        pan14.add(lbl14); pan14.add(txt14);
        pan15.add(lbl15); pan15.add(txt15); pan15.add(txt16); 
        pan16.add(lbl17); pan16.add(txt17);
        pan17.add(btn11); pan17.add(btn12);pan17.add(btn13); pan17.add(btn14);
        pan17.add(btn15); pan17.add(btn16);
        
        
        fr11.add(pan11); fr11.add(pan12); fr11.add(pan13);
        fr11.add(pan14); fr11.add(pan15); fr11.add(pan16);
        fr11.add(pan17);
        fr11.setVisible(true); fr11.pack();
        fr11.setLocation(700, 400);
    
        //CONTROL Y ESPACIO
        //Escuchas de txt-------------------------------------------------------------------
        txt11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt11.getText().equals("")){
                    DesktopNotify.showDesktopMessage("ERROR", "El Id del proveedor es requerido", 3,5000);
                }
                else
                {txt12.requestFocusInWindow(); }
            }
        });
        
        txt12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt12.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El nombre del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El nombre del producto es requerido", 3,5000);
                }
                else
                {txt13.requestFocusInWindow(); }
            }
        });
        
        txt13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt13.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "La direccion del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "La cantidad de productos es requerido", 3,5000);
                }
                else
                {txt14.requestFocusInWindow(); }
            }
        });
        
        txt14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt14.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "La caducidad del producto es requerido", 3,5000);
                }
                else
                {txt15.requestFocusInWindow(); }
            }
        });
        
        txt15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt15.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El id del proveedor es requerido", 3,5000);
                }
                else
                consultaridproveedor();
                    if(swu ==0)
                        txt16.setText("");
                    else
                        btn12.requestFocusInWindow();}
            
        });
        
       
        
        
        //escuchas de botones--------------------------------------------------------
        btn11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevo();
            }
        });
        
        btn12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grabar();
                grabartinventario();
            }
        });
        
        btn13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificar();
                
            }
        });
        
        btn14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrar();
            }
        });
        
        btn15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultar();
            }
        });
        
        btn16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        
    }    
    
    public void nuevo(){ //----------------------------------nuevo
        String nulo="";
        txt11.setText(nulo);   txt12.setText(nulo);   txt13.setText(nulo);
        txt14.setText(nulo);   txt15.setText(nulo);   txt16.setText(nulo);
        txt17.setText(nulo);
        txt11.requestFocusInWindow();
    }
    
    
    public void grabar() { //------------------------------------ grabar
        sql = "insert into producto values(?, ?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, txt11.getText());
            stmt.setString(2, txt12.getText());
            stmt.setString(3, txt13.getText());
            stmt.setString(4, txt14.getText());
            stmt.setString(5, txt15.getText());

            sw = stmt.executeUpdate();

            if (sw != 0) {
                DesktopNotify.showDesktopMessage("BIEN", "Registro dado de alta con éxito", 1, 5000);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void grabartinventario() {
        sql = "";
        sql = "insert into inventario (IDproducto, nombre, costo, cantidad) values (?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, txt11.getText());
            stmt.setString(2, txt12.getText());
            stmt.setString(3, txt13.getText());
            stmt.setInt(4, Integer.parseInt(txt17.getText()));

            sw = stmt.executeUpdate();

            if (sw != 0) {
                DesktopNotify.showDesktopMessage("BIEN", "Registro dado de alta con éxito en inventario", 1, 5000);
                nuevo();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void modificar(){    //-----------------------------------modificar
        sql = "update producto set ";
        sql += "nombre='" + txt12.getText() + "' , ";
        sql += "costo='" + txt13.getText() + "' , ";
        sql += "caducidad='" + txt14.getText() + "' , ";
        sql += "Idproveedor='" + txt15.getText() + "'  ";
        sql += "where Idproducto='" + txt11.getText() + "'; ";
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
                if(sw != 0)
                {//JOptionPane.showMessageDialog(null, "Registro modificado con exito");
                    DesktopNotify.showDesktopMessage("MODIFICACION", "Registro modificado con exito", 1,5000);
                    nuevo();
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void borrar(){   //--------------------------------------------borrar
        sql = "delete from producto ";
        sql += "where Idproducto='" + txt11.getText() + "'";
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
                if(sw != 0)
                {//JOptionPane.showMessageDialog(null, "Registro borrado con exito");
                    DesktopNotify.showDesktopMessage("BORRAR", "Registro borrado con exito", 3,5000);
                    nuevo();
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void consultar() { //------------------------ consultar
        sw = 0;
        sql = "select * from producto ";
        sql += "where idproducto=?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, txt11.getText());
            tabla = stmt.executeQuery();
            while (tabla.next()) {
                sw = 1;
                txt12.setText(tabla.getString(2));
                txt13.setText(tabla.getString(3));
                txt14.setText(tabla.getString(4));
                txt15.setText(tabla.getString(5));
                consultaridproveedor();
                consultaridcantidad();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if (sw == 0) {
            DesktopNotify.showDesktopMessage("ERROR", "Registro inexistente", 3, 5000);
        }
    }
    
    public void consultaridproveedor(){    //------------------------ consultar
        sw = 0;
        swu = 0;
        sql = "select * from proveedores ";
        sql += "where Idproveedor=\"" + txt15.getText() + "\"";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    swu = 1;
                    txt16.setText(tabla.getString(2)); 
                    
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if(sw == 0)
        {
            //JOptionPane.showMessageDialog(null, "****Registro inexistente****");
            DesktopNotify.showDesktopMessage("ERROR", "Registro inexistente", 3,5000);
        }
    }
    
    public void consultaridcantidad(){    //------------------------ consultar
        sw = 0;
        swu = 0;
        sql = "select * from inventario ";
        sql += "where Idproducto=\"" + txt11.getText() + "\"";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    swu = 1;
                    txt17.setText(tabla.getString(4)); 
                    
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if(sw == 0)
        {
            //JOptionPane.showMessageDialog(null, "****Registro inexistente****");
            DesktopNotify.showDesktopMessage("ERROR", "Registro inexistente", 3,5000);
        }
    }
    
    public void salir(){        //-----------------------------------------salir
        sw = JOptionPane.showConfirmDialog(null, "En verdad deseas salir: ");
        if(sw == 0)
        {
            fr11.dispose();
            ProyectoBD mp = new ProyectoBD();
            mp.usar1();
        }
    }
    
    public static void main(String[] args) {
        productos myproductos = new productos(); 
        myproductos.usar();
    }
}
