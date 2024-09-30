class Seting {
    private int width,height;
    Seting(int width, int height){//กำหนด กว้างสูงโดยเฉพาะ
        this.width = width;
        this.height = height;
    }
    void setWidth(int width) {this.width = width;}
    void setHeight(int height) {this.height = height;}
    int getWidth() {return this.width;}
    int getHeight() {return this.height;}
}
