package br.com.raphael.arquivos.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "pessoas_arquivo")
public class Pessoas {
    @Id
    @Column(name = "seq")
    private Integer id;

    private String nome;
    @Column(name = "nome_mae")

    private String nomeMae;

    private String cpf;
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "data_falecimento")
    @Temporal(TemporalType.DATE)
    private Date dataFalecimento;

    @Column(name = "data_lavratura")
    private Date dataLavratura;

    @Column(name = "idade_falecimento")
    private int idadeFalecimento;

    public Pessoas() {
    }

    public Pessoas(Integer sequencial, String nome, String nomeMae, String cpf, Date dataNascimento, Date dataFalecimento, Date dataLavratura, int idadeFalecimento) {
        this.id = sequencial;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataFalecimento = dataFalecimento;
        this.dataLavratura = dataLavratura;
        this.idadeFalecimento = idadeFalecimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(Date dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public Date getDataLavratura() {
        return dataLavratura;
    }

    public void setDataLavratura(Date dataLavratura) {
        this.dataLavratura = dataLavratura;
    }

    public int getIdadeFalecimento() {
        return idadeFalecimento;
    }

    public void setIdadeFalecimento(int idadeFalecimento) {
        this.idadeFalecimento = idadeFalecimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoas pessoas = (Pessoas) o;
        return id.equals(pessoas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoas{" +
                "sequencial=" + id +
                ", nome='" + nome + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataFalecimento=" + dataFalecimento +
                ", dataLavratura=" + dataLavratura +
                ", idadeFalecimento=" + idadeFalecimento +
                '}';
    }
}