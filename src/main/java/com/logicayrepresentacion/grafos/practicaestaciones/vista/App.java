/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicayrepresentacion.grafos.practicaestaciones.vista;

import com.logicayrepresentacion.grafos.practicaestaciones.Grafo2;
import com.logicayrepresentacion.grafos.practicaestaciones.CantidadEstacionesException;
import com.logicayrepresentacion.grafos.practicaestaciones.DatosEstacion;
import com.logicayrepresentacion.grafos.practicaestaciones.Estacion;
import static com.logicayrepresentacion.grafos.practicaestaciones.vista.Lienzo.DIAMETRO;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 57300
 */
public class App extends javax.swing.JFrame {

    private DatosEstacion datosEstacion;

    /**
     * Creates new form App
     */
    public App() {
        initComponents();

        // Carga los datos de las estaciones leyendo el archivo estaciones.txt
        // de la ruta de ejecución
        
        try {
            Grafo2.iniciarGrafo();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("ruta.txt"));
            String linea;
            linea = bufferedReader.readLine();
            int cantidadEstaciones = Integer.parseInt(linea);
            datosEstacion = new DatosEstacion(cantidadEstaciones, costoMinimojTextPane1, matrizAdyjTextPane1);

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(",");
                String ciudad1 = partes[0];
                String ciudad2 = partes[1];
                int distancia = Integer.parseInt(partes[2]);
                datosEstacion.addAdyacencia(ciudad1, ciudad2, distancia);
                Grafo2.getInstance().agregarRuta(ciudad1, ciudad2, distancia);
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | NumberFormatException | CantidadEstacionesException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Carga los datos de las posiciones del grafico desde el archivo
        // grafico
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("grafico1.txt"));
            String linea;
            String ests = "";
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreEstacion = partes[0];
                String coordenada1Str = partes[1];
                String coordenada2Str = partes[2];
                double coordenada1 = Double.parseDouble(coordenada1Str);
                double coordenada2 = Double.parseDouble(coordenada2Str);
                Estacion estacion = datosEstacion.buscar(nombreEstacion);
                estacion.setForma(new Ellipse2D.Double(coordenada1, coordenada2, DIAMETRO + 50, DIAMETRO));
                ests+=nombreEstacion+",";
            }
        String ests2 = ests.substring(0, ests.length()-1);        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        lienzo1.setObjArbol(datosEstacion);

        matrizAdyjTextPane1.setText(datosEstacion.parseMatrizAdy());
        lienzo1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo1 = new com.logicayrepresentacion.grafos.practicaestaciones.vista.Lienzo();
        jScrollPane1 = new javax.swing.JScrollPane();
        matrizAdyjTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        costoMinimojTextPane1 = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(900, 700));

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        matrizAdyjTextPane1.setEditable(false);
        jScrollPane1.setViewportView(matrizAdyjTextPane1);

        jScrollPane2.setViewportView(costoMinimojTextPane1);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * Se utiliza para almacenar las posiciones de las estaciones y poderlas
     * volver a cargar
     *
     * @param evt
     */
    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("grafico1.txt"));
            for (Estacion estacion : datosEstacion.getEstaciones()) {
                writer.write(estacion.getNombre() + ","
                        + estacion.getForma().getX() + ","
                        + estacion.getForma().getY());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane costoMinimojTextPane1;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.logicayrepresentacion.grafos.practicaestaciones.vista.Lienzo lienzo1;
    private javax.swing.JTextPane matrizAdyjTextPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
