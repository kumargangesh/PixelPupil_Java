import java.util.*;

class CircularPrime{
    public static void main(String[] args) {
        
        System.out.print("Enter a number :\t");
        int num = new Scanner(System.in).nextInt();

        if(num < 10){
            if(isPrime(num) == true)    
                System.err.println(num+" is a Prime number, but not a Rotational Prime number");
            else
                System.err.println(num+" is a not a Prime number, so also it is not a Rotational Prime number");
        }else{
            int arr[] = numToArray(num);
            int flag = 0;

            for(int g=0;g<arr.length;g++){
                if(isPrime( arrayToNumber(rotateByOne(arr)) ) == false)
                    flag = 1;
            }

            if(flag == 1){
                System.out.println(num+" is not a Circular Prime number");
            }else{
                System.out.println(num+" is a Circular Prime number");
            }

        }

    }

    public static int sizeOfNumber(int num){
        int size = 0;

        if(num < 10){
            return 1;
        }else{
            while (num != 0) {
                size += 1;
                num /= 10;
            }
            return size;
        }
    }

    public static int[] numToArray(int num){
        int[] arr = new int[sizeOfNumber(num)];
        int index = 0;

        while(num != 0){
            arr[index] = num % 10;
            num /= 10;
            index++;
        }

        return arr;
    }

    public static boolean isPrime(int num){
        if(num == 2 || num == 3 || num == 5 || num == 7){
            return true;
        }else{
            int flag = 0;
            for(int g=2;g<=num/2;g++){
                if(num % g == 0){
                    flag = 1;
                }
            }

            if(flag == 1){
                return false;
            }return true;
        }
    }

    public static int arrayToNumber(int[] arr){
        int num = 0;
        for(int g=0;g<arr.length;g++){
            num = num*10+arr[g];
        }return num;
    }

    public static int[] rotateByOne(int[] arr){
        int temp = arr[arr.length-1];
        for(int g=arr.length-1;g>=1;g--){
            arr[g] = arr[g-1];
        }
        arr[0] = temp;
        return arr;
    }

}