package ir.midev.librarymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCard extends BaseModel{

    private int count;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;

}
