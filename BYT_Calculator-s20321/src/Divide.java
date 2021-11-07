public class Divide implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getOperations()=="divide"){
            System.out.println(request.getNum1()+ " / " + request.getNum2()+ " = "
                    +(request.getNum1()/request.getNum2()));
        }else {
            System.out.println("Please use multiply,divide,add and subtract");
        }
    }
}
