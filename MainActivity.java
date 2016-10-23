package com.example.administrator.calcluatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.Stack;
import java.util.Collections;
/*import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_reduce;
    Button btn_equal;
    Button btn_add;
    Button btn_point;
    Button btn_clear;
    Button btn_del;
    Button btn_divide;
    Button btn_mul;
    EditText et_input;
    Button btn_two;
    Button btn_eight;
    Button btn_sixteen;
    Button left;
    Button right;
    boolean clear_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button)findViewById(R.id.btn_0);
        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        btn_3=(Button)findViewById(R.id.btn_3);
        btn_4=(Button)findViewById(R.id.btn_4);
        btn_5=(Button)findViewById(R.id.btn_5);
        btn_6=(Button)findViewById(R.id.btn_6);
        btn_7=(Button)findViewById(R.id.btn_7);
        btn_8=(Button)findViewById(R.id.btn_8);
        btn_9=(Button)findViewById(R.id.btn_9);
        btn_reduce=(Button)findViewById(R.id.btn_reduce);
        btn_equal=(Button)findViewById(R.id.btn_equal);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_point=(Button)findViewById(R.id.btn_point);
        btn_clear=(Button)findViewById(R.id.btn_clear);
        btn_del=(Button)findViewById(R.id.btn_del);
        btn_divide=(Button)findViewById(R.id.btn_divide);
        btn_mul=(Button)findViewById(R.id.btn_mul);
        et_input= (EditText) findViewById(R.id.et_input);
        btn_two=(Button)findViewById(R.id.btn_two) ;
        btn_eight=(Button)findViewById(R.id.btn_eight);
        btn_sixteen=(Button)findViewById(R.id.btn_sixteen);
        left=(Button)findViewById(R.id.left);
        right=(Button)findViewById(R.id.right);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_sixteen.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_reduce.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_add.setOnClickListener(this);
    }
    /*ctrl+o对父类方法进行重写*/
    @Override
    public void onClick(View v) {
        String str=et_input.getText().toString();
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.left:
            case R.id.right:
            case R.id.btn_point:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_reduce:
            case R.id.btn_add:
            case R.id. btn_divide:
            case R.id.btn_mul:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_clear:

                et_input.setText("");
                break;
            case R.id.btn_del:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                if(str!=null&&!str.equals("")) {
                    et_input.setText(str.substring(0,str.length() - 1));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
            case R.id.btn_two:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                two();
                break;
            case R.id.btn_eight:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                eight();
                break;
        }

    }

    private void getResult(){

        String exp=et_input.getText().toString();
        double re=Calculator.conversion(exp);
        et_input.setText(re+" ");
       /* if(exp.equals(" ")&&exp==null){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        String str1=exp.substring(0,exp.indexOf(" "));*//*第一个数字*//*
        String str3=exp.substring(exp.indexOf(" ")+3);*//*第二个数字*//*
        String str2=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);*//*运算符*//*
        double result = 0;
        if(!str1.equals("")&&!str3.equals("")){
            double s1=Double.parseDouble(str1);
            double s3=Double.parseDouble(str3);
            if(str2.equals("＋")){
                result=s1+s3;
            }else  if(str2.equals("－")){
                result=s1-s3;
            }else  if(str2.equals("×")){
                result=s1*s3;
            }else  if(str2.equals("÷")){
                if(s3==0){
                    result=0;
                }else{

                    result=s1/s3;
                }

            }
            if(!str1.contains(".")&&!str3.contains(".")&&!str2.equals("÷")){
                int r=(int)result;
                et_input.setText(r+"");
            }else{
                et_input.setText(result+"");
            }
        }
        else if(str1.equals("")&&!str3.equals("")){

            double s3=Double.parseDouble(str3);
            if(str2.equals("＋")){
                result=0+s3;
            }else  if(str2.equals("－")){
                result=0-s3;
            }else  if(str2.equals("×")){
                result=0;
            }else  if(str2.equals("÷")){

                result=0;


            }
            if(!str3.contains(".")){
                int r=(int)result;
                et_input.setText(r+"");
            }else{
                et_input.setText(result+"");
            }
        }
        else if(!str1.equals("")&&str3.equals("")){
            et_input.setText(exp);
        }else {
            et_input.setText("");
        }*/
    }
    private void two(){
        String exp=et_input.getText().toString();
        Double num=Double.parseDouble(exp);
        int temp1= (int) Math.floor(num);
        double temp2=num-temp1;
        int[] array=new int[20];
        int top=0;
        int m;
        while(temp1!=0){
            m=temp1%2;
            array[top]=m;
            top++;
            temp1=temp1/2;
        }
        StringBuilder strb=new StringBuilder();
        for(int i =top-1;i>=0;i--){
            strb.append(array[i]);
        }
        String result=strb.toString();
        int[] array1=new int[20];
        int top1=0;
        int n = 0;
        while(temp2!=0){
            n= (int) Math.floor(temp2*2);
            array1[top1]=n;
            top1++;
            temp2=temp2*2-n;
            if (top1>15)
                break;
        }
        StringBuilder strb1=new StringBuilder();
        for(int j=0;j<top1;j++){
            strb1.append(array1[j]);
        }
        String result1=strb1.toString();
        String r;
        if (temp2==0){
            r=result;
        }
        else
        r=result+"."+result1;
        et_input.setText(r);
    }
    private void eight(){
        String exp=et_input.getText().toString();
        Double num=Double.parseDouble(exp);
        int temp1= (int) Math.floor(num);
        double temp2=num-temp1;
        int[] array=new int[20];
        int top=0;
        int m;
        while(temp1!=0){
            m=temp1%8;
            array[top]=m;
            top++;
            temp1=temp1/8;
        }
        StringBuilder strb=new StringBuilder();
        for(int i =top-1;i>=0;i--){
            strb.append(array[i]);
        }
        String result=strb.toString();
        int[] array1=new int[20];
        int top1=0;
        int n = 0;
        while(temp2!=0){
            n= (int) Math.floor(temp2*8);
            array1[top1]=n;
            top1++;
            temp2=temp2*8-n;
            if (top1>5)
                break;
        }
        StringBuilder strb1=new StringBuilder();
        for(int j=0;j<top1;j++){
            strb1.append(array1[j]);
        }
        String result1=strb1.toString();
        String r;
        if (temp2==0){
            r=result;
        }
        else
            r=result+"."+result1;
        et_input.setText(r);
    }
}
class Calculator{

        private Stack<String> postfixStack = new Stack<String>();// 后缀式栈
        private Stack<Character> opStack = new Stack<Character>();// 运算符栈
        private int[] operatPriority = new int[] { 0, 3, 2, 1, -1, 1, 0, 2 };// 运用运算符ASCII码-40做索引的运算符优先级
        public static double conversion(String expression) {
            double result = 0;
            Calculator cal = new Calculator();
            try {
                expression = transform(expression);
                result = cal.calculate(expression);
            } catch (Exception e) {
                //e.printStackTrace(); // 运算错误返回NaN
                return 0.0 / 0.0;
            }
            //return new String().valueOf(result);
            return result;
        }
        private static String transform(String expression) {
            char[] arr = expression.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '-')
                {
                    if (i == 0)
                    {
                        arr[i] = '~';
                    }
                    else {
                        char c = arr[i - 1];
                        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == 'E' || c == 'e')
                        { arr[i] = '~'; } } } }
            if(arr[0]=='~'||arr[1]=='('){
                arr[0]='-';
                return "0"+new String(arr);
            }
            else{
                return new String(arr);
            }
        }
        public double calculate(String expression) {
            Stack<String> resultStack = new Stack<String>();
            prepare(expression);
            Collections.reverse(postfixStack);// 将后缀式栈反转
            String firstValue, secondValue, currentValue;// 参与计算的第一个值，第二个值和算术运算符
            while (!postfixStack.isEmpty()) {
                currentValue = postfixStack.pop();
                if (!isOperator(currentValue.charAt(0))) {// 如果不是运算符则存入操作数栈中
                    currentValue = currentValue.replace("~", "-");
                    resultStack.push(currentValue);
                }
                else {// 如果是运算符则从操作数栈中取两个值和该数值一起参与运算
                    secondValue = resultStack.pop();
                    firstValue = resultStack.pop(); // 将负数标记符改为负号
                    firstValue = firstValue.replace("~", "-");
                    secondValue = secondValue.replace("~", "-");
                    String tempResult = calculate(firstValue, secondValue, currentValue.charAt(0));
                    resultStack.push(tempResult);
                }
            } return Double.valueOf(resultStack.pop()); } /** * 数据准备阶段将表达式转换成为后缀式栈 * * @param expression */
        private void prepare(String expression) {
            opStack.push(',');// 运算符放入栈底元素逗号，此符号优先级最低
            char[] arr = expression.toCharArray();
            int currentIndex = 0;// 当前字符的位置
            int count = 0;// 上次算术运算符到本次算术运算符的字符的长度便于或者之间的数值
            char currentOp, peekOp;// 当前操作符和栈顶操作符
            for (int i = 0; i < arr.length; i++) {
                currentOp = arr[i];
                if (isOperator(currentOp)) {// 如果当前字符是运算符
                    if (count > 0) {
                        postfixStack.push(new String(arr, currentIndex, count));// 取两个运算符之间的数字
                    }
                    peekOp = opStack.peek();
                    if (currentOp == ')') {
                        while (opStack.peek() != '(') {
                            postfixStack.push(String.valueOf(opStack.pop()));
                        }
                        opStack.pop();
                    }
                    else {
                        while (currentOp != '(' && peekOp != ',' && compare(currentOp, peekOp)){
                            postfixStack.push(String.valueOf(opStack.pop()));
                            peekOp = opStack.peek();
                        }
                        opStack.push(currentOp);
                    }
                    count = 0; currentIndex = i + 1;
                }
                else {
                    count++;
                }
            }
            if (count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {// 最后一个字符不是括号或者其他运算符的则加入后缀式栈中
                postfixStack.push(new String(arr, currentIndex, count));
            }
            while (opStack.peek() != ',') {
                postfixStack.push(String.valueOf(opStack.pop()));// 将操作符栈中的剩余的元素添加到后缀式栈中
            }
        } /** * 判断是否为算术符号 * * @param c * @return */
        private boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
        } /** * 利用ASCII码-40做下标去算术符号优先级 * * @param cur * @param peek * @return */
        public boolean compare(char cur, char peek) {// 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
            boolean result = false;
            if (operatPriority[(peek) - 40] >= operatPriority[(cur) - 40]) {
                result = true;
            }
            return result;
        }
        private String calculate(String firstValue, String secondValue, char currentOp) {
            String result = "";
            switch (currentOp) {
                case '+':
                    result = String.valueOf(ArithHelper.add(firstValue, secondValue));
                    break;
                case '-':
                    result = String.valueOf(ArithHelper.sub(firstValue, secondValue)); break;
                case '*': result = String.valueOf(ArithHelper.mul(firstValue, secondValue)); break;
                case '/': result = String.valueOf(ArithHelper.div(firstValue, secondValue)); break;
            }
            return result;
        }
    }


 class ArithHelper { // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 16; // 这个类不能实例化
    private ArithHelper() {

    } /** * 提供精确的加法运算。 * * @param v1 被加数 * @param v2 加数 * @return 两个参数的和 */
    public static double add(double v1, double v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    public static double add(String v1, String v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        return b1.add(b2).doubleValue();
    } /** * 提供精确的减法运算。 * * @param v1 被减数 * @param v2 减数 * @return 两个参数的差 */
    public static double sub(double v1, double v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    public static double sub(String v1, String v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        return b1.subtract(b2).doubleValue();
    } /** * 提供精确的乘法运算。 * * @param v1 * 被乘数 * @param v2 * 乘数 * @return 两个参数的积 */
    public static double mul(double v1, double v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    public static double mul(String v1, String v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        return b1.multiply(b2).doubleValue();
    } /** * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。 * * @param v1 * 被除数 * @param v2 * 除数 * @return 两个参数的商 */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }
    public static double div(String v1, String v2) {
        java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
        java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
        return b1.divide(b2, DEF_DIV_SCALE, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    } /** * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。 * * @param v1 被除数 * @param v2 除数 * @param scale 表示表示需要精确到小数点以后几位。 * @return 两个参数的商 */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        java.math.BigDecimal b1 = new java.math.BigDecimal(Double.toString(v1));
        java.math.BigDecimal b2 = new java.math.BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    } /** * 提供精确的小数位四舍五入处理。 * * @param v 需要四舍五入的数字 * @param scale 小数点后保留几位 * @return 四舍五入后的结果 */
    public static double round(double v, int scale) { if (scale < 0) {
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
        java.math.BigDecimal b = new java.math.BigDecimal(Double.toString(v));
        java.math.BigDecimal one = new java.math.BigDecimal("1");
        return b.divide(one, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public static double round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        java.math.BigDecimal b = new java.math.BigDecimal(v);
        java.math.BigDecimal one = new java.math.BigDecimal("1");
        return b.divide(one, scale, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}