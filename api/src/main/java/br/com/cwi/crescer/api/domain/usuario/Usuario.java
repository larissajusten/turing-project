package br.com.cwi.crescer.api.domain.usuario;

import br.com.cwi.crescer.api.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "SEQ_USUARIO", allocationSize = 1)
public class Usuario {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @NotNull
    private Long id;

    @NotEmpty
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Perfil perfil;
}
