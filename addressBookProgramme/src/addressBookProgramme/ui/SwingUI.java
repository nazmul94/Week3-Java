package addressBookProgramme.ui;

import addressBookProgramme.main.TaskProcessing;
import addressBookProgramme.models.Contact;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import static addressBookProgramme.models.GeneratedContacts.contactList;

public class SwingUI implements ActionListener{

    private static JFrame mainFrame;
    private JPanel listPanel, fieldPanel;
    private JList contactJList;
    private JTextField txtId, txtFirstName, txtLastName, txtPhoneNumber, txtStreet, txtCity, txtPostCode, txtCountry;
    private List<Contact> current;

    private final int NOT_SELECTED = -1;
    private int selectedIndex = NOT_SELECTED;

    public SwingUI(){
        mainFrame = new JFrame("Awesome Contact Address Book Programme");
        mainFrame.setSize(1600,800);
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

        //prepare our list
        current = contactList;
        prepareJList();

        //prepare list panel
        listPanel = new JPanel();
        listPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        JScrollPane scrollPane = new JScrollPane(createContactList(contactList));
        scrollPane.setPreferredSize(new Dimension(380, 320));
        listPanel.add(scrollPane);
        content.add(listPanel);


        //prepare field panel
        fieldPanel = new JPanel();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Contact's Details");
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
        contactJList = new JList<>();
        contactJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactJList.addListSelectionListener(e -> {
            if(!contactJList.getValueIsAdjusting()){
                if(!contactJList.isSelectionEmpty()){
                    selectedIndex= contactJList.getSelectedIndex();
                    if(selectedIndex>NOT_SELECTED){
                        //display on text field
                        setContactField(selectedIndex, current);
                    }
                }
            }
        });
    }

    //list contactList on JList
    private JList<Contact> createContactList(List<Contact> resultList){
        DefaultListModel<Contact> listModel = new DefaultListModel<>();
        if(contactList.size() > 0) {
            for (Contact c : resultList)
                listModel.addElement(c);
        }
        contactJList.setModel(listModel);

        return contactJList;

    }

    private JPanel createFieldPanel(){
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,2,5,5));

        JLabel labelId = new JLabel("ID");
        inputPanel.add(labelId);
        txtId = new JTextField();
        inputPanel.add(txtId);

        JLabel labelfn = new JLabel("First Name");
        inputPanel.add(labelfn);
        txtFirstName = new JTextField();
        inputPanel.add(txtFirstName);

        JLabel labelln = new JLabel("Last Name");
        inputPanel.add(labelln);
        txtLastName = new JTextField();
        inputPanel.add(txtLastName);

        JLabel labelpn = new JLabel("Phone Number");
        inputPanel.add(labelpn);
        txtPhoneNumber = new JTextField();
        inputPanel.add(txtPhoneNumber);

        JLabel labeldob = new JLabel("Street");
        inputPanel.add(labeldob);
        txtStreet = new JTextField();
        inputPanel.add(txtStreet);

        JLabel labelemid = new JLabel("City");
        inputPanel.add(labelemid);
        txtCity = new JTextField();
        inputPanel.add(txtCity);

        JLabel labelhd = new JLabel("Post Code");
        inputPanel.add(labelhd);
        txtPostCode = new JTextField();
        inputPanel.add(txtPostCode);

        JLabel labelpos = new JLabel("Country");
        inputPanel.add(labelpos);
        txtCountry = new JTextField();
        inputPanel.add(txtCountry);

        return inputPanel;
    }

    private void setContactField(int index, List<Contact> current){
        Contact selected = current.get(index);
        txtId.setText(Integer.toString(selected.getId()));
        txtFirstName.setText(selected.getPerson().getFirstName());
        txtLastName.setText(selected.getPerson().getLastName());
        txtPhoneNumber.setText(Long.toString(selected.getPhoneNumber()));
        txtStreet.setText(selected.getAddress().getStreet());
        txtCity.setText(selected.getAddress().getCity());
        txtPostCode.setText(selected.getAddress().getPostCode());
        txtCountry.setText(selected.getAddress().getCountry());
    }

    private void clearField(){
        txtId.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhoneNumber.setText("");
        txtStreet.setText("");
        txtPostCode.setText("");
        txtCity.setText("");
        txtCountry.setText("");
    }

    private java.util.List<String> getContactInfo(){
        java.util.List<String> data = new ArrayList<>();
        data.add(txtId.getText());
        data.add(txtFirstName.getText());
        data.add(txtLastName.getText());
        data.add(txtPhoneNumber.getText());
        data.add(txtStreet.getText());
        data.add(txtCity.getText());
        data.add(txtPostCode.getText());
        data.add(txtCountry.getText());

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
                    JOptionPane.showMessageDialog(mainFrame, TaskProcessing.createNew(getContactInfo()));
                } else{
                    JOptionPane.showMessageDialog(mainFrame, TaskProcessing.editContact(selectedIndex, getContactInfo()));
                    selectedIndex = NOT_SELECTED;
                }
                clearField();
                current = contactList;
                createContactList(contactList);
            }
        });
        btnPanel.add(btnSave);

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskProcessing.removeContact(selectedIndex);
                current = contactList;
                createContactList(current);
                clearField();
            }
        });
        btnPanel.add(btnRemove);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearField();
                contactJList.clearSelection();
                current = contactList;
                createContactList(current);
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
            contactJList.clearSelection();
            selectedIndex = NOT_SELECTED;
        } else if("Exit".equals(action)){
            mainFrame.dispose();
            System.exit(0);
        } else if("Search".equals(action)){
            String input = JOptionPane.showInputDialog("Enter text to search: ");
            current = TaskProcessing.search(input);
            createContactList(current);
        } else if("Load All".equals(action)){
            current = contactList;
            createContactList(contactList);
        } else if("Sort By First Name".equals(action)){
            TaskProcessing.sortByFirstName();
            current = contactList;
            createContactList(contactList);
        }
    }
}