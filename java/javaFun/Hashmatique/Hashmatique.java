import java.util.Set;
import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("On Chill", "Wale");
        trackList.put("Just Friends", "Musiq SoulChild");
        trackList.put("Baby One More Time", "Brittney Spears");

        String song = trackList.get("Just Friends");
        System.out.println("One artist = " + song);

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println("Song: " + key + " - By " + trackList.get(key));

        }
    }
}