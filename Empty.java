import java.util.Random;

class Empty {
    private DataEmpty data;
    private int MP=100;
    private int operationX,operationY;
    private int index;
    private int speed;
    int width = 50;
    int height = 50;
    int hidbox = 5;
    Empty(int index, DataEmpty data) {
        this.index = index;
        this.data = data;
        this.operationX = new Random().nextInt(-3,3);
        this.operationY = new Random().nextInt(-3,3);
        this.speed = new Random().nextInt(10,30);
    }
    void checkEmpty(){
        // for(int i=0;i<this.data.getEmptyLive();i++){
        //     if(i!=this.index){
        //         int thisX = this.data.getPositionXEmpty(this.index);
        //         int thisY = this.data.getPositionYEmpty(this.index);
        //         int otherX = this.data.getPositionXEmpty(i);
        //         int otherY = this.data.getPositionYEmpty(i);
        //         if(thisX>otherX-this.hidbox&&thisX<otherX+this.hidbox){
        //             System.out.println("true");
        //             if(this.operationX!=0){
        //                 if(this.operationX>0){
        //                     this.operationX = -3;
        //                 }else{
        //                     this.operationX = 3;
        //                 }
        //             }
        //         }
        //     }
        // }
        //     if(this.data.getPositionXEmpty(this.index)==this.data.getPositionXEmpty(i)+this.width){
        //         this.operationX = 1;
        //         break;
        //     }
        //     if(this.data.getPositionYEmpty(this.index)==this.data.getPositionYEmpty(i)-this.height){
        //         this.operationY = -1;
        //         break;
        //     }
        //     if(this.data.getPositionYEmpty(this.index)==this.data.getPositionYEmpty(i)+this.height){
        //         this.operationY = 1;
        //         break;
        //     }

        if(this.data.getPositionXEmpty(this.index) <= 0 || this.data.getPositionXEmpty(this.index)+50 >= this.data.getSeting().getWidth()){
            if(this.operationX!=0){
                this.operationX = (this.operationX>0) ? -3 : 3; 
                // this.speed = new Random().nextInt(1,10);
            }
        }
        if(this.data.getPositionYEmpty(this.index) <= 0 || this.data.getPositionYEmpty(this.index)+50 >= this.data.getSeting().getHeight()){
            if(this.operationY!=0){
                this.operationY = (this.operationY>0) ? -3 : 3; 
                // this.speed = new Random().nextInt(1,10);
            }
        }
    }
    void runEmpty() {
        this.data.setPositionX(this.index, this.data.getPositionXEmpty(this.index)+this.operationX);
        // this.data.setPositionY(this.index, this.data.getPositionYEmpty(this.index)+this.operationY);
        // this.data.check(this.index);
        checkEmpty();
    }
    void setOperationX(int operation){this.operationX = operation;}
    void setOperationY(int operation){this.operationY = operation;}
    int getSpeed(){return this.speed;}
    int getX(){return this.data.getPositionXEmpty(this.index);}
    int getY(){return this.data.getPositionYEmpty(this.index);}
}