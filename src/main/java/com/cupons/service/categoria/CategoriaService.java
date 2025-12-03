package com.cupons.service.categoria;

import com.cupons.models.categoria.Categoria;
import com.cupons.models.categoria.CategoriaResponse;
import com.cupons.repository.categoria.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaResponse> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaResponse> respostas = new ArrayList<>();

        for (Categoria categoria : categorias) {
            CategoriaResponse response = new CategoriaResponse();
            response.setIdCategoria(categoria.getIdCategoria());
            response.setNomeCategoria(categoria.getNomeCategoria());
            respostas.add(response);
        }

        return respostas;
    }
}
