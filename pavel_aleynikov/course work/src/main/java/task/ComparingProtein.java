package task;

import dto.Protein;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.fasta.FASTAItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Comparing Protein
 * <p>
 * Try find translated protein from DNA in defined protein
 */
public class ComparingProtein {

    public static final String LABEL_LOCATION_TERM = "/location:";
    private static final Logger LOGGER = LoggerFactory.getLogger(ComparingProtein.class);

    /**
     * Comparing Protein
     *
     * @param definedProteins - source protein
     * @param findedProteins  - translated protein
     * @return - count of matched proteins
     */
    public static int analyze(List<Protein> definedProteins, List<Protein> findedProteins) {
        int matchedCount = 0;
        for (Protein targetProtein : definedProteins) {
            Optional<Protein> matched = findedProteins.stream().filter(pr -> pr.getSequence().equals(targetProtein.getSequence())).findFirst();
            if (matched.isPresent()) {
                matchedCount++;
                LOGGER.info("Find protein {} with location {}..{} in location {}..{}", targetProtein.getName(),
                        targetProtein.getStartIndex(), targetProtein.getStopIndex(),
                        matched.get().getStartIndex(), matched.get().getStopIndex());
            } else {
                LOGGER.info("Can't find protein {} with location {}..{}", targetProtein.getName(),
                        targetProtein.getStartIndex(), targetProtein.getStopIndex());
            }
        }
        return matchedCount;
    }

    /**
     * Covert protein from {@link FASTAItem} to {@link Protein}
     * <p>
     * Method parse metadata from FASTS label to {@link Protein}
     *
     * @param source - list of FASTA item
     * @return - list of covert protein
     */
    public static List<Protein> convertFastsToProtein(List<FASTAItem> source) {
        List<Protein> result = new ArrayList<>(source.size());
        for (FASTAItem item : source) {
            String[] labelParts = item.getLabel().split(LABEL_LOCATION_TERM);
            String[] location = labelParts[1].split("\\.\\.");
            result.add(new Protein(labelParts[0],
                    Integer.parseInt(location[0]),
                    Integer.parseInt(location[1]),
                    item.getSequence()));
        }
        return result;
    }

}
