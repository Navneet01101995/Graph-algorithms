import java.util.Random;

class RandomGraphs {

    public static int randomgr(int nodes, int edges, long seed, boolean simple, boolean acyclic, boolean directed, boolean weighted, int minweight, int maxweight, int[] nodei, int[] nodej, int[] weight)
            {
                int maxedges,a,b;
                boolean [][] adj=new boolean[nodes+1][nodes+1];
                int [] perm=new int[nodes+1];
                Random r=new Random(seed);
                if(simple) {
                    maxedges = nodes * (nodes - 1);
                    if (!directed) {
                        maxedges = maxedges / 2;
                    }
                    if (edges > maxedges)
                        return 1;
                }
                    if(acyclic) {
                        maxedges = (nodes * (nodes - 1)) / 2;
                        if (edges > maxedges)
                            return 1;
                        Randompermute.randomPer(nodes, r, perm);
                    }
                    for(a=1;a<=nodes;a++)
                    {
                        for(b=1;b<=nodes;b++)
                        {
                            adj[a][b]=false;
                        }
                    }
                    int numberofedges=0;
                    while(numberofedges<edges)
                    {
                        a=r.nextInt(nodes)+1;
                        b=r.nextInt(nodes)+1;
                        if(simple||acyclic)
                        {
                            if(a==b)
                                continue;
                        }
                        if(simple&&(!directed)||acyclic) {
                            if (a > b) {
                                int temp = b;
                                b = a;
                                a = temp;

                            }
                        }
                        if(acyclic)
                        {
                            a=perm[a];
                            b=perm[b];
                        }
                        try {
                            if ((!simple) || (!adj[a][b])){
                                numberofedges++;
                                nodei[numberofedges] = a;
                                nodej[numberofedges] = b;
                                adj[a][b] = true;
                                if (weighted)
                                    weight[numberofedges] = (int)(minweight + r.nextDouble() * (maxweight - minweight + 1));
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }

                    }


                return 0;
            }

}
