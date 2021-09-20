
package Controlador;

import Modelo.Asignatura;
import Modelo.Estudiante;
import Modelo.EstudianteAsignatura;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ControladorEstudianteAsignatura {
    
    public List<Asignatura> lstAsignatura;
    private EstudianteAsignatura ea=new EstudianteAsignatura();
    public List<EstudianteAsignatura> lstEs;
    
     public void leer(String path)
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            lstEs=(List<EstudianteAsignatura>)ois.readObject();
            fileIn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void guardar(EstudianteAsignatura datos, String path) {
        try {
            leer(path);
            if (lstEs==null)
                lstEs=new ArrayList<>();
            lstEs.add(datos);
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lstEs);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    public void cargarAsignaturas(String path)
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            lstAsignatura=(List<Asignatura>)ois.readObject();
            fileIn.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.getMessage();
        }
    }

    /**
     * @return the ea
     */
    public EstudianteAsignatura getEa() {
        return ea;
    }

    /**
     * @param ea the ea to set
     */
    public void setEa(EstudianteAsignatura ea) {
        this.ea = ea;
    }
}
