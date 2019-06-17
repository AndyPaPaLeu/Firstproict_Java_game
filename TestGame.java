package Exception;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TestGame {

	
//	public void 勝負判定(Object 玩家A,Object 玩家B) {
//	if (玩家B.get玩家hp() <= 0 && 玩家A.get玩家hp() <= 0) {
//		System.out.println("平手");
//		break;
//	} else if (玩家B.get玩家hp() <= 0) {
//		System.out.println(玩家A.get玩家名稱() + "獲勝");
//		break;
//	} else if (玩家A.get玩家hp() <= 0) {
//		System.out.println(玩家B.get玩家名稱() + "獲勝");
//		break;
//	}
//	}
	
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入玩家A的名稱");
		System.out.print("=>");
		String 玩家A名稱 = sc.nextLine();
		System.out.println("請輸入玩家B的名稱");
		System.out.print("=>");
		String 玩家B名稱 = sc.nextLine();

		人類戰士 玩家A = new 人類戰士(玩家A名稱);

		玩家A.能力加成();
		LinkedHashMap<String, String> 玩家A技能 = new LinkedHashMap<>();
		for (int i = 0; i < 玩家A.技能.length; i += 2) {
			玩家A技能.put(玩家A.技能[i], 玩家A.技能[i + 1]);
		}

		人類戰士 玩家B = new 人類戰士(玩家B名稱);
		玩家B.能力加成();
		LinkedHashMap<String, String> 玩家B技能 = new LinkedHashMap<>();
		for (int i = 0; i < 玩家B.技能.length; i += 2) {
			玩家B技能.put(玩家B.技能[i], 玩家B.技能[i + 1]);
		}

		int 玩家A動作 = 0;
		int 玩家B動作 = 0;
		do {
			do {
				try {
					System.out.println(玩家A.get玩家名稱() + "請輸入使用招式的順序號碼 ");
//					for (Entry<String, String> string : 玩家A技能.entrySet()) {
//						System.out.println(string);
//					}
					int 招式號碼 = 0;
					Iterator<Entry<String, String>>  iiIterator = 玩家A技能.entrySet().iterator();
					while (iiIterator.hasNext()) {
						招式號碼++;
						Map.Entry<String, String> entry = iiIterator.next();
						System.out.println(招式號碼+")"+entry.getKey()+"\t預計產生效果(初步)\t"+entry.getValue());
					}
	
					
					System.out.print("=>");
					int 動作 = Integer.parseInt(sc.nextLine()); 
					if (動作 > 玩家A技能.size()) {
						throw new ArithmeticException();
					} else {
						玩家A動作 = 動作;
						break;
					}
				} catch (Exception e) {
					System.err.println("輸入錯誤");
				}
			} while (true);

			switch (玩家A動作) {
			case 1:
				玩家B.set玩家hp(玩家B.get玩家hp() - (玩家A.一般攻擊() - 玩家B.get玩家def()));
				System.out.println(玩家B.get玩家名稱() + "受了" + 玩家A.一般攻擊damage + "傷害，血量還剩" + 玩家B.get玩家hp());
				break;
			case 2:
				玩家B.set玩家hp(玩家B.get玩家hp() - (玩家A.捨身攻擊() - 玩家B.get玩家def()));
				System.out.println(玩家B.get玩家名稱() + "受了" + 玩家A.捨身攻擊damage + "傷害，血量還剩" + 玩家B.get玩家hp());
				玩家A.set玩家hp(玩家A.get玩家hp() - (玩家B.get玩家atk()));
				System.out.println(玩家A.get玩家名稱() + "受到反擊，損失" + 玩家B.get玩家atk() + "滴血，血量還剩" + 玩家A.get玩家hp());
				break;
			case 3:
				玩家A.set玩家hp(玩家A.get玩家hp() + 玩家A.自我恢復());
				System.out.println(玩家A.get玩家名稱() + "血量還剩" + 玩家A.get玩家hp());
				break;
			default:
				break;
			}
			System.out.println();
			if (玩家B.get玩家hp() <= 0 && 玩家A.get玩家hp() <= 0) {
				System.err.println("無人生還");
				break;
			} else if (玩家B.get玩家hp() <= 0) {
				System.err.println(玩家A.get玩家名稱() + "獲勝");
				break;
			} else if (玩家A.get玩家hp() <= 0) {
				System.err.println(玩家B.get玩家名稱() + "獲勝");
				break;
			}

			do {
				try {
					System.out.println(玩家B.get玩家名稱() + "請輸入使用招式的順序號碼 ");
//					for (Entry<String, String> string : 玩家B技能.entrySet()) {
//						System.out.println(string);
//					}
					int 招式號碼 = 0;
					Iterator<Entry<String, String>>  iiIterator = 玩家A技能.entrySet().iterator();
					while (iiIterator.hasNext()) {
						招式號碼++;
						Map.Entry<String, String> entry = iiIterator.next();
						System.out.println(招式號碼+")"+entry.getKey()+"\t預計產生效果(初步)\t"+entry.getValue());
					}
					System.out.print("=>");
					int 動作 = Integer.parseInt(sc.nextLine()); 
					if (動作 > 玩家B技能.size()) {
						throw new ArithmeticException();
					} else {
						玩家B動作 = 動作;
						break;
					}
				} catch (Exception e) {
					System.err.println("輸入錯誤");
				}
			} while (true);

			switch (玩家B動作) {
			case 1:
				玩家A.set玩家hp(玩家A.get玩家hp() - (玩家B.一般攻擊() - 玩家A.get玩家def()));
				System.out.println(玩家A.get玩家名稱() + "受了" + 玩家B.一般攻擊damage + "傷害，血量還剩" + 玩家A.get玩家hp());
				break;
			case 2:
				玩家A.set玩家hp(玩家A.get玩家hp() - (玩家B.捨身攻擊() - 玩家A.get玩家def()));
				System.out.println(玩家A.get玩家名稱() + "受了" + 玩家B.捨身攻擊damage + "傷害，血量還剩" + 玩家A.get玩家hp());
				玩家B.set玩家hp(玩家B.get玩家hp() - (玩家A.get玩家atk()));
				System.out.println(玩家B.get玩家名稱() + "受到反擊，損失" + 玩家A.get玩家atk() + "滴血，血量還剩" + 玩家B.get玩家hp());
				break;
			case 3:
				玩家B.set玩家hp(玩家B.get玩家hp() + 玩家B.自我恢復());
				System.out.println(玩家B.get玩家名稱() + "血量還剩" + 玩家B.get玩家hp());
				break;
			default:
				break;
			}
			System.out.println();
			if (玩家B.get玩家hp() <= 0 && 玩家A.get玩家hp() <= 0) {
				System.out.println("無人生還");
				break;
			} else if (玩家B.get玩家hp() <= 0) {
				System.out.println(玩家A.get玩家名稱() + "獲勝");
				break;
			} else if (玩家A.get玩家hp() <= 0) {
				System.out.println(玩家B.get玩家名稱() + "獲勝");
				break;
			}

		} while (true);
		
//Object aaObject = 玩家A;
//aaObject.
		
	}

	public static 人類戰士  winner(人類戰士 A, 人類戰士 B) {
		
		if (A.get玩家hp() <= 0 && B.get玩家hp() <= 0) {
			System.out.println("無人生還");
			return null;
		} else if (B.get玩家hp() <= 0) {
			System.out.println(A.get玩家名稱() + "獲勝");
			return A;
		} else if (A.get玩家hp() <= 0) {
			System.out.println(B.get玩家名稱() + "獲勝");
			return B;
		}

		return null;
		
	}
	
	
}
