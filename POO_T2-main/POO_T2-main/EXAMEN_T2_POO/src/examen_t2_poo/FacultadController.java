
package examen_t2_poo;

import java.util.ArrayList;

public class FacultadController 
{
    private ArrayList<Facultad> ListaFacultades;
    public FacultadController()
    {
        ListaFacultades = new ArrayList<>();
    }
    public Facultad BuscarFacultad(String cod_fc)
    {
        for(Facultad f : ListaFacultades)
        {
            if(f.getCodigo_facultad().equalsIgnoreCase(cod_fc))
            {
                return f;
            }
        }
        return null;
    }
    public void AgregarFacultad(Facultad f)
    {
        if(BuscarFacultad(f.getCodigo_facultad())== null)
        {
            ListaFacultades.add(f);
        }
    }
    public Boolean EstaVacia()
    {
        return ListaFacultades.isEmpty();
    }
    public void ListarFacultades()
    {
        for(Facultad fc : ListaFacultades)
        {
            System.out.println(fc.MostrarDatosFacultades());
        }
    }
}