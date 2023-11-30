package com.pin2.proj.services;

import java.util.List;
import java.util.Optional;

import com.pin2.proj.models.Historico;
import com.pin2.proj.models.Item;

public interface ItemInterface {

    void salvar(Item item);

    void alterar(Item item) throws Exception;

    Optional<Item> buscarPorPat(String patrimonio);

    void deletatarPorPat(String patrimonio);

    List<Item> buscarTodos();

    List<Historico> buscarHistoricoItem(String patrimonio);
}
