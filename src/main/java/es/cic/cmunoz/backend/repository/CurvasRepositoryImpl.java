package es.cic.cmunoz.backend.repository;

import es.cic.cmunoz.backend.dominio.Curvas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Interfaz que uso para la adición de métodos propios que no tiene
 * CrudRepository por defecto
 */
public class CurvasRepositoryImpl implements CurvasRepository {

    /**
     * Es un objeto que tiene métodos por defecto para el tratamiento de la base
     * de datos
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Método usado para hacer la actualización (Update) de las curvas que
     * tengan un Id de curva de 99.999 o menos en los que cambia la fecha por
     * una String definida por codigo
     */
    @Override
    public void updateCurvas() {

        Query consulta = new Query(Criteria.where("Id Curva").lt(100000));

        Update actualizado = new Update();
        actualizado.set("Fecha", "Cambio Fecha Menores De 100000");

        mongoTemplate.updateMulti(consulta, actualizado, "JuanchoCurvas");

    }

    /**
     * Método usado para hacer la actualización (Update) de la curva que tenga
     * id 1 en la que le cambia el código del pais del Cups a Gran Bretaña
     */
    @Override
    public void updateUnaCurva() {
        Query consulta = new Query(Criteria.where("Id Curva").is(1));

        Update actualizado = new Update();
        actualizado.set("Cups", "GB0027700000000000000010F");

        mongoTemplate.updateFirst(consulta, actualizado, "JuanchoCurvas");
    }

    @Override
    public Curvas findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas findByIdCurva(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas findByCups(String cups) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas findByMagnitud(String magnitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas findByFecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas findByValores(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas encontrarCups(String cups) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curvas> encontrarFechas(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas encontrarIdCurva(long idCurva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curvas> encontrarCurvasPorPattern(String valorInicio, String flagFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Curvas> S save(S entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Curvas> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curvas findOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Curvas> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Curvas> findAll(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Curvas entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Curvas> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
