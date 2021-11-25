public class Main4 {
    public static void main(String[] args) {
        int[] valores = {1, 10, 5};
        int[] solucion = {0,0,0};
        Entero numMonedasMejor = new Entero(Integer.MAX_VALUE);
        monedasOptimo(valores, 0, solucion, 0, 12, solucion, numMonedasMejor);
        System.out.println(numMonedasMejor.getValor());
    }

    public static void monedasOptimo(int[] valores, int nivel, int[] solucion, int numMonedas, int resto, int[] mejorSolucion, Entero numMonedasMejor){
        if(resto == 0) {
            if(numMonedas < numMonedasMejor.getValor()) {
                numMonedasMejor.setValor(numMonedas);
                for(int i = 0; i < mejorSolucion.length; i++)
                    mejorSolucion[i] = solucion[i];
            }
        }
        else if(nivel < valores.length) {
            int n = 0;
            while(n <= resto/valores[nivel]) {
                resto -= valores[nivel]*n;
                solucion[nivel] = n;
                numMonedas += n;
                nivel++;
                if(numMonedas < numMonedasMejor.getValor())
                    monedasOptimo(valores, nivel, solucion, numMonedas, resto, mejorSolucion, numMonedasMejor);
                nivel--;
                numMonedas -= n;
                solucion[nivel] = 0;
                resto += valores[nivel]*n;
                n++;
            }
        }
    }
}
