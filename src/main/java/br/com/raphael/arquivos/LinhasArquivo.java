package br.com.raphael.arquivos;


import br.com.raphael.arquivos.entities.Pessoas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinhasArquivo {

    public static List<Pessoas> LerArquivo() {
        List<Pessoas> pessoas = new ArrayList<>();
        try {
            Path file = Paths.get("D:\\Testes\\Arquivo\\ArquivoGeral.txt");

            BufferedReader br = new BufferedReader(new FileReader(file.toString()));
            System.out.println("Efetuando leitura do arquivo: " + file.toString());

            String s;
            int i = 1;
            while ((s = br.readLine()) != null) {

                String nome = s.substring(39, 115);
                String cpfArquivo = s.substring(163, 174);
                String dtNascimento = s.substring(147, 155);
                String dtFalecimento = s.substring(155, 163);
                String nomeMae = s.substring(115, 147);

                String dataLavratura = s.substring(21, 29);
                int anoNasc = Integer.parseInt(dtNascimento.substring(0, 4));
                int anoFal = Integer.parseInt(dtFalecimento.substring(0, 4));
                int idadeFal = anoFal - anoNasc;
                if (idadeFal > 200) {
                    idadeFal = 0;
                }

                if (dtNascimento.equals("00000000")) {
                    dtNascimento = "19000101";
                }

                DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                Date dataN = null;
                Date dataF = null;
                Date dataL = null;
                try {
                    dataN = (Date) formatter.parse(dtNascimento);
                    dataF = (Date) formatter.parse(dtFalecimento);
                    dataL = (Date) formatter.parse(dataLavratura);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pessoas.add(new Pessoas(i, nome, nomeMae, cpfArquivo, dataN, dataF, dataL, idadeFal));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }
}




