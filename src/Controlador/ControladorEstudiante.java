
package Controlador;

import Modelo.Estudiante;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ControladorEstudiante {
    public List<Estudiante> lst;
    private Estudiante estudiante=new Estudiante();
    
    public void guardarEstudiante(Estudiante datos, String path) {
        try {
            leerDEstudiante(path);
            if (lst==null)
                lst=new ArrayList<>();
            lst.add(datos);
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lst);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void leerDEstudiante(String path)
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            lst=(List<Estudiante>)ois.readObject();
            fileIn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //Metodos Accesores y Modificadores del Objeto de tipo Estudiante.

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
}