package com.saucedemo.automation.web.util;

import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Utility for random selection of elements.
 */
public final class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {}

    /**
     * Selects a specified number of random elements from a list.
     *
     * @param elements the list of elements to choose from
     * @param count the number of elements to select
     * @return a list of randomly selected elements
     */
    public static List<WebElement> selectRandomElements(List<WebElement> elements, int count) {
        if (count > elements.size()) {
            throw new IllegalArgumentException(
                    "Cannot select " + count + " elements from a list of " + elements.size()
            );
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices, RANDOM);

        List<WebElement> selected = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            selected.add(elements.get(indices.get(i)));
        }

        return selected;
    }
}

