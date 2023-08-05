package com.example;

import org.junit.jupiter.api.Test;

import com.example.entities.Transacao;
import com.example.enums.TipoMoeda;
import com.example.enums.TipoTransacao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testListaTransacoesSuspeitasTrue() {
        try {
            boolean expected = true;
            boolean actual = false;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data;
            data = sdf.parse("01/01/2000");
            List<Transacao> transacoes = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Transacao transacao = new Transacao(123, 500.00, TipoMoeda.valueOf("USD"),
                        TipoTransacao.valueOf("DEPOSITO"), data);
                transacoes.add(transacao);
            }
            List<Transacao> tSusp = new ArrayList<>();
            int count = 0;
            for (Transacao t : transacoes) {
                int auxCliente = t.getCliente();
                String aux = sdf.format(t.getData());
                for (Transacao tr : transacoes) {
                    if (auxCliente == tr.getCliente() && aux.equals(sdf.format(tr.getData()))) {
                        count++;
                        tSusp.add(tr);
                    }
                }
            }
            if (count > 3) {
                actual = true;
            } else {
            }

            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    void testListaTransacoesSuspeitasFalse() {
        try {
            boolean expected = false;
            boolean actual = false;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data;
            data = sdf.parse("01/01/2000");
            List<Transacao> transacoes = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Transacao transacao = new Transacao(i, 500.00, TipoMoeda.valueOf("USD"),
                        TipoTransacao.valueOf("DEPOSITO"), data);
                transacoes.add(transacao);
            }
            List<Transacao> tSusp = new ArrayList<>();
            int count = 0;
            for (Transacao t : transacoes) {
                int auxCliente = t.getCliente();
                String aux = sdf.format(t.getData());
                for (Transacao tr : transacoes) {
                    if (auxCliente == tr.getCliente() && aux.equals(sdf.format(tr.getData()))) {
                        count++;
                        tSusp.add(tr);
                        auxCliente = tr.getCliente();
                    }
                }
            }
            if (count > 3) {
                actual = true;
            } else {
            }

            assertEquals(expected, actual);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
