package employeeProgramme.ui;

import employeeProgramme.main.TaskProcessing;
import employeeProgramme.models.Employee;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import static employeeProgramme.models.GeneratedEmployees.employees;

public class SwingUI implements ActionListener{

    private static JFrame mainFrame;
    private JPanel listPanel, fieldPanel;
    private JList employeeJList;
    private JTextField txtId, txtFirstName, txtLastName, txtDob, txtEmployeeId, txtHireDate, txtPosition;
    private List<Employee> current;

    private final int NOT_SELECTED = -1;
    private int selectedIndex = NOT_SELECTED;

    public SwingUI(){
        mainFrame = new JFrame("Awesome Employee BOOM Programme");
        mainFrame.setSize(800,400);
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        WindowListener l = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(mainFrame, "Are you sure that you want to exit? Really?", "Exit Confirmation", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(confirm == 0){
                    mainFrame.dispose();
                    System.exit(0);
                }
            }
        };

        mainFrame.addWindowListener(l);
        //place JFrame window in the middle of the screen
        Dimension di = mainFrame.getToolkit().getScreenSize();
        mainFrame.setLocation(di.width/2 - mainFrame.getWidth()/2, di.height/2 - mainFrame.getHeight()/2);

        //prepare menu bar
        mainFrame.setJMenuBar(createMenu());

        //prepare main panel
        JPanel content = (JPanel) mainFrame.getContentPane();
        content.setLayout(new GridLayout(1,2,5,5));

        prepareJList();

        //prepare list panel
        listPanel = new JPanel();
        listPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        JScrollPane scrollPane = new JScrollPane(createEmployeeList());
        scrollPane.setPreferredSize(new Dimension(380, 320));
        listPanel.add(scrollPane);
        content.add(listPanel);


        //prepare field panel
        fieldPanel = new JPanel();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Employee's Details");
        fieldPanel.setBorder(title);

        //prepare sub-panel for label and text field
        fieldPanel.add(createFieldPanel(), BorderLayout.CENTER);
        fieldPanel.add(createButtonPanel(), BorderLayout.SOUTH);
        content.add(fieldPanel);

        mainFrame.setVisible(true);
    }

    private JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.GRAY);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.addActionListener(this);

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.addActionListener(this);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        exitMenuItem.addActionListener(this);

        fileMenu.add(newMenuItem);
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        JMenu optionMenu = new JMenu("Options");
        optionMenu.setMnemonic(KeyEvent.VK_O);
        optionMenu.addActionListener(this);

        JMenuItem searchMenuItem = new JMenuItem("Search");
        searchMenuItem.setMnemonic(KeyEvent.VK_S);
        searchMenuItem.addActionListener(this);

        JMenuItem listMenuItem = new JMenuItem("List All");
        listMenuItem.setMnemonic(KeyEvent.VK_L);
        listMenuItem.addActionListener(this);

        JMenuItem sortMenuItem = new JMenuItem("Sort By First Name");
        sortMenuItem.setMnemonic(KeyEvent.VK_B);
        sortMenuItem.addActionListener(this);

        optionMenu.add(searchMenuItem);
        optionMenu.add(listMenuItem);
        optionMenu.add(sortMenuItem);

        menuBar.add(optionMenu);

        return menuBar;
    }

    private void prepareJList(){
        employeeJList = new JList<>();
        employeeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeJList.addListSelectionListener(e -> {
            if(!employeeJList.getValueIsAdjusting()){
                if(!employeeJList.isSelectionEmpty()){
                    selectedIndex= employeeJList.getSelectedIndex();
                    if(selectedIndex>NOT_SELECTED){
                        //display on text field
                        setEmployeeField(selectedIndex);
                    }
                }
            }
        });
    }

    //list employees on JList
    private JList<Employee> createEmployeeList(){
        DefaultListModel<Employee> listModel = new DefaultListModel<>();
        if(employees.size() > 0) {
            for (Employee e : employees)
                listModel.addElement(e);
        }
        employeeJList.setModel(listModel);

        return employeeJList;

    }

    private JPanel createFieldPanel(){
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,2,5,5));

        JLabel labelId = new JLabel("ID");
        inputPanel.add(labelId);
        txtId = new JTextField();
        txtId.setEditable(false);
        inputPanel.add(txtId);

        JLabel labelfn = new JLabel("First Name");
        inputPanel.add(labelfn);
        txtFirstName = new JTextField();
        inputPanel.add(txtFirstName);

        JLabel labelln = new JLabel("Last Name");
        inputPanel.add(labelln);
        txtLastName = new JTextField();
        inputPanel.add(txtLastName);

        JLabel labeldob = new JLabel("Date of Birth");
        inputPanel.add(labeldob);
        txtDob = new JTextField();
        inputPanel.add(txtDob);

        JLabel labelemid = new JLabel("Employee ID");
        inputPanel.add(labelemid);
        txtEmployeeId = new JTextField();
        inputPanel.add(txtEmployeeId);

        JLabel labelhd = new JLabel("Hire Date");
        inputPanel.add(labelhd);
        txtHireDate = new JTextField();
        inputPanel.add(txtHireDate);

        JLabel labelpos = new JLabel("Position");
        inputPanel.add(labelpos);
        txtPosition = new JTextField();
        inputPanel.add(txtPosition);

        return inputPanel;
    }

    private void setEmployeeField(int index){
        Employee selected = employees.get(index);
        txtId.setText(Integer.toString(selected.getId()));
        txtFirstName.setText(selected.getFirstName());
        txtLastName.setText(selected.getLastName());
        txtDob.setText(selected.getDob().toString());
        txtEmployeeId.setText(selected.getEmployeeId());
        txtHireDate.setText(selected.getHireDate().toString());
        txtPosition.setText(selected.getPosition());
    }

    private void clearField(){
        txtId.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtDob.setText("");
        txtHireDate.setText("");
        txtEmployeeId.setText("");
        txtPosition.setText("");
    }

    private java.util.List<String> getEmployeeInfo(){
        java.util.List<String> data = new ArrayList<>();
        data.add(txtFirstName.getText());
        data.add(txtLastName.getText());
        data.add(txtDob.getText());
        data.add(txtEmployeeId.getText());
        data.add(txtHireDate.getText());
        data.add(txtPosition.getText());

        //check to ensure its not empty!
        for(int i=0; i< data.size(); i++){
            if(data.get(i).isEmpty()){
                JOptionPane.showMessageDialog(mainFrame, "Some fields are empty!");
            }
        }
        return data;
    }

    private JPanel createButtonPanel(){
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedIndex == NOT_SELECTED){
                    JOptionPane.showMessageDialog(mainFrame, TaskProcessing.createNew(getEmployeeInfo()));
                } else{
                    JOptionPane.showMessageDialog(mainFrame, TaskProcessing.editEmployee(selectedIndex, getEmployeeInfo()));
                    selectedIndex = NOT_SELECTED;
                }
                try{
                    TaskProcessing.refreshAllEmployees();
                } catch (SQLException saveEx){
                    JOptionPane.showMessageDialog(mainFrame, "FAILED TO ADD to DB: " + saveEx);
                }
                clearField();
                createEmployeeList();
            }
        });
        btnPanel.add(btnSave);

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskProcessing.removeEmployee(selectedIndex);
                createEmployeeList();
                clearField();
            }
        });
        btnPanel.add(btnRemove);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearField();
                employeeJList.clearSelection();
                current = employees;
                createEmployeeList();
            }
        });
        btnPanel.add(btnClear);

        return btnPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if("New".equals(action)){
            clearField();
            employeeJList.clearSelection();
            selectedIndex = NOT_SELECTED;
        } else if("Exit".equals(action)){
            mainFrame.dispose();
            System.exit(0);
        } else if("Search".equals(action)){
            String input = JOptionPane.showInputDialog("Enter text to search: ");
            current = TaskProcessing.search(input);
            createEmployeeList();
        } else if("Load All".equals(action)){
            createEmployeeList();
        } else if("Sort By First Name".equals(action)){
            TaskProcessing.sortByFirstName();
            createEmployeeList();
        }
    }
}