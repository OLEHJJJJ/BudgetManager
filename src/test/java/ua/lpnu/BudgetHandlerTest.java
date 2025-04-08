package ua.lpnu;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class BudgetHandlerTest {
    private BudgetHandler budgetHandler;
    private DefaultListModel<String> budgetListModel;
    private JList<String> budgetList;
    private JTextField amountInput;
    private JTextField descriptionInput;
    private JComboBox<String> categoryBox;

    @Before
    public void setUp() {
        budgetListModel = new DefaultListModel<>();
        budgetList = new JList<>(budgetListModel);
        amountInput = new JTextField();
        descriptionInput = new JTextField();
        categoryBox = new JComboBox<>(new String[]{"🍔 Їжа", "🚕 Транспорт", "🎉 Розваги", "📦 Інше"});
        budgetHandler = new BudgetHandler(budgetListModel, budgetList, amountInput, descriptionInput, categoryBox);
    }

    @Test
    public void testAddExpense() {
        amountInput.setText("250");
        descriptionInput.setText("Обід у їдальні");
        categoryBox.setSelectedItem("🍔 Їжа");

        budgetHandler.addExpense();

        assertEquals(1, budgetListModel.size());
        assertEquals("🍔 Їжа - 250 грн - Обід у їдальні", budgetListModel.getElementAt(0));
    }

    @Test
    public void testRemoveExpense() {
        budgetListModel.addElement("🍔 Їжа - 250 грн - Обід у кафе");
        budgetList.setSelectedIndex(0);

        budgetHandler.removeExpense();

        assertEquals(0, budgetListModel.size());
    }

    @Test
    public void testClearExpenses() {
        budgetListModel.addElement("🍔 Їжа - 250 грн - Обід у кафе");
        budgetListModel.addElement("🚕 Транспорт - 100 грн - Таксі");

        budgetHandler.clearExpenses();

        assertEquals(0, budgetListModel.size());
    }
}
