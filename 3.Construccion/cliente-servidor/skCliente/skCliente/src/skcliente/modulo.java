/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package skcliente;
/**
 *
 * @author Jeison Nisperuza
 */
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.SwingUtilities;
/**
 *
 * @author Jeison  Nisperuza
 */
public class modulo {
    
Socket servidor = null;
Socket cliente = null;
static Thread hiloCliente=null;
static Thread hiloPString=null;
Object objeto = new Object();
private ObjectOutputStream salida;
private ObjectInputStream entrada;
private String mensaje = "";
public static String servidorChat;
int chars=0;
int mm;

public class HiloStartCliente extends Thread {

 public void run() {
  try {
    try {
     conectarAServidor();
       obtenerFlujos();
        procesarConexion();
        }catch ( EOFException excepcionEOF ) {
         System.err.println( "El cliente termino la conexión" );
            try {
              salida.close();
               entrada.close();
                cliente.close();
               hiloCliente=null;
              hiloCliente.stop();
             SkClienteView.jbDesconectar.setText("Conectar");
            }catch( NullPointerException npe ){}
          catch( IOException excepcionES ){SkClienteView.jbDesconectar.setText("Conectar");}
         }
        catch ( IOException excepcionES ) {   }
         finally {
          cerrarConexion();
         }
        } catch (Exception ex) {SkClienteView.jbDesconectar.setText("Conectar");}
          synchronized(objeto) {
            try {
              objeto.wait( 100 );
              } catch( InterruptedException e ) {
                // Se ignoran las excepciones
             }
           }
        hiloCliente=null;
      }
   }

 public void StartCliente(){
      try{
        if( hiloCliente == null ) {
            hiloCliente = new HiloStartCliente();
            hiloCliente.start();
          }
   	} catch (Exception e){SkClienteView.jbDesconectar.setText("Conectar");}

  }

   private void conectarAServidor() throws IOException {
      mostrarMensaje( "\nIntentando realizar conexión\n" );
      cliente = new Socket( InetAddress.getByName( servidorChat ), Integer.valueOf(SkClienteView.jtfTunnel.getText()) );
      mostrarMensaje( "Conectado a: " +
         cliente.getInetAddress().getHostName() );
   }

   private void obtenerFlujos() throws IOException{
      salida = new ObjectOutputStream( cliente.getOutputStream() );
      salida.flush();
      entrada = new ObjectInputStream( cliente.getInputStream() );
      mostrarMensaje( "\nSe recibieron los flujos de E/S\n" );
   }

   private void procesarConexion() throws IOException {
      byte sk=0;
      establecerCampoTextoEditable( true );
      SkClienteView.jbEnviar.setEnabled(true);
      do {
         try {
            mensaje = ( String ) entrada.readObject();
               try{
                   mm=Integer.parseInt(mensaje)*1;
                   if (sk==0){
                       SkClienteView.jlCantPalabras.setText(""+mm);sk=1;mm=0;
                   }else if (sk==1){
                       SkClienteView.jlCantLineas.setText(""+mm);sk=0;mm=0;
                   }
               }catch(Exception e){mostrarMensaje( "\n" + mensaje );}
         }
         catch ( ClassNotFoundException excepcionClaseNoEncontrada ) {
            mostrarMensaje( "\nSe recibió un objeto de tipo desconocido" );
             try {
              salida.close();
               entrada.close();
                cliente.close();
               hiloCliente=null;
              hiloCliente.stop();
             SkClienteView.jbDesconectar.setText("Conectar");
            }
            catch( NullPointerException npe ){SkClienteView.jbEnviar.setEnabled(false);}
          catch( IOException excepcionES ){SkClienteView.jbEnviar.setEnabled(false);SkClienteView.jbDesconectar.setText("Conectar");}
         }
      } while ( !mensaje.equals( "SERVIDOR>>> TERMINAR" ) );
   }

   public void cerrarConexion(){
    mostrarMensaje( "\nCerrando conexión" );
     establecerCampoTextoEditable( false );
      try {
       salida.close();
        entrada.close();
         cliente.close();
         hiloCliente=null;
         hiloCliente.stop();
        SkClienteView.jbDesconectar.setText("Conectar");
       SkClienteView.jbEnviar.setEnabled(false);
      }
      catch( NullPointerException npe ){SkClienteView.jbEnviar.setEnabled(false);}
     catch( IOException excepcionES ){SkClienteView.jbEnviar.setEnabled(false);SkClienteView.jbDesconectar.setText("Conectar");}
   }

   public void enviarDatos( String mensaje ){
      try {
         salida.writeObject( "CLIENTE>>> " + mensaje );
         salida.flush();
         mostrarMensaje( "\nCLIENTE>>> " + mensaje );
      }
      catch ( IOException excepcionES ) {
         SkClienteView.jtaMensajesCliente.append( "\nError al escribir el objeto" );
      }
   }


   private void mostrarMensaje( final String mensajeAMostrar ){
      SwingUtilities.invokeLater(
         new Runnable() {
            public void run()
            {
               SkClienteView.jtaMensajesCliente.append( mensajeAMostrar );
               SkClienteView.jtaMensajesCliente.setCaretPosition(
               SkClienteView.jtaMensajesCliente.getText().length() );
            }
         }

      );
   }
   private void establecerCampoTextoEditable( final boolean editable ){
      SwingUtilities.invokeLater(
         new Runnable(){
            public void run(){
               SkClienteView.jtfMensajeCliente.setEditable(editable);
            }
         }
      );
   }


}

