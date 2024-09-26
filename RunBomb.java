import javax.swing.JLabel;
import javax.swing.JPanel;

public class RunBomb extends Thread {
    private JPanel jPanel;
    private int get_x;
    private int get_y;
    private JLabel jLabel;
    // RunBomb(JPanel jPanel,int x,int y){
    //     this.jPanel = jPanel;
    //     this.get_x = x;
    //     this.get_y = y;
    // }
    RunBomb(JLabel jLabel ){
        this.jLabel = jLabel;
    }
    @Override
    public void run() {
        this.jPanel.showGif(this.get_x,this.get_y);
        try{Thread.sleep(1000);}catch(InterruptedException e){};
            
    }
}
