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
        this.operationX = new Random().nextInt(-1,1); //ซ้ายกับขวา
        this.operationY = new Random().nextInt(-1,1);// บนกับล่าง
        this.speed = new Random().nextInt(1,10);
    }
    void runEmpty() {
        this.data.setPositionX(this.index, this.data.getPositionXEmpty(this.index)+this.operationX);
        this.data.setPositionY(this.index, this.data.getPositionYEmpty(this.index)+this.operationY);
        //  this.data.check();
    }
    void setOperationX(int operationX){
        this.operationX = operationX;
    }
    void setOperationY(int operationY){
        this.operationY = operationY;
    }
    int getSpeed(){return this.speed;}
    int getX(){return this.data.getPositionXEmpty(this.index);}
    int getY(){return this.data.getPositionYEmpty(this.index);}
}