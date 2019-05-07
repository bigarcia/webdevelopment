package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import java.util.List;

public class TestaDAO {

    public String cidade = "Araraquara";
    public static void main(String[] args) {
        ClienteDAO cDAO = new ClienteDAO();
        LocadoraDAO lDAO = new LocadoraDAO();
        
        Cliente c1 = new Cliente();
        c1.setEmail_cliente("bianca@gmail.com");
        c1.setSenha_cliente("aaaa");
        c1.setCpf_cliente("11111111111");
        c1.setNome_cliente("Bianca");
        c1.setTelefone_cliente("911111111");
        c1.setSexo_cliente("f");
        c1.setNascimento_cliente("01/01/2001");
        cDAO.save(c1);
        
        Cliente c2 = new Cliente();
        c2.setEmail_cliente("gabrieli@gmail.com");
        c2.setSenha_cliente("bbbb");
        c2.setCpf_cliente("22222222222");
        c2.setNome_cliente("Gabrieli");
        c2.setTelefone_cliente("922222222");
        c2.setSexo_cliente("f");
        c2.setNascimento_cliente("02/02/2002");
        cDAO.save(c2);
        
        Cliente c3 = new Cliente();
        c3.setEmail_cliente("giulia@gmail.com");
        c3.setSenha_cliente("cccc");
        c3.setCpf_cliente("33333333333");
        c3.setNome_cliente("Giulia");
        c3.setTelefone_cliente("933333333");
        c3.setSexo_cliente("f");
        c3.setNascimento_cliente("03/03/2003");
        cDAO.save(c3);
        
        Cliente c4 = new Cliente();
        c4.setEmail_cliente("isadora@gmail.com");
        c4.setSenha_cliente("dddd");
        c4.setCpf_cliente("44444444444");
        c4.setNome_cliente("Isadora");
        c4.setTelefone_cliente("944444444");
        c4.setSexo_cliente("f");
        c4.setNascimento_cliente("04/04/2004");
        cDAO.save(c4);
        
        Locadora l1 = new Locadora();
        l1.setEmail_locadora("locadora1@gmail.com");
        l1.setSenha_locadora("L111");
        l1.setCnpj_locadora("11111111111111");
        l1.setNome_locadora("Locadora 1");
        l1.setCidade_locadora("São Carlos");
        lDAO.save(l1);
        
        Locadora l2 = new Locadora();
        l2.setEmail_locadora("locadora2@gmail.com");
        l2.setSenha_locadora("L222");
        l2.setCnpj_locadora("22222222222222");
        l2.setNome_locadora("Locadora 2");
        l2.setCidade_locadora("Araraquara");
        lDAO.save(l2);
        
        Locadora l3 = new Locadora();
        l3.setEmail_locadora("locadora3@gmail.com");
        l3.setSenha_locadora("L333");
        l3.setCnpj_locadora("33333333333333");
        l3.setNome_locadora("Locadora 3");
        l3.setCidade_locadora("Araraquara");
        lDAO.save(l3);
        
        //Listagem de todas as locadoras em uma única página
        System.out.println();
        System.out.println("Listagem de Locadoras");
        System.out.println();
        
        List<Locadora> listaLocadoras = lDAO.getAll();
        for (Locadora l : listaLocadoras) {
            System.out.println(l);
        }
        
        //Listagem de todas as locadoras por cidade
        System.out.println();
        System.out.println("Listagem de Locadoras por cidade");
        System.out.println();
        System.out.println(lDAO.getByCidade("Araraquara"));
        System.out.println();
    }
}
    