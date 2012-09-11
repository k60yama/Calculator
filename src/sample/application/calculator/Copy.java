package sample.application.calculator;

import android.app.Activity;
import android.text.ClipboardManager;
import android.widget.TextView;

public class Copy implements FunctionLogic{

	@Override
	public void doFunction(CalculatorActivity ca) {
		// TODO 自動生成されたメソッド・スタブ
		ClipboardManager cm = (ClipboardManager)ca.getSystemService(Activity.CLIPBOARD_SERVICE);
		cm.setText(((TextView)ca.findViewById(R.id.displayPanel)).getText());
	}

}
