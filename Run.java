class Run {
    public static void main(String[] args){
        App app = new App();
        Page page = new Page();
        RunThread runThread = new RunThread(page);
        runThread.start();
        app.add(page);
    }    
}
class RunThread extends Thread {
    private Object obj1;
    RunThread(Object object){
        this.obj1 = object;
    }
    public void run() {
        ((Page) obj1).randomPosition();
        ((Page) obj1).chkCollision();
        try{Thread.sleep(100);}catch(InterruptedException e){};
    }
}
