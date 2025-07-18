package ir.midev.librarymanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = SchemaName.SchemaName)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factor extends BaseModel{

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Payed  payed;
}
