package com.mexpedition.web.controller;

import com.mexpedition.dao.ExpeditionDao;
import com.mexpedition.web.exception.ExpeditionNotFoundException;
import com.mexpedition.web.exception.ImpossibleAjouterExpedtionException;
import com.mexpedition.model.Expedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    @PostMapping(value = "/expeditions")
    public ResponseEntity<Expedition> AjouterExpedition (@RequestBody Expedition expedition) {
        Expedition nouvelleExpedition = expeditionDao.save(expedition);
        if (nouvelleExpedition==null) throw  new ImpossibleAjouterExpedtionException("Impossible d'ajouter cette expedition");
        return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
    }

    @GetMapping( value = "/expeditions/{id}")
    public Expedition recupererExpedition (@PathVariable int id){
        Optional<Expedition> expedition = expeditionDao.findById(id);
        if (!expedition.isPresent()) throw new ExpeditionNotFoundException("Expedition non trouvée!!");
        return expedition.get();
    }

    @PutMapping(value = "/expeditions")
    public void updateExpedition( @RequestBody Expedition expedition)
    {
        expeditionDao.save(expedition);
    }
}
