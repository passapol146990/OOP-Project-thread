
import javax.swing.JFrame;

public class Frame_nigth extends JFrame {
    private Setting_nigth setting = new Setting_nigth();
    Frame_nigth(){
        int with_space = setting.getWith_space();
        int hight_space = setting.getHight_space();
        setSize(with_space,hight_space);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Container_nigth panel = new Container_nigth(setting);
        add(panel);
    }
}