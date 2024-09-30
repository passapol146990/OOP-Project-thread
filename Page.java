import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
            public void mouseClicked(MouseEvent e) {//ถ้ากด 2ครั้งก็จะให้เรียก setbomb มาเพื่อที่จะเอาตำแหน่งไปเช็คเพื่อวาดรูประเบิด
                if(e.getClickCount() == 2){
                    setBomb(e.getX(),e.getY());
                }
            }
        });
        addComponentListener(new ComponentAdapter() {//มีเพื่อรับตำแหน่ง x,y ตามความเป็นจริงมันจะขยายขึ้นตาม frame
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();
                seting.setWidth(width);
                seting.setHeight(height);
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
        for(int i : this.data.getEmptyLive()){//ให้จำนวนเปรียบเทียบกับ จำนวนอาเรย์ เพื่อที่จะนำมาวาดรูปอุกกาบาตต่างๆ
            if(this.data.getHp(i)!= 0){
                int x = this.data.getPositionXEmpty(i);
                int y = this.data.getPositionYEmpty(i);
                g.drawImage(Toolkit.getDefaultToolkit().getImage("./images/"+this.data.getImageNumber(i)+".png"), x, y,50,50,this);
            }
        }
    }
    void setBomb(int x, int y){//รับค่า x,y มาเพื่อมาวนลูปละจากนั้นดึง method clickBombคือถ้าเกิดเรากด 2 ทีระเบิดเราไปโดนพื้นที่ของอุกกาบาตทำให้มันหายไป
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
