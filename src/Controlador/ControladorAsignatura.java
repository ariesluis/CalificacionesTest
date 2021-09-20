
package Controlador;

import Modelo.Asignatura;
import Modelo.Docente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ControladorAsignatura {
    public List<Asignatura> lstAsig;
    public List<Docente> lstDocente=new ArrayList<>();
    public Docente docente;
    
    public void buscarDocente(String path, String ci)
    {
        lstDocente= new ControladorDocente().leerDocente(path);
        for (Docente d : lstDocente) {
            if(d.getCedula().equals(ci))
                docente=d;
        }
    }
    
    
    
    public void guardarAsignatura(Docente d, String nombre, List<String> nom, List<Double> val, String path) {
        try {
            Asignatura obj=new Asignatura();
            obj.setCodigo(0);
            obj.setNombre(nombre);
            obj.setDocente(d);
            obj.setNom_param(nom);
            obj.setVal_param(val);
            
            leerAsignaturas(path);
            if(lstAsig==null)
                lstAsig=new ArrayList<>();
            lstAsig.add(obj);
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lstAsig);
            out.close();
            
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    public void leerAsignaturas(String path)
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            lstAsig=(List<Asignatura>)ois.readObject();
            fileIn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
