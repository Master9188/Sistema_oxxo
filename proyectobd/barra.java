
package proyectobd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;


public class barra {
    JFrame fr11;
    JProgressBar progressBar;
    JLabel lblProgress;
    
    public barra() {
        fr11 = new JFrame("CARGANDO");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.CYAN); // Cambiar color de la barra de progreso
        lblProgress = new JLabel("Cargando sistema");
        lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
        lblProgress.setFont(new Font("Arial", Font.BOLD, 21));
    }
    
    
    public void usar() {
        fr11.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.add(progressBar, BorderLayout.CENTER);
        panel.add(lblProgress, BorderLayout.SOUTH);
        fr11.add(panel, BorderLayout.CENTER);
        fr11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr11.setSize(300, 140);
        fr11.setLocationRelativeTo(null);
        fr11.setUndecorated(true); // Eliminar bordes del JFrame
        fr11.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK)); // Agregar borde personalizado al JFrame
        fr11.setVisible(true);

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    publish(i);
                    Thread.sleep(100);
                }
                return null;
            }

           
            protected void process(java.util.List<Integer> chunks) {
                for (int value : chunks) {
                    progressBar.setValue(value);
                    progressBar.setString(value + "%");
                }
            }

            protected void done() {
                fr11.dispose();
                ProyectoBD mp = new ProyectoBD();
                mp.usar1();
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {
        barra mybarra = new barra();
        mybarra.usar();
    }
}
