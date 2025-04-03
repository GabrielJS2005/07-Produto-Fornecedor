package br.fiap.main;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.util.Util;

public class Main {

    public static void main(String[] args) {

        Fornecedor f = new Fornecedor("xpto", 1);

        Util u = new Util();

        u.menuPrincipal();

        //System.out.println(f.getNome());
        //f.setNome("Fiap");
        //System.out.println(f.getNome());

    }

}
