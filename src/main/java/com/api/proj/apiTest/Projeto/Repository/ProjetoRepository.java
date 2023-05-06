package com.api.proj.apiTest.Projeto.Repository;

import com.api.proj.apiTest.Projeto.Entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
