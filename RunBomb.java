import javax.swing.JLabel;

public class RunBomb extends Thread {
    private JLabel jLabel;
    RunBomb(JLabel jLabel){
        this.jLabel = jLabel;
    }
    @Override
    public void run() {
        try{Thread.sleep(500);}catch(InterruptedException e){};
        this.jLabel.setVisible(false);
    }
}
