package com.sistemacajesus.sistemaestoque.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbfornecedores")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Integer id;

    @Column(name = "nome_fornecedor", length = 255, nullable = false)
    private String nome;

    @Column(name = "telefone_fornecedor", length = 15, nullable = false)
    private String telefone;

    @Column(name = "cnpj_fornecedor", length = 18, unique = true, nullable = false)
    private String cnpj;

    @Column(name = "email_fornecedor", length = 255, unique = true, nullable = false)
    private String email;

    @Column(name = "cep_fornecedor", length = 9, nullable = false)
    private String cep;

    @Column(name = "endereco_fornecedor", length = 255)
    private String endereco;

    @Column(name = "numero_fornecedor", length = 10)
    private String numero;

    @Column(name = "complemento_fornecedor", length = 255)
    private String complemento;

    @Column(name = "bairro_fornecedor", length = 100)
    private String bairro;

    @Column(name = "cidade_fornecedor", length = 100)
    private String cidade;

    @Column(name = "estado_fornecedor", length = 2)
    private String estado;

    @Column(name = "ativo_fornecedor", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean ativo = true;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Fornecedor() {}

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    // getters e setters (gere com Alt+Insert no IntelliJ)
}