package ru.netology;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Max {

    public static Map<String, String> category(List<ProductString> listProducts, Set<String> categorySet) {
        Map<String, String> maxCategory = new HashMap<>();
        maxCategory.put("category", "");
        maxCategory.put("sum", "0");
        for (String cat : categorySet) {
            int sumCategory = 0;
            for (ProductString product : listProducts) {
                if (product.getCategory().equals(cat)) {
                    sumCategory += Integer.parseInt(product.getSum());
                }
            }
            if (sumCategory > Integer.parseInt(maxCategory.get("sum"))) {
                maxCategory.put("category", cat);
                maxCategory.put("sum", String.valueOf(sumCategory));
            }
        }
        return maxCategory;
    }

    public static Map<String, String> periodCategory(List<ProductString> listProducts, Set<String> categorySet, Set<String> dateSet, int subperiod) {
        Map<String, String> maxPeriodCategory = new HashMap<>();
        maxPeriodCategory.put("category", "");
        maxPeriodCategory.put("sum", "0");
        for (String cat : categorySet) {
            for (String date : dateSet) {
                int sumCategory = 0;
                String period = date.substring(0, subperiod);
                for (ProductString product : listProducts) {
                    if (product.getCategory().equals(cat) && product.getDate().substring(0, subperiod).equals(period)) {
                        sumCategory += Integer.parseInt(product.getSum());
                    }
                }
                if (sumCategory > Integer.parseInt(maxPeriodCategory.get("sum"))) {
                    maxPeriodCategory.put("category", cat);
                    maxPeriodCategory.put("sum", String.valueOf(sumCategory));
                }
            }
        }
        return maxPeriodCategory;
    }
}