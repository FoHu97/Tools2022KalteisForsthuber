import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Label;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class BallSpiel extends JFrame {

	private JPanel contentPane;
	private Panel panel;
	private Button button;
	Ball ball;
	private Button button_1;
	private Timer t;
	private Timer t2;
	private Balken balkenSpieler;
	private Balken balkenComputer;
	private Label label;
	private int lebenSpieler = 4;
	private int zeit = 0;
	private JMenuBar menuBar;
	private JMenu mnApplication;
	private JMenuItem mntmNewGame;
	private Label label_1;

	/**
	 * Launch the application.
	 */
	public void paint(java.awt.Graphics g) {
		super.paint(g);
		Graphics leinwand = panel.getGraphics();

		leinwand.setColor(Color.ORANGE);
		leinwand.fillRect(0, 0, panel.getWidth(), panel.getHeight());
		ball.zeichnen();
		balkenSpieler.zeichnen();
		balkenComputer.zeichnen();

		repaint();

	}

	public void startTimer() {
		int delay = 10; // Zeit in millisekunden

		t = new Timer(delay, new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				ball.move();
				balkenComputer.set_y(ball.get_y());
				balkenComputer.move();
				leben();
				repaint();

			}
		});

		int delay_zeit = 20;

		t2 = new Timer(delay_zeit, new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				zeit++;
				label.setText("Leben: " + lebenSpieler + "   Zeit: " + zeit);

			}

		});
	}

	private void initGame() {
		ball = new Ball(50, 50, 30, -10, 10, panel);
		balkenSpieler = new Balken(0, panel.getHeight() / 2, 15, 70, 10, panel);
		balkenComputer = new Balken(panel.getWidth() - 15,
				panel.getHeight() / 2, 15, 70, 0, panel);
	}

	private void leben() {

		if (ball.get_x() <= balkenSpieler.get_breite()
				&& ball.get_y() + ball.get_groesse() / 2 >= balkenSpieler
						.get_y()
				&& ball.get_y() + ball.get_groesse() / 2 <= balkenSpieler
						.get_y() + balkenSpieler.get_hoehe()) {

			ball.set_stepInX(-ball.get_stepInX());

		}
		if (ball.get_x() <= 0) {
			t.stop();
			t2.stop();

			if (lebenSpieler > 1) {
				lebenSpieler--;
				JOptionPane.showMessageDialog(null,
						"Leider hast du ein Leben verloren.\nDu hast jetzt "
								+ lebenSpieler + " Leben\nZeit: " + zeit
								+ " ms");

				label.setText("Leben: " + lebenSpieler + "   Zeit: " + zeit
						+ " ms");

			} else {
				JOptionPane.showMessageDialog(null, "Game over!!!\nEndzeit: "
						+ zeit + " ms");
				button.disable();
				lebenSpieler--;
				label.setText("Leben: " + lebenSpieler + "   Zeit: " + zeit
						+ " ms");
			}
			ball.set_x(50);
			ball.set_y(50);

		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BallSpiel frame = new BallSpiel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BallSpiel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 345);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getButton());
		contentPane.add(getButton_1());
		contentPane.add(getLabel());
		initGame();
		label.setText("Leben: " + lebenSpieler + "   Zeit: " + zeit + " ms");
		contentPane.add(getLabel_1_1());

	}

	private Panel getPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setBackground(Color.ORANGE);
			panel.setBounds(10, 46, 414, 205);
		}
		return panel;
	}

	private Button getButton() {
		if (button == null) {
			button = new Button("Start");
			button.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {

					if (e.getKeyCode() == KeyEvent.VK_UP) {
						balkenSpieler.set_y(balkenSpieler.get_y() - 20);
						balkenSpieler.move();
						repaint();
					}

					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						balkenSpieler.set_y(balkenSpieler.get_y() + 20);
						balkenSpieler.move();
						repaint();
					}

				}
			});
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					startTimer();
					t.start();
					t2.start();

				}
			});
			button.setBounds(10, 18, 70, 22);
		}
		return button;
	}

	private Button getButton_1() {
		if (button_1 == null) {
			button_1 = new Button("End");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					System.exit(0);

				}
			});
			button_1.setBounds(354, 18, 70, 22);
		}
		return button_1;
	}

	private Label getLabel() {
		if (label == null) {
			label = new Label("");
			label.setBounds(156, 18, 141, 22);
		}
		return label;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnApplication());
		}
		return menuBar;
	}

	private JMenu getMnApplication() {
		if (mnApplication == null) {
			mnApplication = new JMenu("Application");
			mnApplication.add(getMntmNewGame());
		}
		return mnApplication;
	}

	private JMenuItem getMntmNewGame() {
		if (mntmNewGame == null) {
			mntmNewGame = new JMenuItem("New Game");
			mntmNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					button.enable();
					initGame();
					lebenSpieler = 4;
					zeit = 0;

				}
			});
		}
		return mntmNewGame;
	}
	private Label getLabel_1_1() {
		if (label_1 == null) {
			label_1 = new Label("\u00a9 by Dominik Forsthuber");
			label_1.setBounds(10, 257, 200, 19);
		}
		return label_1;
	}
}
