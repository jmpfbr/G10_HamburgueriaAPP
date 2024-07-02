package com.example.g10_hamburgueria.repository

import com.example.g10_hamburgueria.Perfil

object PerfilRepository {
    private var perfil : Perfil? = null

    fun setPerfil(perfil: Perfil) {
        this.perfil = perfil
    }

    fun getPerfil(): Perfil? {
        return this.perfil
    }

}