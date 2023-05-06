package com.api.proj.apiTest.Membro.Repository;

import com.api.proj.apiTest.Membro.Entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
}
