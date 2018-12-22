package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    private EditText output=null;
    private EditText input=null;
    private Button btn0=null;
    private Button btn1=null;
    private Button btn2=null;
    private Button btn3=null;
    private Button btn4=null;
    private Button btn5=null;
    private Button btn6=null;
    private Button btn7=null;
    private Button btn8=null;
    private Button btn9=null;
    private Button btnadd=null;
    private Button btnsubtract=null;
    private Button btnmultiply=null;
    private Button btndivide=null;
    private Button btnclear=null;
    private Button btnresult=null;
    private Button btndot=null;
    private Button btnzhengshu=null;
    private Button btnkaifang=null;
    private Button btnpingfang=null;


    private String str="";//保存数字
    private String strold="";//原数字
    private char act=' ';//记录“加减乘除等于”符号
    private int count=0;//判断要计算的次数，如果超过一个符号，先算出来一部分
    private Double result=0.0;//计算的输出结果
    private  Boolean errBoolean=false;//有错误的时候为true，无错为false
    private Boolean flagBoolean=false;//一个标志，如果为true，可以响应运算消息，如果为false，不响应运算消息，只有前面是数字才可以响应运算消息
    private  Boolean flagDot=false; //小数点标志位

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output=(EditText)findViewById(R.id.output);
        input=(EditText)findViewById(R.id.input);
        btn0=(Button)findViewById(R.id.zero);
        btn1=(Button)findViewById(R.id.one);
        btn2=(Button)findViewById(R.id.two);
        btn3=(Button)findViewById(R.id.three);
        btn4=(Button)findViewById(R.id.four);
        btn5=(Button)findViewById(R.id.five);
        btn6=(Button)findViewById(R.id.six);
        btn7=(Button)findViewById(R.id.seven);
        btn8=(Button)findViewById(R.id.eight);
        btn9=(Button)findViewById(R.id.nine);
        btnadd=(Button)findViewById(R.id.add);
        btnsubtract=(Button)findViewById(R.id.subtract);
        btnmultiply=(Button)findViewById(R.id.multiply);
        btndivide=(Button)findViewById(R.id.divide);
        btnclear=(Button)findViewById(R.id.clear);
        btnresult=(Button)findViewById(R.id.result);
        btndot=(Button)findViewById(R.id.dot);
        btnzhengshu=(Button)findViewById(R.id.zhengfu);
        btnkaifang=(Button)findViewById(R.id.kaifang);
        btnpingfang=(Button)findViewById(R.id.pingfang);
        //设置按钮侦听事件
        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        //执行运算
        btnadd.setOnClickListener(listener);
        btnsubtract.setOnClickListener(listener);
        btnmultiply.setOnClickListener(listener);
        btndivide.setOnClickListener(listener);
        btnclear.setOnClickListener(listener);
        btnresult.setOnClickListener(listener);

        btndot.setOnClickListener(listener);
        btnzhengshu.setOnClickListener(listener);
        btnkaifang.setOnClickListener(listener);
        btnpingfang.setOnClickListener(listener);

    }

    private OnClickListener listener=new OnClickListener()
    {

        public void onClick(View v)
        {
            // TODO Auto-generated method stub
            switch (v.getId())
            {
                //输入数字
                case R.id.zero:
                    num(0) ;
                    break;
                case R.id.one:
                    num(1) ;
                    break;
                case R.id.two:
                    num(2) ;
                    break;
                case R.id.three:
                    num(3) ;
                    break;
                case R.id.four:
                    num(4) ;
                    break;
                case R.id.five:
                    num(5) ;
                    break;
                case R.id.six:
                    num(6) ;
                    break;
                case R.id.seven:
                    num(7) ;
                    break;
                case R.id.eight:
                    num(8) ;
                    break;
                case R.id.nine:
                    num(9) ;
                    break;

                case R.id.dot:
                    dot();
                    break;
                //执行运算
                case R.id.zhengfu:
                    zhengfu();
                    break;
                case R.id.kaifang:
                    kaifang();
                    break;
                case R.id.pingfang:
                    pingfang();
                    break;
                case R.id.add:
                    add();
                    break;
                case R.id.subtract:
                    sub() ;
                    break;
                case R.id.multiply:
                    multiply() ;
                    break;
                case R.id.divide:
                    divide() ;
                    break;
                case R.id.clear:
                    clear();
                    break;
                //计算结果
                case R.id.result:
                    result();
                    if(!errBoolean&&flagBoolean){
                        output.setText(String.valueOf(result));
                    }

                default:
                    break;

            }
//		if(strold==""&&act==' '&&str=="")
//		{
//			input.setText("");
//		}
//		else {
//			input.setText(strold+act+str);
//		}
            if(act=='k')
            {
                input.setText(strold);

            }
            else {
                input.setText(strold+act+str);
            }

            output.setText(String.valueOf(result));
            if(act=='j')
            {
                input.setText(strold);

            }
            else {
                input.setText(strold+act+str);
            }

            output.setText(String.valueOf(result));
        }
        private void kaifang()
        {
            // TODO Auto-generated method stub
            if(flagBoolean)
            {
                act='k';
                strold=str;
//		   str="";
                result();
            }
        }
        private void pingfang()
        {
            // TODO Auto-generated method stub
            if(flagBoolean)
            {
                act='j';
                strold=str;
//		   str="";
                result();
            }
        }
        private void zhengfu()
        {
            // TODO Auto-generated method stub
            if(strold=="")
            {
                result=Double.valueOf(str);
            }
            else
            {
                result=Double.valueOf(strold);

            }

            result=result*(-1);
            strold=String.valueOf(result);
            output.setText(String.valueOf(result));
        }
        private void dot()
        {
            // TODO Auto-generated method stub

            if(!flagDot)
            {
                str=str+".";
                flagBoolean=false;
                flagDot=true;
            }
//	   str=str+i;
//	   flagBoolean=false;
        }
        private void clear() {
            // TODO Auto-generated method stub
            str=strold="";
            count=0;
            act=' ';
            result=0.0;
            flagBoolean=false;
            flagDot=false;
            input.setText(strold+act+str);
            output.setText("");
        }
        private void divide() {
            // TODO Auto-generated method stub
            if(flagBoolean)
            {
                check();
                act='/';
                flagBoolean=false;
            }
        }
        private void multiply() {
            // TODO Auto-generated method stub
            if(flagBoolean)
            {
                check();
                act='*';
                flagBoolean=false;
            }
        }
        private void sub() {
            // TODO Auto-generated method stub
            if(flagBoolean)
            {
                check();
                act='-';
                flagBoolean=false;
            }
        }
        private void add() {
            // TODO Auto-generated method stub
            if(flagBoolean)
            {
                check();
                act='+';
                flagBoolean=false;
            }
        }
        private void check() {
            // TODO Auto-generated method stub
            if(count>=1)
            {
                result();
                str=String.valueOf(result);
            }
            strold=str;
            str="";
            count++;
            flagDot=false;
        }
        //计算输出结果
        private void result() {
            // TODO Auto-generated method stub
            if(flagBoolean)
            {
                Double a,b;
//	    		if(act=='k'||act=='c')
//	    		{
//	    			a=Double.parseDouble(strold);
//	    		}
//	    		else {
//	    			a=Double.parseDouble(strold);
//			    	b=Double.parseDouble(str);
//				}
                a=Double.parseDouble(strold);
                b=Double.parseDouble(str);

                if(b==0&&act=='/') {
                    clear();
                    output.setText("除数不能为零!");
                    errBoolean=true;
                }
                if(!errBoolean)
                {
                    switch(act){
                        case '+':
                            result=a+b;
                            break;
                        case '-':
                            result=a-b;
                            break;
                        case '*':
                            result=a*b;
                            break;
                        case '/':
                            result=a/b;
                            break;
                        case 'k':
                            result=Math.sqrt(a);
                            break;
                        case 'j':
                            result=Math.pow(a,2);
                            break;

                        default:
                            break;
                    }
                }

            }
        }

        private void num(int i) {
            // TODO Auto-generated method stub
            str=str+String.valueOf(i);
            flagBoolean=true;
        }
    };
}
