package ImutableObject;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period2 {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period2(){}

    public Period2(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
