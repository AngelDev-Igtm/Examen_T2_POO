
package examen_t2_poo;

public class DepartamentoAcademico 
{
    private String nombre_departamento;
    private int codigo_departamento;
    private Facultad facultad;

    public DepartamentoAcademico() {
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) 
    {
        if(nombre_departamento == null || nombre_departamento.isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        this.nombre_departamento = nombre_departamento;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento)
    {
        if(codigo_departamento<1000 || codigo_departamento>9999)
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo con informacion valida. Intente nuevamente:");
        }
        this.codigo_departamento = codigo_departamento;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad)
    {
        this.facultad = facultad;
    } 
    public Boolean esIndependiente()
    {
        return this.facultad == null;
    }
    public String MostrarDatosDepartamento()
    {
         String dependencia = esIndependiente() ? "INDEPENDIENTE" : "FACULTAD: " + this.facultad.getNombre_facultad();
        return "DEPARTAMENTO: " + this.nombre_departamento + " | COD DEPARTAMENTO: " + this.codigo_departamento + " | " + dependencia;
    }
}