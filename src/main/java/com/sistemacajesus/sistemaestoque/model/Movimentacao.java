package com.sistemacajesus.sistemaestoque.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbmovimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentacao")
    private Integer id;

    // Relacionamento com Produto via marca_produto (UNIQUE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_produto", referencedColumnName = "marca_produto",
            nullable = false, foreignKey = @ForeignKey(name = "fk_mov_produto"))
    private Produto produto;

    @Column(name = "data_movimentacao", nullable = false)
    private LocalDateTime dataMovimentacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "acao_movimentacao", nullable = false, length = 7)
    private AcaoMovimentacao acao;

    @Column(name = "quantidade_movimentacao", nullable = false)
    private Integer quantidade;

    @Column(name = "preco_custo_movimentacao", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoCusto;

    @Column(name = "preco_venda_movimentacao", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoVenda;

    // Lucro é coluna virtual no banco (não persistimos, só leitura)
    // Não mapeamos como campo persistente; se precisar exibir, calculamos no getter ou service
    @Transient
    private BigDecimal lucro;

    @Column(name = "observacao_movimentacao", columnDefinition = "TEXT")
    private String observacao;

    // Relacionamento com Usuário (opcional, pode ser null)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario",
            foreignKey = @ForeignKey(name = "fk_mov_usuario"))
    private Usuario usuario;

    public Movimentacao() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public AcaoMovimentacao getAcao() {
        return acao;
    }

    public void setAcao(AcaoMovimentacao acao) {
        this.acao = acao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    // O lucro pode ser calculado sob demanda:
    public BigDecimal getLucro() {
        if (acao == AcaoMovimentacao.saida && precoVenda != null && precoCusto != null) {
            return precoVenda.subtract(precoCusto).multiply(BigDecimal.valueOf(quantidade));
        }
        return BigDecimal.ZERO;
    }

    public void setLucro(BigDecimal lucro) {
        this.lucro = lucro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}