import java.util.Random;

public class Randompermute {

    public static void randomPer(int n, Random random, int[] arr)
    {
        int i,j,k;
        for(i=1;i<=n;i++)
            arr[i]=i;
        for(i=1;i<=n;i++)
        {
            j=(int)(i+ random.nextDouble()*(n+1-i));
            k=arr[i];
            arr[i]=arr[j];
            arr[j]=k;
        }
    }


}
