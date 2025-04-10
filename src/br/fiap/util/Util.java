package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    private Produto[] produto = new Produto[3];
    private Fornecedor[] fornecedor = new Fornecedor[3];
    private int idxProduto;
    private int idxFornecedor;

    public void menuPrincipal() {

        int opcao = 0;
        String menu = "1. Cadastrar Produto\n2. Pesquisar Produto pelo Nome\n3. Pesquisar Fornecedor pelo CNPJ\n4. Finalizar";

        do {

            opcao = parseInt(showInputDialog(menu));

            switch (opcao) {

                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisar();
                    break;
                default:
                    showMessageDialog(null, "Opção Inválida!");

            }

        } while (opcao != 4);

    }

    private void cadastrarProduto() {

        String nomeProduto;
        double valor;
        int qtd;
        Fornecedor fornecedor = pesquisarFornecedor();

        if (fornecedor == null) {
            fornecedor = cadastrarFornecedor();

        }

            nomeProduto = showInputDialog("Nome do produto: ");
            qtd = parseInt(showInputDialog("Quantidade de produtos em estoque: "));
            valor = parseDouble(showInputDialog("Valor unitário do produto: "));

            produto[idxProduto] = new Produto(nomeProduto, fornecedor, qtd, valor);
            idxProduto++;

    }

    private Fornecedor cadastrarFornecedor() {

        String nome = showInputDialog("Informe o nome do Fornecedor: ");
        long cnpj = parseLong(showInputDialog("Informe o CNPJ do Fornecedor: "));

        fornecedor[idxFornecedor] = new Fornecedor(nome, cnpj);
        idxFornecedor++;

        return (fornecedor[idxFornecedor - 1]);

    }

    private void pesquisarProduto() {

        String aux = "Produto não encontrado!";
        String nome = showInputDialog("Nome do produto: ");

        for (int i = 0; i < idxProduto; i++) {

            if (produto[i].getNomeProduto().equalsIgnoreCase(nome)) {
                aux = "";
                aux += "Nome do produto: " + nome + "\n";
                aux += "Valor Unitário do produto: " + produto[i].getValor() + "\n";
                aux += "Fornecedor: " + produto[i].getFornecedor().getNome() + "\n";

            }

        }

        showMessageDialog(null, aux);

    }

    private Fornecedor pesquisarFornecedor() {

        long cnpj = parseLong(showInputDialog("Informe o CNPJ do Fornecedor: "));

        for (int i = 0; i < idxFornecedor; i++) {

            if (fornecedor[i].getCnpj() == cnpj) {
                return (fornecedor[i]);

            }

        }

        showMessageDialog(null, "O CNPJ: " + cnpj + " Não está cadastrado!");

        return (null);

    }

    private void pesquisar() {

        String aux = "";
        Fornecedor fornecedor = pesquisarFornecedor();

        if (fornecedor != null) {
            aux += "Fornecedor: " + fornecedor.getNome() + "\n";
            aux += "CNPJ: " + fornecedor.getCnpj() + "\n";

            showMessageDialog(null, aux);

        }

    }

}