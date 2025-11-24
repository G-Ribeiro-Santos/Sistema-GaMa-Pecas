package models;

import java.sql.ResultSet;
import java.sql.SQLException;

// Produto.java
public class Produtos {
    private int idProduto;
    private String nomeProduto;
    private String especificacoesTecnicas;
    private String documentacaoStatus;
    
    public Produtos() {
    }
    public Produtos(int idProduto, String nomeProduto, String especificacoesTecnicas, String documentacaoStatus) {
    	this.idProduto = idProduto;
    	this.nomeProduto = nomeProduto;
    	this.especificacoesTecnicas = especificacoesTecnicas;
    	this.documentacaoStatus = documentacaoStatus;
    }
    public Produtos(String nomeProduto, String especificacoesTecnicas, String documentacaoStatus) {
    	this.nomeProduto = nomeProduto;
    	this.especificacoesTecnicas = especificacoesTecnicas;
    	this.documentacaoStatus = documentacaoStatus;
    }
    
    public Boolean buscaProduto() {
    	ProdutosDAO ProdutoPesquisado = new ProdutosDAO();
    	ResultSet rs = ProdutoPesquisado.listarPorID(this.getIdProduto() + "");
    	try {
			while (rs.next()) {
				if (rs.getInt("id_produto") == this.getIdProduto()) {
		    		this.setIdProduto(rs.getInt("id_produto"));
		    		this.setNomeProduto(rs.getString("nome_produto"));
		    		this.setEspecificacoesTecnicas(rs.getString("Especificacoes_tecnicas"));
		    		this.setDocumentacaoStatus(rs.getString("Documentacao_status"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    
    public int salvaProduto() {
    	ProdutosDAO ProdutoSalvo = new ProdutosDAO();
    	this.setIdProduto(ProdutoSalvo.insert(this));
    	return this.getIdProduto();
    }
    
    public int editaProduto() {
    	ProdutosDAO ProdutoSalvo = new ProdutosDAO();
    	return ProdutoSalvo.update(this);
    }
    public int deletaProduto() {
    	ProdutosDAO ProdutoSalvo = new ProdutosDAO();
    	return ProdutoSalvo.delete(this);
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getEspecificacoesTecnicas() {
        return especificacoesTecnicas;
    }
    public void setEspecificacoesTecnicas(String especificacoesTecnicas) {
        this.especificacoesTecnicas = especificacoesTecnicas;
    }

    public String getDocumentacaoStatus() {
        return documentacaoStatus;
    }
    public void setDocumentacaoStatus(String documentacaoStatus) {
        this.documentacaoStatus = documentacaoStatus;
    }
}
