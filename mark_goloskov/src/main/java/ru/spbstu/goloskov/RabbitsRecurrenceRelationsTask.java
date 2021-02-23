package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class RabbitsRecurrenceRelationsTask {


    private static long getRabbitPairs(int months, int rabbits) {
        if (months == 1 || months == 2) {
            return 1;
        }
        return getRabbitPairs(months - 2, rabbits) * rabbits + getRabbitPairs(months - 1, rabbits);
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readDataset(Utils.RABBITS_RECCURENCE_RELATIONS);
        String[] data = lines.get(0).split(" ");
        int months = Integer.parseInt(data[0]);
        int rabbits = Integer.parseInt(data[1]);
        System.out.println(getRabbitPairs(months, rabbits));
    }

}
