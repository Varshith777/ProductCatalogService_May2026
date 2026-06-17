package org.example.productcatalogservice_may2026.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_mentor")
@DiscriminatorValue(value="MENT")
public class Mentor extends User {
    private Double ratings;
}
