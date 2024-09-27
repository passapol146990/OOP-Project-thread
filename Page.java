import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Page extends JPanel{
    private DataEmpty data;
    private Seting seting;
    Page(Seting seting, DataEmpty data){
        this.data = data;
        this.seting = seting;
        setBackground(new Color(0,0,0));
        for(int index : data.getEmptyLive()){
            this.data.setImageNumber(index,new Random().nextInt(1,10));
            this.data.setPositionX(index, new Random().nextInt(0,this.seting.getWidth()));
            this.data.setPositionY(index, new Random().nextInt(0,this.seting.getHeight()-50));
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
                if(e.getClickCount() == 2){
                    setBomb(e.getX(),e.getY());
                }
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
        for(int i : this.data.getEmptyLive()){
            if(this.data.getHp(i)!= 0){
                int x = this.data.getPositionXEmpty(i);
                int y = this.data.getPositionYEmpty(i);
                g.drawImage(Toolkit.getDefaultToolkit().getImage("./images/"+this.data.getImageNumber(i)+".png"), x, y,50,50,this);
            }
            // g.setColor(new Color(0,255,0));
            // g.drawString("X:"+x+"Y :"+y,x, y-5);
            // g.drawRect(x,y,50, 50);
        }
    }
    void setBomb(int x, int y){
        try{
            ImageIcon image = new ImageIcon("./images/bomb.gif");
            JLabel jLabel = new JLabel();
            jLabel.setIcon(image);
            jLabel.setBounds(x-image.getIconWidth()/2, y-image.getIconHeight()/2, image.getIconWidth(),image.getIconHeight());
            jLabel.setVisible(true);
            this.data.clickBomb(x-image.getIconWidth()/2,y-image.getIconHeight()/2);
            add(jLabel);
            RunBomb runBomb = new RunBomb(jLabel);
            runBomb.start();
        }catch (Exception e){}
        
    }
}
