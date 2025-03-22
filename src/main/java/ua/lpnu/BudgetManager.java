package ua.lpnu;

import javax.swing.*;
import java.awt.*;

public class BudgetManager {
    private JFrame frame;
    private DefaultListModel<String> budgetListModel;
    private JList<String> budgetList;
    private JTextField amountInput, descriptionInput;
    private JComboBox<String> categoryBox;
    private JButton addButton, removeButton, clearButton, editButton, statsButton;

    public BudgetManager() {
        frame = new JFrame("Менеджер Бюджету");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        budgetListModel = new DefaultListModel<>();
        budgetList = new JList<>(budgetListModel);
        frame.add(new JScrollPane(budgetList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        amountInput = new JTextField();
        amountInput.setBorder(BorderFactory.createTitledBorder("Сума"));
        descriptionInput = new JTextField();
        descriptionInput.setBorder(BorderFactory.createTitledBorder("Опис витрати"));
        categoryBox = new JComboBox<>(new String[]{"Їжа", "Транспорт", "Розваги", "Інше"});

        inputPanel.add(amountInput);
        inputPanel.add(descriptionInput);
        inputPanel.add(categoryBox);
        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addButton = new JButton("➕ Додати");
        removeButton = new JButton("❌ Видалити");
        clearButton = new JButton("🔄 Очистити");
        editButton = new JButton("✏️ Редагувати");
        statsButton = new JButton("📊 Статистика");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(editButton);
        buttonPanel.add(statsButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        BudgetHandler handler = new BudgetHandler(budgetListModel, budgetList, amountInput, descriptionInput, categoryBox);

        addButton.addActionListener(e -> handler.addExpense());
        removeButton.addActionListener(e -> handler.removeExpense());
        clearButton.addActionListener(e -> handler.clearExpenses());
        editButton.addActionListener(e -> handler.editExpense());
        statsButton.addActionListener(e -> handler.showStatistics());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BudgetManager::new);
    }
}
