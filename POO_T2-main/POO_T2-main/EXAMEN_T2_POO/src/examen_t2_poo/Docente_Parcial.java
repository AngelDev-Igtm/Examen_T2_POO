
package examen_t2_poo;

public class Docente_Parcial extends Docente
{
    private int horas_dictadas;
    private double tarifa_hora;

    public Docente_Parcial() {
    }

    public int getHoras_dictadas() {
        return horas_dictadas;
    }

    public void setHoras_dictadas(int horas_dictadas)
    {
        if(horas_dictadas < 0)
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo con un numero de horas valido. Intente nuevamente:");
        }
        this.horas_dictadas = horas_dictadas;
    }

    public double getTarifa_hora() {
        return tarifa_hora;
    }

    public void setTarifa_hora(double tarifa_hora) 
    {
        if(tarifa_hora <=0)
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo con una tarifa por hora valida. Intente nuevamente:");
        }
        this.tarifa_hora = tarifa_hora;
    }

    @Override
    public String MostrarDatosDocente()
    {
        return "NOMBRE: "+this.nombre+" | APELLIDO PAT: "+ this.apellido_p+" | APELLIDO MAT: "+this.apellido_m+" | TIPO DOC: "+this.tipo_doc+
         " | NRO DOC: "+this.nro_doc+" | DIRECCION: "+this.direccion+" | TELEFONO: "+this.telefono+" | FECHA INGRESO: "
                +this.fecha_ingreso+" | HORAS DICTADAS: "+this.horas_dictadas+" | TARIFA HORA: S/"+this.tarifa_hora
                +" | DEPARTAMENTO ACTUAL: "+this.departamento_actual.getNombre_departamento()+" | SISTEMA PENSIONARIO: "+this.sistema_pension.name();
    }
    public double SueldoCalculado()
    {
        return this.horas_dictadas*this.tarifa_hora;
    }

    @Override
    public String MostrarSueldoNeto() 
    {
        return "SUELDO NETO: S/"+SueldoCalculado();
    }
}