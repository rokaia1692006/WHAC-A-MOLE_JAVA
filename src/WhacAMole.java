
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
public class WhacAMole{
    public static int count = 0;
    public static boolean end = false;
    public static boolean start = false;
    public static int getRandom() {
    int rnd = new Random().nextInt(8);
    return rnd;
}
public void actionPreformed(ActionEvent e , JButton x){
    if (x == null) {
        return ;
        }
        if(e.getSource() == x){
            System.out.println("Button clicked");
        }
}
//track events happening in frame


//create method for resizing images to buttonsize

    int boardw = 650; //board width
    int boardh = 650;  //board hight
    //start a window called whac-a-mole
    JFrame frame = new JFrame("Whac-A-Mole");
//create panel for text
JLabel text = new JLabel();
//create panel for text
JPanel textPanel = new JPanel();
//create panel for game
JPanel gamePanel = new JPanel();
// create 25 buttons for the grid
JButton[] buttons = new JButton[9];
//create restart button
JButton restart = new JButton();
Timer timer;

//load images
Image moleimg = new ImageIcon(getClass().getResource("./mole.jpg")).getImage();
Image bombimg = new ImageIcon(getClass().getResource("./bomb.png")).getImage();
ImageIcon mole = new ImageIcon(moleimg.getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
ImageIcon bomb = new ImageIcon(bombimg.getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
     WhacAMole() {
  
        //set up the window
        frame.setVisible(true);
        //exit when x button is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set board size
        frame.setSize(boardw, boardh);
        //not a resizable window
        frame.setResizable(false);
        //center the window on the screen
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        

        //set properties for text label and panel
        text.setOpaque(true);
         // set text font , style and size
        text.setFont(new Font("Times New Roman", Font.BOLD, 50));
        text.setForeground(Color.red);
        text.setBackground((Color.BLACK));
        //center text
        text.setHorizontalAlignment(JLabel.CENTER);
        //set text at start as score 0
        text.setText("Score: 0");
        //properties of text panel
        textPanel.setLayout(new BorderLayout());
        //add in panel
        textPanel.add(text);
        //set panel position  the top of the frame
        frame.add(textPanel,BorderLayout.NORTH);
        //set properties for game panel
        gamePanel.setLayout(new GridLayout(3, 3));
        gamePanel.setForeground(Color.blue);
        gamePanel.setBackground(Color.black);
        //add in panel
        
        restart.setText("Start");
        restart.setFont(new Font("Arial",Font.BOLD,50));
        restart.setForeground(Color.GREEN);
        restart.setBackground(Color.BLACK);
        restart.setFocusable(false);
        restart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(restart.getText().equals("Start")){
                    restart.setText("Restart");
                }
                count = 0 ;
                end = false;
                text.setText("Score: 0");
                for(JButton button:buttons){
                    button.setIcon(null);
                    button.setEnabled(true);
                }
                timer.start();

            }
        });
        textPanel.add(restart,BorderLayout.SOUTH);
        frame.add(gamePanel);
        //create 25 buttons
        for(int i = 0 ; i < 9;i++){
            //create a button
            JButton tile = new JButton();
            //set color to tiles
            tile.setBackground(Color.pink);
            tile.setFocusable(false);
             //save button in array
            buttons[i] = tile;
            if(restart.getText().equals("start")){
                buttons[i].setEnabled(false);
            }
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //get clicked button
                    JButton cb = (JButton) e.getSource();
                    //check if mole button is clicked
                    if(cb.getIcon()==mole){
                        count++;
                        //update score
                        text.setText("Score: "+count);
                        //cb.setIcon(null);
                        for(JButton button:buttons){
                            //remove icons
                            button.setIcon(null);
                        }
                    }
                    if(cb.getIcon()==bomb){
                        text.setText("GAMEOVER: "+count);
                        cb.setIcon(null);
                        end = true;
                        for(JButton button:buttons){
                            //remove icons
                            button.setIcon(null);
                            //disable
                            button.setEnabled(false);
                            timer.stop();
                        }
                        restart.setText("Restart");
                       

                    }
                    
            }
            });
           
            gamePanel.add(tile);
            
           
        }

       
        timer = new Timer(1100,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                for(JButton button:buttons){
                    //remove icons
                    button.setIcon(null);
                }
                //set new moles and bomb
                int x = getRandom();
                int y = getRandom();
                
                
                buttons[x].setIcon(mole);
         
                buttons[y].setIcon(bomb);
            }
        });
        
    }
    
}