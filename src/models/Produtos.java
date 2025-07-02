package models;

// Produto.java
public class Produtos {
    private int idProduto;
    private String nomeProduto;
    private String especificacoesTecnicas;
    private String documentacaoStatus;

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
