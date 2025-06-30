package controle.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import database.DBQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaProduto {
    private JFrame janela = new JFrame("Produtos");
    private Font fonte = new Font("Arial", Font.BOLD, 24);
    private Font fonte2 = new Font("Arial", Font.BOLD, 16);

    private JLabel textoIDProduto = new JLabel("ID:");
    private JLabel textoNome= new JLabel("Nome do Produto:");
    private JLabel textoEspecificacoes = new JLabel("Especificações Técnicas:");
    private JLabel textoStatus = new JLabel("Status Documentação:");
    private JLabel textoErro = new JLabel("Não foi possível localizar o produto");
    private JTextField campoID = new JTextField();
    private JTextField campoNome = new JTextField();
    private JTextArea  campoEspecificacoes = new JTextArea ();
    private JScrollPane scrollCampoEspecificacoes = new JScrollPane(campoEspecificacoes);
    private JComboBox<String> comboStatus = new JComboBox<>(new String[] {
        "...", "COMPLETO", "INCOMPLETO", "PENDENTE"
    });
    private JLabel titulo = new JLabel("Produtos");

    //botoes
    private JButton botaoCriar= new JButton("Criar");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoDeletar = new JButton("Deletar");
    private JButton botaoPesquisar = new JButton("Pesquisar");
    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoLimpar = new JButton("Limpar");

    //sql
	private DBQuery tabela = new DBQuery("Produtos", "id_produto,nome_produto,Especificacoes_tecnicas,Documentacao_status", "id_produto");
	private String pesquisa = "SELECT * FROM Produtos";
	private int IDProdutoDigitado;

    public TelaProduto() {

        this.janela.setBounds(200, 200, 600, 500);
        this.janela.setLayout(null);
        this.janela.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.titulo.setFont(fonte);
        this.titulo.setBounds(180, 20, 400, 30);
        
        this.textoIDProduto.setBounds(200, 60, 150, 25);
        this.textoIDProduto.setFont(fonte2);

        this.textoNome.setBounds(80, 100, 150, 25);
        this.textoNome.setFont(fonte2);

        this.textoEspecificacoes.setBounds(30, 140, 200, 25);
        this.textoEspecificacoes.setFont(fonte2);

        this.textoStatus.setBounds(50, 310, 180, 25);
        this.textoStatus.setFont(fonte2);
        
        this.campoID.setBounds(230, 60, 300, 25);
        this.campoNome.setBounds(230, 100, 300, 25);
        this.campoNome.setEditable(false);
        this.comboStatus.setBounds(230, 310, 150, 25);
        this.comboStatus.setEditable(false);
        this.scrollCampoEspecificacoes.setBounds(230, 140, 300, 165);
        this.campoEspecificacoes.setLineWrap(true);
        this.campoEspecificacoes.setEditable(false);
        
        //botões
        this.botaoCriar.setBounds(310, 350, 100, 40);
        this.botaoPesquisar.setBounds(200, 350, 100, 40);
        this.textoErro.setBounds(175, 370, 200, 40);

        this.botaoEditar.setBounds(310, 350, 100, 40);
        this.botaoLimpar.setBounds(200, 350, 100, 40);
        this.botaoDeletar.setBounds(320, 350, 100, 40);        
        
        this.botaoCancelar.setBounds(310, 350, 100, 40);
        this.botaoSalvar.setBounds(200, 350, 100, 40);
        

        // Adicionando na janela
        janela.setVisible(true);
        this.janela.add(titulo);
        
        this.janela.add(textoIDProduto);
        this.janela.add(textoEspecificacoes);
        this.janela.add(textoNome);
        this.janela.add(textoStatus);
        
        this.janela.add(scrollCampoEspecificacoes);
        this.janela.add(campoNome);
        this.janela.add(comboStatus);
        this.janela.add(campoID);
        this.janela.add(textoErro);
        
        this.janela.add(botaoCriar);
        this.janela.add(botaoPesquisar);
        
        this.janela.add(botaoEditar);
        this.janela.add(botaoLimpar);
        this.janela.add(botaoDeletar);
        
        this.janela.add(botaoCancelar);
        this.janela.add(botaoSalvar);

        this.botaoCriar.setVisible(true);
        this.botaoPesquisar.setVisible(true);

        this.botaoEditar.setVisible(false);
        this.botaoLimpar.setVisible(false);
        this.botaoDeletar.setVisible(false);
        
        this.botaoCancelar.setVisible(false);
        this.botaoSalvar.setVisible(false);
        
        this.textoErro.setVisible(false);
		this.botaoCriar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				botaoCriar.setVisible(false);
				botaoPesquisar.setVisible(false);
				textoIDProduto.setVisible(false);
				campoID.setVisible(false);
				botaoSalvar.setVisible(true);
				botaoCancelar.setVisible(true);
		        campoNome.setEditable(true);
		        campoEspecificacoes.setEditable(true);
			}
		});

		this.botaoEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoLimpar.setVisible(false);
				botaoEditar.setVisible(false);
				textoIDProduto.setVisible(false);
				campoID.setEditable(false);
				botaoSalvar.setVisible(true);
				botaoCancelar.setVisible(true);
		        campoNome.setEditable(true);
		        campoEspecificacoes.setEditable(true);
		        
			}
		});
		
		this.botaoCancelar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				botaoCriar.setVisible(true);
				botaoPesquisar.setVisible(true);
				textoIDProduto.setVisible(true);
				campoID.setVisible(true);
				botaoSalvar.setVisible(false);
				botaoCancelar.setVisible(false);
				campoNome.setEditable(false);
		        campoEspecificacoes.setEditable(false);
		        if(campoID.getText() == "") {
		        campoNome.setText("");
				campoEspecificacoes.setText("");
		        }else {
		        	
		        }
			}
		});
		this.campoID.addKeyListener(new KeyAdapter() {
			public  void keyPressed(KeyEvent ke) {
				String valorTotal = campoID.getText();
				if((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||  (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					campoID.setEditable(true);
				}else {
					campoID.setEditable(false);
				}
			}
		});
		
		this.botaoPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            ResultSet rs = tabela.query(pesquisa);
				if(campoID.getText().equals("")) {
					System.out.print("erro aqio óia");
					textoErro.setVisible(true);
					return;
				}else {
					textoErro.setVisible(false);
				}
	            IDProdutoDigitado = (int) Double.parseDouble(campoID.getText());
	            try {
					while (rs.next()) {
						if (rs.getInt("id_produto") == IDProdutoDigitado){
					        campoID.setEditable(false);
							botaoCriar.setVisible(false);
							botaoPesquisar.setVisible(false);
							botaoEditar.setVisible(true);
							botaoLimpar.setVisible(true);
							campoNome.setText(rs.getString("nome_produto"));
							campoEspecificacoes.setText(rs.getString("Especificacoes_tecnicas"));
							switch (rs.getString("Documentacao_status")){
							case "COMPLETO":
								comboStatus.setSelectedIndex(1);
								break;
							case "INCOMPLETO":
								comboStatus.setSelectedIndex(2);
								break;
							case "PENDENTE":
								comboStatus.setSelectedIndex(3);
								break;
							default:
								comboStatus.setSelectedIndex(0);
								break;
							}
						}
					}

				} catch (SQLException e1) {
		            e1.printStackTrace();
				}		        
			}
		});

    }
}