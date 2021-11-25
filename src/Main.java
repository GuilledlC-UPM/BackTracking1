public class Main {
    public static void main(String[] args) {
        int[] vector = {13, 11, 7};
        int[] solucion = {0, 0, 0};
        BackTrackSuma(vector, 20, solucion);
        for(int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]*solucion[i] + ", ");
        }
    }

    public static void BackTrackSuma(int[] vector, int num, int[] solucion) {
        BackTrackSuma(vector, num, solucion, 0, 0, new Booleano(false));
    }

    public static void BackTrackSuma(int[] vector, int num, int[] solucion, int id, int suma, Booleano exito) {
        int c = id;
        if(suma == num)
            exito.setValor(true);
        else {
            while(!exito.getValor() && c < vector.length) {
                if(suma + vector[c] <= num) {
                    int aux = vector[c];
                    solucion[c] = 1;
                    suma += aux;
                    c++;
                    BackTrackSuma(vector, num, solucion, c, suma, exito);
                    if(!exito.getValor()) {
                        c--;
                        solucion[c] = 0;
                        suma -= aux;
                    }
                }
                c++;
            }
        }
    }
}
