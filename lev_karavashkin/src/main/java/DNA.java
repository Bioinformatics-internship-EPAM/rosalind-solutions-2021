import org.apache.commons.lang3.StringUtils;

public class DNA {
    public static String count(String str) {
        return StringUtils.countMatches(str, 'A')
                + " " + StringUtils.countMatches(str, 'C')
                + " " + StringUtils.countMatches(str, 'G')
                + " " + StringUtils.countMatches(str, 'T');
    }
}
