import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        char[] operadores = {'+', '-', '*', '/'};
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int resultado = s.nextInt();

            ArrayList<Integer> cifras = new ArrayList<>();
            for (int i = 0; i < 5; i++)
                cifras.add(s.nextInt());
            if (BackTrackCifras(cifras, resultado, operadores))
                System.out.println("SI");
            else
                System.out.println("NO");
        }
    }

    public static boolean BackTrackCifras(ArrayList<Integer> cifras, int resultado, char[] operadores) {
        int sol = cifras.get(0);
        cifras.remove(0);
        return BTCK(cifras, resultado, operadores, sol, 0);
    }

    private static boolean BTCK(ArrayList<Integer> cifras, int resultado, char[] operadores, int sol, int cont) {
        boolean res = false;
        if(sol == resultado)
            res = true;
        else {
            int i = 0;
            int candidato = cifras.get(cont);
            cont++;
            while(sol != resultado && cont < cifras.size() && !res && i < operadores.length) {
                char operador = operadores[i];
                int sol2 = sol;

                if(operador == '+')
                    sol2 = sol + candidato;
                else if(operador == '-')
                    sol2 = sol - candidato;
                else if(operador == '*')
                    sol2 = sol * candidato;
                else if(operador == '/' && sol%candidato == 0 && candidato != 0)
                    sol2 = sol / candidato;
                else {
                    i++;
                    continue;
                }
                for(int t = 0; t <= cont; t++)
                    System.out.print("  ");
                System.out.println(sol + " " + operador + " " + candidato + " = " + sol2);

                if(BTCK(cifras, resultado, operadores, sol2, cont)) {
                    res = true;
                    sol = sol2;
                    break;
                }

                System.out.println();
                i++;
            }
        }
        return res;
    }

    private static boolean BackTrackCifrasAux(ArrayList<Integer> cifras, int resultado, char[] operadores, int sol, int cont) {
        boolean res = false;
        if(sol == resultado)
            res = true;
        else {
            while(sol != resultado && cont < cifras.size() && !res) {
                int candidato = cifras.get(cont);
                cont++;
                for(int i = 0; i < operadores.length; i++) {
                    char operador = operadores[i];
                    int sol2 = sol;
                    if(operador == '+')
                        sol2 = sol + candidato;
                    else if(operador == '-')
                        sol2 = sol - candidato;
                    else if(operador == '*')
                        sol2 = sol * candidato;
                    else if(operador == '/' && sol%candidato == 0)
                        sol2 = sol / candidato;
                    else
                        continue;
                    for(int t = 0; t <= cont; t++)
                        System.out.print("  ");
                    System.out.println(operador + " " + candidato + " = " + sol2);
                    if(BackTrackCifrasAux(cifras, resultado, operadores, sol2, cont)) {
                        res = true;
                        sol = sol2;
                        break;
                    }
                    System.out.println();
                }
            }
        }
        if(res)
            System.out.println("!AAAh" + sol);
        return res;
    }
}
