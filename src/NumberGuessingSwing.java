
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class NumberGuessingGame implements ActionListener {
    JFrame frame;
    JButton guess;
    JTextArea input;
    JLabel nop;
    JLabel message;
    int number,attempts=0;

    NumberGuessingGame(){
        Random gen = new Random();
        number = gen.nextInt(100);

        frame = new JFrame("Guessing Game");
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lb1 = new JLabel("Your guess (0-100):                   ");


        input = new JTextArea(1,15);
        guess = new JButton("Guess");
        guess.addActionListener(this);

        JLabel lb2 = new JLabel("Attempts: ");
        nop = new JLabel(" ");

        message = new JLabel("");

        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(lb1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;

        panel.add(input, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(guess, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(lb2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(nop, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(message,gbc);


        frame.add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int user =  Integer.parseInt(input.getText());
        String s = e.getActionCommand();
        attempts++;
        if(number!= user){
            nop.setText(Integer.toString(attempts));
            if(number>user){
                message.setText("Wrong!! Guess again. Your is guess is lower than Number");
            }
            else{
                message.setText("Wrong!! Guess again. Your is guess is higher than Number");
            }
        }
        else{
            nop.setText(Integer.toString(attempts));
            message.setText("You guessed it right, the number was "+number+"! You took "+attempts+" attempts");
            message.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }
}
class NumberGuessingSwing{
    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
