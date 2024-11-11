package store;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Promotion {
    private String promotionName;
    private int buy;
    private int get;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Promotion(String promotionName, int buy, int get, String startDate, String endDate) {
        this.promotionName = promotionName;
        this.buy = buy;
        this.get = get;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startLD = LocalDate.parse(startDate, formatter);
        LocalDate endLD = LocalDate.parse(endDate, formatter);

        this.startDate = startLD.atStartOfDay();
        this.endDate = endLD.atTime(23, 59, 59);
    }
}
