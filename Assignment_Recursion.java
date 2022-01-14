
public class Assignment_Recursion {
	public static double findGeometricSum(int n) {
		//1 + 1/2 + 1/4 + 1/8 + 1/16 + ..... ....+ 1/2^n
		//we know that if n=0 then sum is 1;
		//for n=2 : 1/2^0  +1/2^1 + 1/2^2
		if(n==0) return 1; //this is the base case
		// using PMI find the sum upto n terms first find (n-1) number sum 
		double lastSum=findGeometricSum(n-1);    //again calling to find sum of n-1 numbers
		double result=lastSum + 1/Math.pow(2, n);
		return result;
	}
	
	public static String reverse(String str) {

		if(str.length()==0) return str;
		String lastStr=reverse(str.substring(1));
		return lastStr+str.charAt(0);
	}
	public static boolean isStringPalindrome(String input) {
		// Write your code here
		String ss=reverse(input);
		if(input.equals(ss)) return true;
		else return false;
	}
	
	public static int sumDigit(int n) {
		//baze case shoul be that if n%10==0 return n i.e. when have one digit return same digit
		if(n%10==0) return n;
		//to find sum digit of n first find sum of didgit of n/10 then add n%10 
		int lastSum=sumDigit(n/10);
		int rem=n%10;
		return lastSum+rem;
	}
	
	public static int countZero(int n) {
		if(n==0) return 1; //if number is zero then we return 1 this is our base case
		else if(n/10==0) return 0;   //number have one non zero digit then we will return this 0
		int lastCount=countZero(n/10);   //we apply Acc to PMI that ,to find zero in n number first find zero in n/10 numbr
		int LastDigitOfCurrentNo= (n%10==0)?1:0;  //here in ever number if last digit zero we count 1 otherwise count 0
		return LastDigitOfCurrentNo+lastCount;  //after we add previos count zero and curemnt count zero
	}
	
	public static int stringToInteger(String str) {
		int n=str.length();   //first find len of string
		if(n==1) {    //if String have one char then return this char
			int s=str.charAt(0);
			s-=48;
			return s;
		}
		int value=stringToInteger(str.substring(1));  //to conver n length string into integer first find substring in integer
		int firstDigit=str.charAt(0);     //take 1st digit of number after handling all digit
	
		firstDigit-=48;    //bcoz ASCII
		int pv=(int)Math.pow(10,n-1);  //position value for the first digit
		return  firstDigit*pv+value;
		
	}
	
	public static String pairStar(String str) {
		if(str.length()==1) return str;     //if string has a single char then return same because we cant check adjacent string
		String lastStr=pairStar(str.substring(1));   //call substring for check acc to PMI
		if(str.charAt(0)==str.charAt(1)) lastStr='*' + lastStr;   //if char of given String same we add * in between
		
		String result=str.charAt(0)+lastStr;
		return result;
	}
	
	public static boolean checkAB(String str) {
		if(str.length()==0) return true;    //acc to rule this is the base case
		if(str.charAt(0)=='a') {     //acc to problem that start from 'a'
			if(str.length()>2 && str.substring(1,3).equals("bb")) return checkAB(str.substring(3));   //if start from 'a' check adjacent are "bb" or not
			else return checkAB(str.substring(1));  //if not "bb" then call substring from 1st
		}
		else return false;    //if not start from 'a' then return false
		
	}

	public static int stairCaseWays(int n) {
		//n is the number of stair
		
		if(n==1 || n==0) return 1; //ythis  is the basecase      
				//if has one stair than the only case we can climb i	
		else if(n==2) return 2;
		
		//to find ways to climb n stairs first find climb of ways (n-1) stairs and last we can take 1 step
		//or find (n-2) stairs climb ways then last can take 2 steps at  a time
		//or take (n-3) stairs climb ways then last can take 3 steps at a time
		return stairCaseWays(n-1)+stairCaseWays(n-2)+stairCaseWays(n-3);
	}
	
    public static int maximumProfit(int[] arr,int si,int maxprofit){
        if(si==arr.length) return maxprofit;
        int key=arr[si];
        int count=0;
        int i=0;
        for(i=0;i<arr.length;i++) {
        	if(arr[i]>=key) count++;
        }
        int profit=key*count;
        if(profit>maxprofit) maxprofit=profit;
        return maximumProfit(arr,si+1,maxprofit);
        
        
    }
    
    
    public static boolean splitArray(int[] arr,int si,int lsum,int rsum) {
    	/*
    	 - Sum of both parts is equal
		- All elements in the input, which are divisible by 5 should be in same group.
		- All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group.
		- Elements which are neither divisible by 5 nor by 3, can be put in any group.
    	 */
    	
    	if(si==arr.length) return lsum==rsum;
    	if(arr[si]%5==0) {  //if true we add this num in lsum
    		lsum+=arr[si]; 
    	}
    	else if(arr[si]%3==0 && arr[si]%5!=0) {     //if this true then add ele in rsum
    		rsum+=arr[si];
    	}
    	//if Above both cond^n is false then add currrent elememn either lsum or rsum ,
    	//so first we call next ele to add current element in lsum and then call current ele with rsum check in which addition is give the true output 
    	else return splitArray(arr,si+1,lsum+arr[si],rsum) || splitArray(arr,si+1,lsum,rsum+arr[si]);  
    	return splitArray(arr,si+1,lsum,rsum);      //oher wise call functipomn
    	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {2,4,3};
		System.out.println(splitArray(arr,0,0,0));
		
	}

}
