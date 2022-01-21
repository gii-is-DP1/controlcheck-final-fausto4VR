package org.springframework.samples.petclinic.care;

import java.util.Set;

import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cares")
public class Care extends BaseEntity{

    //Tambien puede ser @NotNull
    @Column(name = "name", unique=true)
    @NotEmpty
    @Size(min = 5, max = 30)
    String name;

    //Tambien puede ser @NotNull
    @Column(name = "description")
    @NotEmpty
    String description;

    //Tambien puede ser @NotNull
    @NotEmpty
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cares_types", joinColumns = @JoinColumn(name = "cares_id"),
			inverseJoinColumns = @JoinColumn(name = "types_id"))
    Set<PetType> compatiblePetTypes;

    //Ejercicio4
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "incompatible_cares", joinColumns = @JoinColumn(name = "cares1_id"),
			inverseJoinColumns = @JoinColumn(name = "cares2_id"))
    Set<Care> incompatibleCares;
}
