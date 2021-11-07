public class Numbers {

    private int num1;
    private int num2;
    private String operations;

    public Numbers(int number1, int number2,String operation){

        num1 = number1;
        num2 = number2;
        operations = operation;

    }

    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }
    public String getOperations(){
        return operations;
    }
}
