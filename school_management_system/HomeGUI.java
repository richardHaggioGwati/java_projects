import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeGUI extends Frame {

    public HomeGUI() {
        setLayout(new BorderLayout(20, 15));

        add(PanelNorth(), BorderLayout.NORTH);
        add(CustomPanel("Students", new Student("John", "Doe", "Male", 20, 1)), BorderLayout.EAST);
        add(CustomPanel("Teachers", new Teacher("John", "Doe", "Male", 20, "Physics")), BorderLayout.WEST);
        add(CustomExpenseIncomePanel(), BorderLayout.CENTER);

        setTitle("Home");
        setBackground(new Color(229, 229, 229));
        setSize(1650, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(50, 50, (int) dim.getWidth(), (int) dim.getHeight());
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private Panel PanelNorth() {
        Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        Button homeButton = new Button("Home");
        Button settingsButton = new Button("Settings");
        Button logoutButton = new Button("Logout");

        homeButton.setPreferredSize(new Dimension(60, 20));
        settingsButton.setPreferredSize(new Dimension(60, 20));
        logoutButton.setPreferredSize(new Dimension(60, 20));

        panel.add(homeButton);
        panel.add(settingsButton);
        panel.add(logoutButton);

        return panel;
    }

    private <T extends Person> Panel CustomPanel(String title, T person) {
        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());


        Panel labelPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label titleLabel = new Label(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        labelPanel.add(titleLabel);


        List list = new List();
        for (String info : person.getInfo()) {
            list.add(info);
        }

        panel.add(labelPanel, BorderLayout.NORTH);
        panel.add(list, BorderLayout.CENTER);

        return panel;
    }

    private Panel CustomExpenseIncomePanel() {
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(1, 2, 10, 10)); // 2 rows, 1 column with spacing

        Panel expensePanel = new Panel(new BorderLayout());
        Label expenseHeader = new Label("Expenses", Label.CENTER);
        expenseHeader.setFont(new Font("Arial", Font.BOLD, 16));
        List expenseList = new List();
        expenseList.add("Rent");
        expenseList.add("Utilities");
        expenseList.add("Groceries");
        expenseList.add("Transportation");
        expensePanel.add(expenseHeader, BorderLayout.NORTH);
        expensePanel.add(expenseList, BorderLayout.CENTER);

        Panel incomePanel = new Panel(new BorderLayout());
        Label incomeHeader = new Label("Income", Label.CENTER);
        incomeHeader.setFont(new Font("Arial", Font.BOLD, 16));
        List incomeList = new List();
        incomeList.add("Salary");
        incomeList.add("Freelancing");
        incomeList.add("Investments");
        incomeList.add("Rentals");
        incomePanel.add(incomeHeader, BorderLayout.NORTH);
        incomePanel.add(incomeList, BorderLayout.CENTER);

        panel.add(expensePanel);
        panel.add(incomePanel);

        return panel;
    }

    public static void main(String[] args) {
        new HomeGUI();
    }
}


