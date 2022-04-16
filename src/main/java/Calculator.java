public class Calculator {

    private String title;

    public Calculator(String title ) {

        this.title=title;
    }

    public int sum(int a, int b)
    {
        return a+b;
    }


    public int div(int a, int b){


        System.out.println(a/b);
        return  a/b;

    }


    public  double div(double a , double b){
        if(b==0){
            return 0;
        }
        System.out.println(a/b);
        return a/b;



    }


}

