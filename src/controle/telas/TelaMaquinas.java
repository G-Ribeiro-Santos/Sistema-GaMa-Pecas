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

import models.Maquinas;

public class TelaMaquinas {
    private JFrame janela = new JFrame("Máquinas");
    private Font fonte = new Font("Arial", Font.BOLD, 24);
    private Font fonte2 = new Font("Arial", Font.BOLD, 16);

    private JLabel titulo = new JLabel("Máquinas");

    private JLabel textoID = new JLabel("ID:");
    private JLabel textoNome = new JLabel("Nome da Máquina:");
    private JLabel textoDisponibilidade = new JLabel("Disponibilidade:");
    private JLabel textoErro = new JLabel("Não foi possível localizar a máquina");

    private JTextField campoID = new JTextField();
    private JLabel campoIDEstatico = new JLabel("");
    private JTextArea campoNome = new JTextArea();

    private JScrollPane scrollNome = new JScrollPane(campoNome);

    private JComboBox<String> comboDisponibilidade = new JComboBox<>(new String[] {
        "MANUTENCAO", "OPERACIONAL", "PARADA", "INDISPONIVEL"
    });

    private JButton botaoCriar = new JButton("Criar");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoDeletar = new JButton("Deletar");
    private JButton botaoPesquisar = new JButton("Pesquisar");
    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoLimpar = new JButton("Limpar");

    private int IDDigitado;

    public TelaMaquinas() {
        this.janela.setBounds(200, 200, 600, 450);
        this.janela.setLayout(null);
        this.janela.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.titulo.setFont(fonte);
        this.titulo.setBounds(200, 20, 400, 30);

        this.textoID.setBounds(200, 60, 150, 25);
        this.textoID.setFont(fonte2);

        this.textoNome.setBounds(50, 100, 200, 25);
        this.textoNome.setFont(fonte2);

        this.textoDisponibilidade.setBounds(60, 190, 200, 25);
        this.textoDisponibilidade.setFont(fonte2);

        this.textoErro.setBounds(175, 320, 250, 25);

        this.campoID.setBounds(230, 60, 300, 25);
        this.campoIDEstatico.setBounds(230, 60, 300, 25);

        this.scrollNome.setBounds(230, 100, 300, 70);
        this.campoNome.setLineWrap(true);
        this.campoNome.setEditable(false);

        this.comboDisponibilidade.setBounds(230, 190, 200, 25);
        this.comboDisponibilidade.setEnabled(false);

        this.botaoCriar.setBounds(310, 280, 100, 40);
        this.botaoPesquisar.setBounds(200, 280, 100, 40);
        this.botaoDeletar.setBounds(140, 280, 100, 40);
        this.botaoEditar.setBounds(360, 280, 100, 40);
        this.botaoLimpar.setBounds(250, 280, 100, 40);
        this.botaoCancelar.setBounds(310, 280, 100, 40);
        this.botaoSalvar.setBounds(200, 280, 100, 40);

        this.janela.add(titulo);
        this.janela.add(textoID);
        this.janela.add(textoNome);
        this.janela.add(textoDisponibilidade);
        this.janela.add(textoErro);

        this.janela.add(campoID);
        this.janela.add(campoIDEstatico);
        this.janela.add(scrollNome);
        this.janela.add(comboDisponibilidade);

        this.janela.add(botaoCriar);
        this.janela.add(botaoPesquisar);
        this.janela.add(botaoEditar);
        this.janela.add(botaoLimpar);
        this.janela.add(botaoDeletar);
        this.janela.add(botaoCancelar);
        this.janela.add(botaoSalvar);

        this.janela.setVisible(true);
        this.campoIDEstatico.setVisible(false);
        this.textoErro.setVisible(false);

        this.botaoCriar.setVisible(true);
        this.botaoPesquisar.setVisible(true);
        this.botaoEditar.setVisible(false);
        this.botaoLimpar.setVisible(false);
        this.botaoDeletar.setVisible(false);
        this.botaoSalvar.setVisible(false);
        this.botaoCancelar.setVisible(false);

        this.campoID.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    campoID.setEditable(true);
                } else {
                    campoID.setEditable(false);
                }
            }
        });

        this.botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejaMaquina();
            }
        });

        this.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejaMaquina();
            }
        });

        this.botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoID.getText().equals("") || campoIDEstatico.getText().equals("")) {
                    telaLimpa();
                } else {
                    exibeMaquina();
                    Maquinas maquinaNaTela = new Maquinas();
                    IDDigitado = Integer.parseInt(campoIDEstatico.getText());
                    maquinaNaTela.setIdMaquina(IDDigitado);
                    maquinaNaTela.buscaMaquina();
                    campoNome.setText(maquinaNaTela.getNomeMaquina());
                    comboDisponibilidade.setSelectedItem(maquinaNaTela.getDisponibilidade());
                }
            }
        });

        this.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLimpa();
            }
        });

        this.botaoPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoID.getText().equals("")) {
                    textoErro.setVisible(true);
                    return;
                } else {
                    textoErro.setVisible(false);
                }
                Maquinas maquinaNaTela = new Maquinas();
                IDDigitado = Integer.parseInt(campoID.getText());
                maquinaNaTela.setIdMaquina(IDDigitado);
                maquinaNaTela.buscaMaquina();
                if (maquinaNaTela.getNomeMaquina() != null && !maquinaNaTela.getNomeMaquina().equals("")) {
                    exibeMaquina();
                    campoIDEstatico.setText(String.valueOf(maquinaNaTela.getIdMaquina()));
                    campoNome.setText(maquinaNaTela.getNomeMaquina());
                    comboDisponibilidade.setSelectedItem(maquinaNaTela.getDisponibilidade());
                } else {
                    textoErro.setVisible(true);
                }
            }
        });

        this.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maquinas maquinaNaTela = new Maquinas();
                maquinaNaTela.setNomeMaquina(campoNome.getText());
                maquinaNaTela.setDisponibilidade((String) comboDisponibilidade.getSelectedItem());

                if (campoID.getText().equals("")) {
                    maquinaNaTela.salvaMaquina();
                } else {
                    maquinaNaTela.setIdMaquina((int) Double.parseDouble(campoID.getText()));
                    maquinaNaTela.editaMaquina();
                }

                campoID.setText(maquinaNaTela.getIdMaquina() + "");
                campoIDEstatico.setText(maquinaNaTela.getIdMaquina() + "");
                campoNome.setText(maquinaNaTela.getNomeMaquina());
                comboDisponibilidade.setSelectedItem(maquinaNaTela.getDisponibilidade());

                exibeMaquina();
            }
        });

        this.botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maquinas maquinaNaTela = new Maquinas();
                maquinaNaTela.setIdMaquina(Integer.parseInt(campoID.getText()));
                maquinaNaTela.deletaMaquina();
                telaLimpa();
            }
        });
    }

    public void exibeMaquina() {
        botaoCriar.setVisible(false);
        botaoPesquisar.setVisible(false);
        botaoEditar.setVisible(true);
        botaoLimpar.setVisible(true);
        botaoDeletar.setVisible(true);
        botaoSalvar.setVisible(false);
        botaoCancelar.setVisible(false);
        textoErro.setVisible(false);
        
        campoID.setVisible(false);
        campoID.setEditable(false);
        campoIDEstatico.setVisible(true);

        campoNome.setEditable(false);
        comboDisponibilidade.setEnabled(false);
    }

    public void manejaMaquina() {
        botaoCriar.setVisible(false);
        botaoPesquisar.setVisible(false);
        botaoEditar.setVisible(false);
        botaoLimpar.setVisible(false);
        botaoDeletar.setVisible(false);
        botaoSalvar.setVisible(true);
        botaoCancelar.setVisible(true);

        campoID.setVisible(false);
        campoID.setEditable(false);
        campoIDEstatico.setVisible(true);

        campoNome.setEditable(true);
        comboDisponibilidade.setEnabled(true);
    }

    public void telaLimpa() {
        botaoCriar.setVisible(true);
        botaoPesquisar.setVisible(true);
        botaoEditar.setVisible(false);
        botaoLimpar.setVisible(false);
        botaoDeletar.setVisible(false);
        botaoSalvar.setVisible(false);
        botaoCancelar.setVisible(false);

        campoID.setVisible(true);
        campoID.setEditable(true);
        campoIDEstatico.setVisible(false);

        campoNome.setEditable(false);
        comboDisponibilidade.setEnabled(false);

        campoID.setText("");
        campoIDEstatico.setText("");
        campoNome.setText("");
        comboDisponibilidade.setSelectedIndex(0);

        textoErro.setVisible(false);
    }
}
