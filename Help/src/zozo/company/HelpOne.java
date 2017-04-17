package zozo.company;

import sun.java2d.pipe.BufferedContext;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;



public class HelpOne {

    JTextArea incoming;
    JTextArea incoming1;
    JTextField outgoing;

    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args) {
	    HelpOne gui = new HelpOne();
        gui.go();// write your code here
    }

    public void go(){
        JFrame frame = new JFrame("Справка первая линия");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.setBackground(Color.lightGray);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("Настройка IE");
        button1.setSize(30,300);
        JButton button2 = new JButton("Настройка eToken");
        button2.setSize(30,400);
        JButton button3 = new JButton("Генерация ключа");
        button3.setSize(30,400);
        JButton button4 = new JButton("Установка библиотек");
        button4.setSize(30,400);
        JButton button5 = new JButton("Шаблоны документов");
        button5.setSize(30,400);
        JButton button6 = new JButton("Генерация холдинг");
        button6.setSize(30,400);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);

        JScrollPane qScroller = new JScrollPane(incoming);

        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetworking();

        incoming1 = new JTextArea(30, 40);
        incoming1.setLineWrap(true);
        incoming1.setWrapStyleWord(true);
        incoming1.setEditable(false);
        JScrollPane qScroller2 = new JScrollPane(incoming1);
        qScroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel1.add(qScroller2);
        button1.addActionListener(new Izfile2());
        button2.addActionListener(new Izfile3());

        frame.getContentPane().add(BorderLayout.EAST, mainPanel);
        frame.getContentPane().add(BorderLayout.WEST, panel);
        frame.getContentPane().add(BorderLayout.CENTER, panel1);
        frame.setSize(1300, 1000);

        frame.setVisible(true);

    }

    class FileReaderClass {

        public String read() {
            StringBuilder sb = new StringBuilder();
            try {
                String s;
                FileReader fr = new FileReader("C:\\Users\\Измерение\\IdeaProjects\\Help\\resource\\1.doc");
                BufferedReader br = new BufferedReader(fr);
                LineNumberReader lr = new LineNumberReader(br);
                while ((s = lr.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return sb.toString();
        }

        public String read2() {
            StringBuilder sb = new StringBuilder();
            try {
                String s;
                FileReader fr = new FileReader("C:\\Users\\Измерение\\IdeaProjects\\Help\\resource\\2.doc");
                BufferedReader br = new BufferedReader(fr);
                LineNumberReader lr = new LineNumberReader(br);
                while ((s = lr.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return sb.toString();
        }


    }
    class Izfile2 implements ActionListener {
        FileReaderClass myIzfile1 = new FileReaderClass();

        public Izfile2() {

            incoming1.append(myIzfile1.read());

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class Izfile3 implements ActionListener {
        FileReaderClass myIzfile1 = new FileReaderClass();

        public Izfile3() {

            incoming1.append(myIzfile1.read2());

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    private void setUpNetworking(){
        try{
            sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public class IncomingReader implements Runnable {
        public void run() {

            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
    public class SendButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            try{
                writer.println(outgoing.getText());
                writer.flush();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }



        }}

