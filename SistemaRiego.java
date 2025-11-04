public class SistemaRiego extends Dispositivo implements Accionable {
    private int numeroValvulas;
    private double caudalMaximo;
    private double presionOperacion;

    public SistemaRiego(String id, String nombre, String fabricante,
                       double consumoElectrico, String ubicacion,
                       int numeroValvulas, double caudalMaximo, double presionOperacion) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.numeroValvulas = numeroValvulas;
        this.caudalMaximo = caudalMaximo;
        this.presionOperacion = presionOperacion;
    }

    public int getNumeroValvulas() { 
        return numeroValvulas; 
    }
    
    public double getCaudalMaximo() { 
        return caudalMaximo; 
    }
    
    public double getPresionOperacion() { 
        return presionOperacion; 
    }

    @Override
    public void ejecutarAccion(String accion) {
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Sistema Riego | Válvulas: %d | Caudal máx: %.1fL/min | Presión: %.1f PSI",
                           numeroValvulas, caudalMaximo, presionOperacion);
    }
}
