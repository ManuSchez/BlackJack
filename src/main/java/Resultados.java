import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "resultados")
public class Resultados {

    private List<Resultado> listaResultados;

    public Resultados() {
        listaResultados = new ArrayList<>();
    }

    public List<Resultado> getListaResultados() {
        return listaResultados;
    }

    @XmlElement(name = "resultado")
    public void setListaResultados(List<Resultado> listaResultados) {
        this.listaResultados = listaResultados;
    }
}
