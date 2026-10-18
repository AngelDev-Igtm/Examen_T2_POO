
package examen_t2_poo;

public class Facultad 
{
    private String nombre_facultad;
    private String codigo_facultad;

    public Facultad() {
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad)
    {
        if(nombre_facultad == null || nombre_facultad.trim().isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        this.nombre_facultad = nombre_facultad;
    }

    public String getCodigo_facultad() {
        return codigo_facultad;
    }

    public void setCodigo_facultad(String codigo_facultad)
    {
        if(codigo_facultad == null || codigo_facultad.trim().isEmpty() || codigo_facultad.length()!=3)
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo con informacion valida. Intente nuevamente:");
        }
        this.codigo_facultad = codigo_facultad;
    }
    public String MostrarDatosFacultades()
    {
        return "NOMBRE: "+this.nombre_facultad+" | CODIGO: "+this.codigo_facultad;
    }
}