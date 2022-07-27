/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practicaApiRestFull.controller;

import com.example.practicaApiRestFull.modelo.Usuario;
import com.example.practicaApiRestFull.service.usuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author patri
 */
@RestController
@RequestMapping("/api/usuario")
public class usuarioController {

    @Autowired
    usuarioService usuarioservice;

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> listar() {
        return new ResponseEntity<>(usuarioservice.finByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(Usuario u) {
        return new ResponseEntity<>(usuarioservice.crear(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id) {
        usuarioservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(buscarusuario(id), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario u) {
        Usuario usuario = buscarusuario(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {
                usuario.setNombre(u.getNombre());
                usuario.setClave(u.getClave());
                usuario.setEmail(u.getEmail());
                usuario.setEstado(u.getEstado());
                return new ResponseEntity<>(usuarioservice.crear(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    public Usuario buscarusuario(@PathVariable Long id) {
        return usuarioservice.findById(id);
    }
}
