
package proyectobd;

import javax.swing.JOptionPane;

public class Acerca {
    
    String mensaje = "Autor: Aleman Santiago Andrik Yahir";
    String mensaje1 = "Lenguajes utilizados: Java, SQL";
    String mensaje2 = "Universidad Politecnica del Valle de Mexico";
    
    public void mensajes(){
    JOptionPane.showMessageDialog(null, mensaje + "\n" + mensaje1 + "\n" + mensaje2);
    }
    
    public static void main(String[] args) {
        Acerca myacerca = new Acerca();
        myacerca.mensajes();
    }
}
