package ru.spbstu.shakhmin;

import ru.spbstu.shakhmin.utils.RosalindUtils;

import java.util.List;

public final class RabbitsAndRecurrenceRelationsTask implements RosalindTask {

    private static final String DATASET_FILE_NAME = "rabbits_and_recurrence_relations.txt";

    @Override
    public String resolve(final List<String> dataset) {
        final var inputData = dataset.get(0).split(" ");
        final var monthsCount = Integer.parseInt(inputData[0]);
        final var rabbitPairsToProduce = Integer.parseInt(inputData[1]);
        return String.valueOf(countRabbits(monthsCount, rabbitPairsToProduce));
    }

    private static long countRabbits(final int monthsCount, final int rabbitPairsToProduce) {
        if (monthsCount == 1 || monthsCount == 2) {
            return 1;
        }
        return countRabbits(monthsCount - 2, rabbitPairsToProduce) * rabbitPairsToProduce +
                countRabbits(monthsCount - 1, rabbitPairsToProduce);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new RabbitsAndRecurrenceRelationsTask().resolve(
                RosalindUtils.loadDataset(DATASET_FILE_NAME)));
    }
}
