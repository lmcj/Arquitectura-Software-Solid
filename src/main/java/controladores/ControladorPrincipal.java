package controladores;

import DAO.DAOEmpleado;
import DAO.DAOFundacion;
import DAO.DAOMascota;
import DAO.DAOVoluntario;
import HoraActual.HoraActualDAO;
import InterfazDAO.IDAO_1;
import InterfazDAO.IDAO_2;
import conexiondb.AdminDB;
import conexiondb.ConexionFactory;
import conexiondb.IConfiguracionBaseDatos;

public class ControladorPrincipal {

    IConfiguracionBaseDatos iConfiguracionBaseDatos = ConexionFactory.obtenerConexion();
    AdminDB adminDB = AdminDB.obtenerInstancia(); // Obtener una instancia de AdminDB

    IDAO_1 iDAO_1Fundacion = new DAOFundacion(iConfiguracionBaseDatos);
    IDAO_1 iDAO_1Empleado = new DAOEmpleado(iConfiguracionBaseDatos);
    IDAO_1 iDAO_1Mascota = new DAOMascota(iConfiguracionBaseDatos);
    IDAO_1 iDAO_1Voluntario = new DAOVoluntario(iConfiguracionBaseDatos);
    IDAO_2 iDAO_2Empleado = new DAOEmpleado(iConfiguracionBaseDatos);
    IDAO_2 iDAO_2Mascota = new DAOMascota(iConfiguracionBaseDatos);
    IDAO_2 iDAO_2Voluntario = new DAOVoluntario(iConfiguracionBaseDatos);

    private ControladorFundacion controladorFundacion;
    private ControladorEmpleado controladorEmpleado;
    private ControladorMascota controladorMascota;
    private ControladorVoluntario controladorVoluntario;

    public ControladorPrincipal() {
        this.controladorFundacion = new ControladorFundacion(iDAO_1Fundacion);
        this.controladorEmpleado = new ControladorEmpleado(iDAO_1Empleado, iDAO_2Empleado);
        this.controladorMascota = new ControladorMascota(iDAO_1Mascota, iDAO_2Mascota);
        this.controladorVoluntario = new ControladorVoluntario(iDAO_1Voluntario, iDAO_2Voluntario);
    }

    public ControladorFundacion obtenerControladorFundacion() {
        return controladorFundacion;
    }

    public ControladorEmpleado obtenerControladorEmpleado() {
        return controladorEmpleado;
    }

    public ControladorMascota obtenerControladorMascota() {
        return controladorMascota;
    }

    public ControladorVoluntario obtenerControladorVoluntario() {
        return controladorVoluntario;
    }

    public String obtenerHoraActual() {
        HoraActualDAO horaActualDAO = adminDB.obtenerHoraActualDAO();
        return horaActualDAO.horaActual();
    }
}
