import java.util.Scanner;
class Run {
    public static void main(String[] args){
        try{
            System.out.print("Input number : ");
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();;
            if(count > 2000){
                count = 1000;
            }
            Seting seting = new Seting(720,720);
            DataEmpty data = new DataEmpty(seting);
            data.setCountEmpty(count);
            
            App app = new App(seting);
            Page page = new Page(seting,data);
            app.add(page);
        }catch(Exception e){System.out.println("Please input Number!!!");}
    }    
}
