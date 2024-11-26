package app_java_project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class App_java_project {

    public static void main(String[] args) {
        // INICIO MAIN
        ControlCondominio CC = new ControlCondominio(5);
        App_java_project cc = new App_java_project();

        int indice = 0;

        do {
            indice = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                    + "1) Agregar\n2) Consultar\n3) Eliminar\n4) Cambiar Estado\n5) Generar Txt\n6) Salir"));

            switch (indice) {
                case 1 -> {
                    CC.AgregarQuis(new DatosQuisckpass());
                }
                case 2 -> {
                    int indice2 = 0; //MENU SECUNDARIO
                    int indice3 = 0; //SUBMENU SECUNDARIO           

                    indice2 = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                            + "1) Visualizar Datos\n2) Visualizar Datos Eliminados\n3) Salir"));

                    switch (indice2) {
                        case 1 -> {//VISUALIZAR DATOS
                            indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n4) Salir"));

                            switch (indice3) {
                                case 1 -> { //MOSTRAR TODOS LOS DATOS
                                    JOptionPane.showMessageDialog(null, CC.toString());
                                }

                                case 2 -> { //MOSTRAR LOS DATOS DE UNA FILIAL
                                    String consulta = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                    JOptionPane.showMessageDialog(null, CC.toString(consulta));
                                }

                                case 3 -> {//MOSTRAR LOS DATOS DE UNO EN ESPECIFICO  
                                    String consultaFil = JOptionPane.showInputDialog(null, "Ingrese el número de la Filial");
                                    String consultaCod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");
                                    JOptionPane.showMessageDialog(null, CC.toString(consultaCod, consultaFil));
                                }

                                case 4 -> {
                                    /*SALIR*/ }
                                default ->
                                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                            }
                        }
                        case 2 -> {
                            //VISUALIZAR DATOS ELIMINADOS
                            indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS ELIMINADOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n4) Salir"));
                            switch (indice3) {
                                case 1 -> { //MOSTRAR TODOS LOS DATOS
                                    JOptionPane.showMessageDialog(null, CC.toStringEliminado());
                                }

                                case 2 -> { //MOSTRAR LOD DATOS DE UNA FILIAL
                                    String consulta = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                    JOptionPane.showMessageDialog(null, CC.toStringEliminado(consulta));
                                }

                                case 3 -> { //MOSTRAR LOS DATOS DE UNO EN ESPECIFICO
                                    String consultaFil = JOptionPane.showInputDialog(null, "Ingrese el número de la Filial");
                                    String consultaCod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");
                                    JOptionPane.showMessageDialog(null, CC.toStringEliminado(consultaCod, consultaFil));
                                }

                                case 4 -> {
                                    /*SALIR*/ }
                                default ->
                                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                            }
                        }
                        case 3 -> {
                            /*SALIR*/ }
                        default ->
                            JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                    }
                }
                case 3 -> {
                    //ELIMINAR
                    int menuEliminar = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                            + "1) ELIMINAR CON LA PLACA\n2) ELIMINAR CON EL CODIGO\n3) Salir"));

                    switch (menuEliminar) {
                        case 1 -> {
                            String placa = JOptionPane.showInputDialog("Ingrese la placa: ");
                            CC.EliminarQuis(placa);
                        }

                        case 2 -> {
                            String codigo = JOptionPane.showInputDialog("Ingrese el codigo: ");
                            CC.EliminarQuis(codigo);
                        }

                        case 3 -> {
                            /*SALIR*/ }
                        default ->
                            JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                    }
                }
                case 4 -> {
                    //CAMBIAR ESTADO
                    String codigoEstado = JOptionPane.showInputDialog("Ingrese el código para cambiar el estado:");

                    boolean cambioExitoso = CC.CambiarEstado(codigoEstado);

                    if (cambioExitoso) {
                        JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el Quisckpass con ese código.");
                    }
                }
                case 5 -> {
                    int indice2 = Integer.parseInt(JOptionPane.showInputDialog("********* CONSULTAR ACCESOS *********\n"
                            + "1) Registrar acceso\n"
                            + "2) Consultar por filial\n"
                            + "3) Consultar por fecha\n"
                            + "4) Consultar por código o placa\n"
                            + "5) Generar archivo de acceso\n"
                            + "6) Salir"));

                    switch (indice2) {
                        case 1 -> {
                            // Llamada al método de registrar acceso
                            cc.registrarAcceso();
                        }
                        case 2 -> {
                            // Llamada al método para consultar por filial
                            cc.consultarPorFilial();
                        }
                        case 3 -> {
                            // Llamada al método para consultar por fecha
                            cc.consultarPorFecha();
                        }
                        case 4 -> {
                            // Llamada al método para consultar por código o placa
                            cc.consultarPorCodigo();
                        }
                        case 5 -> {
                            // Llamada al método para generar un archivo de texto (opcional)
                            cc.generarTxt();
                        }
                        case 6 -> {
                            // Salir
                            JOptionPane.showMessageDialog(null, "Saliendo del menú de consultas.");
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, "ERROR: Opción no válida");
                        }
                    }
                }
                case 6 -> {
                    /*SALIR*/

                }
                default ->
                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
            }//FIN SWITCH
        } while (indice != 6);
        //FIN MAIN
    }
    // Método para registrar la actividad en el archivo Historial.txt

    private static void registrarActividad(String consulta, String resultado, String codigo, String placa, String filial, Estado estado) {
        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaHora = ahora.format(formatter);

        // Crear la línea que se va a guardar en el archivo
        String linea = "Código: " + codigo + "; Placa: " + placa + "; Filial: " + filial + "; Condición: " + estado + "; Fecha: " + fechaHora + "; Consulta: " + consulta + "; Resultado: " + resultado + "\n";

        // Guardar la línea en el archivo Historial.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial.txt", true))) {
            writer.write(linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para registrar un acceso
    public void registrarAcceso() {
        // Solicitar los datos al usuario
        String codigo = JOptionPane.showInputDialog("Ingrese el código:");
        String placa = JOptionPane.showInputDialog("Ingrese la placa:");
        String filial = JOptionPane.showInputDialog("Ingrese la filial:");
        String resultado = "Acceso registrado para el código: " + codigo + " y placa: " + placa;

        // Registrar la actividad
        registrarActividad("Registrar acceso", resultado, codigo, placa, filial, Estado.Activo);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado);
    }

    // Método para consultar por filial
    public void consultarPorFilial() {
        // Solicitar la filial al usuario
        String filial = JOptionPane.showInputDialog("Ingrese la filial para la consulta:");
        String resultado = "Consulta exitosa para la filial: " + filial;

        // Registrar la actividad
        registrarActividad("Consultar por filial", resultado, "1011234567", "123ABC", filial, Estado.Activo);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado);
    }

    // Método para consultar por fecha
    public void consultarPorFecha() {
        String resultado = "Consulta exitosa por fecha";

        // Registrar la actividad
        registrarActividad("Consultar por fecha", resultado, "1011234567", "123ABC", "Filial A01", Estado.Activo);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado);
    }

    // Método para consultar por código o placa
    public void consultarPorCodigo() {
        // Solicitar código o placa al usuario
        String codigo = JOptionPane.showInputDialog("Ingrese el código o la placa:");
        String resultado = "Consulta exitosa para el código o placa: " + codigo;

        // Registrar la actividad
        registrarActividad("Consultar por código o placa", resultado, codigo, "123ABC", "Filial A01", Estado.Activo);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado);
    }

    // Método para generar el archivo de acceso (opcional)
    public void generarTxt() {
        // Aquí puedes implementar la lógica de generación de un archivo, si lo deseas
        JOptionPane.showMessageDialog(null, "Archivo generado.");
    }

}
