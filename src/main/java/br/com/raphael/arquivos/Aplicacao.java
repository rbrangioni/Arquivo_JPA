package br.com.raphael.arquivos;


import br.com.raphael.arquivos.dao.PessoasDAO;
import br.com.raphael.arquivos.entities.Pessoas;

import java.time.LocalDateTime;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) throws InterruptedException {
        PessoasDAO dao = new PessoasDAO();
        dao.getTransaction();

        List<Pessoas> pessoas = buscar();

        int i = 1;
        for (Pessoas pes : pessoas) {
            dao.persist(pes);
            System.out.println("Seq: " + i+"/"+pessoas.size());
            i++;
        }
        LocalDateTime ini = LocalDateTime.now();
        System.out.println("Iniciando Commit " + ini);
        dao.commit();
        LocalDateTime fim = LocalDateTime.now();
        System.out.println("Término Commit " + fim);
    }

    public static List<Pessoas> buscar() {
        return LinhasArquivo.LerArquivo();
    }


}

