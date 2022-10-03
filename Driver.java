public class Driver { 
	public static void main(String [] args) { 
		double [] c1 = {3,1,4};
        int [] e1 = {1,0,3};
        Polynomial p1 = new Polynomial(c1,e1);
        double [] c2 = {5,6,7,4,2};
        int [] e2 = {4,1,7,5,6};
        Polynomial p2 = new Polynomial(c2,e2);
        for(int i = 0; i < p1.exponents.length; i++) {
            System.out.println("P1 array exponent at= " + p1.exponents[i]);
            System.out.println("P1 array coeff = " + p1.non_zero[i]);
        }
        for(int i = 0; i < p2.exponents.length; i++) {
            System.out.println("P2 array exponent at = " + p2.exponents[i]);
            System.out.println("P2 array coeff = " + p2.non_zero[i]);

        }
        Polynomial result = p1.add(p2);
        for(int i = 0; i < result.exponents.length; i++) {
            System.out.println("result array exponent = " + result.exponents[i]);
            System.out.println("result array coeff = " + result.non_zero[i]);

          

		System.out.println("p1(0.1) = " + p1.evaluate(0.1)); 

		if(p1.hasRoot(1)) 
			System.out.println("1 is a root of p1"); 
		else 
			System.out.println("1 is not a root of p1"); 
		 } 
		double [] c3 = {1,4};
	    int [] e3 = {0,3};
	    Polynomial p3 = new Polynomial (c3,e3);
	    double [] c4 = {6,5,7};
	    int [] e4 = {1,4,7};
	    Polynomial p4 = new Polynomial (c4,e4);
	
	    Polynomial sum = p3.multiply(p4);
	    for(int i = 0; i < sum.exponents.length; i++) {
	        System.out.println("result array exponent = " + sum.exponents[i]);
	        System.out.println("result array coeff = " + sum.non_zero[i]);
	}
	    p1.saveToFile("POPO.txt");
	}
}
        