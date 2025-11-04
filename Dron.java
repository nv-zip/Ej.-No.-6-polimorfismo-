public class Dron extends Dispositivo implements Medible, Accionable, Registrable {
    private int autonomiaVuelo;
    private double capacidadTanque;
    private double alturaMaxima;

    public Dron(String id, String nombre, String fabricante,
               double consumoElectrico, String ubicacion,
               int autonomiaVuelo, double capacidadTanque, double alturaMaxima) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.autonomiaVuelo = autonomiaVuelo;
        this.capacidadTanque = capacidadTanque;
        this.alturaMaxima = alturaMaxima;
    }

    public int getAutonomiaVuelo() { 
        return autonomiaVuelo; 
    }
    
    public double getCapacidadTanque() { 
        return capacidadTanque; 
    }
    
    public double getAlturaMaxima() { 
        return alturaMaxima; 
    }

    @Override
    public String obtenerMedicion() {
        return "Capturando imágenes multiespectrales desde " + alturaMaxima + "m de altura";
    }

    @Override
    public void ejecutarAccion(String accion) {
    }

    @Override
    public void registrarDatos(String datos) {
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Dron | Autonomía: %d min | Capacidad tanque: %.1fL | Altura máx: %.1fm",
                           autonomiaVuelo, capacidadTanque, alturaMaxima);
    }
}
