import java.util.Random;

class Empty {
    private DataEmpty data;
    private int MP=100;
    private int operationX,operationY;
    private int index;
    private int speed;
    Empty(int index, DataEmpty data) {
        this.index = index;
        this.data = data;
        this.operationX = new Random().nextInt(-1,1);
        this.operationY = new Random().nextInt(-1,1);
        this.speed = new Random().nextInt(1,10);
    }
    void checkEmpty(){
        if (getY()==0) {
            this.operationY +=1;
        }else if(getY()>650&&getY()<1300){
            this.operationY =-1;
        }else if(getX()==0){
            this.operationX +=1;
        }else if(getX()>650&&getX()<1300){
            this.operationX =-1;
        }
        
    }
    
    
    void runEmpty() {
        this.data.setPositionX(this.index, this.data.getPositionXEmpty(this.index)+this.operationX);
        this.data.setPositionY(this.index, this.data.getPositionYEmpty(this.index)+this.operationY);
        checkEmpty();

    }
    int getSpeed(){
        return this.speed;}
    int getX(){
        return this.data.getPositionXEmpty(this.index);}
    int getY(){return this.data.getPositionYEmpty(this.index);}
}