public class Calculator {

    private String title;

    public Calculator(String title ) {

        this.title=title;
    }

    public int sum(int a, int b)
    {
        return a+b;
    }


    public  double div(int a, int b){

        if(b==0){
            return 0;
        }

        return (double) a/b;



    }


    public  double div(double a , double b){
        if(b==0){
            return 0;
        }
        return a/b;



    }


}

