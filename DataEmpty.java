class DataEmpty {
    private boolean isSetUp=false;
    private int count;
    private int [] position_x;
    private int [] position_y;
    private int width;
    private int height;
    DataEmpty(){}
    void check(){}
    void setCountEmpty(int count){
        this.count = count;
        this.position_x = new int[count];
        this.position_y = new int[count];
    }
    void setWidth(int width){this.width = width;}
    void setheight(int height){this.height = height;}
    void setPositionX(int index,int position){this.position_x[index] = position;}
    void setPositionY(int index,int position){this.position_y[index] = position;}
    void setIsSetUp(boolean isSetUp){this.isSetUp=isSetUp;};
    
    boolean getIsSetUp(){return this.isSetUp;}
    int getCountEmpty(){return this.count;}
    int getPositionXEmpty(int index){return this.position_x[index];}
    int getPositionYEmpty(int index){return this.position_y[index];}
}
