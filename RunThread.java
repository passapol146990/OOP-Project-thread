class RunThread extends Thread {
    private DataEmpty data;
    private int index;
    private Page page;
    RunThread(DataEmpty data,int index,Page page){
        this.data = data;
        this.index = index;
        this.page = page;
    }
    public void run() {//คือเอามากำหนดความเร็วของแต่ละ index
        while (this.data.getHp(this.index)>0) {
            this.data.runSystem(this.index);
            try{Thread.sleep(this.data.getSpeedEmpty(this.index));}catch(InterruptedException e){};
            this.page.repaint();//ให้มันวาดเรื่อยๆตามที่มีอยู่
        }
    }
}