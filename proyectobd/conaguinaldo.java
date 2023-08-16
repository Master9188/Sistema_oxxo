
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

public class conaguinaldo {
    
    JFrame fr11;
    JPanel pan11, pan12, pan13,pan14,pan15,pan16,pan17,pan18;
    JLabel lbl11, lbl12,lbl13,lbl14,lbl15,lbl16;
    JButton btn11,btn15,btn16;
    JTextField txt11,txt12,txt13,txt14,txt15,txt16;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0,swu = 0;
    String sql ="";
    
    conexion mycon = new conexion();
    
    
    public conaguinaldo(){
        con = mycon.conecta();
        
        fr11 = new JFrame("Aguinaldos");
        
        lbl11 = new JLabel("ID aguinaldo");
        lbl12 = new JLabel("ID trabajador");
        lbl13 = new JLabel("nombre");
        lbl14 = new JLabel("sueldo");
        lbl15 = new JLabel("Aguinaldo");
        lbl16 = new JLabel("Dias trabajados");
        
        
        txt11 = new JTextField(5);
        txt12 = new JTextField(5);
        txt12.setEditable(false);
        txt13 = new JTextField(25);
        txt13.setEditable(false);
        txt14 = new JTextField(25);
        txt14.setEditable(false);
        txt15 = new JTextField(20);
        txt15.setEditable(false);
        txt16 = new JTextField(20);
        txt16.setEditable(false);
       
        
        btn11 = new JButton("Nuevo");
        btn15 = new JButton("Consulta");
        btn16 = new JButton("Salir");
        
        
        
        pan11 = new JPanel(); pan12 = new JPanel(); pan13 = new JPanel();
        pan14 = new JPanel(); pan15 = new JPanel(); pan16 = new JPanel();
        pan17 = new JPanel(); pan18 = new JPanel(); 
    }
    
    public void usar(){
        fr11.setLayout(new GridLayout(6, 1));
        pan11.add(lbl11); pan11.add(txt11);
        pan12.add(lbl12); pan12.add(txt12); pan12.add(lbl13); pan12.add(txt13);
        pan13.add(lbl14); pan13.add(txt14);
        pan14.add(lbl15); pan14.add(txt15); 
        pan15.add(lbl16); pan15.add(txt16);
        
        pan18.add(btn11); 
        pan18.add(btn15); pan18.add(btn16);
        
        
        fr11.add(pan11); fr11.add(pan12); fr11.add(pan13);
        fr11.add(pan14); fr11.add(pan15); fr11.add(pan18);
        
        fr11.setVisible(true); fr11.pack();
        fr11.setLocation(700,300);
    
        //CONTROL Y ESPACIO
        //Escuchas de txt-------------------------------------------------------------------
        txt11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt11.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El id del proveedor es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El Id del aguinaldo es requerido", 3,5000);
                }
                else
                {txt12.requestFocusInWindow(); }
            }
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
        txt11.requestFocusInWindow();
    }
    

    
    public void consultar(){    //------------------------ consultar
        sw = 0;
        sql = "select * from aguinaldo ";
        sql += "where idaguinaldo=\"" + txt11.getText() + "\"";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    txt12.setText(tabla.getString(2));
                    txt13.setText(tabla.getString(3));
                    txt14.setText(tabla.getString(4)); txt15.setText(tabla.getString(5));
                    txt16.setText(tabla.getString(6)); 
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
        conaguinaldo myconaguinaldo = new conaguinaldo();
        myconaguinaldo.usar();
    }
}

    
