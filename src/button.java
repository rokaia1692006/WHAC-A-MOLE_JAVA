
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class button {
    public static void main(String[] args) throws Exception {
      JFrame frame = new JFrame();
      JButton button = new JButton();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 500);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setLayout(null);
      button.setBackground(Color.yellow);
      button.setText("this is a buttonn :)");
      button.setBounds(175,200,150,50);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });
    
    }
    
}
