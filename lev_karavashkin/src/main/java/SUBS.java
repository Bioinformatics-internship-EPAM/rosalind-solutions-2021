import java.util.ArrayList;
import java.util.List;

public class SUBS {
    public static List<Integer> getLocations(String s, String t) {

        List<Integer> locations = new ArrayList<>();

        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            int prevIdx = idx;
            idx = s.indexOf(t,i);
            if(idx != -1 && idx != prevIdx){
                locations.add(idx + 1);
            }
        }

        return locations;
    }
}
