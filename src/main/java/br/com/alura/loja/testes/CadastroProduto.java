package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CadastroProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone XR","Iphone muito top!",new BigDecimal(800), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);
        CategoriaDAO categoriaDao = new CategoriaDAO(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
