import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resultado {
    private String nombre;
    private int puntos;

    public Resultado() {
        // Constructor por defecto requerido por JAXB
    }

    public Resultado(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }
    //Creacion de getters y setters
    @XmlElement
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    }

