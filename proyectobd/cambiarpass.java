
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class cambiarpass {
    JLabel lbl11, lbl12,lbl13;
    JTextField txt11;
    JPasswordField txt12,txt13;
    JButton btn11;
    JFrame fr11;
    JPanel pan11, pan12, pan13,pan14;
    //--------------para la base de datos(
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0;
    String sql ="";
    conexion mycon = new conexion();
    //----------------------------------------)
    
    //-------para fecha
    Date fechasistema = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fechactual = sdf.format(fechasistema);
    
    //Otra forma de sacar fecha del sistema y sumarle dias
    //LocalDateTime today = LocalDateTime.now(); 
    //LocalDateTime tomorrow = today.plusDays(30);
    
    
    
    //constructor por default
    //nivel de clase, variables de clase
    String usu, pas;   
    
    cambiarpass(String usu, String pas){
        
        this.usu = usu;
        this.pas = pas;
        fr11 = new JFrame("CAMBIA PASSWORD");
        lbl11 = new JLabel("Passoword actual");
        lbl12 = new JLabel("Nuevo Password");
        lbl13 = new JLabel("Confirma Password");
        txt11 = new JTextField(25);
        
        txt11.setText(pas);
        txt11.setEditable(false);               //para no moverle o escribirle
        
        txt12 = new JPasswordField(25);
        txt13 = new JPasswordField(25);
        btn11 = new JButton("Acceder");
        
        pan11 = new JPanel(); pan12 = new JPanel(); pan13 = new JPanel(); pan14 = new JPanel();
        
        System.out.println("fecha del sistema " + fechasistema + 
                "fecha actual " + fechactual);
        
    }
    
    
    public void usar2(){
        con = mycon.conecta();//--------------conectar base de datos
        
        fr11.setLayout(new GridLayout(4, 1));
        pan11.add(lbl11); pan11.add(txt11);
        pan12.add(lbl12); pan12.add(txt12);
        pan13.add(lbl13); pan13.add(txt13); 
        pan14.add(btn11); 
        fr11.add(pan11); fr11.add(pan12); fr11.add(pan13); fr11.add(pan14);
        fr11.setVisible(true); fr11.pack();
        fr11.setLocation(700, 300);
        txt12.requestFocusInWindow();
        
    //-----------------------escuchas
        txt12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt12.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "*** El Password nuevo es obligatorio***");
                    DesktopNotify.showDesktopMessage("ERROR", "El Password nuevo es obligatorio", 3,8000);
                }
                else
                {
                    if(txt11.getText().equals(txt12.getText())){
                        //JOptionPane.showMessageDialog(null, "***El password actual y nuevo deben ser diferentes***");
                        DesktopNotify.showDesktopMessage("ERROR", "El Password actual y nuevo deben ser diferentes", 3,8000);
                    }
                    else
                        txt13.requestFocusInWindow(); }
            }
        });
        
        txt13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt13.getText().equals("")){
                    //JOptionPane.showMessageDialog(null, "*** El confirma password es obligatorio ***");
                    DesktopNotify.showDesktopMessage("ERROR", "El confirmar password es obligatorio", 3,5000);
                }
                else
                {
                    if(txt12.getText().equals(txt13.getText())){
                        btn11.requestFocusInWindow();
                    }
                    else
                        //JOptionPane.showMessageDialog(null, "*** El nuevo y confirma deben ser iguales ***");
                        DesktopNotify.showDesktopMessage("ERROR", "El nuevo y confirma deben ser iguales", 3,5000);
                        }
            }
        });
        
        btn11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valida();
            }
        });
    }            
    
    public Date sumarDiasFecha(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        return calendar.getTime();
    }
    
    public void valida(){
            java.util.Date fechasistema = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechasistema = sumarDiasFecha(fechasistema);
            String fechaactual = sdf.format(fechasistema);
            
            sql = "update usuarios set ";
            sql += "password='" + txt13.getText() + "',";
            sql += " fecvento='" + fechactual + "'";
            sql += " where idusuario='" + this.usu + "'";
            System.out.println(sql);
            sw = 0;
        try {
            stmt = con.prepareStatement(sql);
            sw = stmt.executeUpdate();
            if(sw!=0){
                fr11.dispose();
                Login mylogin = new Login();
                mylogin.usar2();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());}
        }
    
    
    
    
    public static void main(String[] args) {
        cambiarpass mycambia = new cambiarpass("user","password");
        mycambia.usar2();
    }
    
}
