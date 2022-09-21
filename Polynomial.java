public class Polynomial{
	double [] coefficient;

	public Polynomial() {
		coefficient = new double[100];
		for (int i=0; i<coefficient.length; i++) {
			coefficient[i] = 0;
		}
	}
	//  the entire array = [0,0,..]

	public Polynomial(double [] a) {
		coefficient = new double[100];
		for (int i=0; i<a.length; i++) {
			coefficient[i] = a[i];
		}
	}
	
	public Polynomial add(Polynomial p){
		//Polynomial [] sum = coefficient.length;
		for (int i=0; i<coefficient.length; i++) {
			coefficient[i] = p.coefficient[i] + coefficient[i];
		}
		return this;
	}
	
	public double evaluate(double d){
		double result = coefficient[0];
		for (int i=1; i<coefficient.length; i++) {
			result = result + coefficient[i]*Math.pow(d,i);
			
		}
		return result;
	}

	public boolean hasRoot(double x){
		if (evaluate(x)==0) {
			return true; 
		}
		else
			return false; 
	}
}