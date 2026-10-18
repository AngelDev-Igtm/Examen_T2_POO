
package examen_t2_poo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Docente 
{
    protected String nombre;
    protected String apellido_p;
    protected String apellido_m;
    protected String tipo_doc;
    protected String nro_doc;
    protected String direccion;
    protected String telefono;
    protected LocalDate fecha_ingreso;
    protected DepartamentoAcademico departamento_actual;
    protected SistemaPensionario sistema_pension;
    protected ArrayList<MovimientoDepartamento> ListaMovimientos = new ArrayList<>();

    public Docente() {
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        if(nombre == null || nombre.trim().isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p)
    {
         if(apellido_p == null || apellido_p.trim().isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) 
    {
         if(apellido_m == null || apellido_m.trim().isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        this.apellido_m = apellido_m;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) 
    {
         if(tipo_doc == null || tipo_doc.trim().isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        if(!tipo_doc.equalsIgnoreCase("dni") && !tipo_doc.equalsIgnoreCase("ce"))
        {
             throw new IllegalArgumentException("Error: No se acepta este tipo de documento. Debe ser DNI o CE. Intente nuevamente:");
        }
        this.tipo_doc = tipo_doc;
    }

    public String getNro_doc() {
        return nro_doc;
    }

    public void setNro_doc(String nro_doc) 
    {
         if(nro_doc == null || nro_doc.trim().isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
         if(this.tipo_doc == null)
        {
            throw new IllegalStateException("Error: Primero debe asignar el tipo de documento. Intente nuevamente:");
        }
        if(this.tipo_doc.equalsIgnoreCase("dni") && nro_doc.length()!= 8)
        {
            throw new IllegalArgumentException("Error: El DNI debe tener obligatoriamente 8 digitos. Intente nuevamente:");
        }
        if(this.tipo_doc.equalsIgnoreCase("ce") && nro_doc.length()!= 9)
        {
            throw new IllegalArgumentException("Error: El CE debe tener obligatoriamente 9 digitos. Intente nuevamente:");
        }
        this.nro_doc = nro_doc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
         if(direccion == null || direccion.trim().isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
         if(telefono == null || telefono.isEmpty())
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        if(telefono.trim().length()!=9)
        {
            throw new IllegalArgumentException("Error: El numero de telefono debe tener obligatoriamente 9 digitos. Intente nuevamente:");
        }
        if(!telefono.trim().startsWith("9"))
        {
            throw new IllegalArgumentException("Error: El telefono debe empezar con '9'. Intente nuevamente:");
        }
        this.telefono = telefono;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) 
    {
         if(fecha_ingreso == null)
        {
            throw new IllegalArgumentException("Error: Debe llenar este campo primero. Intente nuevamente:");
        }
        this.fecha_ingreso = fecha_ingreso;
    }

    public DepartamentoAcademico getDepartamento_actual() {
        return departamento_actual;
    }

    public void setDepartamento_actual(DepartamentoAcademico departamento_actual) 
    {
        if(departamento_actual == null)
        {
            throw new IllegalArgumentException("Error: Debe asignar este campo obligatoriamente. Intente nuevamente:");
        }
        this.departamento_actual = departamento_actual;
    }

    public SistemaPensionario getSistema_pension() {
        return sistema_pension;
    }

    public void setSistema_pension(SistemaPensionario sistema_pension) 
    {
        if(sistema_pension == null)
        {
            throw new IllegalArgumentException("Error: Debe asignar este campo obligatoriamente. Intente nuevamente:");
        }
        this.sistema_pension = sistema_pension;
    }
    public void AsignarNuevoDepartamento(DepartamentoAcademico nuevo_dep, LocalDate fecha_nuevo_mov)
    {
        if(nuevo_dep == null || fecha_nuevo_mov == null)
        {
            throw new IllegalArgumentException("Error: Debe asignar estos datos correctamente. Intente de nuevo:");
        }
        if(this.fecha_ingreso != null && fecha_nuevo_mov.isBefore(fecha_ingreso))
        {
            throw new IllegalArgumentException("Error: La fecha de movimiento no debe ser anterior a la de ingreso. Intente nuevamente:");
        }
        if(!ListaMovimientos.isEmpty())
        {
            MovimientoDepartamento ultimoMovimiento = ListaMovimientos.get(ListaMovimientos.size()-1);
            ultimoMovimiento.setFecha_fin(fecha_nuevo_mov);
        }
        MovimientoDepartamento nuevoMovimiento = new MovimientoDepartamento();
        nuevoMovimiento.setDepartamento(nuevo_dep);
        nuevoMovimiento.setFecha_inicio(fecha_nuevo_mov);
        
        ListaMovimientos.add(nuevoMovimiento);
        this.departamento_actual = nuevo_dep;
    }
    public String MostrarHistorialMov()
    {
        if(this.ListaMovimientos.isEmpty())
        {
            return "Este docente aun no tiene movimientos/rotaciones registrados.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("----------------HISTORIAL MOVIMIENTOS--------------------\n");
        for(MovimientoDepartamento md : ListaMovimientos)
        {
            sb.append(md.MostrarDatosMovimiento()).append("\n");
        }
        return sb.toString();
    }
    public abstract String MostrarDatosDocente();
    public abstract String MostrarSueldoNeto();
}