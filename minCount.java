	public static int minCount(int n){
		/*
		Given an integer N, find and return the count of minimum numbers, sum of whose squares is equal to N.
		That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
		 Output will be 1, as 1 is the minimum count of numbers required. 
		 */
		
		//if n==1 then only 1^2 is posible min
        //if n==2 then only 1^2 + 1^2 i.e. two count possible
        //if n==3 then only 1^2 + 1^2 + 1^2, i.e. three count possible
        //this is the base case that if n<=3 return n 
        if(n<=3) return n;
        //if input 4 its max to max count can be 1^2 + 1^2 + 1^2 + 1^2  ,count=4 possible i.e count not >the number which given
        int maxTomaxCount =n;
		int square =0;
        int count=0;
        for(int i=1 ; i<n ; i++){
            square =i*i;
            if(square >n) break;
            count=minCount(n-square) + 1;  //acc to recursion find n-i*i you can get
            //compare both count which min we choose
            maxTomaxCount=(count<maxTomaxCount) ? count : maxTomaxCount ;
        }
        return maxTomaxCount;
		
	}
