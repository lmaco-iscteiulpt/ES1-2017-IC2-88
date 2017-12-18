package antiSpamFilter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI {

	private JFrame frame; //janela

	private Object[] colunas = new Object[]{"Regra", "Peso"};

	private JTextField textFicheiroRegras;
	private JTextField textFicheiroHam;
	private JTextField textFicheiroSpam;

	private JPanel panelManual;
	private JTable tblManual;
	private JScrollPane scrollManual;
	private JTextField textFalsosPositivosManual;
	private JTextField textFalsosNegativosManual;

	private JPanel panelAutomatico;
	private JTable tblAutomatico;
	private JScrollPane scrollAutomatico;
	private JTextField textFalsosPositivosAutomatico;
	private JTextField textFalsosNegativosAutomatico;

	public GUI(){
		frame = new JFrame();
		frame.setLayout(new GridLayout(3, 1));

		frame.setTitle("Configura��o manual do filtro anti-spam");
		createPanel1();
		createPanelManual();
		createPanel3();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
	}

	public void open() {
		frame.setVisible(true);
	}

	private void createPanel1() {
		JPanel panel1 = new JPanel(new GridLayout(3, 1));

		// Ligra Regras
		JPanel panelRegras = new JPanel(new FlowLayout());
		panelRegras.add(new JLabel("Ficheiro regras: "));
		textFicheiroRegras = new JTextField(30);
		panelRegras.add(textFicheiroRegras);
		panel1.add(panelRegras);

		// Linha Ham
		JPanel panelHam = new JPanel(new FlowLayout());
		panelHam.add(new JLabel("Ficheiro Ham:     "));
		textFicheiroHam = new JTextField(30);
		panelHam.add(textFicheiroHam);
		panel1.add(panelHam);

		// Linha Spam
		JPanel panelSpam = new JPanel(new FlowLayout());
		panelSpam.add(new JLabel("Ficheiro Spam:    "));
		textFicheiroSpam = new JTextField(30);
		panelSpam.add(textFicheiroSpam);
		panel1.add(panelSpam);

		frame.add(panel1);
	}

	private void createPanelManual() {
		panelManual = new JPanel(new BorderLayout());


		JLabel titulo = new JLabel("Configura��o Manual");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelManual.add(titulo, BorderLayout.NORTH);

		// Tabela
		tblManual = new JTable(new Object[0][0], colunas);
		tblManual.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tblManual.setFillsViewportHeight(true);
		scrollManual = new JScrollPane(tblManual);
		panelManual.add(scrollManual, BorderLayout.CENTER);

		// Botoes
		JPanel panelBotoes = new JPanel(new GridLayout(3, 1));

		JButton btnCarregar = new JButton("Carregar Regras");
		btnCarregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		panelBotoes.add(btnCarregar);


		JButton btnAvaliar = new JButton("Avaliar Filtro Manual");
		btnAvaliar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		panelBotoes.add(btnAvaliar);

		JButton btnGuardar = new JButton("Guardar Regras");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}

		});
		panelBotoes.add(btnGuardar);
		panelManual.add(panelBotoes, BorderLayout.EAST);

		// Labels
		JPanel panelLabels = new JPanel(new FlowLayout());
		panelLabels.add(new JLabel("FP: "));
		textFalsosPositivosManual = new JTextField(5);
		textFalsosPositivosManual.setEditable(false);
		panelLabels.add(textFalsosPositivosManual);
		panelLabels.add(new JLabel("FN: "));
		textFalsosNegativosManual = new JTextField(5);
		textFalsosNegativosManual.setEditable(false);
		panelLabels.add(textFalsosNegativosManual);
		panelManual.add(panelLabels, BorderLayout.SOUTH);

		frame.add(panelManual);
	}

	private void createPanel3() {
		panelAutomatico = new JPanel(new BorderLayout());

		JLabel titulo = new JLabel("Configura��o Autom�tica");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelAutomatico.add(titulo, BorderLayout.NORTH);

		tblAutomatico = new JTable(new Object[0][0], colunas);
		tblAutomatico.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tblAutomatico.setFillsViewportHeight(true);
		scrollAutomatico = new JScrollPane(tblAutomatico);
		panelAutomatico.add(scrollAutomatico, BorderLayout.CENTER);

		JPanel panelBotoes = new JPanel(new GridLayout(2, 1));
		JButton btnAvaliar = new JButton("Avaliar Filtro Automatico");
		btnAvaliar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelBotoes.add(btnAvaliar);
		JButton btnGuardar = new JButton("Guardar Regras");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelBotoes.add(btnGuardar);
		panelAutomatico.add(panelBotoes, BorderLayout.EAST);

		JPanel panelLabels = new JPanel(new FlowLayout());
		panelLabels.add(new JLabel("FP: "));
		textFalsosPositivosAutomatico = new JTextField(5);
		textFalsosPositivosAutomatico.setEditable(false);
		panelLabels.add(textFalsosPositivosAutomatico);
		panelLabels.add(new JLabel("FN: "));
		textFalsosNegativosAutomatico = new JTextField(5);
		textFalsosNegativosAutomatico.setEditable(false);
		panelLabels.add(textFalsosNegativosAutomatico);
		panelAutomatico.add(panelLabels, BorderLayout.SOUTH);


		frame.add(panelAutomatico);
	}


	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.open();
	}

}
