
package examen_t2_poo;

public class Docente_Tiempo_Completo extends Docente
{
    private double sueldo_fijo;
    private int inasistencias;
    private int tardanzas;
    private final double dsct_inasistencia = 40.0;
    private final double dsct_tardanza = 15.0;

    public Docente_Tiempo_Completo() {
    }

    public double getSueldo_fijo() {
        return sueldo_fijo;
    }

    public void setSueldo_fijo(double sueldo_fijo) 
    {
        if(sueldo_fijo <=0)
        {
            throw new IllegalArgumentException("Error: Ingrese un monto de sueldo valido. Intente nuevamente:");
        }
        this.sueldo_fijo = sueldo_fijo;
    }

    public int getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(int inasistencias) 
    {
        if(inasistencias<0)
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo con un numero de inasistencias valido. Intente nuevamente:");
        }
        this.inasistencias = inasistencias;
    }

    public int getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(int tardanzas) 
    {
        if(tardanzas < 0)
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo con un numero de tardanzas valido. Intente nuevamente:");
        }
        this.tardanzas = tardanzas;
    }

    @Override
    public String MostrarDatosDocente() 
    {
        return "NOMBRE: "+this.nombre+" | APELLIDO PAT: "+this.apellido_p+" | APELLIDO MAT: "+this.apellido_m+" | TIPO DOC: "+this.tipo_doc+" | NRO DOC: "+this.nro_doc
                +" | DIRECCION: "+this.direccion+" | TELEFONO: "+this.telefono+" | FECHA INGRESO: "+this.fecha_ingreso+" | SUELDO FIJO: "+this.sueldo_fijo
                +" | NRO TARDANZAS: "+this.tardanzas+" | NRO INASISTENCIAS: "+this.inasistencias
                +" | DEPARTAMENTO ACTUAL: "+this.departamento_actual.getNombre_departamento()+" | SISTEMA PENSIONARIO: "+this.sistema_pension.name();
    }
    public double CalcularSueldoNeto()
    {
        double total_descuento = (this.tardanzas*dsct_tardanza)+(this.inasistencias*dsct_inasistencia);
        return this.sueldo_fijo-total_descuento;
    }

    @Override
    public String MostrarSueldoNeto() 
    {
        return "SUELDO NETO: s/"+CalcularSueldoNeto();
    }
}