package com.sistemacajesus.sistemaestoque.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbusuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "tipo_usuario", nullable = false)
    private Integer tipoUsuario;

    @Column(name = "nome_usuario", length = 255, nullable = false)
    private String nome;

    @Column(name = "email_usuario", length = 255, unique = true, nullable = false)
    private String email;

    @Column(name = "senha_usuario", length = 255, nullable = false)
    private String senha;

    @Column(name = "cpf_usuario", length = 14, unique = true, nullable = false)
    private String cpf;

    @Column(name = "rg_usuario", length = 20, unique = true, nullable = false)
    private String rg;

    @Column(name = "telefone_usuario", length = 15, nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo_usuario", nullable = false)
    private SexoUsuario sexo;

    @Column(name = "cep_usuario", length = 9, nullable = false)
    private String cep;

    @Column(name = "endereco_usuario", length = 255)
    private String endereco;

    @Column(name = "cidade_usuario", length = 100)
    private String cidade;

    @Column(name = "estado_usuario", length = 2)
    private String estado;

    @Column(name = "numero_usuario", length = 10)
    private String numero;

    @Column(name = "complemento_usuario", length = 255)
    private String complemento;

    @Column(name = "bairro_usuario", length = 100)
    private String bairro;

    @Column(name = "ativo_usuario", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean ativo = true;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;

    @Column(name = "deletado_em")
    private LocalDateTime deletadoEm;

    // Construtor vazio
    public Usuario() {
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public SexoUsuario getSexo() {
        return sexo;
    }

    public void setSexo(SexoUsuario sexo) {
        this.sexo = sexo;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public LocalDateTime getDeletadoEm() {
        return deletadoEm;
    }

    public void setDeletadoEm(LocalDateTime deletadoEm) {
        this.deletadoEm = deletadoEm;
    }
}