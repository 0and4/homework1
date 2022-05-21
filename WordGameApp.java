package hw1;
import java.util.Scanner;
class Player {
	private String name;
	private String inword;
	public Player() { this.name=null;}
	public Player(String name) {
		this.name=name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	String getWord() {
		Scanner sc = new Scanner(System.in);
		System.out.print(name + ">> ");
		inword = sc.nextLine();
		return inword;
	}
	boolean check(String preWord) {
		boolean check = false;
		int lastIndex = preWord.length() - 1; //이전 단어의 마지막 인덱스 설정
		char lastChar = preWord.charAt(lastIndex); //이전 단어의 마지막 글자
		char firstChar = inword.charAt(0); //입력한 단어의 첫번째 글자
		if(lastChar == firstChar) {
			check = true;
		}
		return check;
	}
}
class WordGameApp {
	private String startWord = "와이파이";
	private Player [] p;
	int num = 0;
	Scanner sc = new Scanner(System.in);
	private void createPlayers() {
		System.out.print("게임에 참가하는 인원은 몇명입니까>> ");
		num = Integer.parseInt(sc.nextLine());
		p = new Player[num];
		for(int i = 0; i < num; i++) {
			p[i] = new Player("");
		}
	}
	void run() {
		createPlayers();
		for(int i = 0; i < num; i++) {
			System.out.print("참가자의 이름을 입력하세요>> ");
			p[i].setName(sc.nextLine());
		}
		String lastWord = startWord;
		System.out.println("시작하는 단어는 " + startWord + "입니다.");
		int index = 0;
		
		while(true) {
			String newWord = p[index].getWord();
			if(p[index].check(lastWord)==false) {
				System.out.println(p[index].getName() + "이 졌습니다.");
				break;
			}
			lastWord = newWord;
			index++;
			index %= p.length; // 참가자가 돌아가면서 끝말잇기 - 인덱스 값은 반복
		}
	}
	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();
	}
}