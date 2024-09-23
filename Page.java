import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

class Page extends JPanel{
    private DataEmpty data;
    Page(){
        setBackground(new Color(0,0,0));
    }
    void setDataEmpty(DataEmpty data){
        this.data = data;
    }
    // private int count = 1;
    // private int [] move_x = new int[count];
    // private int [] move_y = new int[count];
    // private int [] operationX = new int[count];
    // private int [] operationY = new int[count];
    // private int [] speedMove = new int[count];
    // void createEmpty(){
        // for(int i = 0; i < count; i++){
              
        // }
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
    void setPositionEmpty(int x, int y){
        // for(this.data.getCountEmpty()){

        // }
    }
    public void paint(Graphics g) {
        super.paint(g);
        int x = new Random().nextInt(0,getWidth());
        int y = new Random().nextInt(0,getHeight());
        // setPositionEmpty()
        // g.drawImage(Toolkit.getDefaultToolkit().getImage("./images/1.png"), x, y,50,50,this);
        // g.setColor(new Color(0,255,0));
        // g.drawString("X:"+x+"Y :"+y,x, y-5);
        // g.drawRect(x,y,50, 50);
        // for(int i = 0; i < count; i++){
        //     g.drawImage(Toolkit.getDefaultToolkit().getImage("./images/1.png"), this.move_x[i], this.move_y[i],50,50,this);
        //     g.setColor(new Color(0,255,0));
        //     int x = this.move_x[i];
        //     int y = this.move_y[i];
        //     g.drawString("X:"+x+"Y :"+y,x, y-5);
        //     g.drawRect(x,y,50, 50);
        // }
    }
}
