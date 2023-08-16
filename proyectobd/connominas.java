
package proyectobd;

import java.awt.GridLayout;
import javax.swing.*;
import java.sql.*;
import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class connominas {
    JFrame fr11;
    JPanel pan11, pan12, pan13,pan14,pan15,pan16,pan17,pan18;
    JLabel lbl11, lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18;
    JButton btn11,btn15,btn16;
    JTextField txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0,swu = 0;
    String sql ="";
    
    conexion mycon = new conexion();
    
    
    public connominas(){
        con = mycon.conecta();
        
        fr11 = new JFrame("NOMINAS");
        
        lbl11 = new JLabel("ID nomina");
        lbl12 = new JLabel("ID trabajador");
        lbl13 = new JLabel("nombre");
        lbl14 = new JLabel("sueldo");
        lbl15 = new JLabel("ispt");
        lbl16 = new JLabel("Subsidio");
        lbl17 = new JLabel("Total");
        lbl18 = new JLabel("P. Quincenal");
        
        
        txt11 = new JTextField(5);
        txt12 = new JTextField(5);
        txt13 = new JTextField(25);
        txt13.setEditable(false);
        txt14 = new JTextField(25);
        txt14.setEditable(false);
        txt15 = new JTextField(20);
        txt15.setEditable(false);
        txt16 = new JTextField(20);
        txt16.setEditable(false);
        txt17 = new JTextField(20);
        txt17.setEditable(false);
        txt18 = new JTextField(20);
        txt18.setEditable(false);
        
        btn11 = new JButton("Nuevo");
        btn15 = new JButton("Consulta");
        btn16 = new JButton("Salir");
        
        
        
        pan11 = new JPanel(); pan12 = new JPanel(); pan13 = new JPanel();
        pan14 = new JPanel(); pan15 = new JPanel(); pan16 = new JPanel();
        pan17 = new JPanel(); pan18 = new JPanel(); 
    }
    
    public void usar(){
        fr11.setLayout(new GridLayout(8, 1));
        pan11.add(lbl11); pan11.add(txt11);
        pan12.add(lbl12); pan12.add(txt12); pan12.add(lbl13); pan12.add(txt13);
        pan13.add(lbl14); pan13.add(txt14);
        pan14.add(lbl15); pan14.add(txt15); 
        pan15.add(lbl16); pan15.add(txt16);
        pan16.add(lbl17); pan16.add(txt17); 
        pan17.add(lbl18); pan17.add(txt18); 
        
        pan18.add(btn11); 
        pan18.add(btn15); pan18.add(btn16);
        
        
        fr11.add(pan11); fr11.add(pan12); fr11.add(pan13);
        fr11.add(pan14); fr11.add(pan15); fr11.add(pan16);
        fr11.add(pan17); fr11.add(pan18);
        
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
                {txt12.requestFocusInWindow(); }
            }
        });
        
        txt12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt12.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El nombre del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El nombre del provvedor es requerido", 3,5000);
                }
                else
                {txt13.requestFocusInWindow(); }
            }
        });
        
        txt13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt13.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "La direccion del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "La direccion del proveedor es requerido", 3,5000);
                }
                else
                {txt14.requestFocusInWindow(); }
            }
        });
        
        txt14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt14.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El Telefono del proveedor es requerido", 3,5000);
                }
                else
                {txt15.requestFocusInWindow(); }
            }
        });
        
        txt15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt15.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El telefono del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El telefono del proveedor es requerido", 3,5000);
                }
                else
                btn15.requestFocusInWindow();}
            
        });
        
       
        
        
        //escuchas de botones--------------------------------------------------------
        btn11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevo();
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
    

    
    public void consultar(){    //------------------------ consultar
        sw = 0;
        sql = "select * from nominas where idnomina='" + txt11.getText() + "' and idtrabajador='";
        sql += txt12.getText() + "'";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    txt13.setText(tabla.getString(3));
                    txt14.setText(tabla.getString(4)); txt15.setText(tabla.getString(5));
                    txt16.setText(tabla.getString(6)); txt17.setText(tabla.getString(7));
                    txt18.setText(tabla.getString(8)); 
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
        connominas myconnomina = new connominas(); 
        myconnomina.usar();
    }
}
