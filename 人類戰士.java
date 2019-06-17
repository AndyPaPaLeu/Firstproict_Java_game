package Exception;

import java.util.HashMap;
import java.util.Set;

public class 人類戰士 extends Human implements 戰士{
	
	private String 玩家名稱;
	private int 玩家hp = 	super.hp;
	private int 玩家atk = super.atk;
	private int 玩家def = super.def;
	int 一般攻擊damage = 10;
	String [] 技能 = {"一般攻擊",Integer.toString(一般攻擊damage),"捨身攻擊",Integer.toString(捨身攻擊damage),"自我恢復",Integer.toString(自我恢復)};
	
	人類戰士(String name){
		玩家名稱 = name;
	}
	
	public int 一般攻擊() {
		System.out.println(玩家名稱+"使用了一般攻擊");
		return 一般攻擊damage;
	}
	
	@Override
	public int 捨身攻擊() {
		System.out.println(玩家名稱+"使用了捨身攻擊");
		return 捨身攻擊damage;
		
	}

	@Override
	public int 自我恢復() {
		System.out.println(玩家名稱+"使用了自我恢復，將可恢復"+super.自我恢復+"血量");
		super.自我恢復();
		return super.自我恢復;
	}
	
	@Override
	public void 能力加成() {
		System.out.println("玩家名稱"+this.玩家名稱);
		this.玩家hp += ihp;
		System.out.println("血量\t"+this.玩家hp);
		this.玩家atk += iatk;
		System.out.println("攻擊力\t"+this.玩家atk);
		this.玩家def += idef;
		System.out.println("防禦力\t"+this.玩家def);
	}

	public String get玩家名稱() {
		return 玩家名稱;
	}

	public int get玩家hp() {
		return 玩家hp;
	}

	public void set玩家hp(int 玩家hp) {
		this.玩家hp = 玩家hp;
	}

	public int get玩家atk() {
		return 玩家atk;
	}

	public void set玩家atk(int 玩家atk) {
		this.玩家atk = 玩家atk;
	}

	public int get玩家def() {
		return 玩家def;
	}

	public void set玩家def(int 玩家def) {
		this.玩家def = 玩家def;
	}


	
	
	
	
	}
	
