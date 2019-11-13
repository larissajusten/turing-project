package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
