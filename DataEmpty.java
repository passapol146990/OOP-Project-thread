import java.awt.Rectangle;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

class DataEmpty {
    private Seting seting;
    private int count;
    private ArrayList<Integer> EmptyLive = new ArrayList<Integer>();
    private int [] position_x;
    private int [] position_y;
    private int [] modeX;
    private int [] modeY;
    private int [] speed;
    private int [] hp;
    private int [] imageNumber;
    private boolean [] disCheck;
    private int hidbox = 40;
    DataEmpty(Seting seting){
        this.seting = seting;
    }
    void setCountEmpty(int count){
        this.count = count;
        for(int i=0; i<count; i++){
            this.EmptyLive.add(i);
        }
        this.position_x = new int[count];
        this.position_y = new int[count];
        this.hp =  new int[count];
        this.modeX = new int[count];
        this.modeY = new int[count];
        this.speed = new int[count];
        this.disCheck = new boolean[count];
        this.imageNumber = new int[count];
    }
    int getRandomInt(int min, int max){
        return new Random().nextInt(min, max);
    }
    void runSystem(int index){
        if(this.position_x[index]<=0){
            this.modeX[index] = getRandomInt(1,2);
        }
        if(this.position_x[index]>=this.seting.getWidth()){
            this.modeX[index] = getRandomInt(-2,-1);
        }
        if(this.position_y[index]<=0){
            this.modeY[index] = getRandomInt(1,2);
        }
        if(this.position_y[index]>=this.seting.getHeight()){
            this.modeY[index] = getRandomInt(-2,-1);
        }
        for (int i : this.EmptyLive) {
            if (i != index) {
                if(!this.disCheck[index]&&!this.disCheck[i]){
                    Rectangle thisAsteroid = new Rectangle(this.position_x[index], this.position_y[index], this.hidbox, this.hidbox);
                    Rectangle otherAsteroid = new Rectangle(this.position_x[i], this.position_y[i], this.hidbox, this.hidbox);
                    if (thisAsteroid.intersects(otherAsteroid)) {
                        int dx = this.position_x[index] - this.position_x[i];
                        int dy = this.position_y[index] - this.position_y[i];
                        
                        if (dx == 0) dx = 1; 
                        if (dy == 0) dy = 1;

                        this.position_x[index] += 5 * (dx / Math.abs(dx)); // แยกออกตามทิศทาง X
                        this.position_y[index] += 5 * (dy / Math.abs(dy)); // แยกออกตามทิศทาง Y

                        this.position_x[i] -= 5 * (dx / Math.abs(dx));
                        this.position_y[i] -= 5 * (dy / Math.abs(dy));

                        this.modeX[index] = (this.modeX[index]>0)?getRandomInt(-2,-1):getRandomInt(1,5);// บวก ช้าย ลบ ขวา
                        this.modeX[i] = (this.modeX[i]>0)?getRandomInt(-2,-1):getRandomInt(1,5); 
                        this.modeY[index] = (this.modeY[index]>0)?getRandomInt(-2,-1):getRandomInt(1,5);// บวก บน ลบ ล่าง
                        this.modeY[i] = (this.modeY[i]>0)?getRandomInt(-2,-1):getRandomInt(1,5);  
                        this.disCheck[index] = true;    
                        this.disCheck[i]    = true; 
                    }
                }
            }
        this.disCheck[index] = false; 
        this.disCheck[i]    = false; 
    }
        this.position_x[index] += this.modeX[index];
        this.position_y[index] += this.modeY[index];
    }
    void clickBomb(int x, int y){
        try{
            Iterator<Integer> iter = this.EmptyLive.iterator();
            while (iter.hasNext()) {
                int i = iter.next();
                Rectangle thisAsteroid = new Rectangle(this.position_x[i], this.position_y[i], this.hidbox, this.hidbox);
                Rectangle otherAsteroid = new Rectangle(x, y, this.hidbox, this.hidbox);
                if (thisAsteroid.intersects(otherAsteroid)) {
                    this.hp[i] = 0;
                    iter.remove();
                }
            }
        }catch(Exception e){}

    }
    void setImageNumber(int index,int number){this.imageNumber[index] = number;}
    void setPositionX(int index,int position){this.position_x[index] = position;}
    void setPositionY(int index,int position){this.position_y[index] = position;}
    void setModeX(int index,int mode){this.modeX[index] = mode;}
    void setModeY(int index,int mode){this.modeY[index] = mode;}
    void setSpeed(int index,int speed){this.speed[index] = speed;}
    void setHp(int index, int hp){this.hp[index] = hp;}
    void setCheckColision(boolean []check){this.disCheck = check;}
    Seting getSeting(){return this.seting;}
    ArrayList<Integer> getEmptyLive(){return this.EmptyLive;}
    int getCountEmpty(){return this.count;}
    int getSpeedEmpty(int index){return this.speed[index];}
    int getPositionXEmpty(int index){return this.position_x[index];}
    int getPositionYEmpty(int index){return this.position_y[index];}
    int getHp(int index){return this.hp[index];}
    int getImageNumber(int index){return this.imageNumber[index];}
}
