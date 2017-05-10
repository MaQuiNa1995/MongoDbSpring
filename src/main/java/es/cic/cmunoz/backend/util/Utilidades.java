package es.cic.cmunoz.backend.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * Clase que contiene métodos para la generación de datos
 */
@Service
public class Utilidades {

    private static final Logger LOG = Logger.getLogger(Utilidades.class.getName());

    /**
     * Método usado para la generación de Cups
     *
     * @param numeroCups Número usado para la generación del cups (Corresponde
     * al numero variable del cups)
     * @return cupsGenerado - Cups generado y formateado
     */
    public String generarCups(int numeroCups) {

        LOG.info("Generando cups");

        final String PRINCIPIOCUPS = "ES00277000000000";
        final String FINCUPS = "0F";

        StringBuilder sb = new StringBuilder(PRINCIPIOCUPS);

        String cadenaConvertida = annadirCeros(String.valueOf(numeroCups));

        sb.append(cadenaConvertida);
        sb.append(FINCUPS);

        String cupsGenerado = sb.toString();

        return cupsGenerado;
    }

    /**
     * Método usado para la generación de un millón de ids
     *
     * @return mapaIds - Lista que contiene todos los ids que usaremos
     */
    public List<Integer> generarId() {

        LOG.info("Generando arreglo de Id Curvas");

        List<Integer> mapaIds = new ArrayList<>();

        for (int i = 1; i < 1000001; i++) {
            mapaIds.add(i);
        }

        return mapaIds;
    }

    /**
     * Método usado para la generación de un millón de fechas del año 2016
     *
     * @return mapaFechas - Lista de fechas generadas
     */
    public List<String> generarFechas() {

        LOG.info("Generando arreglo de fechas");

        final String ANNO = "2016";
        final int arraymeses[] = generarDiasMeses();

        int registrosCompletados = 0;

        List<String> mapaFechas = new ArrayList<>();

        do {

            int contadorMeses = 1;

            for (int mes : arraymeses) {

                for (int dia = 1; dia < mes + 1; dia++) {

                    StringBuilder fechaCompleta = new StringBuilder();

                    fechaCompleta.append(ANNO);
                    fechaCompleta.append(formatearDiaMes(contadorMeses));
                    fechaCompleta.append(formatearDiaMes(dia));

                    mapaFechas.add(fechaCompleta.toString());
                    if (registrosCompletados < 1000000) {
                        registrosCompletados++;
                    } else {
                        return mapaFechas;
                    }

                }
                contadorMeses++;
            }

        } while (registrosCompletados < 1000000);

        return mapaFechas;
    }

    /**
     * Método usado para la generación de cinco fechas
     *
     * @return mapaFechas - Arreglo que contiene las fechas generadas y
     * formateadas
     */
    public String[] generarCincoFechas() {

        LOG.info("Generando cinco fechas");

        final String ANNO = "2016";

        String mapaFechas[] = {
            null, null, null, null, null, null
        };

        for (int i = 0; i < mapaFechas.length; i++) {

            StringBuilder fechaCompleta = new StringBuilder();

            if (i != 6) {
                fechaCompleta.append(ANNO);
                fechaCompleta.append(generarUnMes());
                fechaCompleta.append(generarUnDia());

                mapaFechas[i] = fechaCompleta.toString();
            } else {
                mapaFechas[i] = "FechaNoExistente";
            }

        }

        return mapaFechas;
    }

    /**
     * Método usado para la generación de un dia aleatorio
     *
     * @return diaFormateado - String que representa el dia generado en numeros
     */
    private String generarUnDia() {

        Random rand = new Random();
        int dia = rand.nextInt(30) + 1;

        String diaFormateado;
        if (dia < 10) {
            diaFormateado = "0".concat(String.valueOf(dia));
        } else {
            diaFormateado = String.valueOf(dia);
        }

        return diaFormateado;
    }

    /**
     * Método usado para la generación de un mes aleatorio
     *
     * @return diaFormateado - String que representa el mes generado en numeros
     */
    private String generarUnMes() {

        Random rand = new Random();
        int mes = rand.nextInt(12) + 1;

        String mesFormateado;
        if (mes < 10) {
            mesFormateado = "0".concat(String.valueOf(mes));
        } else {
            mesFormateado = String.valueOf(mes);
        }

        return mesFormateado;
    }

    /**
     * Método usado para la generación de valores
     *
     * @return magnitudGenerada - String que representa el valor generado y
     * formateado
     */
    public int[] generarValores() {

        LOG.info("Generando Valores");

        int[] arregloValores = new int[25];

        for (int i = 0; i < arregloValores.length; i++) {
            arregloValores[i] = 1678;
        }

        return arregloValores;

    }

    /**
     * Método usado para la generación de flags
     *
     * @return flagGenerada - String que representa el valor generado y
     * formateado
     */
    public int[] generarFlags() {

        LOG.info("Generando Flags");

        int[] arregloFlag = new int[25];

        final int LIMITE = 2;
        Random rand = new Random();
        for (int i = 0; i < arregloFlag.length; i++) {
            arregloFlag[i] = rand.nextInt(LIMITE);
        }

        return arregloFlag;
    }

    /**
     * Método usado para la generacion del arreglo de los meses del año
     *
     * @return ARREGLOMESES - Arreglo que contiene la información de los meses
     * del año
     */
    private int[] generarDiasMeses() {

        final int ENERO = 31;
        final int MARZO = 31;
        final int MAYO = 31;
        final int JULIO = 31;
        final int AGOSTO = 31;
        final int OCTUBRE = 31;
        final int DICIEMBRE = 31;

        final int ABRIL = 30;
        final int JUNIO = 30;
        final int SEPTIEMBRE = 30;
        final int NOVIEMBRE = 30;

        final int FEBRERO = 28;

        final int ARREGLOMESES[] = {
            ENERO, FEBRERO, MARZO,
            ABRIL, MAYO, JUNIO,
            JULIO, AGOSTO, SEPTIEMBRE,
            OCTUBRE, NOVIEMBRE, DICIEMBRE
        };

        return ARREGLOMESES;
    }

    /**
     * Método usado para el formateado de un dia del mes
     *
     * @param diaMes String del dia del mes sin formatear
     * @return diaMesFormateado - String dia del mes formateada
     */
    private String formatearDiaMes(int diaMes) {
        StringBuilder sb = new StringBuilder();
        if (diaMes < 10) {
            sb.append("0");
        }
        String diaMesFormateado = sb.append(diaMes).toString();

        return diaMesFormateado;
    }

    /**
     * Método usado para el formateado de un cups
     *
     * @param cadenaSinCeros Cups sin formatear
     * @return cadenaConvertida - Cups formateado
     */
    private String annadirCeros(String cadenaSinCeros) {

        StringBuilder sb = new StringBuilder();

        int cerosAgregar = 7 - cadenaSinCeros.length();

        if (cerosAgregar != 0) {
            for (int i = 0; i < cerosAgregar; i++) {
                sb.append("0");
            }
        }

        String cadenaConvertida = sb.append(cadenaSinCeros).toString();

        return cadenaConvertida;
    }

    /**
     * Método usado para la generación de ids
     *
     * @return ARREGLOIDS - Arreglo de ids
     */
    public int[] generarArregloIds() {

        LOG.info("Generando arreglo de ids");

        final int[] ARREGLOIDS = {
            1, 200000, 400000,
            600000, 800000,
            1000000, 234567890
        };

        return ARREGLOIDS;
    }

    /**
     * Método usado para la generación de cups aleatorios
     *
     * @return arregloRandoms - arreglo que contiene los cups generados
     */
    public List<String> generarArreglosCups() {

        LOG.info("Generando arreglo de cups");

        Random rand = new Random();
        List<String> arregloRandoms = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String cupsGenerado = generarCups(rand.nextInt(1000000));
            arregloRandoms.add(cupsGenerado);
        }

        return arregloRandoms;
    }

    /**
     * Método usado para conseguir la hora actual
     *
     * @return ahoraMismo - Tiempo de ahora mismo en milisegundos
     */
    public static long conseguirHora() {

        long ahoraMismo = Calendar.getInstance().getTimeInMillis();

        return ahoraMismo;
    }

    /**
     * Método usado para el cálculo entre horas
     *
     * @param antes registro del primer tiempo
     * @param despues registro del segundo tiempo
     * @return tiempoCalculado - numero que contiene el resultado de la
     * operación
     */
    public long calcularTiempo(long antes, long despues) {

        long tiempoCalculado = despues - antes;

        return tiempoCalculado;
    }

    /**
     * Método usado para registrar una String en un fichero predeterminado
     *
     * @param cadenaMeter String que meteremos al archivo
     */
    public void registrarActividad(String cadenaMeter) {

        String nombreFichero = "log.txt";

        try (FileWriter fichero = new FileWriter(nombreFichero, true)) {

            fichero.write(cadenaMeter + "\r\n");

        } catch (IOException ex) {
            LOG.log(
                    Level.INFO,
                    "Hubo una excepcion al intentar escribir en el fichero {0}"
                    + "Razon: {1}", new Object[]{nombreFichero, ex.getMessage()});
        }
    }

}
