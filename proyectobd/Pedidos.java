
package proyectobd;

import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pedidos {
    JFrame fr11;
    JPanel pan11, pan12, pan13,pan14,pan15,pan16,pan17,pan18;
    JLabel lbl11, lbl12,lbl13,lbl14,lbl15,lbl16,lbl18;
    JButton btn11,btn12,btn13,btn14,btn15,btn16;
    JTextField txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0,swu = 0;
    String sql ="";
    
    conexion mycon = new conexion();
    
    public Pedidos(){
        con = mycon.conecta();
        
        fr11 = new JFrame("PEDIDOS A PROVEEDORES");
        
        lbl11 = new JLabel("ID pedido");
        lbl12 = new JLabel("ID producto");
        lbl13 = new JLabel("Producto");
        lbl14 = new JLabel("Cantidad");
        lbl15 = new JLabel("fecha pedido");
        lbl16 = new JLabel("fecha llegada");
        lbl18 = new JLabel("ID proveedor");
        
        txt11 = new JTextField(5);
        txt12 = new JTextField(5);
        txt13 = new JTextField(25);
        txt14 = new JTextField(25);
        txt15 = new JTextField(25);
        txt16 = new JTextField(25);
        txt17 = new JTextField(25);
        txt18 = new JTextField(5);
        
        btn11 = new JButton("Nuevo");
        btn12 = new JButton("Guardar");
        btn13 = new JButton("Modificar");
        btn14 = new JButton("Borrar");
        btn15 = new JButton("Consulta");
        btn16 = new JButton("Salir");
        
        
        
        pan11 = new JPanel(); pan12 = new JPanel(); pan13 = new JPanel();
        pan14 = new JPanel(); pan15 = new JPanel(); pan16 = new JPanel();
        pan17 = new JPanel(); pan18 = new JPanel();
        
    }
    
    public void usar(){
        fr11.setLayout(new GridLayout(8, 1));
        pan11.add(lbl11); pan11.add(txt11);  
        pan12.add(lbl12); pan12.add(txt12); pan12.add(txt13);
        pan13.add(lbl18); pan13.add(txt18); pan13.add(txt17);
        pan14.add(lbl14); pan14.add(txt14); 
        pan15.add(lbl15); pan15.add(txt15); 
        pan16.add(lbl16); pan16.add(txt16); 
        
        
        pan17.add(btn11); pan17.add(btn12);pan17.add(btn13); pan17.add(btn14);
        pan18.add(btn15); pan18.add(btn16);
        
        fr11.add(pan11); fr11.add(pan12); fr11.add(pan13);
        fr11.add(pan14); fr11.add(pan15); fr11.add(pan16); fr11.add(pan17);
        fr11.add(pan18);
        
        fr11.setVisible(true); fr11.pack();
        fr11.setLocation(700, 300);
    
        //CONTROL Y ESPACIO
        //Escuchas de txt-------------------------------------------------------------------
        txt11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt11.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El id del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El Id del proveedor es requerido", 3,5000);
                }
                else
                {
                        txt12.requestFocusInWindow();
                
                }
            }
        });
        
        txt12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt12.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El nombre del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El Id del producto es requerido", 3,5000);
                }
                else
                {
                    consultaridproducto();
                    if(swu ==0)
                        txt12.setText("");
                    else
                        txt13.requestFocusInWindow();
                }
            }
        });
        
        
        txt14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt14.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "La cantidad solicitada es requerida", 3,5000);
                }
                else
                {txt15.requestFocusInWindow(); }
            }
        });
        
        txt15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt15.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR","La fecha de pedido es requerdo", 3,5000);
                }
                else
                txt16.requestFocusInWindow(); 
            }
            
        });
        
        txt15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt15.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR","La fecha de llegada se tiene que imprimir sola", 3,5000);
                }
                else
                btn11.requestFocusInWindow(); 
            }
            
        });
        
        txt16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt16.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR","La fecha de llegada se tiene que imprimir sola", 3,5000);
                }
                else
                txt17.requestFocusInWindow(); 
            }
            
        });
        
        
        txt18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt18.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR","El Id del proveedor es requerido", 3,5000);
                }
                else
                    consultaridproveedor();
                    if(swu ==0)
                        txt18.setText("");
                    
            }
            
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
        txt17.setText(nulo);   txt18.setText(nulo);
        txt11.requestFocusInWindow();
    }
    
    
    public void grabar(){   //------------------------------------ grabar
        sql = "insert into pedidosproveedores values(";
        sql += "\"" + txt11.getText() + "\" , ";
        sql += "\"" + txt12.getText() + "\" , ";
        sql += "\"" + txt18.getText() + "\" , ";
        sql += "\"" + txt13.getText() + "\" , ";
        sql += "\"" + txt17.getText() + "\" , ";
        sql += "\"" + txt14.getText() + "\" , ";
        sql += "\"" + txt15.getText() + "\" , ";
        sql += "\"" + txt16.getText() + "\" ) ";
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
                if(sw != 0)
                {//JOptionPane.showMessageDialog(null, "Registro dado de alta con exito");
                    DesktopNotify.showDesktopMessage("BIEN", "Registro dado de alta con exito", 1,5000);
                    nuevo();
                }
        }
        catch(SQLException e){
        }
    }
    
    public void modificar(){    //-----------------------------------modificar
        sql = "update pedidosproveedores set ";
        sql += "idproducto='" + txt12.getText() + "' , ";
        sql += "idproveedor='" + txt18.getText() + "' , ";
        sql += "producto='" + txt13.getText() + "' , ";
        sql += "nomproveedor='" + txt17.getText() + "' , ";
        sql += "cantidad='" + txt14.getText() + "' , ";
        sql += "fechapedido='" + txt15.getText() + "' , ";
        sql += "fechaquere='" + txt16.getText() + "'  ";
        sql += "where idpedido='" + txt11.getText() + "'; ";
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
        sql = "delete from pedidosproveedores ";
        sql += "where Idpedido='" + txt11.getText() + "'";
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
    
    public void consultar(){    //------------------------ consultar
        sw = 0;
        sql = "select * from pedidosproveedores where idpedido=\"" + txt11.getText() + "\"";
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    txt12.setText(tabla.getString(2));
                    txt13.setText(tabla.getString(4));
                    txt18.setText(tabla.getString(3)); 
                    txt17.setText(tabla.getString(5));
                    txt14.setText(tabla.getString(6)); 
                    txt15.setText(tabla.getString(7));
                    txt16.setText(tabla.getString(8));
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
    
    public void consultaridproveedor(){    //------------------------ consultar
        sw = 0;
        swu = 0;
        sql = "select * from proveedores ";
        sql += "where Idproveedor=\"" + txt18.getText() + "\"";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    swu = 1;
                    txt17.setText(tabla.getString(2)); 
                    
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
    
    public void consultaridproducto(){    //------------------------ consultar
        sw = 0;
        swu = 0;
        sql = "select * from producto ";
        sql += "where Idproducto=\"" + txt12.getText() + "\"";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    swu = 1;
                    txt13.setText(tabla.getString(2)); 
                    
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
        Pedidos mypedidos = new Pedidos();
        mypedidos.usar();
    }
    
}
