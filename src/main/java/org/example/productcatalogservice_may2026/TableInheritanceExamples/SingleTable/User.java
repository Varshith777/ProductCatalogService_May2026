package org.example.productcatalogservice_may2026.TableInheritanceExamples.SingleTable;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.Type;

@Entity(name="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    private Long id;

    private String name;
}
