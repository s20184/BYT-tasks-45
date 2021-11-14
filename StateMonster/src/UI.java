import javax.swing.*;
import java.awt.*;

public class UI {
    private Monster monster;
    private static final JTextField textField = new JTextField("Welcome to monster behavior analysis!");

    public UI(Monster monster){
        this.monster = monster;
    }

    public void init(){
        JFrame frame = new JFrame("Monster behavior test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton playerAdd = new JButton("See player");
        JButton playerLose = new JButton("Lose player");
        JButton monsterKill = new JButton("Kill monster");
        JButton monsterRevive = new JButton("Revive monster");

        playerAdd.addActionListener(e -> textField.setText(monster.getState().playerEnteredSight()));
        playerLose.addActionListener(e -> textField.setText(monster.getState().playerLeftSight()));
        monsterKill.addActionListener(e -> textField.setText(monster.getState().monsterKilled()));
        monsterRevive.addActionListener(e -> textField.setText(monster.getState().monsterRevived()));

        buttons.add(playerAdd);
        buttons.add(playerLose);
        buttons.add(monsterKill);
        buttons.add(monsterRevive);

        context.add(textField);
        context.add(buttons);

        frame.setSize(470,200);
        frame.setVisible(true);
    }
}
