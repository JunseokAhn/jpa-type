package CollectionsType;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period3 {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period3(){}

    public Period3(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
