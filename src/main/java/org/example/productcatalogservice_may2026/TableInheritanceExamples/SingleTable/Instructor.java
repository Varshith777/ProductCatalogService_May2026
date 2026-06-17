package org.example.productcatalogservice_may2026.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_inst1")
@DiscriminatorValue(value="INST1")
public class Instructor extends User {
    private String company;
}
