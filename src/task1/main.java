package task1;

import java.io.*;

public class main {
    public static void main(String[] args){

        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));

            String line;
            while((line = br.readLine()) != null){



            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
