/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package skservidor;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.StringTokenizer;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jeison  Nisperuza
 */
public class skmodulo {

   static Thread hiloServidor=null;
   Object objeto = new Object();
   private ObjectOutputStream salida;
   private ObjectInputStream entrada;
   private ServerSocket servidor;
   private Socket conexion;
   private int contador = 1;

   public class HiloServidor extends Thread {
    public void run() {
    try {

      try {
         servidor = new ServerSocket( Integer.valueOf(SkServidorView.jtfTunnel.getText()), 100 );
         while ( true ) {

            try {
               esperarConexion();
               obtenerFlujos();
               procesarConexion();
            }
            catch ( EOFException excepcionEOF ) {
               System.err.println( "El servidor terminó la conexión" );
               try {
                salida.close();
                entrada.close();
                conexion.close();
                hiloServidor=null;
                SkServidorView.jbDesconectar.setText("Conectar");
               }catch( NullPointerException npe ){}
               catch( IOException excepcionES ){SkServidorView.jbDesconectar.setText("Conectar");}
            }
            finally {
               cerrarConexion();
               contador=contador+1;
			crearConexxion();

            }
         }
      }catch( SocketException ske ){cerrarConexion();}
      catch ( IOException excepcionES ){cerrarConexion();}


            } catch (Exception ex) {}
                synchronized(objeto) {
                try {
                    objeto.wait( 100 );
                  } catch( InterruptedException e ) {
                // Se ignoran las excepciones
              }
            }
          hiloServidor=null;
      }
   }

   
 public void StartServidor(){
      try{
        if( hiloServidor == null ) {
            hiloServidor = new HiloServidor();
            hiloServidor.start();
          }
   	} catch (Exception e){cerrarConexion();}

  }
 
   private void esperarConexion() throws IOException{
      mostrarMensaje( "Esperando una conexión\n" );
      conexion = servidor.accept();
      mostrarMensaje( "Conexión " + contador + " recibida de: " +
      conexion.getInetAddress().getHostName() );
   }

   private void obtenerFlujos() throws IOException{
      salida = new ObjectOutputStream( conexion.getOutputStream() );
      salida.flush();
      entrada = new ObjectInputStream( conexion.getInputStream() );
      mostrarMensaje( "\nSe recibieron los flujos de E/S\n" );
   }

   private void procesarConexion() throws IOException{
      String mensaje = "Conexión exitosa";
      enviarDatos( mensaje,0 );
      SkServidorView.jtfMensajeServidor.setEnabled( true );
      SkServidorView.jbEnviar.setEnabled(true);
      do {
         try {
            mensaje = ( String ) entrada.readObject();
            mostrarMensaje( "\n" + mensaje);
         }
         catch ( ClassNotFoundException excepcionClaseNoEncontrada ) {
            mostrarMensaje( "\nSe recibió un tipo de objeto desconocido" );
            try {
                salida.close();
                entrada.close();
                conexion.close();
                hiloServidor=null;
                cerrarConexion();
            }catch( NullPointerException npe ){SkServidorView.jbEnviar.setEnabled(false);}
            catch( IOException excepcionES ){SkServidorView.jbEnviar.setEnabled(false);SkServidorView.jbDesconectar.setText("Conectar");}
         }
      } while ( !mensaje.equals( "CLIENTE>>> TERMINAR" ) );
   }

   public void cerrarConexion(){
    mostrarMensaje( "\nFinalizando la conexión\n" );
     SkServidorView.jtfMensajeServidor.setEnabled( false );
      try {
         salida.close();
          entrada.close();
           conexion.close();
           servidor.close();
           hiloServidor=null;
          hiloServidor.stop();
         SkServidorView.jbDesconectar.setText("Conectar");
       SkServidorView.jbEnviar.setEnabled(false);
      }
     catch( NullPointerException npe ){SkServidorView.jbEnviar.setEnabled(false);}
    catch( IOException excepcionES ){SkServidorView.jbEnviar.setEnabled(false);SkServidorView.jbDesconectar.setText("Conectar");}
   }

   public void enviarDatos( String mensaje, int origen){
      try {
          if (origen==1){
            salida.writeObject( mensaje );
            salida.flush();
          }else if (origen==0){
            salida.writeObject( "SERVIDOR>>> " + mensaje );
            salida.flush();
            mostrarMensaje( "\nSERVIDOR>>> " + mensaje );
          }
      }catch ( IOException excepcionES ) {
         SkServidorView.jtaMensajeServidor.append( "\nError al escribir objeto" );
      }
   }

   public void mostrarMensaje( final String mensajeAMostrar ){
      SwingUtilities.invokeLater(
         new Runnable() {
            public void run()
             {
               SkServidorView.jtaMensajeServidor.append( mensajeAMostrar );
                try{
                  StringTokenizer tokensPalabras = new StringTokenizer(mensajeAMostrar.substring(11, mensajeAMostrar.length())," ");
                   enviarDatos(String.valueOf(tokensPalabras.countTokens()),1);
                   StringTokenizer tokensLineas = new StringTokenizer(mensajeAMostrar.substring(11, mensajeAMostrar.length()),"\n");
                  enviarDatos(String.valueOf(tokensLineas.countTokens()),1);
                 }catch(Exception e){}
                SkServidorView.jtaMensajeServidor.setCaretPosition(
              SkServidorView.jtaMensajeServidor.getText().length() );
            }

         }

      );

   }


}
