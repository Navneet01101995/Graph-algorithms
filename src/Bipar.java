import java.util.Random;

public class Bipar {
    public static void RandomBip(int n1, int n2, long seed, int m, int nodei[], int nodej[]) {
        int nodea, nodeb, nodec, numedges;
        int n = n1 + n2;
        boolean[][] adjacent = new boolean[n1 + n2 + 1][n1 + n2 + 1];
        Random rn = new Random(seed);
        for (nodea = 0; nodea <= n; nodea++) {
            for (nodeb = 0; nodeb <= n; nodeb++) {
                adjacent[nodea][nodeb] = false;
            }
        }
        if (m != 0)
        {
            if (m > (n1 * n2))
                m = n1 * n2;
            numedges = 0;
            while (numedges < m) {
                nodea = (int) (1 + rn.nextDouble() * n1);
                nodeb = (int) (n1 + 1 + rn.nextDouble() * n2);
                if (!adjacent[nodea][nodeb]) {
                    adjacent[nodea][nodeb] = true;
                    numedges++;
                }
            }
        } else {
            for (nodea = 1; nodea <= n1; nodea++) {
                for (nodeb = n1 + 1; nodeb <= n; nodeb++) {
                    adjacent[nodea][nodeb] = (rn.nextInt(2) != 0);

                }
            }
        }
        boolean temp;
        for (nodea = 1; nodea <= n; nodea++) {
            nodec = (int) (nodea + rn.nextDouble() * (n + 1 - nodea));
            for (nodeb = 1; nodeb <= n; nodeb++) {
                temp = adjacent[nodec][nodeb];
                adjacent[nodec][nodeb] = adjacent[nodea][nodeb];
                adjacent[nodea][nodeb] = temp;
            }
            for (nodeb = 1; nodeb <= n; nodeb++) {
                temp = adjacent[nodec][nodeb];
                adjacent[nodec][nodeb] = adjacent[nodea][nodeb];
                adjacent[nodea][nodeb] = temp;
            }
            numedges = 0;
            for (nodea = 1; nodea <= n; nodea++) {
                for (nodeb = nodea + 1; nodeb <= n; nodeb++) {
                    if (adjacent[nodea][nodeb]) {
                        numedges++;
                        nodei[numedges] = nodea;
                        nodej[numedges] = nodeb;
                    }
                }
            }
            nodei[0]=numedges;
        }
    }
}





