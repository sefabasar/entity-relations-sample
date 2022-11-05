package io.kodlama.entityrelationssample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Framework {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String name;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    private Language language;

     */

}
