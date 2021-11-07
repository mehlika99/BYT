public class Add implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getOperations()=="add"){
            System.out.println(request.getNum1()+" + " + request.getNum2()+ " = "
                    +(request.getNum1()+request.getNum2()));
        }else {
            nextChain.calculate(request);
        }
    }
}
