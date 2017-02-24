package task1;

import java.util.ArrayList;

public class Endpoint{

    int id;
    int cacheConnections;
    int[] cacheLantencies;
    ArrayList<Video> videos;
    int datacentarLatancy;

    Endpoint(){
        this.videos = new ArrayList<>();
    }

}
