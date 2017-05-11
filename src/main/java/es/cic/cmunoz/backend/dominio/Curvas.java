package es.cic.cmunoz.backend.dominio;

import java.util.Arrays;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Pattern(regexp=".+@.+\\.[a-z]+")
@Document(collection = "Curvas")
public class Curvas {

    @Id
    private String id;
    @Field("Id Curva")
    private int idCurva;
    @Field("Cups")
    private String cups;
    @Field("Magnitud")
    private int magnitud;
    @Field("Fecha")
    private String fecha;
    @Field("Valores")
    private int[] valores;
    @Field("Flag")
    private int[] flag;

    public Curvas() {

    }

    public Curvas(int idCurva, String cups,
            int magnitud, String fecha, int[] valores, int[] flag) {
        this.idCurva = idCurva;
        this.cups = cups;
        this.magnitud = magnitud;
        this.fecha = fecha;
        this.valores = valores;
        this.flag = flag;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdCurva() {
        return idCurva;
    }

    public void setIdCurva(int idCurva) {
        this.idCurva = idCurva;
    }

    public String getCups() {
        return cups;
    }

    public void setCups(String cups) {
        this.cups = cups;
    }

    public int getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(int magnitud) {
        this.magnitud = magnitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int[] getValores() {
        return valores;
    }

    public void setValores(int[] valores) {
        this.valores = valores;
    }

    public int[] getFlag() {
        return flag;
    }

    public void setFlag(int[] flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Curvas{" + "id=" + id + ", idCurva=" + idCurva + ", cups=" + cups + ", magnitud=" + magnitud + ", fecha=" + fecha + ", valores=" + Arrays.toString(valores) + ", flag=" + Arrays.toString(flag) + '}';
    }



}
