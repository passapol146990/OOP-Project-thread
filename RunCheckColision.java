class RunCheckColision extends Thread{
    private DataEmpty data;
    private boolean [] disCheck;
    private int index;
    RunCheckColision(DataEmpty data,boolean[] check,int index) {
        this.data = data;
        this.disCheck = check;
        this.index = index;
    }
    public void run() {
        this.disCheck[this.index] = true;
        this.data.setCheckColision(disCheck);
        try{Thread.sleep(100);}catch(Exception e){}
        this.disCheck[this.index] = false;
        this.data.setCheckColision(disCheck);
    }
}
