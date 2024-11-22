import abstractfactory.MedievalWorldFactory;
import abstractfactory.SciFiWorldFactory;
import abstractfactory.WorldFactory;
import character.Character;
import weapon.Weapon;

import javax.swing.*;
import java.awt.*;

public class GameClient extends JFrame {
    private JTextArea outputArea;
    private JLabel imageLabel;

    public GameClient() {
        // GUI Setup
        setTitle("RPG Spiel mit Bildern");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Image Label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(imageLabel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton medievalButton = new JButton("Mittelalterliche Welt");
        JButton sciFiButton = new JButton("Science-Fiction-Welt");

        // Button Actions
        medievalButton.addActionListener(e -> setupWorld(new MedievalWorldFactory(), "knight.jpg"));
        sciFiButton.addActionListener(e -> setupWorld(new SciFiWorldFactory(), "spaceman.jpg"));

        buttonPanel.add(medievalButton);
        buttonPanel.add(sciFiButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupWorld(WorldFactory factory, String imagePath) {
        Character character = factory.createCharacter();
        Weapon weapon = factory.createWeapon();

        // Update output area
        outputArea.setText("");
        outputArea.append(character.describe() + "\n");
        outputArea.append(weapon.use() + "\n");

        // Load image using ClassLoader
        try {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            Image image = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            outputArea.append("\nBild konnte nicht geladen werden: " + imagePath);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameClient gui = new GameClient();
            gui.setVisible(true);
        });
    }
}
