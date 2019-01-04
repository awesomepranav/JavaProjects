////////////////////////////////////////////////////////////////////////
//
// FracCalc
//
// Written by [ Pranav Krovvidi ]
// AP Computer Science A
// 
// Version 1
//
import java.util.*;
public class FracCalc
{
    public static String op = " " ;
    public static void main(String[] args) 
    {
      
        //Getting user input
        Scanner console = new Scanner (System.in);
        String operation = " ";
        while(!console.equals ("quit"))
        {
        System.out.println("Please enter an operation that you want to perform:           ");
        operation = console.nextLine();
        //FracCalc1.op = console.next();
        String ans = produceAnswer(operation);
        System.out.println("answer = " + ans);
        }
    }
   public static String produceAnswer(String input)
    {
       String op1 = " ";
       String op2 = " ";
       FracCalc.op = " ";
       String temp = input;
       
        
           op1 = temp.substring(0,temp.indexOf(' ')+1);
           temp = temp.substring(temp.indexOf(' ')+ 1);
           System.out.println("op1 = " + op1);
           FracCalc.op = temp.substring(0,temp.indexOf(' ')+1);
           temp = temp.substring(temp.indexOf(' ')+1);
           System.out.println("op = " + FracCalc.op);
           op2 = temp;
           System.out.println("op2 = " + op2);
int wholeNumber1 = getWholeNumber(op1);
int wholeNumber2 = getWholeNumber(op2);
   System.out.println("Whole number1:" + wholeNumber1);
System.out.println("Whole number2:" + wholeNumber2);
int numerator1 = getNumerator(op1);
int numerator2 = getNumerator(op2);
System.out.println("num1:" + numerator1);
System.out.println("num2:" + numerator2);
int denominator1 = getDenominator1(op1);
int denominator2 = getDenominator2(op2);
System.out.println("denom1:" + denominator1);
System.out.println("denom2:" + denominator2);
int LCM = getLCM(denominator1, denominator2);
System.out.println("LCM is " + LCM);
 
String answer = " ";
String operator = FracCalc.op;
 System.out.println ("Operator = " + operator);
 
  if(input.contains("_"))
  {
      numerator1 = mixedFunction(wholeNumber1, numerator1,denominator1);
      numerator2 = mixedFunction(wholeNumber2,numerator2,denominator2);
  }
   if(operator.contains("+"))
   {
      answer = makeProper(additionFunction(numerator1, numerator2, LCM, denominator1,denominator2));
      System.out.println (" Answer is ...." + answer);
   }
   else if (operator.contains("-"))
   {
       // two - -
       if (numerator2 < 0)
       {
           answer = makeProper(additionFunction(numerator1, Math.abs(numerator2), LCM, denominator1,denominator2));
        }
        else if ( numerator1 == numerator2 && denominator1 == denominator2)
        {
            answer ="0";
        }
        else
        {
        answer = makeProper(subtractionFunction(numerator1,numerator2,LCM,denominator1,denominator2));
        }
        
       
   }
   else if (operator.contains("*"))
   {
        answer = makeProper(multiplicationFunction(numerator1,numerator2, denominator1, denominator2));
   }
   
   else
   {
       answer = makeProper(divisionFunction(numerator1,numerator2,denominator1, denominator2));
   }
String revisedAnswer = answer.trim();
System.out.print("The answer is:     " + revisedAnswer);
           return revisedAnswer;
 }
    public static int getWholeNumber(String fraction_1){
if (fraction_1.indexOf("_") != -1){
//get the value of the whole number
int indexOfUnderscore = fraction_1.indexOf("_");
String wholeNumber = fraction_1.substring(0,indexOfUnderscore); 
int wholeNumberInt = Integer.parseInt(wholeNumber);
return wholeNumberInt;
} else{
return 0;
}
}
public static int getNumerator(String fraction_1){
//get the value of the numerator
int indexOfUnderscore = fraction_1.indexOf("_");
int indexOfSlash = fraction_1.indexOf("/");
if(indexOfSlash != -1){
    if (fraction_1.indexOf("_") != -1){
        String numerator = fraction_1.substring(indexOfUnderscore + 1,indexOfSlash);
        int numeratorInt = Integer.parseInt(numerator);
        return numeratorInt;
    }else {
       //  System.out.print("In elsehhhhhhhhhhhhhhhhhhhhhhhhh");
        String numerator = fraction_1.substring(0,indexOfSlash);
        int numeratorInt = Integer.parseInt(numerator);
               return numeratorInt;
    }
}else{   
    String fractionNoSpace = fraction_1.trim();
    return Integer.parseInt(fractionNoSpace);
}
}
public static int getDenominator1(String fraction_1){
//get the value of the numerator
int indexOfSlash = fraction_1.indexOf("/");
if(indexOfSlash != -1){
String denominator = fraction_1.substring((indexOfSlash + 1),(fraction_1.length()-1));
int denominatorInt = Integer.parseInt(denominator);
return denominatorInt;
}else{
return 1;
}
}
public static int getDenominator2(String fraction_2){
//get the value of the numerator
int indexOfSlash = fraction_2.indexOf("/");
if(indexOfSlash != -1){
String denominator = fraction_2.substring((indexOfSlash + 1),(fraction_2.length()));
int denominatorInt = Integer.parseInt(denominator);
return denominatorInt;
}else{
return 1;
}
}
private static int getLCM(int denominator_1,int denominator_2)
{
    System.out.println ( "In getLCM fn");
   int denominator1 = denominator_1; 
        int denominator2 = denominator_2;
        //find the least common multiple
        while(denominator_1 != denominator_2){
            if(denominator_1 < denominator_2){
                denominator_1 = denominator1 + denominator_1;
            }else if(denominator_2 < denominator_1){
                denominator_2 = denominator2 + denominator_2;
            }
        }
     System.out.println ("Denpm1 " + denominator_1);    
        return denominator_1;
}
private static String additionFunction(int numerator1, int numerator2, int LCM, int denominator1, int denominator2)
{
    int firstNumerator = (LCM/denominator1) * numerator1;
    int secondNumerator = (LCM/denominator2) * numerator2;
    int addedNumerators = firstNumerator+secondNumerator;
    if(addedNumerators<0 && LCM<0)
    {
        return Math.abs(addedNumerators) + "/" + Math.abs(LCM);
    }
    else if (LCM<0)
    {
        return addedNumerators + "/" + Math.abs(LCM);
    }
    else
    {
        return addedNumerators + "/" + LCM;
    }
}
private static String subtractionFunction(int numerator1, int numerator2, int LCM, int denominator1, int denominator2)
{
    int firstNumerator = (LCM/denominator1)*numerator1;
    int secondNumerator = (LCM/denominator2)*denominator2;
    int subtractedNumerators = firstNumerator - secondNumerator;
  
    if(subtractedNumerators<0 && LCM<0)
    {
        return Math.abs(subtractedNumerators) + "/" + Math.abs(LCM);
    }
    else if(LCM<0)
    {
        return subtractedNumerators + "/" + Math.abs(LCM);
    }
    else
    {
        String subtractedFraction = subtractedNumerators + "/" + LCM;
        return subtractedFraction;
    }
}
private static String multiplicationFunction(int numerator1, int numerator2, int denominator1, int denominator2)
{
    int multipliedNumerator = numerator1*numerator2;
    int multipliedDenominator = denominator1*denominator2;
    String multipliedFraction = multipliedNumerator + "/" + multipliedDenominator;
    return multipliedFraction;
}
private static String divisionFunction(int numerator1, int numerator2, int denominator1, int denominator2)
{
    int dividedNumerator = numerator1*denominator2;
    int dividedDenominator = denominator1*numerator2;
    String dividedFraction = dividedNumerator + "/" + dividedDenominator;
    if(dividedNumerator<0 && dividedDenominator < 0)
    {
         return Math.abs(dividedNumerator) + "/" + Math.abs(dividedDenominator);
    }
    else if(dividedDenominator<0)
    {
        return -dividedNumerator + "/" + Math.abs(dividedDenominator);
    }
    else
    {
            return dividedFraction;
    }
}
private static int mixedFunction(int whole, int numerator, int denominator)
{
    int improperNumerator;
    if(whole < 0)
    {
        improperNumerator = (whole*denominator)-numerator;
        return improperNumerator;
    }
    else if(whole > 0)
    {
       improperNumerator = (denominator*whole)+numerator;
       return improperNumerator;
    }
    else
    {
        return numerator;
    }
    //return improperNumerator;
}
private static String makeProper(String improperFraction)
{
    int indexOfSlash = improperFraction.indexOf("/");
    String numeratorString = improperFraction.substring(0,indexOfSlash);
    String denominatorString = improperFraction.substring(indexOfSlash + 1);
    int numerator = Integer.parseInt(numeratorString);
    int denominator = Integer.parseInt(denominatorString);
    int wholeNumber = numerator/denominator;
    numerator = numerator % denominator;
    String answer = " ";
    if(wholeNumber < 0 && numerator < 0)
    {
        numerator = Math.abs(numerator);
    }
    if(wholeNumber == 0)
    {
        answer = numerator + "/" + denominator;
    }
    else if(numerator != 0)
    {
       answer = wholeNumber + "_" + numerator + "/" + denominator;
    }
    else
    {
        answer = wholeNumber + " ";
    }
    return answer;
}
}
