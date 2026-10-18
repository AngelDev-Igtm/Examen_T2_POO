
package examen_t2_poo;

import java.util.ArrayList;

public class DocenteController 
{
    private ArrayList<Docente> ListaDocentes;

    public DocenteController() 
    {
        ListaDocentes = new ArrayList<>();
    }
    public Docente BuscarDocente(String doc_d)
    {
        for(Docente d : ListaDocentes)
        {
            if(d.getNro_doc().equalsIgnoreCase(doc_d))
            {
                return d;
            }
        }
        return null;
    }
    public void AgregarDocente(Docente d)
    {
        if(BuscarDocente(d.getNro_doc())== null)
        {
            ListaDocentes.add(d);
        }
    }
    public void ListarDocentes()
    {
        for(Docente dc : ListaDocentes)
        {
            System.out.println(dc.MostrarDatosDocente());
            System.out.println(dc.MostrarSueldoNeto());
            System.out.println(dc.MostrarHistorialMov());
        }
    }
}