package com.pin2.proj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pin2.proj.models.Historico;
import com.pin2.proj.models.Item;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {

        List<Historico> findByItem_id(Long item_id);

        List<Historico> findBySetor_idAndSituacao_id(Long setor_id, Long situacao_id);
}
