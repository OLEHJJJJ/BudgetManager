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
        frame = new JFrame("Менеджер Бюджету 💰");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 520);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        // Ініціалізація списку витрат
        budgetListModel = new DefaultListModel<>();
        budgetList = new JList<>(budgetListModel);
        budgetList.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(new JScrollPane(budgetList), BorderLayout.CENTER);

        // Панель для введення витрат
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Додати витрату"));

        amountInput = new JTextField();
        amountInput.setBorder(BorderFactory.createTitledBorder("Сума"));
        descriptionInput = new JTextField();
        descriptionInput.setBorder(BorderFactory.createTitledBorder("Опис"));
        categoryBox = new JComboBox<>(new String[]{"🍔 Їжа", "🚕 Транспорт", "🎉 Розваги", "📦 Інше"});

        inputPanel.add(amountInput);
        inputPanel.add(descriptionInput);
        inputPanel.add(categoryBox);
        frame.add(inputPanel, BorderLayout.NORTH);

        // Панель з кнопками
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Дії"));

        addButton = UIHelper.createStyledButton("➕ Додати");
        removeButton = UIHelper.createStyledButton("🗑 Видалити");
        clearButton = UIHelper.createStyledButton("🔄 Очистити");
        editButton = UIHelper.createStyledButton("📝 Редагувати");
        statsButton = UIHelper.createStyledButton("📈 Статистика");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(editButton);
        buttonPanel.add(statsButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Обробник подій
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
