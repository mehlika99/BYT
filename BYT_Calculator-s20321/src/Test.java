public class Test {

    public static void main(String[] args){

        //define objects of chain

        Chain add = new Add();
        Chain subtract = new Subtract();
        Chain multiplication = new Multiplication();
        Chain divide = new Divide();



        add.setNextChain(subtract);
        subtract.setNextChain(multiplication);
        multiplication.setNextChain(divide);


        Numbers test1 = new Numbers(10,5,"add");

        add.calculate(test1);


    }
}
