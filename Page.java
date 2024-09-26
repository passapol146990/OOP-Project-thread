import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Random;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.io.File;
import java.awt.image.BufferedImage;

class Page extends JPanel{
    private DataEmpty data;
    private Seting seting;
    private JLabel jLabel = new JLabel();
    Page(Seting seting, DataEmpty data){
        // jLabel.setVisible(false);//ซ่อน gif
        this.data = data;
        this.seting = seting;
        setSize(this.seting.getWidth(), this.seting.getHeight());
        setBackground(new Color(0,0,0));
        this.data.setWidth(getWidth());
        this.data.setWidth(getHeight());
        this.addMouseListener(new MouseAdapter() { // เอาไว้โชว์ระเบิดเวลาคลิก
            @Override
            public void mouseClicked(MouseEvent e) {
                showGif(e.getX(),e.getY());
                add(jLabel);
            }
        });
        for(int index=0; index<this.data.getCountEmpty();index++){
            this.data.setPositionX(index, new Random().nextInt(0,getWidth()));
            this.data.setPositionY(index, new Random().nextInt(0,getHeight()));
            Empty empty = new Empty(index,this.data);
            RunThread runThread = new RunThread(empty,this);
            runThread.start();
        }
        
        
    }
      
       
        
    
    // void createEmpty(){
        // repaint();
        // for(int i = 0; i < count; i++){
        //     if(this.move_x[i]==0&&this.move_y[i]==0){
        //         int x = (int)(Math.random()*getWidth()-30);
        //         int y = (int)(Math.random()*getHeight()-30);
        //         this.move_x[i] = x;
        //         this.move_y[i] = y;
        //         this.operationX[i] = new Random().nextInt(-1, 1);
        //         this.operationY[i] = new Random().nextInt(-1, 1);
        //         this.speedMove[i] = new Random().nextInt(100,1000);
        //     }else{
        //         this.move_x[i] = this.move_x[i]+this.operationX[i];
        //         this.move_y[i] = this.move_y[i]+this.operationY[i];
        //         if(this.move_x[i]>=getWidth()-30){
        //             this.operationX[i] = -1;
        //         }else if(this.move_x[i]<=0){
        //             this.operationX[i] = 1;
        //         }
        //         if(this.move_y[i]>=getHeight()-30){
        //             this.operationY[i] = -1;
        //         }else if(this.move_y[i]<=0){
        //             this.operationY[i] = +1;
        //         }
        //     }
        //     repaint();
        // }
    // }
    void setPositionEmpty(){
        // for(int i=0;i<this.data.getCountEmpty();i++){
            // if(!this.data.getIsSetUp()){
                // this.data.setPositionX(i, new Random().nextInt(0,getWidth()));
                // this.data.setPositionY(i, new Random().nextInt(0,getHeight()));
            // }else{
            //     int x = this.data.getPositionXEmpty(i);
            //     int y = this.data.getPositionYEmpty(i);
            // }
        // }
        // this.data.setIsSetUp(true);
        // repaint();
    }
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<this.data.getCountEmpty();i++){
            int x = this.data.getPositionXEmpty(i);
            int y = this.data.getPositionYEmpty(i);
            g.drawImage(Toolkit.getDefaultToolkit().getImage("./images/1.png"), x, y,50,50,this);
            g.setColor(new Color(0,255,0));
            g.drawString("X:"+x+"Y :"+y,x, y-5);
            g.drawRect(x,y,50, 50);
        }
    }
    public void showGif(int x, int y){
        try{
            ImageIcon image = new ImageIcon("C:\\gitclone\\OOP-Project-thread\\images/bomb.gif");
            jLabel.setIcon(image);
            jLabel.setBounds(x, y,image.getIconWidth(), image.getIconHeight());
            jLabel.setVisible(true);

            
        }catch (Exception e){
            e.printStackTrace();//แสดงผิด
        }
    }
    
}
    
