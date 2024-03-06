import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        String rutaAbsoluta = "/Users/ManuelSchez/Desktop/Trabajo/salida.xml";
        List<Juego> resultado = new ArrayList<>();
        Mazo mazo = new Mazo();
        mazo.barajar();

        Mano manoJugador = new Mano();

        Scanner scanner = new Scanner(System.in);

        boolean finJuego = false;
        while (!finJuego) {
            System.out.println("¿Quieres otra carta? (s/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equals("s")) {
                Carta carta = mazo.solicitarCarta();
                if (carta == null) {
                    finJuego = true;
                    System.out.println("No quedan más cartas en el mazo, te has plantado con "
                            + manoJugador.valorMano() + " puntos");
                } else {
                    manoJugador.pedirCarta(mazo);
                    System.out.println("Tu mano: " + manoJugador);

                    if (manoJugador.finDeJuego()) {
                        System.out.println("¡Has perdido!");
                        finJuego = true;
                    }
                }
            } else if (respuesta.equals("n")) {
                System.out.println("Te has plantado con " + manoJugador.valorMano() + " puntos");
                finJuego = true;
            } else {
                System.out.println("Introduce una de las opciones solicitadas: ");
            }
        }

        Resultado resultadoJuego = new Resultado("Jugador", manoJugador.valorMano());
        guardarResultado(resultadoJuego);
    }

    private static void guardarResultado(Resultado resultado) {
        try {
            // Crear un contexto JAXB para la clase Resultado
            JAXBContext jaxbContext = JAXBContext.newInstance(Resultado.class);

            // Crear un marshaller
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Verificar si el archivo XML existe
            File archivoXML = new File("ejemplo.xml");
            Resultado.Resultados resultadosExistentes = new Resultado.Resultados();
            if (archivoXML.exists()) {
                // Leer el contenido del archivo XML
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                resultadosExistentes = (Resultado.Resultados) unmarshaller.unmarshal(new File("ejemplo.xml"));
            }

            // Agregar el nuevo resultado a la lista
            resultadosExistentes.getlistaResultados().add(resultado);

            // Reescribir el archivo XML con la lista modificada
            marshaller.marshal(resultadosExistentes, archivoXML);

            System.out.println("Archivo XML generado exitosamente.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
