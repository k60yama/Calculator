package sample.application.calculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	
	//クラス変数
	public static String num1;				//＋押下後、表示領域の数字を格納
	public static String num2;				//=押下後、表示領域の数字を格納
	public static String math;				//演算子格納
	public static int result_int;			//計算結果(int)
	public static double result_double;		//計算結果(double)
	public static String result_str = "";	//表示用計算結果
	
	//教科書ロジック
	public String strTemp = "";
	public String strResult = "0";
	public int operator = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }
    
    
    //レイアウトのxmlファイルに設定されているonClickに"numKeyOnClick"が設定される場合に、このメソッドが実行される。
    public void numKeyOnClick(View v){
    	
    	//教科書ロジック
    	String strInKey = (String) ((Button)v).getText();
    	
    	if(".".equals(strInKey)){
    		if(this.strTemp.length() == 0){
    			this.strTemp = "0.";
    		}else{
    			if(this.strTemp.indexOf(".") == -1){
    				this.strTemp = this.strTemp + ".";
    			}
    		}
    	}else{
    		this.strTemp = this.strTemp + strInKey;
    	}
    	
    	this.showNumber(this.strTemp);
    	
    	/*
    	// 自作 ここから
    	//引数vをButton型にキャスト
    	Button  button = (Button)v;
		
    	TextView tv = (TextView)this.findViewById(R.id.displayPanel);

    	tv.setText(tv.getText().toString() + button.getText().toString());
    	
		//計算未処理チェック
		if(result_str == "" ){
			//数値表示チェック(表示されてるのが0か？)
			if((tv.getText().toString()).equals("0")){
				
				//小数点チェック(押したのが小数点か？)
				if((button.getText().toString()).equals(".")){
					tv.setText(tv.getText().toString() + button.getText().toString());
				}else{
					tv.setText(button.getText().toString());
				}
				
			}else{
				//続けて表示
				tv.setText(tv.getText().toString() + button.getText().toString());
			}
			
		}else{
			//表示
			tv.setText(button.getText().toString());
			
			//表示用計算結果初期化
			result_str = "";
		}
		//自作 ここまで
		*/
    }
    
    private void showNumber(String strNum){
    	
    	//整数時に先頭が0の場合、DecimalFormatに指定している#の役割で、自動的に0が消える。
    	DecimalFormat form = new DecimalFormat("#.##0");
    	String strDecimal = "";
    	String strInt = "";
    	String fText = "";
    	
    	if(strNum.length() > 0){
    		int decimalPoint = strNum.indexOf(".");				//小数点がある位置を取得
    		if(decimalPoint > -1){
    			strDecimal = strNum.substring(decimalPoint); 	//(小数点を含む)小数点から後の文字列を取得
    			strInt = strNum.substring(0,decimalPoint); 		//小数点よりも前の文字列取得
    		}else{
    			strInt = strNum; 								//小数点がなければ入力された文字列を代入
    		}
    		
    		fText = form.format(Double.parseDouble(strInt)) + strDecimal; //文字列を整形
    	}else{
    		fText = "0";
    	}
    	
    	((TextView)this.findViewById(R.id.displayPanel)).setText(fText); //計算結果表示部分に設定
    }
    
    /*
    //自作 ここから
    public void addKeyOnClick(View v){
    	
    	//Botton型のキャスト
    	Button button = (Button)v;
    	
    	//TextView(this:CalculatorActivityクラスのインスタンス)
    	TextView tv = (TextView)this.findViewById(R.id.displayPanel);
    	
    	//Log.d("ID",tv.getId());
    	
    	//画面に表示している数字を num1 に格納
    	num1 = tv.getText().toString();
    	
    	//+を math に格納
    	math = button.getText().toString();
    	
    	//画面に表示している数字を初期化する
    	tv.setText("0");
    }
    
    public void equalKeyOnClick(View v){
    	
    	//TextViewオブジェクトを取得
    	TextView tv = (TextView)this.findViewById(R.id.displayPanel);
    	
    	//画面に表示している数字を num2 に格納
    	num2 = tv.getText().toString();
    		
    	//演算子チェック
    	if(math.equals("+")){
    		
    		//小数点入力チェック
    		if(num1.indexOf(".") == -1 & num2.indexOf(".") == -1){
    			//計算処理(整数)
    			result_int = Integer.valueOf(num1) + Integer.valueOf(num2);
    			result_str = String.valueOf(result_int);
    		}else{
    			//計算処理(小数)
    			result_double = Double.valueOf(num1) + Double.valueOf(num2);
    			result_str = String.valueOf(result_double);
    		}
 
    		//計算結果を設定
    		tv.setText(result_str);	
    	}
    }
    //自作 ここまで
    */
}
