package com.springmvc.hibernate.controller;

import com.springmvc.hibernate.domain.Makanan;
import com.springmvc.hibernate.service.MakananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class MakananController {

    @Autowired
    private MakananService makananService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/makanan", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Makanan> getMakanans(){
        return makananService.getMakanans();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/makanan", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> saveMakanan(@RequestBody Makanan makanan){
        makananService.save(makanan);

        Map<String, Object>m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Tersimpan");

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/makanan", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object>updateMakanan(@RequestBody Makanan makanan){
        makananService.update(makanan);

        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Berhasil Diupdate");

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/makanan{idMakanan}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteMakanan(@PathVariable("idMakanan") String idMakanan){
        makananService.delete(makananService.getMakanan(idMakanan));

        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Berhasil Dihapus");

        return m;
    }
}
