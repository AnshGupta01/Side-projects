package com.unit.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

//Better than hamcrest as is better with imports and we can chain their relations
public class AssertJ {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,45);

        assertThat(numbers).hasSize(3)
                .contains(12,15)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);
        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                .startsWith("AB")
                .endsWith("E");
    }
}
