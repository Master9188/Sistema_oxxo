
package proyectobd;
import java.awt.GridLayout;
import javax.swing.*;
import java.sql.*;
import DAO.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class proveedores {
    JFrame fr11;
    JPanel pan11, pan12, pan13,pan14,pan15,pan16;
    JLabel lbl11, lbl12,lbl13,lbl14;
    JButton btn11,btn12,btn13,btn14,btn15,btn16;
    JTextField txt11,txt12,txt13,txt14;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0;
    String sql ="";
    
    conexion mycon = new conexion();
    
    
    public proveedores(){
        con = mycon.conecta();
        
        fr11 = new JFrame("PROVEEDORES");
        
        lbl11 = new JLabel("ID proveedor     ");
        lbl12 = new JLabel("Nombre empresa   ");
        lbl13 = new JLabel("Direccion        ");
        lbl14 = new JLabel("Telefono         ");
        
        txt11 = new JTextField(25);
        txt12 = new JTextField(25);
        txt13 = new JTextField(25);
        txt14 = new JTextField(25);
        
        btn11 = new JButton("Nuevo");
        btn12 = new JButton("Guardar");
        btn13 = new JButton("Modificar");
        btn14 = new JButton("Borrar");
        btn15 = new JButton("Consulta");
        btn16 = new JButton("Salir");
        
        
        
        pan11 = new JPanel(); pan12 = new JPanel(); pan13 = new JPanel();
        pan14 = new JPanel(); pan15 = new JPanel(); pan16 = new JPanel();
        
        
        
        
    }
    
    public void usar(){
        fr11.setLayout(new GridLayout(6, 1));
        pan11.add(lbl11); pan11.add(txt11);
        pan12.add(lbl12); pan12.add(txt12);
        pan13.add(lbl13); pan13.add(txt13);
        pan14.add(lbl14); pan14.add(txt14);
        
        pan16.add(btn11); pan16.add(btn12);pan16.add(btn13); pan16.add(btn14);
        pan16.add(btn15); pan16.add(btn16);
        fr11.add(pan11); fr11.add(pan12); fr11.add(pan13);
        fr11.add(pan14); fr11.add(pan15); fr11.add(pan16);
        
        fr11.setVisible(true); fr11.pack();
        fr11.setLocation(700, 400);
    
        //CONTROL Y ESPACIO
        //Escuchas de txt-------------------------------------------------------------------
        txt11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt11.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "El id del proveedor es requerido: ");
                }
                else
                {txt12.requestFocusInWindow(); }
            }
        });
        
        txt12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt12.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "El nombre del proveedor es requerido: ");
                }
                else
                {txt13.requestFocusInWindow(); }
            }
        });
        
        txt13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt13.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "La direccion del proveedor es requerido: ");
                }
                else
                {txt14.requestFocusInWindow(); }
            }
        });
        
        txt14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt14.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                }
                else
                {btn11.requestFocusInWindow(); }
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
        
    }    //----------------------usar 
    
    
    public void nuevo(){ //----------------------------------nuevo
        String nulo="";
        txt11.setText(nulo);   txt12.setText(nulo);   txt13.setText(nulo);
        txt14.setText(nulo);   
        txt11.requestFocusInWindow();
    }
    
    
    public void grabar(){   //------------------------------------ grabar
        sql = "insert into proveedores values(";
        sql += "\"" + txt11.getText() + "\" , ";
        sql += "\"" + txt12.getText() + "\" , ";
        sql += "\"" + txt13.getText() + "\" , ";
        sql += "\"" + txt14.getText() + "\" ) ";
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
                if(sw != 0)
                {JOptionPane.showMessageDialog(null, "Registro dado de alta con exito");
                    nuevo();
                }
        }
        catch(SQLException e){
        }
    }
    
    public void modificar(){    //-----------------------------------modificar
        sql = "update proveedores set ";
        sql += "nombreempresa='" + txt12.getText() + "' , ";
        sql += "direccion='" + txt13.getText() + "' , ";
        sql += "telefono='" + txt14.getText() + "'  ";
        sql += "where idproveedor='" + txt11.getText() + "'; ";
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
                if(sw != 0)
                {JOptionPane.showMessageDialog(null, "Registro modificado con exito");
                    nuevo();
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void borrar(){   //--------------------------------------------borrar
        sql = "delete from proveedores ";
        sql += "where idproveedor='" + txt11.getText() + "'";
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
                if(sw != 0)
                {JOptionPane.showMessageDialog(null, "Registro borrado con exito");
                    nuevo();
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void consultar(){    //------------------------ consultar
        sw = 0;
        sql = "select * from proveedores ";
        sql += "where idproveedor=\"" + txt11.getText() + "\"";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    txt12.setText(tabla.getString(2)); txt13.setText(tabla.getString(3));
                    txt14.setText(tabla.getString(4)); 
                    
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if(sw == 0)
        {JOptionPane.showMessageDialog(null, "****Registro inexistente****");}
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
        proveedores myproveedores = new proveedores(); 
        myproveedores.usar();
    }
}





