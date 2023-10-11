package com.mycompany.fundacion;

import DAO.DAOFundacion;
import java.util.Date;
import conexiondb.ConfiguracionMySQL;
import DAO.DAOEmpleado;
import DAO.DAOFundacion;
import dominio.Fundacion;
import dominio.CalculadoraSalario;
import dominio.Empleado;
import dominio.Voluntario;
import dominio.Mascota;
import java.sql.SQLException;
import java.util.List;
import conexiondb.IConfiguracionBaseDatos;
import controladores.ControladorFundacion;
import controladores.ControladorPrincipal;

public class Main {

public static void main(String[] args) throws SQLException {

//        IConfiguracionBaseDatos configuracion = new ConfiguracionMySQL();
//        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(configuracion);
//        ControladorFundacion controladorFundacion = controladorPrincipal.getControladorFundacion();
//        List<Fundacion> fundaciones = controladorFundacion.obtenerTodasLasFundaciones();
//        DAOFundacion insertFundacion = new DAOFundacion(configuracion);
//        DAOEmpleado insertEmpleado = new DAOEmpleado();

        
//FUNDACIONES

//        Insertar Main
//        Fundacion fundacion = new Fundacion("Las Criaturitas ", 35656872, "Popular", "criaturitas@gmail.com", "Proteger a las criaturas");
//        insertFundacion.insertar(fundacion);

//        Listar fundaciones
//        List<Fundacion> listaFundacion = insertFundacion.Listar();
//        for (Main fundacion : listaFundacion) {
//            System.out.println(fundacion.toString());
//        }

//        Editar fundaciones
//        Main fundacion = new Main();
//        fundacion.setIdFundacion(2);
//        fundacion.setNombre("Hogar de Animalitos");
//        fundacion.setTelefono(649321);
//        fundacion.setDireccion("Villanueva");
//        fundacion.setMision("Proteger y rescatar");
//        fundacion.setCorreo_electronico("hogarAnimalitos@gmail.com");        
//        insertFundacion.editar(fundacion);

//        Buscar fundacion
//        int idFundacion = 2;
//        Main fundacionBuscar = new Main();
//        fundacionBuscar.setIdFundacion(idFundacion);
//        insertFundacion.buscar(fundacionBuscar);

//        Eliminar fundacion
//        int idFundacion = 8;
//        Main fundacionEliminar = new Main();
//        fundacionEliminar.setIdFundacion(idFundacion);
//        insertFundacion.eliminar(fundacionEliminar);

//EMPLEADOS

//        Insertar empleados
//        String nombreEmpleado = "Camilo";
//        String cargoEmpleado = "Doctor";
//        String funcionesEmpleado = "Gestión de proyectos";
//        int idFundacion = 4 ;        
//        Main fundacion = new Main(idFundacion);       
//        insertEmpleado.insertarEmpleado(fundacion.agregarEmpleado(nombreEmpleado, cargoEmpleado, funcionesEmpleado, fundacion));

////      Editar empleado
//        int idEmpleado = 3;
//        
//        Empleado empleado = new Empleado();
//        String nuevoNombre = "Nuevo Nombre";
//        String nuevoCargo = "Nuevo Cargo";
//        String nuevasFunciones = "Nuevas Funciones";
//        Main fundacion = new Main();       
//        fundacion.editarEmpleado(empleado, nuevoNombre, nuevoCargo, nuevasFunciones);



    }

}
