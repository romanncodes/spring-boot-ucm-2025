package cl.ucm.serviceproduct.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("LogItem")
@AllArgsConstructor
@Setter
@Getter
public class LogItem {
    @Id
    private String id;
    private String description;
    private Date date;
}
