
package proyectobd;
import ds.desktop.notify.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import DAO.conexion;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login {

    JLabel textousuario, textopassword, imagen1;
    JTextField cajausuario;
    JPasswordField cajapassword;
    JButton btn11;
    JFrame fr11;
    JPanel pan11, pan12, pan13, pan14;
    Connection con;
    PreparedStatement stmt;
    ResultSet tabla;
    int sw = 0;
    String sql ="";
    conexion mycon = new conexion();
    Date fechasistema = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fechactual = sdf.format(fechasistema);

    ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/imagen chica oxxo.jpg"));

    Login(){

        fr11 = new JFrame("LOGIN");
        textousuario = new JLabel("Usuario:");
        textopassword = new JLabel("Password:");
        cajausuario = new JTextField(15);
        cajapassword = new JPasswordField(15);
        btn11 = new JButton("Acceso");
        pan11 = new JPanel();
        pan12 = new JPanel();
        pan13 = new JPanel();
        pan14 = new JPanel();
        imagen1 = new JLabel(icon);
        con = mycon.conecta();

        fr11.setLayout(new BorderLayout());
        pan14.add(imagen1);
        fr11.add(pan14, BorderLayout.NORTH);

        pan11.add(textousuario);
        pan11.add(cajausuario);

        pan12.add(textopassword);
        pan12.add(cajapassword);

        pan13.add(btn11);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        centerPanel.add(pan11);
        centerPanel.add(pan12);
        centerPanel.add(pan13);

        fr11.add(centerPanel, BorderLayout.CENTER);

        fr11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr11.pack();
        fr11.setSize(400, 350);
        fr11.setLocationRelativeTo(null);
    }

    public void usar2(){
        //con = mycon.conecta();//--------------conectar base de datos

        //-----------------------escuchas
        cajausuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cajausuario.getText().trim().isEmpty()){
                    DesktopNotify.showDesktopMessage("ERROR", "El id del usuario es obligatorio", 3, 5000);
                } else {
                    cajapassword.requestFocusInWindow();
                }
            }
        });

        cajapassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cajapassword.getText().trim().isEmpty()){
                    DesktopNotify.showDesktopMessage("ERROR", "El password es obligatorio", 3, 5000);
                } else {
                    btn11.requestFocusInWindow();
                }
            }
        });

        btn11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valida();
            }
        });

        fr11.setVisible(true);
    }

    public void valida(){
        sql = "select * from usuarios where idusuario='" + cajausuario.getText();
    sql += "' and password='" + cajapassword.getText() + "'";
    System.out.println(sql);
    sw = 0;
    try {
        stmt = con.prepareStatement(sql);
        tabla = stmt.executeQuery();
        while (tabla.next()) {
            sw = 1;
            String status = tabla.getString("status"); // Obtener el valor de la columna "status"
            if (status.equals("in")) {
            sw = 2;
            } else {
                String fechaTabla = tabla.getString(4);
                if (fechaTabla.equals(fechactual)) {
                    sw = 3;
                } else if (fechaTabla.compareTo(fechactual) > 0) {
                    sw = 4;
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());}
        if(sw == 0)
            DesktopNotify.showDesktopMessage("ERROR", "Usuario inexistente", 3,5000);
        if(sw == 2)
            DesktopNotify.showDesktopMessage("ERROR", "Usuario inactivo, Contacta a sistemas", 3,5000);
        if(sw == 3){        //----------------------------------para que pase al menu si se acepta 
            fr11.dispose();
            barra mybarra = new barra();
            mybarra.usar();
        
        }
        if(sw == 4){
            fr11.dispose();
            barra mybarra = new barra();
            mybarra.usar();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login mylogin = new Login();
            mylogin.usar2();
        });
    }
}
