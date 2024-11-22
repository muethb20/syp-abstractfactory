import abstractfactory.MedievalWorldFactory;
import abstractfactory.SciFiWorldFactory;
import abstractfactory.WorldFactory;
import character.Character;
import weapon.Weapon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameClient extends JFrame {
    private JTextArea outputArea;
    private JLabel imageLabel;

    public GameClient() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus theme not available, falling back to default.");
        }

        setTitle("🎮 RPG Spiel mit Bildern");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 30, 30));

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        outputArea.setBackground(new Color(50, 50, 50));
        outputArea.setForeground(Color.WHITE);
        outputArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        imageLabel.setPreferredSize(new Dimension(400, 400));
        add(imageLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(30, 30, 30));

        JButton medievalButton = createStyledButton("🏰 Mittelalterliche Welt");
        JButton sciFiButton = createStyledButton("🚀 Science-Fiction-Welt");
        //TODO: Add Test World

        medievalButton.addActionListener(e -> setupWorld(new MedievalWorldFactory()));
        sciFiButton.addActionListener(e -> setupWorld(new SciFiWorldFactory()));
        // TODO: Add Action Listener


        buttonPanel.add(medievalButton);
        buttonPanel.add(sciFiButton);
        // TODO: Add Button to Panel

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 100, 100));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 70, 70));
            }
        });
        return button;
    }

    private void setupWorld(WorldFactory factory) {
        Character character = factory.createCharacter();
        Weapon weapon = factory.createWeapon();

        outputArea.setText("");
        outputArea.append(character.describe() + "\n");
        outputArea.append(weapon.use() + "\n");

        try {
            ImageIcon imageIcon = new ImageIcon(character.getImagePath());
            Image image = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            outputArea.append("\nBild konnte nicht geladen werden: " + character.getImagePath());
        }
    }

    public static void main(String[] args) {
        GameClient gui = new GameClient();
        gui.setVisible(true);
    }
}
