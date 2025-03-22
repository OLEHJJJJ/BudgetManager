package ua.lpnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIHelper {
    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(50, 150, 250));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(160, 40));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

        // Додавання ефекту наведення
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(30, 130, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(50, 150, 250));
            }
        });

        return button;
    }
}
