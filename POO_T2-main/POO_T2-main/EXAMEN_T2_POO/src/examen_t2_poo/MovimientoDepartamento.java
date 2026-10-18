
package examen_t2_poo;

import java.time.LocalDate;

public class MovimientoDepartamento 
{
    private DepartamentoAcademico departamento;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    public MovimientoDepartamento()
    {
       this.fecha_fin = null;
    }

    public DepartamentoAcademico getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoAcademico departamento)
    {
        if(departamento == null)
        {
            throw new IllegalArgumentException("Error: Se debe asignar este campo primero. Intente nuevamente");
        }
        this.departamento = departamento;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) 
    {
        if(fecha_inicio == null)
        {
            throw new IllegalArgumentException("Error: Debe completar este campo primero. Intente nuevamente:");
        }
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) 
    {
        if(fecha_fin != null && this.fecha_inicio != null && fecha_fin.isBefore(this.fecha_inicio))
        {
            throw new IllegalArgumentException("Error: La fecha de fin no puede ser igual a la de inicio. Intente nuevamente:");
        }
        this.fecha_fin = fecha_fin;
    }
    public String MostrarDatosMovimiento()
    {
        String fin = (this.fecha_fin == null) ? "Actualidad" : this.fecha_fin.toString();
        return "DEPARTAMENTO: "+this.departamento.getNombre_departamento()+" | DESDE: "+this.fecha_inicio.toString()+" | HASTA: "+fin;
    }
}