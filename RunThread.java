class RunThread extends Thread {
    private Page page;
    private Empty empty;
    RunThread(Empty empty, Page page){
        this.empty = empty;
        this.page = page;
    }
    public void run() {
        while (true) {
            this.empty.runEmpty();
            try{Thread.sleep(this.empty.getSpeed());}catch(InterruptedException e){};
            this.page.repaint();
        }
    }
}