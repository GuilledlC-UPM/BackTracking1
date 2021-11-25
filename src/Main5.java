public class Main5 {
    public static void main(String[] args) {
        int[] bienes = {2, 2, 2};
        int[] hijos = {0, 0};
        System.out.println(hayRepartoEquitativo(bienes, hijos));
    }

    public static boolean hayRepartoEquitativo(int[] bienes, int[] hijos) {
        return hayAux2(bienes, hijos, 0);
    }

    public static boolean hayAux(int[] bienes, int nivel, int luis, int carlos) {
        if(nivel == bienes.length && luis == carlos)
            return true;
        else if(nivel < bienes.length){
            int c = 0;
            while(c < 2) {
                int bien = bienes[nivel];
                if(c == 1)
                    luis += bien;
                else
                    carlos += bien;
                nivel++;
                if(hayAux(bienes, nivel, luis, carlos))
                    return true;
                nivel--;
                if(c == 1)
                    luis -= bien;
                else
                    carlos -= bien;
                c++;
            }
        }
        return false;
    }

    public static boolean hayAux2(int[] bienes, int[] hijos, int nivel) {
        if(nivel == bienes.length && allEqual(hijos))
            return true;
        else if(nivel < bienes.length) {
            int c = 0;
            while(c < hijos.length) {
                hijos[c] += bienes[nivel];
                nivel++;
                if(hayAux2(bienes, hijos, nivel))
                    return true;
                nivel--;
                hijos[c] -= bienes[nivel];
                c++;
            }
        }
        return false;
    }

    public static boolean allEqual(int[] array) {
        boolean res = true;
        for(int i = 1; i < array.length; i++)
            res &= array[i] == array[0];
        return res;
    }
}
