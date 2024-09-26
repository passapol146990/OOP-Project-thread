import java.awt.Rectangle;
import java.util.Random;
class DataEmpty {
    private Seting seting;
    private boolean isSetUp=false;
    private int count;
    private int EmptyLive;
    private int [] position_x;
    private int [] position_y;
    private int [] modeX;
    private int [] modeY;
    private int [] speed;
    private boolean [] disCheck;
    int hidbox = 50;
    DataEmpty(Seting seting){
        this.seting = seting;
    }
    void setCountEmpty(int count){
        this.count = count;
        this.EmptyLive = count;
        this.position_x = new int[count];
        this.position_y = new int[count];
        this.modeX = new int[count];
        this.modeY = new int[count];
        this.speed = new int[count];
        this.disCheck = new boolean[count];
    }
    int getRandomInt(int min, int max){
        return new Random().nextInt(min, max);
    }
    void runSystem(int index){
        if(this.position_x[index]<=0){
            this.modeX[index] = getRandomInt(3,5);
            this.disCheck[index] = false; 
        }
        if(this.position_x[index]>=this.seting.getWidth()){
            this.modeX[index] = getRandomInt(-5,-3);
            this.disCheck[index] = false; 
        }
        if(this.position_y[index]<=0){
            this.modeY[index] = getRandomInt(3,5);
            this.disCheck[index] = false; 
        }
        if(this.position_y[index]>=this.seting.getHeight()){
            this.modeY[index] = getRandomInt(-5,-3);
            this.disCheck[index] = false; 
        }
        for (int i = 0; i < this.EmptyLive; i++) {
            if (i != index) {
                if(!this.disCheck[index]&&!this.disCheck[i]){
                    Rectangle thisAsteroid = new Rectangle(this.position_x[index], this.position_y[index], this.hidbox, this.hidbox);
                    Rectangle otherAsteroid = new Rectangle(this.position_x[i], this.position_y[i], this.hidbox, this.hidbox);
                    if (thisAsteroid.intersects(otherAsteroid)) {
                        this.modeX[index] = (this.modeX[index]>0)?getRandomInt(-5,-1):getRandomInt(1,5);  
                        this.modeY[index] = (this.modeY[index]>0)?getRandomInt(-5,-1):getRandomInt(1,5);  
                        this.modeX[i] = (this.modeX[i]>0)?getRandomInt(-5,-1):getRandomInt(1,5);  
                        this.modeY[i] = (this.modeY[i]>0)?getRandomInt(-5,-1):getRandomInt(1,5);  
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
    void setPositionX(int index,int position){this.position_x[index] = position;}
    void setPositionY(int index,int position){this.position_y[index] = position;}
    void setModeX(int index,int mode){this.modeX[index] = mode;}
    void setModeY(int index,int mode){this.modeY[index] = mode;}
    void setIsSetUp(boolean isSetUp){this.isSetUp=isSetUp;};
    void setSpeed(int index,int speed){this.speed[index] = speed;}
    
    Seting getSeting(){return this.seting;}
    boolean getIsSetUp(){return this.isSetUp;}
    int getEmptyLive(){return this.EmptyLive;}
    int getCountEmpty(){return this.count;}
    int getSpeedEmpty(int index){return this.speed[index];}
    int getPositionXEmpty(int index){return this.position_x[index];}
    int getPositionYEmpty(int index){return this.position_y[index];}
}
