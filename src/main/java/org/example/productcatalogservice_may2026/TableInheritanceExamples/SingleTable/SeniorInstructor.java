package org.example.productcatalogservice_may2026.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_inst2")
@DiscriminatorValue(value="INST2")
public class SeniorInstructor extends User {
    private String organizationName;

}
