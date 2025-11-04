public class SensorSuelo extends Dispositivo implements Medible, Registrable {
    private double profundidad;
    private String tipoSensor;
    private double ultimaLectura;

    public SensorSuelo(String id, String nombre, String fabricante,
                      double consumoElectrico, String ubicacion,
                      double profundidad, String tipoSensor, double ultimaLectura) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.profundidad = profundidad;
        this.tipoSensor = tipoSensor;
        this.ultimaLectura = ultimaLectura;
    }

    public double getProfundidad() { 
        return profundidad; 
    }
    
    public String getTipoSensor() { 
        return tipoSensor; 
    }
    
    public double getUltimaLectura() { 
        return ultimaLectura; 
    }

    @Override
    public String obtenerMedicion() {
        return "Medición de humedad: " + ultimaLectura + "% a " + profundidad + "m de profundidad";
    }

    @Override
    public void registrarDatos(String datos) {
        this.ultimaLectura = Double.parseDouble(datos);
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Sensor Suelo | Profundidad: %.2fm | Tipo: %s | Última lectura: %.1f%%",
                           profundidad, tipoSensor, ultimaLectura);
    }
}
