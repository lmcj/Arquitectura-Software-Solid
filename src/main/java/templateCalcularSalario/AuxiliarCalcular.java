
package templateCalcularSalario;

import java.util.Date;
import java.util.Map;

public class AuxiliarCalcular extends CalculadoraSalarioTemplate {
    
    @Override
    protected double calcularTarifa(String cargo) {
        return 8000;
    }

    @Override
    protected double calcularHorasTrabajadas(Map<Date, Double> horario_registro) {
        double horas_trabajadas = 0.0;

        for (double horas : horario_registro.values()) {
            horas_trabajadas += horas;
        }

        return horas_trabajadas;
    }
}
