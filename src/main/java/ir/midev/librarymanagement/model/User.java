package ir.midev.librarymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseModel {

    private String username;
    private String password;
}
