package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MaxTest {
    Set<String> categorySet = new HashSet<>();
    List<ProductString> listProducts = new ArrayList<>();
    Set<String> dateSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        categorySet.add("еда");
        categorySet.add("одежда");
        categorySet.add("быт");
        categorySet.add("финансы");
        dateSet.add("22.02.2022");
        dateSet.add("22.03.2021");
        listProducts.add(new ProductString("булка", "еда", "22.02.2022", "300"));
        listProducts.add(new ProductString("колбаса", "еда", "22.02.2022", "200"));
        listProducts.add(new ProductString("мыло", "быт", "22.03.2021", "50"));
    }

    @Test
    @DisplayName("Проверка поиска максимальной категории за все время")
    void catTrue() {
        Map<String, String> maxCategory = Max.category(listProducts, categorySet);
        Assertions.assertEquals("еда", maxCategory.get("category"));
    }

    @Test
    @DisplayName("Проверка поиска стоимости максимальной категории за все время")
    void sumTrue() {
        Map<String, String> maxCategory = Max.category(listProducts, categorySet);
        Assertions.assertEquals("500", maxCategory.get("sum"));
    }

    @Test
    @DisplayName("Проверка поиска максимальной категории за год")
    void catYearTrue() {
        Map<String, String> maxCategory = Max.periodCategory(listProducts, categorySet, dateSet, 4);
        Assertions.assertEquals("еда", maxCategory.get("category"));
    }

    @Test
    @DisplayName("Проверка поиска стоимости максимальной категории за все время")
    void sumYearTrue() {
        Map<String, String> maxCategory = Max.periodCategory(listProducts, categorySet, dateSet, 4);
        Assertions.assertEquals("500", maxCategory.get("sum"));
    }
}