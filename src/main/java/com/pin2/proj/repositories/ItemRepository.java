package com.pin2.proj.repositories;

import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pin2.proj.models.Item;
import com.pin2.proj.models.Situacao;

public interface ItemRepository extends JpaRepository<Item, Long> {

  List<Item> findItemByPatrimonio(String patrimonio);

  List<Item> findByPatrimonioContainingIgnoreCase(String patrimonio);

  @Query(value = "SELECT * FROM item WHERE ((item.patrimonio like :patrimonio) or (item.modelo_id = :modelo_id or item.modelo_id in (select modelo.id from modelo where fabricante_id = :fabricante_id)) "+
      "or (item.modelo_id = :modelo_id or item.modelo_id in (select modelo.id from modelo where tipo_id = :tipo_id))) "+
      "or (item.id in (SELECT item_id FROM historico WHERE ((historico.setor_id = :setor_id) and historico.id "+ 
      "in ((SELECT max(historico.id) from historico where historico.item_id = item.id limit 1))) or (historico.situacao_id = :situacao_id) and historico.id "+ 
      "in ((SELECT max(historico.id) from historico where historico.item_id = item.id limit 1) )))", nativeQuery = true)

  List<Item> itemRelatorio(String patrimonio, Long fabricante_id, Long tipo_id, Long modelo_id, Long setor_id, Long situacao_id);

}

