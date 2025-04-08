package ua.lpnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIHelper {
    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(60, 63, 65)); // Темний фон
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(140, 40));
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));

        // Додавання ефекту наведення
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(80, 83, 85)); // Трохи світліший при наведенні
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(60, 63, 65));
            }
        });

        return button;
    }
}
