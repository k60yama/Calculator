package sample.application.calculator;

public class Bs extends Abstract{

	@Override
	public void doSomething(CalculatorActivity ca) {
		// TODO 自動生成されたメソッド・スタブ
		if(ca.strTemp.length() == 0){
			return ;
		}else{
			ca.strTemp = ca.strTemp.substring(0,ca.strTemp.length()-1);
		}
	}
}
