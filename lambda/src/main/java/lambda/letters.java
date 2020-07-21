package lambda;
import java.util.*;
import java.util.stream.Collectors;

public class letters {
	public static void main(String[] args){
	List<String> sn=Arrays.asList("abc","abcd","niki","nic","ani");
	System.out.println(search(sn));
	}
	public static List<String> search(List<String> sh) {
	return sh.stream()
	  .filter(s -> s.startsWith("a"))
	  .filter(s -> s.length() == 3)
	  .collect(Collectors.toList());

	}
	}
