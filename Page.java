import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

class Page extends JPanel{
    private DataEmpty data;
    private Seting seting;
    Page(Seting seting, DataEmpty data){
        this.data = data;
        this.seting = seting;
        setBackground(new Color(0,0,0));
        for(int index=0; index<this.data.getCountEmpty();index++){
            //this.data.setPositionX(index, new Random().nextInt(0,this.seting.getWidth()));
            this.data.setPositionX(index,100);
            this.data.setPositionY(index, new Random().nextInt(0,this.seting.getHeight()-50));
            // this.data.setPositionY(index, 100);
            this.data.setModeX(index,new Random().nextInt(-3,3));
            this.data.setModeY(index,new Random().nextInt(-3,3));
            this.data.setSpeed(index,new Random().nextInt(10,20));
            RunThread runThread = new RunThread(this.data, index,this);
            runThread.start();
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<this.data.getCountEmpty();i++){
            int x = this.data.getPositionXEmpty(i);
            int y = this.data.getPositionYEmpty(i);
            g.drawImage(Toolkit.getDefaultToolkit().getImage("./images/1.png"), x, y,50,50,this);
            // g.setColor(new Color(0,255,0));
            // g.drawString("X:"+x+"Y :"+y,x, y-5);
            // g.drawRect(x,y,50, 50);
        }
    }
}
