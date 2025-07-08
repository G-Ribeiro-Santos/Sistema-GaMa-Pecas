package controle;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controle.telas.TelaFichaTecnica;
import controle.telas.TelaMateriais;
import controle.telas.TelaOrdemDeProducao;
import controle.telas.TelaOrdemDeServico;
import controle.telas.TelaProduto;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {
	
	private JFrame janela = new JFrame();
	private JLabel textoHeader1 = new JLabel("Seja bem vindo");
	private JLabel textoHeader2 = new JLabel("Escolha um módulo");
	private JLabel textoModulo = new JLabel("");
	private Font fonte = new Font("Arial", Font.BOLD, 26);
	private Font fonte2 = new Font("Arial", Font.BOLD, 24);
	private Font fonte3 = new Font("Arial", Font.BOLD, 20);
	
	private JButton botaoModuloProducao = new JButton();
	private JButton botaoModuloProdutos = new JButton();
	private JButton botaoModuloMateriais = new JButton();
	
	private JButton botaoVoltar = new JButton();
	
	private JButton telaFichaTecnica = new JButton();
	private JButton telaMaterial = new JButton();
	private JButton telaOrdemDeProducao = new JButton();
	private JButton telaOrdemDeServico = new JButton();
	private JButton telaProduto = new JButton();

	public TelaInicial() {
		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setTitle("Início");
		
		//Configurações dos itens (tamanho, posição, cor, etc)
		//janela
		this.janela.setBounds(500, 300, 800, 300);
		this.janela.setLayout(null);
		this.janela.getContentPane().setBackground(Color.LIGHT_GRAY);

		//labels
		this.textoHeader1.setBounds(300, 10, 200, 40);
		this.textoHeader1.setFont(fonte);

		this.textoHeader2.setBounds(275, 50, 300, 40);
		this.textoHeader2.setFont(fonte2);
		
		this.textoModulo.setBounds(315,50,300,40);
		this.textoModulo.setFont(fonte2);

		//buttons seções da tela inicial
		this.botaoModuloProducao.setBounds(150, 100, 150, 80);
		this.botaoModuloProducao.setText("Produção");
		this.botaoModuloProducao.setFont(fonte);
		this.botaoModuloProducao.setBorder(BorderFactory.createEtchedBorder(1));
		

		this.botaoModuloProdutos.setBounds(320, 100, 150, 80);
		this.botaoModuloProdutos.setText("Produtos");
		this.botaoModuloProdutos.setFont(fonte);
		this.botaoModuloProdutos.setBorder(BorderFactory.createEtchedBorder(1));
		
		this.botaoModuloMateriais.setBounds(490, 100, 150, 80);
		this.botaoModuloMateriais.setText("Materiais");
		this.botaoModuloMateriais.setFont(fonte);
		this.botaoModuloMateriais.setBorder(BorderFactory.createEtchedBorder(1));
		
		this.botaoVoltar.setBounds(20, 20, 100, 50);
		this.botaoVoltar.setText("Voltar");
		this.botaoVoltar.setFont(fonte3);
		
		// buttons para as telas
		
		//modulo PRODUTOS
		this.telaFichaTecnica.setBounds(200, 100, 150, 80);
		this.telaFichaTecnica.setText("<html>Fichas<br/>Técnicas</html>");
		this.telaFichaTecnica.setFont(fonte);
		this.telaFichaTecnica.setBorder(BorderFactory.createEtchedBorder(1));

		this.telaProduto.setBounds(400, 100, 150, 80);
		this.telaProduto.setText("<html>Produtos</html>");
		this.telaProduto.setFont(fonte);
		this.telaProduto.setBorder(BorderFactory.createEtchedBorder(1));

		//modulo PRODUÇÃO
		this.telaOrdemDeServico.setBounds(200, 100, 150, 80);
		this.telaOrdemDeServico.setText("<html>Ordem de<br/>Serviço</html>");
		this.telaOrdemDeServico.setFont(fonte);
		this.telaOrdemDeServico.setBorder(BorderFactory.createEtchedBorder(1));

		this.telaOrdemDeProducao.setBounds(400, 100, 150, 80);
		this.telaOrdemDeProducao.setText("<html>Ordem de<br/>Produção</html>");
		this.telaOrdemDeProducao.setFont(fonte);
		this.telaOrdemDeProducao.setBorder(BorderFactory.createEtchedBorder(1));
		
		//modulo MATERIAIS
		this.telaMaterial.setBounds(315, 100, 150, 80);
		this.telaMaterial.setText("<html>Materiais</html>");
		this.telaMaterial.setFont(fonte);
		this.telaMaterial.setBorder(BorderFactory.createEtchedBorder(1));

		//textfield
		//adicionando tudo à tela
		this.janela.setVisible(true);
		this.janela.add(textoHeader1);
		this.janela.add(textoHeader2);
		this.janela.add(textoModulo);
		this.janela.add(botaoModuloProducao);
		this.janela.add(botaoModuloProdutos);
		this.janela.add(botaoModuloMateriais);
		this.janela.add(botaoVoltar);
		
		this.janela.add(telaFichaTecnica);
		this.janela.add(telaProduto);
		this.janela.add(telaOrdemDeProducao);
		this.janela.add(telaOrdemDeServico);
		this.janela.add(telaMaterial);


		//visibilidades
		this.textoHeader1.setVisible(true);
		this.botaoModuloProducao.setVisible(true);
		this.botaoModuloProdutos.setVisible(true);
		this.botaoModuloMateriais.setVisible(true);
		this.botaoVoltar.setVisible(false);

		this.telaFichaTecnica.setVisible(false);
		this.telaProduto.setVisible(false);
		this.telaOrdemDeProducao.setVisible(false);
		this.telaOrdemDeServico.setVisible(false);
		this.telaMaterial.setVisible(false);


		this.botaoModuloProducao.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				textoHeader1.setVisible(false);
				textoHeader2.setVisible(false);
				botaoModuloProducao.setVisible(false);
				botaoModuloProdutos.setVisible(false);
				botaoModuloMateriais.setVisible(false);
				
				botaoVoltar.setVisible(true);
				textoModulo.setVisible(true);
				textoModulo.setText("PRODUÇÃO");
				telaOrdemDeProducao.setVisible(true);
				telaOrdemDeServico.setVisible(true);
			}
		});
		this.botaoModuloProdutos.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				textoHeader1.setVisible(false);
				textoHeader2.setVisible(false);
				botaoModuloProducao.setVisible(false);
				botaoModuloProdutos.setVisible(false);
				botaoModuloMateriais.setVisible(false);
				botaoVoltar.setVisible(true);
				
				telaFichaTecnica.setVisible(true);		
				textoModulo.setText("PRODUTOS");		
				textoModulo.setVisible(true);
				telaProduto.setVisible(true);
			}
		});
		this.botaoModuloMateriais.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				textoHeader1.setVisible(false);
				textoHeader2.setVisible(false);
				botaoModuloProducao.setVisible(false);
				botaoModuloProdutos.setVisible(false);
				botaoModuloMateriais.setVisible(false);
				
				botaoVoltar.setVisible(true);
				textoModulo.setText("MATERIAIS");
				textoModulo.setVisible(true);
				telaMaterial.setVisible(true);
			}
		});
		
		
		this.botaoVoltar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				botaoVoltar.setVisible(false);
				textoHeader1.setVisible(true);
				textoHeader2.setVisible(true);
				botaoModuloProducao.setVisible(true);
				botaoModuloProdutos.setVisible(true);
				botaoModuloMateriais.setVisible(true);
				
				textoModulo.setVisible(false);
				telaFichaTecnica.setVisible(false);
				telaMaterial.setVisible(false);
				telaOrdemDeProducao.setVisible(false);
				telaOrdemDeServico.setVisible(false);
				telaProduto.setVisible(false);

			}
		});
		

		this.telaFichaTecnica.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				TelaFichaTecnica telaFichaTec = new TelaFichaTecnica();
			}
		});
		this.telaMaterial.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				TelaMateriais telaMate = new TelaMateriais();
			}
		});
		this.telaOrdemDeProducao.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				TelaOrdemDeProducao telaOrdemProd = new TelaOrdemDeProducao();
			}
		});
		this.telaOrdemDeServico.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				TelaOrdemDeServico telaOrdemServ = new TelaOrdemDeServico();
			}
		});
		this.telaProduto.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				TelaProduto telaProd = new TelaProduto();
			}
		});
	}
}

