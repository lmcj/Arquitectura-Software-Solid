package templateCalcularSalario;

import java.util.Date;
import java.util.Map;

public abstract class CalculadoraSalarioTemplate {

    public final double calcularSalario(String cargo, Map<Date, Double> horario_registro) {
        double salario = 0.0;

        salario = calcularHorasTrabajadas(horario_registro) * calcularTarifa(cargo);
        
        System.out.println("Salario calculado para " + cargo + ": " + salario);
        
        return salario;
    }

    protected abstract double calcularTarifa(String cargo);

    protected abstract double calcularHorasTrabajadas(Map<Date, Double> horario_registro);
}
