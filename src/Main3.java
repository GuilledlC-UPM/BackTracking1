import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        int[] pesos = {2, 3, 7};
        int[] valores = {35, 21, 37};
        int maxPeso = 10;
        int[] solucion = {0, 0, 0};
        Entero valorMejor = new Entero(0);
        KP(pesos, valores, maxPeso, 0, solucion, 0, 0, solucion, valorMejor);
        System.out.println(valorMejor.getValor());
    }

    public static void KP(int[] pesos, int[] valores, int maxPeso, int nivel, int[] solucion, int valorActual, int pesoActual, int[] mejorSolucion, Entero valorMejor) {
        if(nivel == pesos.length) {
            if(valorActual > valorMejor.getValor()) {
                valorMejor.setValor(valorActual);
                for (int i = 0; i < solucion.length; i++)
                    mejorSolucion[i] = solucion[i];
            }
        }
        else {
            int c = 0;
            while(c < 2) {
                if(c == 0 || pesoActual + pesos[nivel] <= maxPeso) {
                    solucion[nivel] = c;
                    valorActual += valores[nivel]*c;
                    pesoActual += pesos[nivel]*c;
                    nivel++;
                    KP(pesos, valores, maxPeso, nivel, solucion, valorActual, pesoActual, mejorSolucion, valorMejor);
                    nivel--;
                    pesoActual -= pesos[nivel]*c;
                    valorActual -= valores[nivel]*c;
                    solucion[nivel] = 0;
                }
                c++;
            }
        }
    }
}
