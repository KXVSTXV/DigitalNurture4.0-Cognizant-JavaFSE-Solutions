import java.util.*;

public class FinancialForecasting
{
    //HashMap to store previously computed results (memoization) --- for optimization of recursion
    private static Map<Integer, Double> memo = new HashMap<>();

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Accept past data from user
        System.out.println("Enter initial/past amount: ");
        double principal = sc.nextDouble();
        
        System.out.println("Enter the annual growth rate (in %): ");
        double rate = sc.nextDouble();
        rate = rate / 100.0;
        
        System.out.println("Enter number of years: ");
        int years = sc.nextInt();

        //Calculate future value using recursive approach
        double futureValue = predictFutureValue(principal, rate, years);
        System.out.println("Future Value : " + futureValue);

        sc.close();
    }

    //Optimized recursive method with memoization using HashMap
    public static double predictFutureValue(double principal, double rate, int years)
    {
        //Base case
        if(years == 0)
        {
            return principal;
        }

        //Check memoization cache
        if(memo.containsKey(years))
        {
            return memo.get(years);
        }

        //Recursive computation with memoization
        double futureValue = predictFutureValue(principal, rate, years - 1) * (1 + rate);

        memo.put(years, futureValue);  //Store result in memoization map

        return futureValue; //return computed future value
    }
}