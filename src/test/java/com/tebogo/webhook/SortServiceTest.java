package com.tebogo.webhook;

import com.tebogo.webhook.exception.InvalidInputException;
import com.tebogo.webhook.service.SortService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortServiceTest {
    private final SortService sortService = new SortService();

    @Test
    void testSortAlphabetically() {
        String[] result = sortService.sortAlphabetically("cba");

        assertArrayEquals(new String[]{"a","b","c"}, result);
    }

    @Test
    void testThrowsExceptionWhenInputIsEmpty() {
        assertThrows(InvalidInputException.class,
                () -> sortService.sortAlphabetically(""));
    }
}

