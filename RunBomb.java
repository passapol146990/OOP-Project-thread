import javax.swing.JLabel;

public class RunBomb extends Thread {
    private JLabel jLabel;
    RunBomb(JLabel jLabel){
        this.jLabel = jLabel;
    }
    @Override
    public void run() {//เอาระเบิดที่เราได้มา มาทำให้มีดีเลย์ เพิ่อที่ไม่ให้ gif มัน piant รูปออกมาเรื่อยๆโดยเราจะให้มันโชว์แค่ตามที่กำหนดแล้วก็ setให้มองไม่เห็น
        try{Thread.sleep(500);}catch(InterruptedException e){};
        this.jLabel.setVisible(false);
    }
}
