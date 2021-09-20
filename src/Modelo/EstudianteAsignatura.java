package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstudianteAsignatura implements Serializable {

    //Atributos.
    private int codigo;
    //Objeto Estudiante.
    private Estudiante estudiante;
    //Objeto de tipo Asignatura.
    private Asignatura asignatura;
    private double notaGlobal;
    //Objeto ArrayList de tipo Asignatura.
    private List<Double> parametrosNota;

    //Metodos Accesores Getters y Setters.
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public double getNotaGlobal() {
        return notaGlobal;
    }

    public void setNotaGlobal(double notaGlobal) {
        this.notaGlobal = notaGlobal;
    }

    public List<Double> getParametrosNota() {
        return parametrosNota;
    }

    public void setParametrosNota(List<Double> parametrosNota) {
        this.parametrosNota = parametrosNota;
    }

}
