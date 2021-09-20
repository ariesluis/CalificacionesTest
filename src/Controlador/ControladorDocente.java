
package Controlador;

import Modelo.Docente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ControladorDocente {
    
    private List<Docente> lstD;
    private Docente docente = new Docente();
    
    public void guardarDocente(Docente datos, String path) {
        try {
            lstD = leerDocente(path);
            if (lstD==null)
                lstD = new ArrayList<>();
            lstD.add(datos);
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lstD);
            out.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public List<Docente> leerDocente(String path)
    {
        try
        {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lstD = (List<Docente>)ois.readObject();
            ois.close();
            return lstD;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    //Metodos Acceso del Objeto de Tipo Docente.

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
}
