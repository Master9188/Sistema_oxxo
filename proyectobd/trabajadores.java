
package proyectobd;
import java.awt.GridLayout;
import javax.swing.*;
import java.sql.*;
import DAO.conexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jdk.nashorn.internal.scripts.JO;
public class trabajadores {
    
    JFrame fr11;
    JPanel pan11, pan12, pan13,pan14,pan15,pan16,pan17, pan18,pan19,pan20;
    JLabel lbl11, lbl12,lbl13,lbl14,lbl15,lbl16,lbl17;
    JButton btn11,btn12,btn13,btn14,btn15,btn16;
    JTextField txt11,txt12,txt13,txt14,txt15,txt16,txt17;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0;
    String sql ="";
    
    conexion mycon = new conexion();
    
    
    public trabajadores(){
        
        con = mycon.conecta();
        //------------------como se llama la variable es importante
        fr11 = new JFrame("TRABAJADORES");
        
        lbl11 = new JLabel("ID trabadores");
        lbl12 = new JLabel("Nombre   ");
        lbl13 = new JLabel("Apepat  ");
        lbl14 = new JLabel("Apemat  ");
        lbl15 = new JLabel("Puesto");
        lbl16 = new JLabel("Sueldo");
        lbl17 = new JLabel("fecha ini");
        
        
        txt11 = new JTextField(5);
        txt12 = new JTextField(20);
        txt13 = new JTextField(15);
        txt14 = new JTextField(10);
        txt15 = new JTextField(25);
        txt16 = new JTextField(25);
        txt17 = new JTextField(25);
        
        btn11 = new JButton("Nuevo");
        btn12 = new JButton("Guardar");
        btn13 = new JButton("Modificar");
        btn14 = new JButton("Borrar");
        btn15 = new JButton("Consulta");
        btn16 = new JButton("Salir");
        
        pan11 = new JPanel(); pan12 = new JPanel(); pan13 = new JPanel();
        pan14 = new JPanel(); pan15 = new JPanel(); pan16 = new JPanel();
        pan17 = new JPanel(); 
        pan20 = new JPanel();

    }
    
    public void usar(){
        fr11.setLayout(new GridLayout(8, 1));
        pan11.add(lbl11); pan11.add(txt11); pan11.add(lbl12);  pan11.add(txt12); 
        pan13.add(lbl13); pan13.add(txt13); pan13.add(lbl14); pan13.add(txt14);
        pan14.add(lbl15); pan14.add(txt15);
        pan15.add(lbl16); pan15.add(txt16);
        pan16.add(lbl17); pan16.add(txt17);
        pan17.add(btn11); pan17.add(btn12);pan17.add(btn13); pan17.add(btn14);
        pan20.add(btn15); pan20.add(btn16);
        fr11.add(pan11); fr11.add(pan13); fr11.add(pan14);
        fr11.add(pan15); fr11.add(pan16);
        fr11.add(pan17); 
        fr11.add(pan20);
        fr11.setVisible(true); fr11.pack();
        fr11.setLocation(700, 300);
    
        //CONTROL Y ESPACIO
        //Escuchas de txt-------------------------------------------------------------------
        txt11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt11.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El id del trabajador es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El Id del trabajador es requerido", 3,5000);
                }
                else
                {txt12.requestFocusInWindow(); }
            }
        });
        
        txt12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt12.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "El nombre del trabajador es requerido: ");
                }
                else
                {txt13.requestFocusInWindow(); }
            }
        });
        
        txt13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt13.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El apepat del trabajador es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El apepat del trabajador es requerido", 3,5000);
                }
                else
                {txt14.requestFocusInWindow(); }
            }
        });
        
        txt14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt14.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El apemat del trabajador es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El apemat del trabajdor es requerido", 3,5000);
                }
                else
                {txt15.requestFocusInWindow(); }
            }
        });
        
        txt15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt15.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El puesto del trabajador es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El puesto del trabajador es requerido", 3,5000);
                }
                else
                {txt16.requestFocusInWindow(); }
            }
        });
        
        txt16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt16.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El sueldo del reprobado es requerido: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El sueldo del reprobado es requerido", 3,5000);
                }
                else
                {txt17.requestFocusInWindow(); }
            }
        });
        
        txt17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt17.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "El fecha inicio del trabajador es requerida: ");
                    DesktopNotify.showDesktopMessage("ERROR", "El fecha de inicio del trabajador es requerido", 3,5000);
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
        
    }    //----------------------usar---------------------
    
    public void nuevo(){ //----------------------------------nuevo
        String nulo="";
        txt11.setText(nulo);   txt12.setText(nulo);   txt13.setText(nulo);
        txt14.setText(nulo);   txt15.setText(nulo);   txt16.setText(nulo);
        txt17.setText(nulo);   
        txt11.requestFocusInWindow();
    }
    
    public void grabar(){   //------------------------------------ grabar
        sql = "insert into trabajadores values(";
        sql += "\"" + txt11.getText() + "\" , ";
        sql += "\"" + txt12.getText() + "\" , ";
        sql += "\"" + txt13.getText() + "\" , ";
        sql += "\"" + txt14.getText() + "\" , ";
        sql += "\"" + txt15.getText() + "\" , ";
        sql += "\"" + txt16.getText() + "\" , "; 
        sql += "\"" + txt17.getText() + "\" ) ";
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
        sql = "update trabajadores set ";
        sql += "nombre='" + txt12.getText() + "' , ";
        sql += "apepat='" + txt13.getText() + "' , ";
        sql += "apemat='" + txt14.getText() + "' , ";
        sql += "puesto='" + txt15.getText() + "' , ";
        sql += "sueldo='" + txt16.getText() + "' , ";
        sql += "fecnaini='" + txt17.getText() + "' , "; 
        sql += "where idtrabajador='" + txt11.getText() + "'; ";
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
        sql = "delete from trabajadores ";
        sql += "where idtrabajador='" + txt11.getText() + "'";
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
        sql = "select * from trabajadores ";
        sql += "where idtrabajador=\"" + txt11.getText() + "\"";
        
        System.out.println(sql);
        try
        {
            stmt = con.prepareStatement(sql);
            tabla = stmt.executeQuery();
                while(tabla.next())
                {
                    sw = 1;
                    txt12.setText(tabla.getString(2)); txt13.setText(tabla.getString(3));
                    txt14.setText(tabla.getString(4)); txt15.setText(tabla.getString(5));
                    txt16.setText(tabla.getString(6)); txt17.setText(tabla.getString(7));
                    
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
        trabajadores mytrabajadores = new trabajadores(); 
        mytrabajadores.usar();
    }
    
    
}
