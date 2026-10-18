package examen_t2_poo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EXAMEN_T2_POO 
{

    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        DocenteController dc = new DocenteController();
        DepartamentoController dpc= new DepartamentoController();
        FacultadController fc = new FacultadController();
        
        do 
        {           
            System.out.println("-----------------------------------REGISTRO DE DATOS GLOBALTEC----------------------------------------\n");
            System.out.println("SELECCIONE UNA OPCION:");
            System.out.println("(1) REGISTRAR FACULTAD");
            System.out.println("(2) REGISTRAR DEPARTAMENTO ACADEMICO");
            System.out.println("(3) REGISTRAR DOCENTE");
            System.out.println("(4) AGREGAR MOVIMIENTO/ROTACION DE DOCENTE");
            System.out.println("(5) REGISTRAR TARDANZA O INASISTENCIA DE DOCENTE");
            System.out.println("(6) MOSTRAR LISTA DE DOCENTES");
            System.out.println("(7) MOSTRAR LISTA DE DEPARTAMENTOS");
            System.out.println("(8) MOSTRAR LISTA DE FACULTADES");
            int opMenu = teclado.nextInt();
            teclado.nextLine();
            
            switch (opMenu) 
            {
                case 1:
                    
                    Facultad f = new Facultad();
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("NOMBRE FACULTAD:");
                            f.setNombre_facultad(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("CODIGO FACULTAD (3 DIGITOS):");
                            f.setCodigo_facultad(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    if(fc.BuscarFacultad(f.getCodigo_facultad())!=null)
                    {
                        System.out.println("Error: Ya existe una facultad con ese codigo. Registro cancelado.");
                        break;
                    }
                    fc.AgregarFacultad(f);
                    break;
                case 2:
                    DepartamentoAcademico dp = new DepartamentoAcademico();
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("NOMBRE DEPARTEMENTO:");
                            dp.setNombre_departamento(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("CODIGO (4 DIGITOS):");
                            dp.setCodigo_departamento(teclado.nextInt());
                            teclado.nextLine();
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                        catch(InputMismatchException ie)
                        {
                            System.out.println("Error: Debe ingresar numeros en este campo. Intente nuevamente:");
                            teclado.nextLine();
                        }
                    }
                    if(dpc.BuscaDepartamento(dp.getCodigo_departamento())!=null)
                    {
                        System.out.println("Error: Ya existe un departamento con este codigo. Registro  cancelado");
                        break;
                    }
                    Boolean registroFacValido = true;
                    while (true)
                    {                        
                        System.out.println("FACULTAD: (S/N)");
                        String opFacultad = teclado.nextLine();
                        if(opFacultad.equalsIgnoreCase("s"))
                        {
                            if(fc.EstaVacia())
                            {
                                System.out.println("Error: No hay facultades registradas todavia.");
                                registroFacValido = false;
                                break;
                            }
                            System.out.println("INGRESE EL CODIGO DE LA FACULTAD A LA QUE SE VA A ASIGNAR:");
                            String cof_fc = teclado.nextLine().trim();
                            Facultad fac = fc.BuscarFacultad(cof_fc); //Cambie el f y le puse fac
                            if(fac == null)
                            {
                                System.out.println("Error: No existe esta facultad.");
                                registroFacValido = false;
                                break;
                            }
                            dp.setFacultad(fac);
                            break;
                        }
                        else if(opFacultad.equalsIgnoreCase("n"))
                        {
                            dp.setFacultad(null);
                            break;
                        }
                        else
                        {
                            System.out.println("Error. Ingrese una opcion valida. Intente nuevamente:");
                        }
                    }
                    if(registroFacValido)
                    {
                        dpc.AgregarDepartamento(dp);
                    }
                    else
                    {
                        System.out.println("Error: Registro cancelado.");
                    }
                    break;
                case 3:
                    
                    if(dpc.EstaVacia())
                    {
                        System.out.println("Error: No hay departamentos registrados todavia");
                        System.out.println("Primero debe registrar uno. Intente nuevamente:");
                        break;
                    }
                    System.out.println("SELECCIONE EL TIPO DE CONTRATO: (1) DOCENTE PARCIAL (2) DOCENTE TIEMPO COMPLETO");
                    int opContrato = teclado.nextInt();
                    teclado.nextLine();
                    
                    Docente docente = (opContrato == 1) ? new Docente_Parcial() : new Docente_Tiempo_Completo();
                    
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("NOMBRE:");
                            docente.setNombre(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("APELLIDO PATERNO:");
                            docente.setApellido_p(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("APELLIDO MATERNO:");
                            docente.setApellido_m(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("TIPO DOCUMENTO:");
                            docente.setTipo_doc(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("NRO DOCUMENTO:");
                            docente.setNro_doc(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    if(dc.BuscarDocente(docente.getNro_doc())!=null)
                    {
                        System.out.println("Error: Ya se registró un docente con este numero de documento. Intente nuevamente:");
                        break;
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("DIRECCION:");
                            docente.setDireccion(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("TELEFONO: ");
                            docente.setTelefono(teclado.nextLine());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) 
                    {                        
                        try 
                        {
                            System.out.println("FECHA DE INGRESO: (AAAA-MM-DD)");
                            docente.setFecha_ingreso(LocalDate.parse(teclado.nextLine()));
                            break;
                        } catch (DateTimeException de) 
                        {
                            System.out.println("Error: Use el formato de fecha adecuado: AAAA-MM-DD. Intente nuevamente:");
                        }
                        catch (IllegalArgumentException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("SELECCIONE UN SISTEMA PENSIONARIO: (1)ONP (2)AFP");
                    int opPension = teclado.nextInt();
                    teclado.nextLine();
                    if(opPension == 1)
                    {
                        docente.setSistema_pension(SistemaPensionario.ONP);
                    }
                    else
                    {
                        System.out.println("SELECCIONE EL TIPO DE AFP: (1)PRIMA (2)HABITAT (3)INTEGRA");
                        int tipoAFP = teclado.nextInt();
                        teclado.nextLine();
                        switch (tipoAFP)
                        {
                            case 1:
                                docente.setSistema_pension(SistemaPensionario.AFP_PRIMA);
                                break;
                            case 2:
                                docente.setSistema_pension(SistemaPensionario.AFP_HABITAT);
                                break;
                            case 3:
                                docente.setSistema_pension(SistemaPensionario.AFP_INTEGRA);
                                break;
                        }
                    }
                    Boolean registroValido = true;
                    while (true)
                    {                        
                        try 
                        {
                            System.out.println("INGRESE EL CODIGO DEL DEPARTAMENTO DONDE TRABAJARA:");
                            int cod_dep = teclado.nextInt();
                            teclado.nextLine();
                            DepartamentoAcademico dep = dpc.BuscaDepartamento(cod_dep);
                            if(dep == null)
                            {
                                System.out.println("Error: El departamento asignado no existe. Registro anulado:");
                                registroValido = false;
                                break; 
                            }
                            docente.setDepartamento_actual(dep);
                            docente.AsignarNuevoDepartamento(dep, docente.getFecha_ingreso());
                            break;
                        } catch (IllegalArgumentException e) 
                        {
                            System.out.println(e.getMessage());
                        }
                        catch(InputMismatchException ie)
                        {
                            System.out.println("Error: Debe ingresar numeros en este campo. Intente nuevamente:");
                            teclado.nextLine();
                        }
                    }
                    
                    if(!registroValido)
                    {
                        System.out.println("Error: Registro cancelado.");
                        break;
                    }
                    
                    //downcasting para acceder a los metodos de las clases hijas
                    if(docente instanceof Docente_Parcial)
                    {
                        while (true) 
                        {                            
                            try 
                            {
                                System.out.println("HORAS DICTADAS:");
                                ((Docente_Parcial) docente).setHoras_dictadas(teclado.nextInt());
                                teclado.nextLine();
                                break;
                            } catch (IllegalArgumentException e) 
                            {
                                System.out.println(e.getMessage());
                            }
                            catch(InputMismatchException ie)
                            {
                                System.out.println("Error: Debe ingresar numeros en este campo. Intente nuevamente:");
                                teclado.nextLine();
                            }
                        }
                        while (true)
                        {                            
                            try 
                            {
                                System.out.println("TARIFA POR HORA:");
                                ((Docente_Parcial) docente).setTarifa_hora(teclado.nextDouble());
                                teclado.nextLine();
                                break;
                            } catch (IllegalArgumentException e)
                            {
                                System.out.println(e.getMessage());
                            }
                            catch(InputMismatchException ie)
                            {
                                System.out.println("Error: Debe ingresar numeros en este campo. Intente nuevamente:");
                                teclado.nextLine();
                            }
                        }
                    }
                    else if(docente instanceof Docente_Tiempo_Completo)
                    {
                        while (true) 
                        {                            
                            try 
                            {
                                System.out.println("SUELDO MENSUAL:");
                                ((Docente_Tiempo_Completo) docente).setSueldo_fijo(teclado.nextDouble());
                                teclado.nextLine();
                                break;
                            } catch (IllegalArgumentException e) 
                            {
                                System.out.println(e.getMessage());
                            }
                            catch(InputMismatchException ie)
                            {
                                System.out.println("Error: Debe ingresar numeros en este campo. Intente nuevamente:");
                                teclado.nextLine();
                            }
                        }
                        //faltas e inasistencias inician en 0
                        ((Docente_Tiempo_Completo) docente).setTardanzas(0);
                        ((Docente_Tiempo_Completo) docente).setInasistencias(0);
                    }
                    dc.AgregarDocente(docente);
                    break;
                case 4: 
                {
                    System.out.println("INGRESE EL NRO DE DOCUMENTO DEL DOCENTE:");
                    String docMovimiento = teclado.nextLine().trim();

                    if (docMovimiento.isEmpty()) {
                        System.out.println("Error: Debe ingresar el numero de documento.");
                        break;
                    }

                    Docente docenteMovimiento = dc.BuscarDocente(docMovimiento);

                    if (docenteMovimiento == null) {
                        System.out.println("Error: No existe ningun docente con este numero de documento.");
                        break;
                    }

                    System.out.println("DOCENTE ENCONTRADO: "
                            + docenteMovimiento.getNombre() + " "
                            + docenteMovimiento.getApellido_p());

                    DepartamentoAcademico nuevoDepartamento = null;

                    while (true) {
                        System.out.println("INGRESE EL CODIGO DEL NUEVO DEPARTAMENTO:");

                        String entradaCodigo = teclado.nextLine().trim();
                        int codigoDepartamento;

                        try {
                            codigoDepartamento = Integer.parseInt(entradaCodigo);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Debe ingresar un codigo numerico.");
                            continue;
                        }

                        nuevoDepartamento = dpc.BuscaDepartamento(codigoDepartamento);

                        if (nuevoDepartamento == null) {
                            System.out.println("Error: No existe un departamento con ese codigo. Intente nuevamente:");
                            continue;
                        }

                        break;
                    }

                    while (true) {
                        try {
                            System.out.println("FECHA DEL MOVIMIENTO: (AAAA-MM-DD)");
                            LocalDate fechaMovimiento = LocalDate.parse(teclado.nextLine().trim());

                            docenteMovimiento.AsignarNuevoDepartamento(
                                    nuevoDepartamento,
                                    fechaMovimiento
                            );

                            System.out.println("MOVIMIENTO REGISTRADO CORRECTAMENTE.");
                            System.out.println("DOCENTE: "
                                    + docenteMovimiento.getNombre() + " "
                                    + docenteMovimiento.getApellido_p());
                            System.out.println("NUEVO DEPARTAMENTO: "
                                    + nuevoDepartamento.getNombre_departamento());
                            System.out.println("FECHA DEL MOVIMIENTO: " + fechaMovimiento);

                            break;

                        } catch (DateTimeException e) {
                            System.out.println("Error: Use el formato de fecha adecuado: AAAA-MM-DD. Intente nuevamente:");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;
                }
                case 5:
                    while (true)
                    {
                        try 
                        { 
                            System.out.println("INGRESE EL NRO DE DOCUMENTO DEL DOCENTE:");
                            String doc = teclado.nextLine().trim();
                            if (doc.isEmpty()) 
                            {
                                continue;
                            }
                            Docente d = dc.BuscarDocente(doc);
                            if(d == null)
                            {
                                System.out.println("Error: No existe ningun docente con este numero de documento. Intente nuevamente:");
                                continue; // Permite ingresar el documento otra vez en lugar de cancelar
                            }
                            if (d instanceof Docente_Tiempo_Completo dtc) 
                            {
                                System.out.println("DOCENTE ENCONTRADO: " + dtc.getNombre() + " " + dtc.getApellido_p());
                                System.out.println("REGISTRO QUE DESEA REALIZAR: (1) TARDANZA (2) INASISTENCIA");
                                int opRegistro = teclado.nextInt();
                                teclado.nextLine();
                                switch (opRegistro)
                                {
                                    case 1:
                                        dtc.setTardanzas(dtc.getTardanzas() + 1);
                                        System.out.println("TARDANZA REGISTRADA CORRECTAMENTE (Descuento S/. 15)");
                                        break;
                                    case 2:
                                        dtc.setInasistencias(dtc.getInasistencias() + 1);
                                        System.out.println("INASISTENCIA REGISTRADA CORRECTAMENTE (Descuento S/. 40)");
                                        break;
                                    default:
                                        System.out.println("Error: Opción inválida.");
                                        break;
                                }
                                break; // Registro completado, sale del ciclo para volver al menú principal
                            } 
                            else 
                            {
                                System.out.println("Error: El docente es de Tiempo Parcial. Solo se le aplican sanciones a tiempo completo.");
                                break; // Regresa al menú principal
                            }
                        } catch (InputMismatchException ie) 
                        {
                            System.out.println("Error: Debe ingresar un número válido para la opción.");
                            teclado.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 6:
                    System.out.println("--------------------------------------------LISTA DOCENTES-------------------------------------------------------\n");
                    dc.ListarDocentes();
                    break;
                case 7:
                    System.out.println("--------------------------------------LISTA DEPARTAMENTOS--------------------------------------------\n");
                    dpc.ListarDepartamentos();
                    break;
                case 8:
                    System.out.println("----------------------------------------LISTA FACULTADES---------------------------------------------\n");
                    fc.ListarFacultades();
                    break;
            }
        } while (true);           
    }
}