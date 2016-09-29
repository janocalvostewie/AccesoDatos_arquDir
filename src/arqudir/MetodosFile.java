package arqudir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Runtime.getRuntime;
import javax.swing.JOptionPane;

/**
 *
 * @author Jano
 */
public class MetodosFile {

    /**
     * Creamos una variable en la clase que tome la ruta base con la que
     * trabajaremos.
     */
    String ruta = "C:\\";

    public static File arquDir = new File("C:\\arquivosdir\\");
    public static String arquDirPath = "";
    public static File subDir = new File("C:\\arquivosdir\\subDir\\");
    public static String subDirPath = "";
    public static boolean resultado;

    /**
     * Este método crea una carpeta (directorio). Se le pasa un nombre, nombre
     * que tendrá el directorio y lo crea en la ruta base establecida en la
     * clase
     */
    public static void creaArquivosdir() {

        //Este método devuelve un valor boleano
        //Si es TRUE es que no existe y lo crea
        //Si devuelve FALSE es que no puede porque ya existe.
        resultado = arquDir.mkdir();
        if (resultado == true) {
            Menu.taSalida.setText("Directorio Creado");

        } else if (resultado == false) {
            Menu.taSalida.setText("Directorio NO Creado.\nYa existe");
        }
    }

    /**
     * Este método lista los archivos o directorios de una ruta a través de los
     * propios métodos de la librería IO de JAVA
     *
     * @param NomDir
     */
    public static void listarIO() {

        //Introduce en un Array los valores salimos del metodo 'list()'
        String[] ficheros = arquDir.list();
        String listado = "";

        if (ficheros == null) {
            Menu.taSalida.setText("No hay ficheros en el directorio especificado");
        } else {
            for (int x = 0; x < ficheros.length; x++) {
                listado = listado + ficheros[x] + "\n";

            }
        }
        //Imprimimos el resultado
        Menu.taSalida.setText(listado);
    }

    /**
     * La finalidad es la misma que el anterior, pero empleando los propios
     * comandos del sistema Windows Para ello emplearemos RUNTIME
     *
     * @param NomDir
     *
     * public void listarCMD(String NomDir) { //carpeta = NomDir; try {
     * //Creamos la cadena que pasaremos para ejecutar con el comando windows
     * String cmd = "cmd /c dir " + ruta + carpeta + " /B"; String salidaComando
     * = null; String resultadoSalida = ""; //Esto ejecuta el comando Process
     * procesoComando = Runtime.getRuntime().exec(cmd); //Para poder visualizar
     * la salida necesitamos //StreamReader y el BufferReader InputStreamReader
     * entrada = new InputStreamReader(procesoComando.getInputStream());
     * BufferedReader stdInput = new BufferedReader(entrada);
     *
     * //Si el comando tiene una salidaComando la mostramos if ((salidaComando =
     * stdInput.readLine()) != null) { for (salidaComando = stdInput.readLine();
     * salidaComando != null; salidaComando = stdInput.readLine()) { //while
     * ((salidaComando = lectura.readLine()) != null) {
     *
     * resultadoSalida = resultadoSalida + salidaComando + "\n";
     *
     * }
     * stdInput.close(); System.out.println(resultadoSalida); } else {
     * System.out.println("No se a producido ninguna salida"); } } catch
     * (IOException ioe) { System.out.println(ioe); } }
     */
    public static void creaArchivo(String ruta, String nomArchivo) {
        File archivo = new File(ruta, nomArchivo + ".txt");

        try {
            // A partir del objeto File creamos el fichero físicamente
            if (archivo.createNewFile()) {
                Menu.taSalida.setText("El fichero se ha creado");
            } else {
                Menu.taSalida.setText("No se ha podido crear\nYa existe");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void creaSubDir() {

        //Este método devuelve un valor boleano
        //Si es TRUE es que no existe y lo crea
        //Si devuelve FALSE es que no puede porque ya existe.
        boolean resultado = subDir.mkdir();
        if (resultado == true) {
            Menu.taSalida.setText("Directorio Creado");
        } else if (resultado == false) {
            Menu.taSalida.setText("Directorio NO Creado.\nYa existe");
        }
    }

    public static void compruebaDirCMD(String ruta) {
        String texto = "COMPROBACIÓN POR CMD\n";
        try {
            //Creamos la cadena que pasaremos para ejecutar con el comando windows
            String cmd = "cmd /c IF EXIST " + ruta + " (echo EXISTE) ELSE (echo NO_EXISTE)";
            texto = texto + cmd + "\n\nRESULTADO:\n";
            String salidaComando = null;
            String resultadoSalida = "";
            //Esto ejecuta el comando
            Process procesoComando = Runtime.getRuntime().exec(cmd);
            //Para poder visualizar la salida necesitamos 
            //StreamReader y el BufferReader
            InputStreamReader entrada = new InputStreamReader(procesoComando.getInputStream());

            BufferedReader lectura = new BufferedReader(entrada);

            salidaComando = lectura.readLine();
            texto = texto + salidaComando;
            Menu.taSalida.setText(texto);

        } catch (IOException ioe) {

        }
    }

    public static void borrar(String ruta) {

        File borrador = new File(ruta);
        if (borrador.delete()) {
            Menu.taSalida.setText("El fichero ha sido borrado");
        } else {
            Menu.taSalida.setText("El fichero no puede ser borrado");
        }

    }

    public static void daInfo(String ruta) {
String texto = "ARCHIVO\nProducts1.txt\n\nRuta:\n"+ruta+"\n\nPERMISOS:\n";
        try {
            //Creamos la cadena que pasaremos para ejecutar con el comando windows
            String cmd = "cmd /c cacls " + ruta ;
            
            String salidaComando = null;
            String resultadoSalida = "";
            //Esto ejecuta el comando
            Process procesoComando = Runtime.getRuntime().exec(cmd);
            //Para poder visualizar la salida necesitamos 
            //StreamReader y el BufferReader
            InputStreamReader entrada = new InputStreamReader(procesoComando.getInputStream());

            BufferedReader lectura = new BufferedReader(entrada);

            
            String muestra="";
            while ((resultadoSalida=lectura.readLine()) != null){
                    muestra=muestra+resultadoSalida+"\n";
                }
        
            texto = texto + muestra+"\n\n";
            
            
        } catch (IOException ioe) {}
         try {
            //Creamos la cadena que pasaremos para ejecutar con el comando windows
            String cmd2 = "cmd /c dir " + ruta ;
            
          
         String resultadoS = "";
            //Esto ejecuta el comando
            Process procesoComando = Runtime.getRuntime().exec(cmd2);
            //Para poder visualizar la salida necesitamos 
            //StreamReader y el BufferReader
            InputStreamReader ent = new InputStreamReader(procesoComando.getInputStream());

            BufferedReader lect = new BufferedReader(ent);

            int contador=0;
            String muestra="";
            while ((resultadoS=lect.readLine()) != null){
                contador=contador+1;
                if(contador==7){
                   texto=texto+"Tamaño:\n"+resultadoS;
                   // Menu.taSalida.setText(resultadoSalida);
                }
                }
        
            
            Menu.taSalida.setText(texto);
            
        } catch (IOException ioc) {}
    }

    public static void daPermisos(String ruta) {
        String texto = "ARCHIVO\nProducts1.txt\n\nRuta:\n"+ruta+"\n\nPERMISOS:\n";
        try {
            //Creamos la cadena que pasaremos para ejecutar con el comando windows
            String cmd = "cmd /c echo Y|cacls " + ruta +" /g Usuarios:F";
            texto=cmd+"\n\n";
            String salidaComando = null;
            String resultadoSalida = "";
            //Esto ejecuta el comando
            Process procesoComando = Runtime.getRuntime().exec(cmd);
            //Para poder visualizar la salida necesitamos 
            //StreamReader y el BufferReader
            InputStreamReader entrada = new InputStreamReader(procesoComando.getInputStream());

            BufferedReader lectura = new BufferedReader(entrada);

            
            
            while ((resultadoSalida=lectura.readLine()) != null){
                    Menu.taSalida.setText(texto+resultadoSalida+"\n");
                }
        
            
            
            
        } catch (IOException ioe) {}
         
    }

    public static void quitaPermisos(String ruta) {
        String texto = "";
        try {
            //Creamos la cadena que pasaremos para ejecutar con el comando windows
            String cmd = "cmd /c echo Y|cacls " + ruta +" /p Usuarios:R";
            texto=cmd+"\n\n";
            String salidaComando = null;
            String resultadoSalida = "";
            //Esto ejecuta el comando
            Process procesoComando = Runtime.getRuntime().exec(cmd);
            //Para poder visualizar la salida necesitamos 
            //StreamReader y el BufferReader
            InputStreamReader entrada = new InputStreamReader(procesoComando.getInputStream());

            BufferedReader lectura = new BufferedReader(entrada);

            
            
            while ((resultadoSalida=lectura.readLine()) != null){
                    Menu.taSalida.setText(texto+resultadoSalida+"\n");
                }
        
            
            
            
        } catch (IOException ioe) {}
         
    }
}
