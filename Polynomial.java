import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Polynomial{
	double [] non_zero;
	int [] exponents;

	public Polynomial() {
		non_zero = new double[100];
		exponents = new int[100];
		for (int i=0; i<non_zero.length; i++) {
			non_zero[i] = 0;
			exponents[i]=0;
		}
	}
	//  the entire array = [0,0,..]

	public Polynomial(double [] a, int [] e) {
		non_zero = new double[a.length];
		exponents = new int[e.length];
		for (int i=0; i<a.length; i++) {
			non_zero[i] = a[i];
			exponents[i] = e[i];
		}
	}
	
	public Polynomial(File file) {
		try {
			scanner reader = new FileReader (file);
			
			String x = "";
			x = x.concat(reader.readLine());
			
			
			reader.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
    }		
		
	
	public int max_expo(int [] expo) {
		int max_1 = 0; 
		int max_2 = 0;
		
		for (int i=0; i<this.exponents.length; i++) {
			max_1 = Math.max(max_1, this.exponents[i]);
			}
		for (int i=0; i<expo.length; i++) {
			max_2 = Math.max(max_2, expo[i]);
			}
		return Math.max(max_1, max_2);
	}
	
	public Polynomial add(Polynomial p){
		// find length of biggest input array (this or p
		int big_length = Math.max(this.exponents.length, p.exponents.length);
		
		//initialize a new polynomial named result
		int result_len = this.max_expo(p.exponents) + 1;
		double [] coef_result = new double [result_len];
		int [] expo_result = new int [result_len];
		Polynomial result = new Polynomial(coef_result, expo_result);
		
		// set coef_result to [0,..0]
		for (int i=0; i<result_len; i++) {
			result.non_zero[i]=0;
		}
		
		// set expo_result to [0,1,..max expo]
		for (int j=0; j<result_len; j++) {
			result.exponents[j]=j;
		}
		
		
		// adding this to result
		for (int k=0; k<exponents.length; k++) {
			int index = exponents[k]; 
					
			result.non_zero[index] = non_zero[k]; 
		}
		//adding p to result
		for (int l=0; l<p.exponents.length; l++) {
			int index = p.exponents[l]; 
					
			result.non_zero[index]= result.non_zero[index]+ p.non_zero[l]; 
		}
		
		return result;
	}
	
	public double evaluate(double d){
		double result = 0;
		for (int i=0; i<non_zero.length; i++) {			
			result = result + non_zero[i]*Math.pow(d,exponents[i]);
			
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
	
	
	public Polynomial multiply (Polynomial p) {
	//find length of the result
		int max_1 = 0;
		int max_2 = 0;
		for (int i=0; i<this.exponents.length; i++) {
			max_1 = Math.max(max_1, this.exponents[i]);
			}
		for (int i=0; i<p.exponents.length; i++) {
			max_2 = Math.max(max_2, p.exponents[i]);
			}
		int result_len = max_1 + max_2 +1;
		
	// initialize result of type Polynomial
		double [] coef_result = new double [result_len];
		int [] expo_result = new int [result_len];
		Polynomial result = new Polynomial(coef_result, expo_result);
		
	// set exponents array
		for (int j=0; j<result_len; j++) {
			result.exponents[j]=j;
		}
		
	// multiply
		
		for (int i=0; i<this.exponents.length; i++) {
			for (int j=0; j<p.exponents.length;j++) {
				int index = this.exponents[i]+ p.exponents[j];
				result.non_zero[index] = result.non_zero[index] + (this.non_zero[i]*p.non_zero[j]);
			}
		}
		return result;
		
		
	}
	

	
	public void saveToFile (String s) {
		 try {
	            FileWriter file_ = new FileWriter(s);
	            String result = "";
	            
	            if (this.exponents[0]==0) {
	            	result = result.concat(Double.toString(this.non_zero[0]));
	            }
	            else {
	            	 result = result.concat(Double.toString(this.non_zero[0])+"x"+Integer.toString(this.exponents[0]));
	            }
	           
	            for (int i = 1; i < this.exponents.length; i++) {
	                if(this.non_zero[i] >= 0) {
	                    if (this.exponents[i] ==0) {
	                    	result = result.concat("+"+Double.toString(this.non_zero[i]));
	                    }
	                    else {
	                    	result = result.concat("+"+Double.toString(this.non_zero[i])+"x"+Integer.toString(this.exponents[i]));
	                    }

	                }
	                else {
	                	  if (this.exponents[i] ==0) {
		                    	result = result.concat("+"+Double.toString(this.non_zero[i]));
		                    }
		                    else {
		                    	result = result.concat(Double.toString(this.non_zero[i])+"x"+Integer.toString(this.exponents[i]));
		                    }
	                }

	            }
	            file_.write(result);
	            file_.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }		

}
