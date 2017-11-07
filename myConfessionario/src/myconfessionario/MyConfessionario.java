/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconfessionario;

import javax.persistence.EntityManagerFactory;
import myConfessionario.persistence.PersistenceSingleton;
import myconfessionario.dao.ConfissaoJpaController;
import myconfessionario.dao.EnderecoJpaController;
import myconfessionario.dao.FielJpaController;
import myconfessionario.dao.PecadosJpaController;
import myconfessionario.dao.PessoaJpaController;
import myconfessionario.dao.TiposPecadoJpaController;
import myconfessionario.model.Confissao;
import myconfessionario.model.Endereco;
import myconfessionario.model.Fiel;
import myconfessionario.model.Pecados;
import myconfessionario.model.Pessoa;
import myconfessionario.model.TiposPecado;

/**
 *
 * @author ahcar
 */
public class MyConfessionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        
        
        
        Endereco endereco = new Endereco();
        /**  Cadastrando Endereço   */
        endereco.setCidade("Varginha");
        endereco.setBairro("Centro");
        endereco.setEstado("MG");
        endereco.setNumero(71);
        endereco.setPais("Brasil");
        endereco.setRua("Rua Zeca Marcelino");
        /**  Cadastrando Endereço   */
        
        /**  Cadastrando Pessoa     */
        
        p1.setData_nascimento("1996-09-26");
        p1.setEmail("ahcarvalho01@gmail.com");
        p1.setEndereco(endereco);
        p1.setEstado_civil("solteiro");
        p1.setNome("Alexandre Carvalho");
        p1.setSexo('M');
        p1.setTelefone("(35) 9 9920-2221");
        p1.setProfissao("Developer");        
        
        /**  Cadastrando Pessoa     */
        
        Fiel f1 = new Fiel();
        f1.setCod_pessoa(p1);
        f1.setBatizado(true);
        f1.setFrequenta_igreja(true);
        
        
        TiposPecado tp = new TiposPecado();
        tp.setNome("Pecado Capial");
        
        Pecados p = new Pecados();
        p.setNome("Faltar aula de POO pra assistir Neflix");
        p.setIndice_malvadeza(10);
        p.setTipo_pecado(tp);
        
        Confissao c = new Confissao();
        c.setCategoria("");
        c.setCod_pecador(f1);
        c.setData_confissao("2017-11-07");
        c.setData_pecado("2017-11-03");
        c.setQuantidade_vezes(3);
        c.setLocal("Minha casa");
        c.setPecado(p);
        
        
        
        
        
        
        
        
        EntityManagerFactory emf = PersistenceSingleton.getInstance().getEntityManagerFactory();  
        
        PessoaJpaController conPessoa = new PessoaJpaController(emf);
        EnderecoJpaController conEndereco = new EnderecoJpaController(emf);
        FielJpaController conFiel = new FielJpaController(emf);
        
        TiposPecadoJpaController conTP = new TiposPecadoJpaController(emf);
        PecadosJpaController conPecado = new PecadosJpaController(emf);
        ConfissaoJpaController conConfissao = new ConfissaoJpaController(emf);
        
        
        
        conEndereco.create(endereco);
        conPessoa.create(p1);
        conFiel.create(f1);
        
        conTP.create(tp);
        conPecado.create(p);
        conConfissao.create(c);
        
        
    }
    
}
