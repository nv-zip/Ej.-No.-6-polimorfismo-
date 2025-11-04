public abstract class Dispositivo implements Comparable<Dispositivo> {
    private String id;
    private String nombre;
    private String fabricante;
    private double consumoElectrico;
    private String ubicacion;

    public Dispositivo(String id, String nombre, String fabricante, 
                      double consumoElectrico, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.consumoElectrico = consumoElectrico;
        this.ubicacion = ubicacion;
    }

    public String getId() { 
        return id; 
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public String getFabricante() { 
        return fabricante; 
    }
    
    public double getConsumoElectrico() { 
        return consumoElectrico; 
    }
    
    public String getUbicacion() { 
        return ubicacion; 
    }

    @Override
    public int compareTo(Dispositivo otro) {
        return Double.compare(this.consumoElectrico, otro.consumoElectrico);
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %s | Fabricante: %s | Consumo: %.2f kW/h | Ubicación: %s",
                           id, nombre, fabricante, consumoElectrico, ubicacion);
    }
}
