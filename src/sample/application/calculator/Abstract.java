package sample.application.calculator;

public abstract class Abstract implements FunctionLogic{

	@Override
	public void doFunction(CalculatorActivity ca) {
		// TODO 自動生成されたメソッド・スタブ
		this.doSomething(ca);
		ca.showNumber(ca.strTemp);
	}

	public abstract void doSomething(CalculatorActivity ca);
	
}
