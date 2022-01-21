package org.springframework.samples.petclinic.care;

import org.springframework.samples.petclinic.pet.Visit;
import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "careprovisions")
public class CareProvision extends BaseEntity{

    @Column(name = "duration")
    @NotNull
    // Tambien puede ser @Min(value = 0)
    @PositiveOrZero
    double duration;

    @ManyToOne(optional=true)
    @JoinColumn(name = "visit_id")
    Visit visit;

    @ManyToOne(optional=false)
    @JoinColumn(name = "care_id")
    Care care;   
}
