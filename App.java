import javax.swing.JFrame;

class App extends JFrame{
    App(Seting seting){
        setBounds(50,50,seting.getWidth(),seting.getHeight());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}