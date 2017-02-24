package task1;

import java.util.ArrayList;

public class Cache {

    int memory;
    ArrayList<Video> videos;
    ArrayList<Endpoint> endpoints;

    Cache(){
        this.videos = new ArrayList<>();
        this.endpoints = new ArrayList<>();
    }

    boolean addVideo(Video v){
        videos.add(v);
        if(memory > v.size)
            memory -= v.size;
        else
            return false;
        return true;
    }

    public void removeVideo(Video v){
        videos.remove(v);
        memory += v.size;
    }

}
