package ua.lpnu;

import javax.swing.*;
import java.util.*;

public class BudgetHandler {
    private DefaultListModel<String> budgetListModel;
    private JList<String> budgetList;
    private JTextField amountInput, descriptionInput;
    private JComboBox<String> categoryBox;
    private Map<String, String> budgetDetails;

    public BudgetHandler(DefaultListModel<String> budgetListModel, JList<String> budgetList,
                         JTextField amountInput, JTextField descriptionInput, JComboBox<String> categoryBox) {
        this.budgetListModel = budgetListModel;
        this.budgetList = budgetList;
        this.amountInput = amountInput;
        this.descriptionInput = descriptionInput;
        this.categoryBox = categoryBox;
        this.budgetDetails = new HashMap<>();
    }

    public void addExpense() {
        String amount = amountInput.getText().trim();
        String description = descriptionInput.getText().trim();
        String category = (String) categoryBox.getSelectedItem();

        if (!amount.isEmpty() && !description.isEmpty()) {
            String expenseEntry = category + " - " + amount + " грн - " + description;
            budgetListModel.addElement(expenseEntry);
            budgetDetails.put(expenseEntry, "Деталі: " + description);
            amountInput.setText("");
            descriptionInput.setText("");
        }
    }

    public void removeExpense() {
        int selectedIndex = budgetList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedExpense = budgetListModel.getElementAt(selectedIndex);
            budgetListModel.remove(selectedIndex);
            budgetDetails.remove(selectedExpense);
        }
    }

    public void clearExpenses() {
        budgetListModel.clear();
        budgetDetails.clear();
    }

    public void editExpense() {
        int selectedIndex = budgetList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedExpense = budgetListModel.getElementAt(selectedIndex);
            String[] parts = selectedExpense.split(" - ", 3);
            if (parts.length == 3) {
                String newDescription = JOptionPane.showInputDialog("Редагувати опис:", parts[2]);
                if (newDescription != null && !newDescription.trim().isEmpty()) {
                    String updatedExpense = parts[0] + " - " + parts[1] + " - " + newDescription.trim();
                    budgetListModel.set(selectedIndex, updatedExpense);
                }
            }
        }
    }

    public void showStatistics() {
        JOptionPane.showMessageDialog(null, "Кількість витрат: " + budgetListModel.size(),
                "Статистика", JOptionPane.INFORMATION_MESSAGE);
    }
}
