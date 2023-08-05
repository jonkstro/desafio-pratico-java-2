package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.example.entities.Transacao;
import com.example.enums.TipoMoeda;
import com.example.enums.TipoTransacao;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Transacao> transacoes = new ArrayList<>();
        try {
            System.out.println("SISTEMA BANCÁRIO");
            System.out.print("Insira quantas transações quer inserir: ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.println();
                System.out.print("Insira o cpf do cliente: ");
                int cliente = sc.nextInt();
                sc.nextLine();
                System.out.print("Insira o valor da transação: ");
                double valor = sc.nextDouble();
                sc.nextLine();
                System.out.print("Insira o tipo da moeda (USD, etc...): ");
                TipoMoeda tipoMoeda = TipoMoeda.valueOf(sc.nextLine().toUpperCase());
                System.out.print("Insira o tipo da transação (DEPOSITO, etc...): ");
                TipoTransacao tipoTransacao = TipoTransacao.valueOf(sc.nextLine().toUpperCase());
                System.out.print("Insira a data da transação no formado dd/MM/yyyy: ");
                Date dataTransacao = sdf.parse(sc.nextLine());
                Transacao transacao = new Transacao(cliente, valor, tipoMoeda, tipoTransacao, dataTransacao);
                transacoes.add(transacao);
            }

            listaTransacao(sc, transacoes);

            listaTransacoesSuspeitas(sdf, transacoes);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    private static void listaTransacoesSuspeitas(SimpleDateFormat sdf, List<Transacao> transacoes) {
        System.out.println("========= LISTA DE TRANSAÇÕES SUSPEITAS =========");
        
        List<Transacao> tSusp = new ArrayList<>();
        int count = 0;
        for(Transacao t: transacoes) {
            String aux = sdf.format(t.getData());
            for(Transacao tr: transacoes) {
                if(aux.equals(sdf.format(tr.getData()))){
                    count ++;
                    tSusp.add(tr);
                }
            }
        }
        if (count > 3) {
          System.out.println("\nLISTA DE TRANSACOES SUSPEITAS:");
          System.out.println(tSusp+"\n");  
        } else {
            System.out.println("\nNão foi identificado transações suspeitas");
        }
    }

    private static void listaTransacao(Scanner sc, List<Transacao> transacoes) {
        System.out.println("\n========== LISTAR TRANSACOES POR CLIENTE E TIPO DE TRANSAÇÃO ==========");
        System.out.print(
                "Digite o cpf do cliente que deseja lista as transacoes, ou aperte 0 pra não buscar por cpf: ");
        int cpf = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o tipo de transação que deseja filtrar: ");
        String tipoT = sc.nextLine();
        if (tipoT.equals("")) {
            for (Transacao t : transacoes) {
                if (t.getCliente() == cpf) {
                    if (tipoT == null) {
                        System.out.println(t);
                    }
                }
            }
        } else if (cpf == 0) {
            for (Transacao t : transacoes) {

                if (tipoT.toUpperCase().equals(t.getTipoTransacao().toString())) {
                    System.out.println(t);
                }

            }
        } else {
            for (Transacao t : transacoes) {
                if (t.getCliente() == cpf && tipoT.toUpperCase().equals(t.getTipoTransacao().toString())) {
                    System.out.println(t);
                }
            }
        }
    }
}
