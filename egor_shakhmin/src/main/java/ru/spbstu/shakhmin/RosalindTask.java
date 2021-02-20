package ru.spbstu.shakhmin;

import java.util.List;

@FunctionalInterface
public interface RosalindTask {
    String resolve(List<String> dataset);
}
