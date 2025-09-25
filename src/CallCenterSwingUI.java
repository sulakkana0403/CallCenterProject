// CallCenterUIDesign.java
import javax.swing.*;
import java.awt.*;

class CallCenterUIDesign extends JFrame {
    private CallCenterSystem callCenter = new CallCenterSystem();
    private JTextArea queueArea;
    private JTextField nameField, issueField;
    private JLabel statusLabel;

    public CallCenterUIDesign() {
        setTitle("📞 Call Center System");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Split pane: left input, right queue
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(250);

        // Left Panel: Input
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Caller"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(15);
        inputPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Issue:"), gbc);
        gbc.gridx = 1;
        issueField = new JTextField(15);
        inputPanel.add(issueField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add Caller");
        addButton.setBackground(new Color(59, 89, 182));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        inputPanel.add(addButton, gbc);

        splitPane.setLeftComponent(inputPanel);

        // Right Panel: Queue Display
        JPanel queuePanel = new JPanel(new BorderLayout());
        queuePanel.setBorder(BorderFactory.createTitledBorder("Call Queue"));
        queueArea = new JTextArea();
        queueArea.setEditable(false);
        queueArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(queueArea);
        queuePanel.add(scrollPane, BorderLayout.CENTER);
        splitPane.setRightComponent(queuePanel);

        add(splitPane, BorderLayout.CENTER);

        // Bottom Panel: Serve Button & Status
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton serveButton = new JButton("Serve Caller");
        serveButton.setBackground(new Color(220, 53, 69));
        serveButton.setForeground(Color.WHITE);
        serveButton.setFocusPainted(false);
        bottomPanel.add(serveButton, BorderLayout.WEST);

        statusLabel = new JLabel("Total Callers Waiting: 0");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        bottomPanel.add(statusLabel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(e -> addCaller());
        serveButton.addActionListener(e -> serveCaller());

        refreshQueue();
        setVisible(true);
    }

    private void addCaller() {
        String name = nameField.getText().trim();
        String issue = issueField.getText().trim();
        if (name.isEmpty() || issue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Name and Issue.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        callCenter.addCaller(name, issue);
        nameField.setText("");
        issueField.setText("");
        refreshQueue();
    }

    private void serveCaller() {
        Caller served = callCenter.serveCaller();
        if (served != null) {
            JOptionPane.showMessageDialog(this, "Serving: " + served, "Call Served", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No callers in queue.", "Queue Empty", JOptionPane.INFORMATION_MESSAGE);
        }
        refreshQueue();
    }

    private void refreshQueue() {
        StringBuilder sb = new StringBuilder();
        for (Caller c : callCenter.getQueue()) {
            sb.append(c.toString()).append("\n");
        }
        queueArea.setText(sb.toString());
        statusLabel.setText("Total Callers Waiting: " + callCenter.getQueueSize());
    }
}
