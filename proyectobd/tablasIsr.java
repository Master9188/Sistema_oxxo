
package proyectobd;

import java.sql.*;
import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class tablasIsr {
    //FORMULARIO PARA ACTUALIZAR TABLAS
    
    JFrame fr1;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6;
    JButton btn1, btn2,btn3,btn4,btn5,btn6;
    JPanel pan1,pan2,pan3,pan4,pan5,pan6,pan7, pan8;
    String nulo = "";
    //--------------para conexion sql
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    conexion mycon = new conexion();
    int sw = 0;
    
    String sql = "";
    
    tablasIsr(){
        //Concectar tablas
        con = mycon.conecta();
        lbl1 = new JLabel("Id tablas");
        lbl2 = new JLabel("R  englon");
        lbl3 = new JLabel("Lim.  inf");
        lbl4 = new JLabel("Lim.  sup");
        lbl5 = new JLabel("cu o  ta ");
        lbl6 = new JLabel("POrcent. ");
        
        txt1 = new JTextField(15); txt2 = new JTextField(15);
        txt3 = new JTextField(15); txt4 = new JTextField(15);
        txt5 = new JTextField(15); txt6 = new JTextField(15);
        
        pan1 = new JPanel(); pan2 = new JPanel();
        pan3 = new JPanel(); pan4 = new JPanel();
        pan5 = new JPanel(); pan6 = new JPanel();
        pan7 = new JPanel(); pan8 = new JPanel();
        
        btn1 = new JButton("Nuevo");
        btn2 = new JButton("Grabar");
        btn3 = new JButton("Modificar");
        btn4 = new JButton("Consultar");
        btn5 = new JButton("Borrar");
        btn6 = new JButton("Salir");
        
        fr1 = new JFrame("Tablas de ISR");
    }
    
    public void usar(){
        fr1.setLayout(new GridLayout(8,1));
        pan1.add(lbl1); pan1.add(txt1);
        pan2.add(lbl2); pan2.add(txt2);
        pan3.add(lbl3); pan3.add(txt3);
        pan4.add(lbl4); pan4.add(txt4);
        pan5.add(lbl5); pan5.add(txt5);
        pan6.add(lbl6); pan6.add(txt6);
        pan7.add(btn1); pan7.add(btn2);pan7.add(btn3); pan7.add(btn4);
        pan8.add(btn5); pan8.add(btn6);
        
        fr1.add(pan1); fr1.add(pan2); fr1.add(pan3); fr1.add(pan4);
        fr1.add(pan5); fr1.add(pan6); fr1.add(pan7); fr1.add(pan8);
        
        fr1.setVisible(true); fr1.pack();
        fr1.setLocation(700, 400);
        
        
        txt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt1.getText().equals(nulo)){
                DesktopNotify.showDesktopMessage("ERROR", "El id la tabla es requerido", 3,5000);
                }else{
                    txt2.requestFocusInWindow();
                }
            }     
        });
        
        txt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt2.getText().equals(nulo)){
                DesktopNotify.showDesktopMessage("ERROR", "El renglon es requerido", 3,5000);
                }else{
                    txt3.requestFocusInWindow();
                }
            }     
        });
        
        txt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt3.getText().equals(nulo)){
                DesktopNotify.showDesktopMessage("ERROR", "El limite inferior es requerido", 3,5000);
                }else{
                    txt4.requestFocusInWindow();
                }
            }     
        });
        
        txt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt4.getText().equals(nulo)){
                DesktopNotify.showDesktopMessage("ERROR", "El id del edificio es requerido", 3,5000);
                }else{
                    txt5.requestFocusInWindow();
                }
            }     
        });
        
        txt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt5.getText().equals(nulo)){
                DesktopNotify.showDesktopMessage("ERROR", "La cuota es requerida", 3,5000);
                }else{
                    txt6.requestFocusInWindow();
                }
            }     
        });
        
        txt6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt6.getText().equals(nulo)){
                DesktopNotify.showDesktopMessage("ERROR", "El porcentaje es requerido", 3,5000);
                }else{
                    btn1.requestFocusInWindow();
                }
            }     
        });
        
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevo();
            }     
        });
        
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grabar();
            }     
        });
        
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modificar();
            }     
        });
        
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultar();
            }     
        });
        
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrar();
            }     
        });
        
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir();
            }     
        });
    }
    
    public void nuevo(){
        txt1.setText(nulo); txt2.setText(nulo); txt3.setText(nulo);
        txt4.setText(nulo); txt5.setText(nulo); txt6.setText(nulo);
        txt1.requestFocusInWindow();
    }
    
    public void grabar(){
        try {
            sql = "insert into tablasisr values(";
            sql += "'" + txt1.getText() + "',";
            sql += "'" + txt2.getText() + "',";
            sql += "'" + txt3.getText() + "',";
            sql += "'" + txt4.getText() + "',";
            sql += "'" + txt5.getText() + "',";
            sql += "'" + txt6.getText() + "')";
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
            
            if(sw != 0){
                DesktopNotify.showDesktopMessage("BIEN", "Registro dado de alta con exito", 1,5000);
            }
        } catch (SQLException e) {
           DesktopNotify.showDesktopMessage("ERROR", "Error en algo", 3,5000); 
        }
    }
    
    public void Modificar() {
        try{
            sql = "update tablaisr set ";
            sql += "liminf='" + txt3.getText() + "',";
            sql += "limsup='" + txt4.getText() + "',";
            sql += "cuota='" + txt5.getText() + "',";
            sql += "porcen='" + txt6.getText() + "',";
            sql += "where idtabla='" + txt1.getText() + "' and";
            sql += "renglon'" + txt2.getText() + "',";
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
            if(sw!=0)
            DesktopNotify.showDesktopMessage("Error", "Error",1,3000);    
        }catch (SQLException e){
            DesktopNotify.showDesktopMessage("Error", "Registro modificado con exito",1,3000);
        }
    }
    
    public void consultar(){
        try {
            sql = "select * from tablasisr where idtabla='" + txt1.getText() + "' and renglon='";
            sql += txt2.getText() + "'";
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
            
            while(tabla.next()){ 
                sw = 1;
                txt3.setText(tabla.getString(3)); txt4.setText(tabla.getString(4));
                txt5.setText(tabla.getString(5)); txt6.setText(tabla.getString(6));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if(sw == 0){
            DesktopNotify.showDesktopMessage("ERROR", "Registro inexistente", 3,5000); 
        }
    }
    
    public void borrar(){
        try {
            sql = "delete from tablasisr ";
            sql += " where idtabla'" + txt1.getText() + "'and ";
            sql += " renglon='" + txt2.getText() + "'";
            sql += txt2.getText() + "'";
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
            
            if(sw != 0){
                DesktopNotify.showDesktopMessage("BORRAR", "Borrado con exito", 1,5000);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void salir(){
        sw = JOptionPane.showConfirmDialog(null, "¿En verdad deseas salir?");
        if (sw ==0)
        fr1.dispose();
        ProyectoBD mp = new ProyectoBD();
        mp.usar1();
    }
    
    public static void main(String[] args) {
        tablasIsr mytablasisr = new tablasIsr();
        mytablasisr.usar();
    }
}
