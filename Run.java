class Run {
    public static void main(String[] args){
        int count = 200;
        Seting seting = new Seting(720,720);
        DataEmpty data = new DataEmpty(seting);
        data.setCountEmpty(count);

        App app = new App(seting);
        Page page = new Page(seting,data);
        app.add(page);
    }    
}
