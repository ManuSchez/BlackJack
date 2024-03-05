public class Carta {

    private int numeroCarta;
    private palo palo;
    //Introducimos un enumerador con los posibles palos que se van a usar
    public enum palo {
        TREBOL, DIAMANTES, CORAZONES, PICAS
    }
    //Introducimos un aviso en el caso de que el usuario introduzca una carta menos que 1 o mayor que 13
//En el caso de introducir el numero correcto genera el objeto carta
    public Carta(int numeroCarta, palo palo) {
        if (numeroCarta < 1 || numeroCarta > 13) {
            System.out.println("El numero debe estar entre 1 y 13");
        } else {
            this.numeroCarta = numeroCarta;
            this.palo = palo;
        }
    }
    //Mediante un Switch creamos las posibles cartas con su respectivo nombre en la baraja
    public String mostrarNumero() {
        switch (numeroCarta) {
            case 1:
                return "As";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(numeroCarta);
        }
    }
    //Creacion de getters
    public int getNumeroCarta() {
        return numeroCarta;
    }
    public palo getPalo() {
        return palo;
    }
    //Mediante un if le damos a las cartas sus posibles puntiaciones dependiendo de su numero

    public int getValor() {
        if (numeroCarta == 1) {
            return 11; // As can be 1 or 11 in Blackjack
        } else if (numeroCarta >= 10) {
            return 10; // J, Q, and K are worth 10
        } else {
            return numeroCarta;
        }
    }
    //Con un toString mostramos los resultados de numero y palo que nos va a dar a medida que pidamos cartas
    @Override
    public String toString() {
        return "[" + mostrarNumero() + " - " + palo + "]";
    }
}
