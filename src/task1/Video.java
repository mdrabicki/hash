package task1;

public class Video implements Comparable<Video> {

    int id;
    int numOfRequests;
    int size;
    int points;

    @Override
    public int compareTo(Video o) {
        return numOfRequests - o.numOfRequests;
    }
}
