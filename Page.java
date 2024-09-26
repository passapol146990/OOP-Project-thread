import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Page extends JPanel{
    private JPanel jPanel;
    private DataEmpty data;
    private Seting seting;
    // private JLabel jLabel = new JLabel();
    Page(Seting seting, DataEmpty data){
        this.jPanel = jPanel;
        this.data = data;
        this.seting = seting;
        setBackground(new Color(0,0,0));
        for(int index=0; index<this.data.getCountEmpty();index++){
            // this.data.setPositionX(index, new Random().nextInt(0,this.seting.getWidth()));
            this.data.setPositionX(index,100);
            this.data.setPositionY(index, new Random().nextInt(0,this.seting.getHeight()-50));
            // this.data.setPositionY(index, 100);
            this.data.setModeX(index,new Random().nextInt(-3,3));
            this.data.setModeY(index,new Random().nextInt(-3,3));
            this.data.setSpeed(index,new Random().nextInt(10,20));
            this.data.setHp(index, 100);
            RunThread runThread = new RunThread(this.data, index,this);
            runThread.start();
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RunBomb runBomb = new RunBomb(this.jLabel);
                runBomb.start();
                // showGif(e.getX(), e.getY());
                add(jLabel);
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<this.data.getCountEmpty();i++){
            if(this.data.getHp(i)!= 0){
                int x = this.data.getPositionXEmpty(i);
                int y = this.data.getPositionYEmpty(i);
                g.drawImage(Toolkit.getDefaultToolkit().getImage("./images/1.png"), x, y,50,50,this);
            }
            // g.setColor(new Color(0,255,0));
            // g.drawString("X:"+x+"Y :"+y,x, y-5);
            // g.drawRect(x,y,50, 50);
        }
    }
    public void showGif(int x, int y){
        try{
            ImageIcon image = new ImageIcon("./images/bomb.gif");
            jLabel.setIcon(image);
            jLabel.setBounds(x, y, image.getIconWidth(),image.getIconHeight());
            jLabel.setVisible(true);
        }catch (Exception e){

        }
        
    }
    public void stopBomb(){
        jLabel.setVisible(false);
    }
}
