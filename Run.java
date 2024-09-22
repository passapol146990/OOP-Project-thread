class Run {
    public static void main(String[] args){
        try{
            // int count = Integer.parseInt(args[0]);
            int count = Integer.parseInt("5");
            DataEmpty data = new DataEmpty();
            RunThread runThread = new RunThread();
            data.setCountEmpty(count);

            App app = new App();
            Page page = new Page();
            page.setDataEmpty(data);
            app.add(page);
        }catch(Exception e){System.out.println("Plase Input Number.");}
    }    
}
