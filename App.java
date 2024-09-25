import javax.swing.JFrame;

class App extends JFrame{
    App(Seting seting){
        setBounds(50,50,seting.getWidth()+50,seting.getHeight()+50);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}