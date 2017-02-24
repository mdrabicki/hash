package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Comparator;

public class main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("kittens.in"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

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

            Cache[] caches = new Cache[C];
//            int[][] endpoints = new int[E][V+1];
            Endpoint[] endpoints = new Endpoint[E];

            for(int i = 0; i < E; i++) {

                tmp = br.readLine().split(" ");
                endpoints[i] = new Endpoint();
                endpoints[i].datacentarLatancy = Integer.parseInt(tmp[0]);
                endpoints[i].cacheConnections = Integer.parseInt(tmp[1]);
                endpoints[i].cacheLantencies = new int[C];

                for(int l = 0; l < endpoints[i].cacheConnections; l++){
                    String[] tmp2 = br.readLine().split(" ");
                    caches[Integer.parseInt(tmp2[0])] = new Cache();
                    caches[Integer.parseInt(tmp2[0])].endpoints.add(endpoints[i]);
                    endpoints[i].cacheLantencies[Integer.parseInt(tmp2[0])] = Integer.parseInt(tmp2[1]);
                }

            }


//            for(int i = 0; i < E; i++){
//                Arrays.fill(endpoints[i], -1);
//            }

            for(int i = 0; i < R; i++){
                tmp = br.readLine().split(" ");

                Video v = new Video();
                v.id = Integer.parseInt(tmp[0]);
                v.numOfRequests = Integer.parseInt(tmp[2]);
                v.size = vSize[v.id];

                endpoints[Integer.parseInt(tmp[1])].videos.add(v);

            }

            for(int i = 0; i < E; i++)
                endpoints[i].videos.sort(Video::compareTo);


            for(int i = 0; i < C; i++){
                caches[i].memory = X;
                int finalI = i;
                while (caches[i].memory <= X) {
                    Endpoint e = caches[i].endpoints.stream().filter(endpointe -> endpointe.cacheLantencies[finalI] != 0).min(Comparator.comparingInt(o -> o.cacheLantencies[finalI])).get();
                    for (int l = 0; l < e.videos.size(); l++) {
                        if (!caches[i].addVideo(e.videos.get(l))) {
                            break;
                        } else {
                            e.videos.remove(l);
                        }
                    }
                }
            }

            int cachesUsed = 0;

            for(int i = 0; i < C; i++){
                if(caches[i].memory < X)
                    cachesUsed++;
            }

            bufferedWriter.write(cachesUsed + "\n");
            for(int i = 0; i < C; i++){
                if(caches[i].memory == X)
                    continue;
                bufferedWriter.write(i + " ");
                for(int l = 0; l < caches[i].videos.size(); l++){
                    bufferedWriter.write(caches[i].videos.get(l).id + " ");
                }
            }

            bufferedWriter.flush();

        }

        br.close();

    }

}
