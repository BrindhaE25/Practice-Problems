public class Factorial {
    public int findFactorial(int number) {
        int result = 1;
        if(number < 0)
            return 0;
        else if(number == 0)
            return 1;
        else {
            for(int iter=2;iter<=number;iter++)
                result = result * iter;
            return result;
        }
    }
}
