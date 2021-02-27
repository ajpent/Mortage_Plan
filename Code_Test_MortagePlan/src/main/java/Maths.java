import java.text.DecimalFormat;

public class Maths {
        double amount;
        double interest;
        int time;
        double minterest;
        //constructor
        public void maths(double amount,double interest,int time){
            this.interest=1+interest/100;
            this.amount=amount;
            this.time=time;
        }
        //uses the formula provided and calculates the monthly paymenent and returns it
        public double calculatePayement(){
            calculateMonthlyIntrestrate();
            double payement=amount*((minterest-1)*pow(minterest,time*12))/(pow(minterest,time*12)-1);
            DecimalFormat toPay=new DecimalFormat("#.##");
            return Double.parseDouble(toPay.format(payement));
        }

        //calculates monthly interest rate with accuracy of 0.000001
        void calculateMonthlyIntrestrate(){
            double monthlyInterest=(interest-1)/2+1 ;
            double answer=0;

            while(abs(interest-pow(monthlyInterest,12))>0.000001){
                if(pow(monthlyInterest,12)-interest>0){
                    monthlyInterest=(monthlyInterest-1)/2+1;
                }
                else if (pow(monthlyInterest,12)-interest<0){
                    monthlyInterest=(monthlyInterest-1)*3/2+1;
                }
                else if(pow(monthlyInterest,12)-interest==0){
                    minterest=answer;
                    break;
                }
            }
            answer=monthlyInterest;
            minterest=answer;
        }
        //calculates a to the power of n
        double pow(double x, int n){
            double result = 1;
            for (int i=0;i<n;i++){
                result= result*x;
            }
            return result;
        }
        //returns the absolut value of given double
        double abs(double a){
            if(a>0){
                return a;
            }
            else{
                return -a;
            }
        }
}
