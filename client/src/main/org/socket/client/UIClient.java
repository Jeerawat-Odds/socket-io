package org.socket.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UIClient extends JFrame {

    private JTextArea m_txtMessage;
    private JTextField m_txtInput;
    private JButton m_btnSend;

    public UIClient() {
        super("UI Client");

        onInit();

        super.setVisible(true);
    }

    private void onInit() {
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        super.setResizable(false);
        super.setSize(500, 500);
        super.setLocationRelativeTo(null);

        buildUI();
        registerEventListener();
    }

    private void buildUI() {
        Container paneMain = getContentPane();
        paneMain.setLayout(new BorderLayout());

        paneMain.add(getMainPane(), BorderLayout.CENTER);
        paneMain.add(getSendMessagePane(), BorderLayout.SOUTH);
    }

    private JPanel getMainPane() {
        JPanel pane = new JPanel(new BorderLayout());

        m_txtMessage = new JTextArea("", 200, 200);
        m_txtMessage.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(textArea);
        pane.add(m_txtMessage, BorderLayout.CENTER);

        return pane;
    }

    private JPanel getSendMessagePane() {
        JPanel pane = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        m_txtInput = new JTextField("", 30);
        pane.add(m_txtInput, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        m_btnSend = new JButton("Send");
        pane.add(m_btnSend, gbc);

        return pane;
    }

    private void registerEventListener() {
        m_btnSend.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strMessage = m_txtInput.getText();
                m_txtMessage.append(String.format("%s\n", strMessage));

                m_txtInput.setText("");
            }
        });
    }
}
