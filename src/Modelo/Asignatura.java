
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Asignatura implements Serializable{
    //Atributos
    private int codigo;
    private String nombre;
    //Objeto de tipo Docente.
    private Docente docente;
    //ArrayList de tipo Nota con valores academicos de los estudiantes.
    private List<String> nom_param;
    private List<Double> val_param;
    
    //Metodos Accesores Getters y Setters.

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * @return the nom_param
     */
    public List<String> getNom_param() {
        return nom_param;
    }

    /**
     * @param nom_param the nom_param to set
     */
    public void setNom_param(List<String> nom_param) {
        this.nom_param = nom_param;
    }

    /**
     * @return the val_param
     */
    public List<Double> getVal_param() {
        return val_param;
    }

    /**
     * @param val_param the val_param to set
     */
    public void setVal_param(List<Double> val_param) {
        this.val_param = val_param;
    }

    
}
