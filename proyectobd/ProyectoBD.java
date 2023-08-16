
package proyectobd;

import DAO.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

//para el pdf
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ProyectoBD {
    
    Connection con;
    conexion mycon = new conexion();
    
    JFrame fr1; //para la hoja
    JMenu menu1, menu2, menu3, menu4, menu5;  //para lo menus de arriba
    JMenuItem menu11, menu12, menu13, menu14, menu15, menu16;   //lo que se desplega
    JMenuItem menu21,menu24,menu25;
    JMenuItem menu31, menu32, menu33, menu34,menu35,menu36;
    JMenuItem menu41, menu42, menu43, menu44, menu45, menu46;
    JMenuItem menu51, menu52, menu53;
    
    
    JSeparator js1;
    JMenuBar jbar;
    ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/oxxo.jpg"));
    JLabel imagen1;
    
    
    
    public ProyectoBD(){
        //---------------------------------------------- para la hoja
        fr1 = new JFrame("Menu OXXO");
        jbar = new JMenuBar();
        js1 = new JSeparator();
        imagen1 = new JLabel(icon);
        //---------------------------------------------- la parte de arriba-- barra de menu
        menu1 = new JMenu("Catalogos");
        menu2 = new JMenu("Procesos");
        menu3 = new JMenu("Reportes");
        menu4 = new JMenu("Consultas tabla");
        menu5 = new JMenu("Ayuda");
        //---------------------------------------------- menuitemns
        menu11 = new JMenuItem("Empleados");
        menu12 = new JMenuItem("Productos");
        menu13 = new JMenuItem("Proveedores");
        menu14 = new JMenuItem("Tablas ISR");
        menu15 = new JMenuItem("Pedidos");
        menu16 = new JMenuItem("Salir");
        
        
        menu21 = new JMenuItem("Nomina");
        menu24 = new JMenuItem("Aguinaldo");
        menu25 = new JMenuItem("Venta");
        //---------------------------------------------- reportes
        menu31 = new JMenuItem("Productos");
        menu32 = new JMenuItem("Pedidos");
        menu33 = new JMenuItem("Proveedores");
        menu34 = new JMenuItem("Trabajadores");
        menu35 = new JMenuItem("Nominas");
        menu36 = new JMenuItem("Aguinaldos");
        //---------------------------------------------- para consultas
        menu41 = new JMenuItem("sueldo y empleado");
        menu42 = new JMenuItem("Pedidos");
        menu43 = new JMenuItem("productos");
        menu44 = new JMenuItem("Nominas por empleado");
        menu45 = new JMenuItem("Proveedores");
        menu46 = new JMenuItem("Aguinaldos");
        //----------------------------------------------
        menu51 = new JMenuItem("Ayuda (fr1)");
        menu52 = new JMenuItem("Acerca de...");
        
        menu53 = new JMenuItem("Capacitacion..");
    }
    
    public void usar1(){
        //------------------------------- saber a donde pertenecen
        menu1.add(menu11); menu1.add(menu12); menu1.add(menu13);
        menu1.add(menu14); menu1.add(menu15); 
        
        menu1.add(js1);//---------------------espacio o separador
        menu1.add(menu16);//------------------salir
        
        menu2.add(menu21); menu2.add(menu24); menu2.add(menu25);
        
        menu3.add(menu31); menu3.add(menu32); menu3.add(menu33); 
        menu3.add(menu34); menu3.add(menu35); menu3.add(menu36);
        
        menu4.add(menu41); menu4.add(menu42); menu4.add(menu43);
        menu4.add(menu44); menu4.add(menu45); menu4.add(menu46);
        
        menu5.add(menu51);  menu5.add(menu52); menu5.add(menu53);
        
        
        //------------------------------------ para meter en el jbar
        jbar.add(menu1);
        jbar.add(menu2);
        jbar.add(menu3);
        jbar.add(menu4);
        jbar.add(menu5);
        
        
        fr1.setJMenuBar(jbar);
        
        fr1.add(imagen1);       //------------------para imagen
        //imagen1.setIcon(icon);
        fr1.setVisible(true);
        fr1.setSize(900,650);
        fr1.setLocation(500,250);
        
        //--------------------------------Escuchas o llamar otras tablas
        
        menu11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               trabajadores mytrabajadores = new trabajadores();
               mytrabajadores.usar();
            }
        });
        
        menu12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               productos myproductos = new productos(); 
               myproductos.usar();
            }
        });
        
        menu13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               proveedores myproveedores = new proveedores();
               myproveedores.usar();
            }
        });
        
         menu14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               tablasIsr mytablasisr = new tablasIsr();
               mytablasisr.usar();
            }
        });
         
         menu15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               Pedidos mypedidos = new Pedidos();
               mypedidos.usar();
            }
        });
        
        menu16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fr1.dispose();
                Login mylogin = new Login();
                mylogin.usar2();
            }
        });
        
        menu21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fr1.dispose();
                calculo mycalculo = new calculo();
                mycalculo.menu();
            }
        });
        
        menu24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fr1.dispose();
                aguinaldo myaguinaldo = new aguinaldo();
                myaguinaldo.menu();
            }
        });
        
        menu25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fr1.dispose();
                ventas myventa = new ventas();
                myventa.menu();
            }
        });
        
        menu31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte("productos.jasper");
            }
        });
        
        menu32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte("pedidos.jasper");
            }
        });
        
        menu33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte("proveedores.jasper");
            }
        });
        
        menu34.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte("empleados.jasper");
            }
        });
        
        menu35.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte("Nominas.jasper");
            }
        });
        
        menu36.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte("aguinaldos.jasper");
            }
        });
        
        //-------------------------------------------------consultas especificas
        menu41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               conempleados myempleados = new conempleados(); 
                myempleados.usar();
            }
        });
        
        
        menu42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               conpedidos myconpedidos = new conpedidos();
               myconpedidos.usar();
            }
        });
        
        menu43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               conproductos myconproductos = new conproductos(); 
               myconproductos.usar();
            }
        });
        
        menu44.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               connominas myconnomina = new connominas(); 
               myconnomina.usar();
            }
        });
        
        menu45.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               conproveedores myconproveedores = new conproveedores(); 
               myconproveedores.usar();
            }
        });
        
        menu46.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               conaguinaldo myconaguinaldo = new conaguinaldo();
               myconaguinaldo.usar();
            }
        });
        
        menu51.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               fr1.dispose();//-----tirar a la basura la ventana anterior
               generarmanual();
            }
        });
        
        menu52.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Acerca myacerca = new Acerca();
                myacerca.mensajes();
            }
        });
        
        menu53.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               playVideo();
            }
        });
        
    }
    //----------------------------------------------hasta aqui construimos menu
    //--------------clase para entrar a reportes y visualizarlos rapido solo metiendo 
    //el nombre del archivo
    public void generarReporte(String nombreReporte) {
    try {
        con = mycon.conecta();
        // Ruta del reporte en el package "Reportes"
        String rutaReporte = "/Reportes/" + nombreReporte;

        // Obtenemos la URL del recurso
        URL reporteURL = getClass().getResource(rutaReporte);
        
        if (reporteURL != null) {
            // Cargamos el reporte desde la URL
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reporteURL);

            // Llenamos el reporte 
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);

            // Mostrar el reporte en una ventana de visualización
            JasperViewer.viewReport(jasperPrint, false);

            // Cerramos la conexión a la base de datos
            con.close();
        } else {
            System.err.println("No se encontró el archivo del reporte: " + rutaReporte);
        }
    } catch (JRException | SQLException e) {
        e.printStackTrace();
    }
}
    //Para desplegar el pdf del manual, abiendose desde el cmd
    public void generarmanual() {
        try {
            // Nombre del archivo a buscar
            String nombreArchivo = "Manual de usuario OXXO.pdf";

            // Ruta del archivo en el package "manual"
            String rutaArchivo = "/manual/" + nombreArchivo;

            // Cargamos el archivo desde el InputStream del recurso
            InputStream archivoStream = getClass().getResourceAsStream(rutaArchivo);

            // Creamos un archivo temporal para guardar el contenido del recurso
            File archivoTemporal = File.createTempFile("Manual de usuario OXXO", ".pdf");

            // Copiamos el contenido del InputStream al archivo temporal
            try (FileOutputStream out = new FileOutputStream(archivoTemporal)) {
                int read;
                byte[] bytes = new byte[1024];
                while ((read = archivoStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
            }

            // Abrimos el archivo con el lector de PDF predeterminado del sistema
            Desktop.getDesktop().open(archivoTemporal);

            // Volvemos al menú principal
            ProyectoBD mp = new ProyectoBD();
            mp.usar1();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void playVideo() {
        String videoUrl = "https://www.youtube.com/watch?v=mCdA4bJAGGk";

        try {
            // Abrir la URL del video en el navegador predeterminado del sistema
            Desktop.getDesktop().browse(new URI(videoUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    
     public static void main(String[] args) {
        ProyectoBD mp = new ProyectoBD();
        mp.usar1();
    }
    
    
    
    
       
        
        

    
    
}
