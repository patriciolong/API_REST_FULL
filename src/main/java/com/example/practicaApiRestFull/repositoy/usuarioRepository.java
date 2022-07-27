/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practicaApiRestFull.repositoy;

import com.example.practicaApiRestFull.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author patri
 */
public interface usuarioRepository extends JpaRepository<Usuario, Long>{
    
}
