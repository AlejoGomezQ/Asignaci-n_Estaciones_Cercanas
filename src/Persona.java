public class Persona {
    private Punto2D ubicacion;
    private Estacion estacionBase = null;

    public Persona(Punto2D ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Punto2D getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Punto2D ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Estacion getEstacionBase() {
        return estacionBase;
    }

    public void setEstacionBase(Estacion estacionBase) {
        this.estacionBase = estacionBase;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ubicacion=" + ubicacion +
                ", estacionBase=" + estacionBase +
                '}';
    }
}
