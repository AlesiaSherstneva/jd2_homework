package by.academy.it.pojos;

import javax.persistence.PostPersist;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Trigger {

    // Я не нашла, как привязать триггер к flush(), поэтому привязала к save()

    @PostPersist
    public static void updateTimestamp(Person person) {
        person.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
    }
}
