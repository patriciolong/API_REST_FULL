/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practicaApiRestFull.service;

import com.example.practicaApiRestFull.modelo.Usuario;
import com.example.practicaApiRestFull.repositoy.usuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author patri
 */
@Service
public class usuarioServiceImpl implements usuarioService{
     @Autowired
     private usuarioRepository usuariorepositpory;
    @Override
    public Usuario crear(Usuario p) {
       return usuariorepositpory.save(p);
    }

    @Override
    public Usuario findById(Long id) {
        return usuariorepositpory.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> finByAll() {
        return usuariorepositpory.findAll();
    }

    @Override
    public void delete(Long id) {
        usuariorepositpory.deleteById(id);
    }
}
