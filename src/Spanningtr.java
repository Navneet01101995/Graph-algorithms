import java.util.Random;

public class Spanningtr {
    public static void spanningtre(int n,long seed,int minweight,int maxweight,boolean weighted,int nodei[],int nodej[],int weight[])
    {
        int nodea;
        int nodeb;
        int [] perm=new int[n+1];
        Random rn=new Random(seed);
        Randompermute.randomPer(n,rn,perm);
        int numedges=0;
        for(nodea=2;nodea<=n;nodea++)
        {
            nodeb=(int)(rn.nextInt(nodea-1)+1);
            numedges++;
            nodei[numedges]=perm[nodea];
            nodej[numedges]=perm[nodeb];
            if(weighted)
            {
                weight[numedges]=(int)(minweight+(rn.nextDouble()*(maxweight+1-minweight)));
            }
        }

    }
}
