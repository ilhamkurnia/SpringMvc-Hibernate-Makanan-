package com.springmvc.hibernate.service;

import com.springmvc.hibernate.domain.Makanan;

import java.util.List;

public interface MakananService {
    public void save(Makanan makanan);
    public void update(Makanan makanan);
    public void delete(Makanan makanan);
    public Makanan getMakanan(String idMakanan);
    public List<Makanan> getMakanans();
}
