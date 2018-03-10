package jd.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class Ventana extends JFrame {

    private JLabel entrada = new JLabel("Entrada: ");
    private JButton aceptar;
    private JWindow display;
    private JTextField sampleText = new JTextField("");
    private JTextPane placeholder = new JTextPane();

    public Ventana() throws ParseException {
        super("Text Input");
        Image icon = new ImageIcon(getClass().getResource("icon.png")).getImage();
        setIconImage(icon);
        aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.BLACK);
        aceptar.setForeground(Color.white);
        entrada.setForeground(Color.white);
        getContentPane().setBackground(new Color(40,40,40));
        setLayout(null);
        sampleText.setBounds(90, 20, 180, 30);
        entrada.setBounds(20, 20, 60, 30);
        aceptar.setBounds(110, 70, 80, 30);
        add(entrada);
        add(aceptar);
        add(sampleText);
        display = new JWindow(this);
        display.setSize(400, 400);
        display.getContentPane().setBackground(Color.black);
        display.setLayout(null);
        display.setVisible(false);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                enviarTexto();
                display.setVisible(true);
            }
        });
        placeholder.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                display.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                display.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                display.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        placeholder.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                display.setVisible(false);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }


    private void enviarTexto() {

        String text1 = (String) sampleText.getText();
        placeholder.setText(text1);
        placeholder.setFont(new Font("Arial", Font.BOLD, 90));
        placeholder.setForeground(Color.WHITE);
        placeholder.setBackground(Color.BLACK);
        placeholder.setEditable(false);
        placeholder.setBounds(20, 20, 360, 360);
        display.add(placeholder);
    }

}

