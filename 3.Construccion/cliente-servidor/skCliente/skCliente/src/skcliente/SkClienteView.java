/*
 * SkClienteView.java
 */

package skcliente;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class SkClienteView extends FrameView {
    modulo skCliente =new modulo();

    public SkClienteView(SingleFrameApplication app) {
        super(app);

        initComponents();
        //skCliente.StartCliente();
        modulo.servidorChat=SkClienteView.jtfIPServidor.getText();
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                //statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        //statusAnimationLabel.setIcon(idleIcon);
        //progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        //statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    //progressBar.setVisible(true);
                    //progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    //statusAnimationLabel.setIcon(idleIcon);
                    //progressBar.setVisible(false);
                    //progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    //statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    //progressBar.setVisible(true);
                    //progressBar.setIndeterminate(false);
                    //progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = SkClienteApp.getApplication().getMainFrame();
            aboutBox = new SkClienteAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        SkClienteApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlMensajeCliente = new javax.swing.JLabel();
        jspMensajeCliente = new javax.swing.JScrollPane();
        jtfMensajeCliente = new javax.swing.JTextArea();
        jlMensajesClientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMensajesCliente = new javax.swing.JTextArea();
        jtfIPServidor = new javax.swing.JTextField();
        jpIP = new javax.swing.JLabel();
        jlTunnel = new javax.swing.JLabel();
        jtfTunnel = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbLimpiar = new javax.swing.JButton();
        jbDesconectar = new javax.swing.JButton();
        jbEnviar = new javax.swing.JButton();
        jlPalabras = new javax.swing.JLabel();
        jlLineas = new javax.swing.JLabel();
        jlCantPalabras = new javax.swing.JLabel();
        jlCantLineas = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(skcliente.SkClienteApp.class).getContext().getResourceMap(SkClienteView.class);
        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jlMensajeCliente.setText(resourceMap.getString("jlMensajeCliente.text")); // NOI18N
        jlMensajeCliente.setName("jlMensajeCliente"); // NOI18N

        jspMensajeCliente.setName("jspMensajeCliente"); // NOI18N

        jtfMensajeCliente.setColumns(20);
        jtfMensajeCliente.setRows(5);
        jtfMensajeCliente.setName("jtfMensajeCliente"); // NOI18N
        jspMensajeCliente.setViewportView(jtfMensajeCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspMensajeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addComponent(jlMensajeCliente))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jlMensajeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspMensajeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlMensajesClientes.setText(resourceMap.getString("jlMensajesClientes.text")); // NOI18N
        jlMensajesClientes.setName("jlMensajesClientes"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtaMensajesCliente.setColumns(20);
        jtaMensajesCliente.setLineWrap(true);
        jtaMensajesCliente.setRows(5);
        jtaMensajesCliente.setWrapStyleWord(true);
        jtaMensajesCliente.setFocusable(false);
        jtaMensajesCliente.setName("jtaMensajesCliente"); // NOI18N
        jScrollPane1.setViewportView(jtaMensajesCliente);

        jtfIPServidor.setText(resourceMap.getString("jtfIPServidor.text")); // NOI18N
        jtfIPServidor.setName("jtfIPServidor"); // NOI18N

        jpIP.setText(resourceMap.getString("jpIP.text")); // NOI18N
        jpIP.setName("jpIP"); // NOI18N

        jlTunnel.setText(resourceMap.getString("jlTunnel.text")); // NOI18N
        jlTunnel.setName("jlTunnel"); // NOI18N

        jtfTunnel.setText(resourceMap.getString("jtfTunnel.text")); // NOI18N
        jtfTunnel.setName("jtfTunnel"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jbLimpiar.setIcon(resourceMap.getIcon("jbLimpiar.icon")); // NOI18N
        jbLimpiar.setText(resourceMap.getString("jbLimpiar.text")); // NOI18N
        jbLimpiar.setName("jbLimpiar"); // NOI18N
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbDesconectar.setIcon(resourceMap.getIcon("jbDesconectar.icon")); // NOI18N
        jbDesconectar.setText(resourceMap.getString("jbDesconectar.text")); // NOI18N
        jbDesconectar.setName("jbDesconectar"); // NOI18N
        jbDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDesconectarActionPerformed(evt);
            }
        });

        jbEnviar.setIcon(resourceMap.getIcon("jbEnviar.icon")); // NOI18N
        jbEnviar.setText(resourceMap.getString("jbEnviar.text")); // NOI18N
        jbEnviar.setEnabled(false);
        jbEnviar.setName("jbEnviar"); // NOI18N
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        jlPalabras.setText(resourceMap.getString("jlPalabras.text")); // NOI18N
        jlPalabras.setToolTipText(resourceMap.getString("jlPalabras.toolTipText")); // NOI18N
        jlPalabras.setName("jlPalabras"); // NOI18N

        jlLineas.setText(resourceMap.getString("jlLineas.text")); // NOI18N
        jlLineas.setToolTipText(resourceMap.getString("jlLineas.toolTipText")); // NOI18N
        jlLineas.setName("jlLineas"); // NOI18N

        jlCantPalabras.setText(resourceMap.getString("jlCantPalabras.text")); // NOI18N
        jlCantPalabras.setName("jlCantPalabras"); // NOI18N

        jlCantLineas.setText(resourceMap.getString("jlCantLineas.text")); // NOI18N
        jlCantLineas.setName("jlCantLineas"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlLineas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCantPalabras)
                    .addComponent(jlCantLineas))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPalabras)
                            .addComponent(jlCantPalabras))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlLineas)
                            .addComponent(jlCantLineas))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMensajesClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jpIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jlTunnel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTunnel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMensajesClientes)
                    .addComponent(jlTunnel)
                    .addComponent(jtfTunnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpIP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(skcliente.SkClienteApp.class).getContext().getActionMap(SkClienteView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
     // enviar mensaje:
      if(!jtfMensajeCliente.getText().equals("")){
        skCliente.enviarDatos(jtfMensajeCliente.getText());
        jtfMensajeCliente.setText("");
        jtfMensajeCliente.setEnabled(true);
        jtfMensajeCliente.requestFocus();
      }
    }//GEN-LAST:event_jbEnviarActionPerformed

    private void jbDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDesconectarActionPerformed
        modulo.servidorChat=SkClienteView.jtfIPServidor.getText();
        ImageIcon imagenBoton;
        if(jbDesconectar.getText().equals("Desconectar")){
        // cerrar conexión:
        skCliente.cerrarConexion();
        jtfMensajeCliente.setText("");
        jtfMensajeCliente.setEnabled(false);
        imagenBoton = new ImageIcon(getClass().getResource("/skcliente/resources/connect-icon.png"));
        jbDesconectar.setIcon(imagenBoton);
        jbDesconectar.setText("Conectar");
      }else if(jbDesconectar.getText().equals("Conectar")){
        // cerrar conexión:
        skCliente.StartCliente();
        jtfMensajeCliente.setText("");
        jtfMensajeCliente.setEnabled(true);
        jtfMensajeCliente.requestFocus();
        imagenBoton = new ImageIcon(getClass().getResource("/skcliente/resources/disconnect.png"));
        jbDesconectar.setIcon(imagenBoton);
        jbDesconectar.setText("Desconectar");
      }

    }//GEN-LAST:event_jbDesconectarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // limpiar:
        jtfMensajeCliente.setText("");
        jtaMensajesCliente.setText("");
        jlCantPalabras.setText("0");
        jlCantLineas.setText("0");
        jtfMensajeCliente.requestFocus();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton jbDesconectar;
    public static javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbLimpiar;
    public static javax.swing.JLabel jlCantLineas;
    public static javax.swing.JLabel jlCantPalabras;
    private javax.swing.JLabel jlLineas;
    private javax.swing.JLabel jlMensajeCliente;
    private javax.swing.JLabel jlMensajesClientes;
    private javax.swing.JLabel jlPalabras;
    private javax.swing.JLabel jlTunnel;
    private javax.swing.JLabel jpIP;
    private javax.swing.JScrollPane jspMensajeCliente;
    public static javax.swing.JTextArea jtaMensajesCliente;
    public static javax.swing.JTextField jtfIPServidor;
    public static javax.swing.JTextArea jtfMensajeCliente;
    public static javax.swing.JTextField jtfTunnel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
