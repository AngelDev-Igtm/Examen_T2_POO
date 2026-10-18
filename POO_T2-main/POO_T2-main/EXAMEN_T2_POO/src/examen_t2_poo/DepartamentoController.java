
package examen_t2_poo;

import java.util.ArrayList;

public class DepartamentoController 
{
    private ArrayList<DepartamentoAcademico> ListaDepartamento;
    public DepartamentoController()
    {
        ListaDepartamento = new ArrayList<>();
    }
    public DepartamentoAcademico BuscaDepartamento(int cod_dpt)
    {
        for(DepartamentoAcademico d : ListaDepartamento)
        {
            if(d.getCodigo_departamento() == cod_dpt)
            {
                return  d;
            }
        }
        return null;
    }
    public Boolean EstaVacia()
    {
        return ListaDepartamento.isEmpty();
    }
    public void AgregarDepartamento(DepartamentoAcademico dp)
    {
        if(BuscaDepartamento(dp.getCodigo_departamento()) == null)
        {
            ListaDepartamento.add(dp);
        }
    }
    public void ListarDepartamentos()
    {
        for(DepartamentoAcademico d : ListaDepartamento)
        {
            System.out.println(d.MostrarDatosDepartamento());
        }
    }
}