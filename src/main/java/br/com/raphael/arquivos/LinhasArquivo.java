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

                String estado = null;
                String digitoCpf = cpfArquivo.substring(8, 9);

                if (digitoCpf.equals("0") && cpfArquivo != "00000000000") {
                    estado = "RS";
                } else if (digitoCpf.equals("1")) {
                    estado = "DF, GO, MT, MS, TO";
                } else if (digitoCpf.equals("2")) {
                    estado = "AM, PA, RR, AC, RO";
                } else if (digitoCpf.equals("3")) {
                    estado = "CE, MA, PI";
                } else if (digitoCpf.equals("4")) {
                    estado = "PB, PE, AL, RN";
                } else if (digitoCpf.equals("5")) {
                    estado = "BA, SE";
                } else if (digitoCpf.equals("6")) {
                    estado = "MG";
                } else if (digitoCpf.equals("7")) {
                    estado = "RJ, ES";
                } else if (digitoCpf.equals("8")) {
                    estado = "SP";
                } else if (digitoCpf.equals("9")) {
                    estado = "PR, SC";
                }


//                0	Rio Grande do Sul
//                1	Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins
//                2	Amazonas, Pará, Roraima, Amapá, Acre e Rondônia
//                3	Ceará, Maranhão e Piauí
//                4	Paraíba, Pernambuco, Alagoas e Rio Grande do Norte
//                5	Bahia e Sergipe
//                6	Minas Gerais
//                7	Rio de Janeiro e Espírito Santo
//                8	São Paulo
//                9	Paraná e Santa Catarina

                pessoas.add(new Pessoas(i, nome, nomeMae, cpfArquivo, dataN, dataF, dataL, idadeFal, estado));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }
}




