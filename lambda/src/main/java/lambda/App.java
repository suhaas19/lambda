package lambda;
import java.util.*;

public class App {
	public static void main(String[] args){
	final List<Integer> primes=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
	primes.stream()
	         .mapToInt(i->i)
	         .average()
	         .ifPresent(avg->System.out.println(avg));
	    }
	}