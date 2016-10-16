package mentor.salad.sketch.initialization;

import mentor.salad.sketch.saladmaker.Salad;
import java.io.*;


/**
 * Created by Andriana on 06.10.2016.
 */
public class UserProfile implements Serializable{
    private static UserProfile user;
    public Salad[] salads;
    private String userName;


    private UserProfile(){

    }
    static void loadProfile(){
        user = new UserProfile();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileInputStream fileInputStream = new FileInputStream(br.readLine());
        } catch (IOException e) {
            //todo: log4j


        }
    }
}
