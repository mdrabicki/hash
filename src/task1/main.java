package task1;

import java.io.BufferedReader;
import java.io.FileReader;

public class main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("data.txt"));

        String line;
        while((line = br.readLine()) != null){

            String[] n = line.split(" ");
            int V = Integer.parseInt(n[0]);
            int E = Integer.parseInt(n[1]);
            int R = Integer.parseInt(n[2]);
            int C = Integer.parseInt(n[3]);
            int X = Integer.parseInt(n[4]);

            int[] vSize = new int[V];
            String[] tmp = br.readLine().split(" ");
            for(int i = 0; i < V; i++){
                vSize[i] = Integer.parseInt(tmp[i]);
            }

            int[] DL = new int[E];
            int[][] CL = new int[C][E];
            int[][] caches = new int[C][V];

            int[][] endpoints = new int[E][V+1];

            for(int i = 0; i < E; i++) {

                tmp = br.readLine().split(" ");
                DL[i] = Integer.parseInt(tmp[0]);
                int numCache = Integer.parseInt(tmp[1]);
                endpoints[i][0] = numCache;
                for(int l = 0; l < numCache; l++){
                    String[] tmp2 = br.readLine().split(" ");
                    CL[Integer.parseInt(tmp2[0])][i] = Integer.parseInt(tmp2[1]);
                }

            }

//            for(int i = 0; i < E; i++){
//                Arrays.fill(endpoints[i], -1);
//            }

            for(int i = 0; i < R; i++){
                tmp = br.readLine().split(" ");

                endpoints[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[0])+1] = Integer.parseInt(tmp[2]);

            }

            for(int i = 0; i < E; i++){

                if(endpoints[i][0] == 0)
                    continue;


            }





        }

        br.close();

    }

}
