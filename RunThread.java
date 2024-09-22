class RunThread extends Thread {
    private Page page;
    private DataEmpty data;
    RunThread(){
    }
    public void run() {
        try{Thread.sleep(1000);}catch(InterruptedException e){};
    }
}