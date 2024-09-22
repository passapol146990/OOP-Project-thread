import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random.*;
import javax.swing.JPanel;
import java.net.URL;

public class Page extends JPanel{
    // PagePlayGame(){
    //     setSize(1280,720);
    // }
    private int count = 2;
    private int [] move_x = new int[count];
    private int [] move_y = new int[count];
    private int [] move_status = new int[count];
    // status 0 ไปด้านซ้าย
    // status 1 ไปด้านขวา
    // status 2 ไปด้านบน
    // status 3 ไปด้านล่าง
    void setPosition(int id,int x, int y){
        this.move_x[id] = x;
        // this.move_y[id] = y;
    }
    public Page(){
        new RunThread(this).start();
    }
    void randomPosition(){
        for(int i = 0; i < count; i++){
            if(this.move_x[i]==0&&this.move_y[i]==0){
                int x = (int)(Math.random()*1000);
                int y = (int)(Math.random()*700);
                int z = (int)(Math.random()*3);
                this.move_x[i] = x;
                this.move_y[i] = y;
                move_status[i] = z;
            }else{
                if(this.move_x[i]==1230){
                    move_status[i] = 0;
                }else if(this.move_x[i]==10){
                    move_status[i] = 1;
                }
                // 
                if(this.move_y[i]==710){
                    move_status[i] = 2;
                }else if(this.move_y[i]==10){
                    move_status[i] = 3;
                }
                // 
                if(move_status[i]==0){
                    this.move_x[i] = this.move_x[i] - 1;
                }else{
                    this.move_x[i] = this.move_x[i] + 1;
                }
                if(move_status[i]==1){
                    this.move_x[i] = this.move_x[i] + 1;
                }else{
                    this.move_x[i] = this.move_x[i] - 1;
                }
                if(move_status[i]==2){
                    this.move_y[i] = this.move_y[i] - 1;
                }else{
                    this.move_y[i] = this.move_y[i] + 1;
                }
                if(move_status[i]==3){
                    this.move_y[i] = this.move_y[i] + 1;
                }else{
                    this.move_y[i] = this.move_y[i] - 1;
                }
                if (move_x[i] < 0) move_x[i] = 10;
                if (move_x[i] > 1230) move_x[i] = 1230;
                if (move_y[i] < 0) move_y[i] = 10;
                if (move_y[i] > 710) move_y[i] = 710;
            }
            repaint();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        randomPosition();
        //chkCollision();
        for(int i = 0; i < count; i++){
            // URL meteorImageURL = getClass().getResource("/images/1.png");
            // g.drawImage(Toolkit.getDefaultToolkit().getImage(meteorImageURL), this.move_x[i], this.move_y[i], 50, 50, this); use in jar
            g.drawImage(Toolkit.getDefaultToolkit().getImage("images/1.png"), this.move_x[i], this.move_y[i],50,50,this);
        }
    }

    void chkCollision() {
        int collisionRange = 45; // ระยะที่ถือว่าชนกัน
    
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (j == i) continue; // ข้ามถ้าเป็นวัตถุเดียวกัน
    
                // ตรวจสอบว่าตำแหน่ง x และ y ของวัตถุอยู่ในระยะชนกัน
                if (Math.abs(move_x[i] - move_x[j]) < collisionRange && Math.abs(move_y[i] - move_y[j]) < collisionRange) {
                    // เปลี่ยนทิศทางการเคลื่อนที่ใหม่
                    move_status[i] = (int)(Math.random() * 3); // สุ่มทิศทางใหม่สำหรับวัตถุ i
                    move_status[j] = (int)(Math.random() * 3); // สุ่มทิศทางใหม่สำหรับวัตถุ j
    
                    // ตรวจสอบว่าชนกันในแนวนอนหรือแนวตั้ง
                    if (Math.abs(move_x[i] - move_x[j]) > Math.abs(move_y[i] - move_y[j])) {
                        // ชนกันในแนวนอน: เลื่อนออกทางซ้ายหรือขวา
                        if (move_x[i] < move_x[j]) {
                            move_status[i] = 0;
                            move_status[j] = 1;
                            move_x[i] -= 25; // เลื่อนวัตถุ i ออกไปทางซ้าย
                            move_x[j] += 25; // เลื่อนวัตถุ j ออกไปทางขวา
                        } else {
                            move_status[i] = 1;
                            move_status[j] = 0;
                            move_x[i] += 25; // เลื่อนวัตถุ i ออกไปทางขวา
                            move_x[j] -= 25; // เลื่อนวัตถุ j ออกไปทางซ้าย
                        }
                    } else {
                        // ชนกันในแนวตั้ง: เลื่อนออกทางบนหรือล่าง
                        if (move_y[i] < move_y[j]) {
                            move_status[i] = 2;
                            move_status[j] = 3;
                            move_y[i] -= 25; // เลื่อนวัตถุ i ออกไปทางบน
                            move_y[j] += 25; // เลื่อนวัตถุ j ออกไปทางล่าง
                        } else {
                            move_status[i] = 3;
                            move_status[j] = 2;
                            move_y[i] += 25; // เลื่อนวัตถุ i ออกไปทางล่าง
                            move_y[j] -= 25; // เลื่อนวัตถุ j ออกไปทางบน
                        }
                    }
                }
            }
        }
    }
    
}
