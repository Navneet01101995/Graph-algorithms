import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Generaterandomgraph {
    public static void main(String [] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int nodes;
        System.out.println("Enter the nodes of a graph");
        nodes=Integer.parseInt(br.readLine());
        System.out.println("Enter the edges of graph");
        int edges;
        edges=Integer.parseInt(br.readLine());
        long seed=1;
        String ent;
        System.out.println("Do you want to the graph to be simple?Enter Yes or No");
        ent=br.readLine();
        boolean simple;
        simple= ent.equals("Yes") || ent.equals("YES") || ent.equals("yes");
        boolean acyclic;
        System.out.println("Do you want the graph to be acyclic?Enter Yes or No");
        ent=br.readLine();
        acyclic=ent.equals("Yes")||ent.equals("YES")||ent.equals("yes");
        boolean directed;
        System.out.println("Do you want the graph to be Directed?Enter Yes or No");
        ent=br.readLine();
        directed=ent.equals("YES")||ent.equals("yes")||ent.equals("Yes");
        boolean weighted;
        System.out.println("Do you want the graph to be weighted?Enter Yes or No");
        ent=br.readLine();
        weighted=ent.equals("YES")||ent.equals("Yes")||ent.equals("yes");
        int [] nodei=new int[edges+1];
        for(int ed=0;ed<=edges;ed++)
            nodei[ed]=0;
        int [] nodej=new int[edges+1];
        for(int ed=0;ed<=edges;ed++)
            nodej[ed]=0;
        int [] weight=new int[edges+1];
        for(int ed=0;ed<=edges;ed++)
            weight[ed]=0;
        System.out.println("Enter minimum weight");
        int minimumweight=Integer.parseInt(br.readLine());
        System.out.println("Enter maximum weight");
        int maximumweight=Integer.parseInt(br.readLine());

        int k=RandomGraphs.randomgr(nodes,edges,seed,simple,acyclic,directed,weighted,minimumweight,maximumweight,nodei,nodej,weight);
        if(k!=0) {
            System.out.println("I am sorry but the entered data is wrong ");
        }
        else
        {
            for(int q=1;q<=edges;q++)
            {
                System.out.println(nodei[q]+" "+nodej[q]+" "+weight[q]);
            }
        }
    }
}
