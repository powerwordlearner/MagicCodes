package lxdlz.calculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
public class MainActivity extends Activity implements OnClickListener{
    //声明一些控件
    Button btn0=null;
    Button btn1=null;
    Button btn2=null;
    Button btn3=null;
    Button btn4=null;
    Button btn5=null;
    Button btn6=null;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btnBackspace=null;
    Button btnCE=null;
    Button btnC=null;
    Button btnAdd=null;
    Button btnSub=null;
    Button btnMul=null;
    Button btnDiv=null;
    Button btnEqu=null;
    Button btnPoint=null;
    Button btnPow=null;
    Button btnExt=null;
    Button btnLeft=null;
    Button btnOpp=null;
    TextView tvResult=null;
    //声明两个参数。接收tvResult前后的值
    String num1="0";
    boolean end=true;
    int op=0;//判断操作数，
    boolean anti=false;
    boolean point=false;
    // @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //从布局文件中获取控件，
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnBackspace=(Button)findViewById(R.id.btnBackspace);
        btnCE=(Button)findViewById(R.id.btnCE);
        btnC=(Button)findViewById(R.id.btnC);
        btnEqu=(Button)findViewById(R.id.btnEqu);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        btnPoint=(Button)findViewById(R.id.btnPoint);
        btnPow=(Button)findViewById(R.id.btnPow);
        btnExt=(Button)findViewById(R.id.btnExt);
        btnLeft=(Button)findViewById(R.id.btnLeft);
        btnOpp=(Button)findViewById(R.id.btnOpp);
        tvResult=(TextView)findViewById(R.id.tvResult);
        //添加监听\
        btnBackspace.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnExt.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnOpp.setOnClickListener(this);
    }
    public void initialize(){
        tvResult.setText("0");
        num1="0";
        op=0;
        end=true;
        anti=false;
        point=false;
    }
    public void exe() {
        if(tvResult.getText().toString().equals("-"))return;
        try {
            switch (op) {
                case 0:
                    num1 = tvResult.getText().toString();
                    break;
                case 1:
                {BigDecimal b1=new BigDecimal(num1);
                    BigDecimal b2=new BigDecimal(tvResult.getText().toString());
                    num1 = b1.add(b2).doubleValue()+"";}
                break;
                case 2:
                {BigDecimal b1=new BigDecimal(num1);
                    BigDecimal b2=new BigDecimal(tvResult.getText().toString());
                    num1 = b1.subtract(b2).doubleValue()+"";}
                break;
                case 3:
                {BigDecimal b1=new BigDecimal(num1);
                    BigDecimal b2=new BigDecimal(tvResult.getText().toString());
                    num1 = b1.multiply(b2).doubleValue()+"";}
                break;
                case 4:
                    try{BigDecimal b1=new BigDecimal(num1);
                        BigDecimal b2=new BigDecimal(tvResult.getText().toString());
                        num1 = b1.divide(b2).doubleValue()+"";}
                    catch (Exception e){
                        num1=Double.valueOf(num1)/Double.valueOf(tvResult.getText().toString())+"";
                    }
                    break;
                case 5:
                    num1=Math.pow(Double.valueOf(num1),Double.valueOf(tvResult.getText().toString()))+"";
                    break;
                case 6:
                    num1=Math.pow(Double.valueOf(num1),1/Double.valueOf(tvResult.getText().toString()))+"";
                    break;
                case 7:
                    try{BigDecimal b1=new BigDecimal(num1);
                        BigDecimal b2=new BigDecimal(tvResult.getText().toString());
                        num1 = b1.divideAndRemainder(b2)[1]+"";}
                    catch (Exception e){
                        num1=Double.valueOf(num1)%Double.valueOf(tvResult.getText().toString())+"";
                    }
                    break;
                default:
                    break;
            }
            if(Double.valueOf(num1)%1==0) {
                tvResult.setText(Double.valueOf(num1).longValue() + "");
                point = false;
            }
            else {
                tvResult.setText(Double.valueOf(num1) + "");
                point = true;
            }
        }
        catch (Exception e){
            initialize();
        }
    }
    public void EXE(int i){
        if(anti==false)exe();
        anti=true;
        op=i;
        end=true;
        point=false;
    }
    public void checkPoint(){
        String myStr=tvResult.getText().toString();
        point=false;
        for(int i=0;i<=myStr.length()-1;i++)
        {
            if(myStr.charAt(i)=='.') {
                point=true;
                break;
            }
        }//check point
        tvResult.setText(myStr.substring(0, myStr.length()));
        if(tvResult.getText().toString().equals("")) {
            end = true;
            tvResult.setText("0");
        }
    }
    public void enterNumber(int i){
        if(i!=0) {
            if(end) {
                tvResult.setText(null);
                end=false;
            }
            String myString=tvResult.getText().toString();
            if(tvResult.getText().toString().equals("0")) myString=i+"";
            else if(tvResult.getText().toString().equals("-0"))myString="-"+i;
            else myString+=i;
            tvResult.setText(myString);
        }
        else {
            if(end==false&&point==false) {
                String myString=tvResult.getText().toString();
                if(myString.equals("0")==false)
                    myString+="0";
                myString= Double.valueOf(myString).longValue()+"";
                tvResult.setText(myString);
            }
            else if(point==true) {
                String myString=tvResult.getText().toString();
                myString+="0";
                tvResult.setText(myString);
            }
            else if(end)tvResult.setText("0");
        }
        anti=false;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //btnBackspace和CE--------------------
            case R.id.btnBackspace:
                if(!end) {
                    try {
                        String myStr;
                        if (point == false) myStr = Double.valueOf(tvResult.getText().toString()).longValue() + "";
                        else myStr = tvResult.getText().toString();
                        tvResult.setText(myStr.substring(0, myStr.length()-1));
                        if(tvResult.getText().toString().equals("-"))tvResult.setText("-0");
                        else if (tvResult.getText().toString().equals(""))tvResult.setText("0");
                    }
                    catch (Exception e){
                        tvResult.setText("0");
                    }
                }
                else initialize();
                break;
            case R.id.btnCE:
                tvResult.setText("0");
                break;
            case R.id.btnC:
                initialize();
                break;
            //btn0--9---------------------------
            case R.id.btn0:
                enterNumber(0);
                break;
            case R.id.btn1:
                enterNumber(1);
                break;
            case R.id.btn2:
                enterNumber(2);
                break;
            case R.id.btn3:
                enterNumber(3);
                break;
            case R.id.btn4:
                enterNumber(4);
                break;
            case R.id.btn5:
                enterNumber(5);
                break;
            case R.id.btn6:
                enterNumber(6);
                break;
            case R.id.btn7:
                enterNumber(7);
                break;
            case R.id.btn8:
                enterNumber(8);
                break;
            case R.id.btn9:
                enterNumber(9);
                break;

            //btn+-*/=--------------------------------
            case R.id.btnEqu:
                EXE(0);
                break;
            case R.id.btnAdd:
                EXE(1);
                break;
            case R.id.btnSub:
                EXE(2);
                break;
            case R.id.btnMul:
                EXE(3);
                break;
            case R.id.btnDiv:
                EXE(4);
                break;
            case R.id.btnPow:
                EXE(5);
                break;
            case R.id.btnExt:
                EXE(6);
                break;
            case R.id.btnLeft:
                EXE(7);
                break;
            case R.id.btnPoint:
                if(point==false&&end==false) {
                    if (tvResult.getText().toString().equals("-")) {
                        String myStr = tvResult.getText().toString();
                        myStr += "0.";
                        tvResult.setText(myStr);
                        point = true;
                        end = false;
                    }
                    else{
                        String myStr = tvResult.getText().toString();
                        myStr += ".";
                        tvResult.setText(myStr);
                        point = true;
                        end = false;
                    }
                    anti=false;
                }
                else if(end==true) {
                    String myStr = tvResult.getText().toString();
                    myStr = "0.";
                    tvResult.setText(myStr);
                    point = true;
                    end = false;
                }
                break;
            case R.id.btnOpp:
                if(!end){
                    String myStr;
                    if(tvResult.getText().toString().charAt(0)!='-'){
                        if(tvResult.getText().toString().equals("0"))
                            myStr=("-0");
                        else myStr="-"+tvResult.getText().toString();
                        tvResult.setText(myStr);
                    }
                    else{
                        if(tvResult.getText().toString().length()>=2)
                            myStr=tvResult.getText().toString().substring(1,tvResult.getText().toString().length());
                        else myStr="0";
                    }
                    tvResult.setText(myStr);
                }
                else{
                    tvResult.setText("-0");
                    end=false;
                }
                anti=false;
                break;
            default:
                break;
        }
        checkPoint();
    }
}
