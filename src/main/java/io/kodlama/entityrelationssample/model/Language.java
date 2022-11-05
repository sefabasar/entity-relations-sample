package io.kodlama.entityrelationssample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    @Id
    @GeneratedValue// id'yi otomatik üretmek için kullanılır. dışardan id vermeye gerek kalmaz.
    private Integer id;

    @NotBlank
    private String name;
    // (cascade = CascadeType.ALL) ==> language deki değişiklikleri framework e yansıtır.
    @OneToMany(cascade = CascadeType.ALL) // bir dilin birden fazla frameworku olabilir. bir framework sadece bir dile aittir.
    private List<Framework> frameworks;
}
