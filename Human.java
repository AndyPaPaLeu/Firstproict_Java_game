package Exception;

public class Human {
int hp = 100;
int atk = 10;
int def = 4;
int 自我恢復 =10;
int count = 0;

public int 自我恢復() {
	if (自我恢復<0) {
		自我恢復=0;
		System.err.println("過度使用，自我恢復已失效");	
		return 自我恢復; 
	} else {
		自我恢復 -= count;
		count++;
		return 自我恢復;
	}
}
	
	
}
