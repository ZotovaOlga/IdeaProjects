package zozo.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

class Izfile2 implements ActionListener {
    FileReaderClass myIzfile1 = new FileReaderClass();
    JTextArea textArea;

    public Izfile2(String text, int x, int y) {
        JFrame frm = new JFrame("Текст из файла");
        frm.setBounds(x, y, 750, 500);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(null);
        textArea = new JTextArea();
        textArea.setBounds(150, 150, 330, 250);
        textArea.setEditable(false);
        textArea.append(myIzfile1.read());
        frm.add(textArea);
        frm.setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {

    }
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


}

public class Izfile {

    public static void main(String[] args) {
        new Izfile2("Текст", 300, 400);

    }
}