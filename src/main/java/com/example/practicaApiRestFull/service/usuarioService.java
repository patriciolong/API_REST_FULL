/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practicaApiRestFull.service;

import com.example.practicaApiRestFull.modelo.Usuario;
import java.util.List;

/**
 *
 * @author patri
 */
public interface usuarioService {
    public Usuario crear(Usuario p);
    public Usuario findById(Long id);
    public List<Usuario> finByAll();
    public void delete(Long id);
}
