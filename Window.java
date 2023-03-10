import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Window extends JFrame implements ActionListener {
    public static boolean res = false, vis = true;
    JTextField textField, jTextField;
    JButton button;
    public String textFieldText, ContextText;
    Window(){
        this.setTitle("Application");
        this.setBounds(200,200,400,300);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(res);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        this.getContentPane().setBackground(new Color(0, 0, 0));

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(230, 60));
        textField.setFont(new Font("Verdana", Font.BOLD, 20));
        textField.setToolTipText("Filename");

        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(230, 60));
        jTextField.setFont(new Font("Verdana", Font.BOLD, 20));
        jTextField.setToolTipText("File Text");

        button = new JButton("CREATE NEW FILE");
        button.addActionListener(this);
        button.setBackground(Color.ORANGE);
        button.setOpaque(true);
        button.setFont(new Font("Verdana", Font.ITALIC, 15));
        this.add(textField);
        this.add(jTextField);
        this.add(button);
        this.setVisible(vis);
    }

    public static void File_Creater(String FileName, String File_Text) throws IOException {
        File file = new File(FileName);
        if (!file.exists())
            file.createNewFile();

        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(File_Text);
        printWriter.close();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            textFieldText = textField.getText();
            ContextText = jTextField.getText();
            try {
                File_Creater(textFieldText, ContextText);
                textField.setText("");
                jTextField.setText("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
