import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "resultados")
public class Resultado {

    private String nombre;
    private int puntuacion;
    @XmlElement(name = "resultado")
    private List<Resultado> resultados= new ArrayList<>();

    public Resultado() {
    }

    public Resultado(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setlistaesultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    public static class Resultados {

        private List<Resultado> listaResultados;

        public Resultados() {
            listaResultados = new ArrayList<>();
        }

        public List<Resultado> getlistaResultados() {
            return listaResultados;
        }

        @XmlElement(name = "resultado")
        public void setlistaResultados(List<Resultado> listaResultados) {
            this.listaResultados = listaResultados;
        }
    }
}
