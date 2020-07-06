/*Program Title: SmartFinWare.
@Author: Ch.Tharun Raju.
@SAP ID: 51834549*/
import java.util.Scanner;
public class Main{
    private void AverageStockPrice(){
        Scanner reader = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("Average stock price section.");
        System.out.println("------------------------------");
        System.out.print("Enter the name of an organisation: ");
        String organisationName = reader.nextLine();//stores name of an organisation.
        System.out.println("Enter the number of transactions: ");
        int totalTransactions = reader.nextInt();//stores total number of transactions.
        double capitalFund=0;//stores capital amount.
        double stockPrice=0;//stores stock price at precise transaction.
        int sharesQuantity=0;//stores quantity of shares.
        int sharesQ=0;//stoeres quanity of shares at precise transaction.
        int count=1;//keep tracking the transactin count.
        //keep on exucutes until the count is equal to total number of transactions.
        try{
        while(count<=totalTransactions){
            System.out.printf("Enter the transaction %d nature(1 or 2):\n",count);
            System.out.println("1.Buying\n2.Selling");
            int option = reader.nextInt();//stores user choice.
            //conditional block for option1.
            if(option==1){
                System.out.printf("Enter the share price in transaction %d:\n",count);
                stockPrice = reader.nextDouble();//stock price at precise transaction.
                System.out.printf("Enter the shares quantity in transaction %d:\n",count);
                sharesQ=reader.nextInt();//shares quantity at precise transaction.
                capitalFund+=sharesQ*stockPrice;//updating the capital fund on every transaction.
                sharesQuantity+=sharesQ;//updating the stock quantity on every transaction.
                System.out.println(capitalFund+"   "+sharesQuantity);//Keep track of capital and shares quantity.
                count++;//increment the count.
            }
            else if(option==2){
                System.out.printf("Enter the share price in transaction %d:\n",count);
                stockPrice = reader.nextDouble();//stock price at precise transaction.
                System.out.printf("Enter the shares quantity in transaction %d:\n",count);
                sharesQ=reader.nextInt();//stock quantity at precise transactin.
                capitalFund-=sharesQ*stockPrice;//updating the capital fund on every transaction.
                sharesQuantity-=sharesQ;//updating the stock quantity on every transaction.
                System.out.println(capitalFund+"   "+sharesQuantity);//Keep track of capital and quantity.
                count++;//increment the count.
            }
            //promt a message to user if the input is other than 1 or 2.
            else{
                System.out.println("Choose only below mentioned options(1 or 2)");
            } 
            
        }
        }
        //Exception block for handling inputMismatchException
        catch(Exception ex){
            System.out.println("Please enter only numbers.");
        }
        System.out.println("----------------------------------------------------------------------");
        //total number of shares in portfolio after completing the n number of transactions.
        System.out.println("Number of remaining shares after "+totalTransactions+" transactions: "+sharesQuantity);
        //last transaction price of share(latest traded price).
        System.out.println("Stock price: Rs."+stockPrice);
        //average stock price after n number of transactions.
        System.out.printf("Average stock price: Rs.%.2f\n",(capitalFund/sharesQuantity));
        System.out.println("----------------------------------------------------------------------");
        
    }
//Java program for return on investment.
    private void ReturnOnInvestment(){
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("Return on investment calculation section.");
        System.out.println("------------------------------------------");
        System.out.print("Enter the organisation name: ");
        String organisationName = input.nextLine();//Name of the organisation.
        System.out.print("Enter the number of shares: ");
        int sharesQuantity = input.nextInt();//Quantity of shares.
        System.out.print("Enter the buying price of each share: ");
        float buyingPrice = input.nextFloat();//stores buying price.
        System.out.print("Enter the selling price of each share: ");
        float sellingPrice = input.nextFloat();//stores selling price.
        System.out.print("Enter the holding period of share(e.g:12YEARS or 6MONTHS): ");
        String holdingPeriod = input.next();//variable for storing holding period of shares.
        float costOnInvestment = (sharesQuantity*buyingPrice);//fund after bought the shares.
        float soldPrice = (sharesQuantity*sellingPrice);//fund after selling the shares.
        float profit = soldPrice-costOnInvestment;//stores the profit
        float returnOnInvestment = (profit/costOnInvestment)*100;//formulae to calulate ROI.
        System.out.println("------------------------------------------------------------------");
        System.out.println("Organisation name: "+organisationName);
        System.out.printf("Total invesment : Rs.%.2f \n", costOnInvestment);
        System.out.printf("Total generated revenue in %s: Rs.%.2f \n",holdingPeriod,(costOnInvestment+profit));
        //condition block for validating profit or loss.
        if(profit>=0)
            System.out.printf("Total profit in %s : Rs.%.2f \n",holdingPeriod,profit);
        else
            System.out.printf("Total loss in %s : Rs.%.2f \n",holdingPeriod,profit);
        System.out.printf("ROI(Return on investment) of total investment is %.2f ",returnOnInvestment);
        System.out.println("%");
        System.out.println("------------------------------------------------------------------");
        
    }

    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        Main object = new Main();//refernce object variable.
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Welcome to the SmartFinWare.");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Kindly enter your first name: ");
        String name = userInput.nextLine();
        System.out.println("Hello, "+name);//Greet the user.
        //Exception block for handling inputMismatchException.
        int exit=0;
        try{
        while(exit!=3){
        System.out.println("");
        System.out.println("Please choose one of the below mentioned options: ");
        System.out.println("1)Calculate average stock price.\n2)Calculate return on investment.\n3)Exit.");  
        int userOption = userInput.nextInt();
        exit = userOption;//stores exit loop option.
        //switch cases to invoke the precise methods.
        switch(userOption){
            case 1:
                object.AverageStockPrice();
                break;
            case 2:
                object.ReturnOnInvestment();
                break;
            case 3:
                break;
            default:
                System.out.println("Please enter only 1 or 2 or 3.");
        }
        }
        }
        catch(Exception ex){
            System.out.println("Please enter only whole numbers.");
        }
        System.out.println("\nThank you for using our services.");
        userInput.close();
    }
}
