import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        String rutaAbsoluta = "/Users/ManuelSchez/Desktop/Ejercicios/Prog/TareaFinal/salida.xml";
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
            }else {
                System.out.println("Introduce una de las opciones solicitadas: ");
            }
        }

    }
}