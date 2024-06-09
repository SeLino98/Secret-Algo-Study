import java.util.*;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			String str = sc.nextLine();
			if(str.equals("0")) {
				break;
			}else {
				
				char[] list = str.toCharArray();
				boolean yes = true;
				for (int i = 0; i < (list.length/2); i++) {
					if(list[i] == list[list.length-i-1]){
						
					}else {
						yes = false;
					}
				}
				if(yes) {
					System.out.println("yes");
				}else{
					System.out.println("no");
				}
			}
		}
	}

}
