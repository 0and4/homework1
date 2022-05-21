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
		int lastIndex = preWord.length() - 1; //���� �ܾ��� ������ �ε��� ����
		char lastChar = preWord.charAt(lastIndex); //���� �ܾ��� ������ ����
		char firstChar = inword.charAt(0); //�Է��� �ܾ��� ù��° ����
		if(lastChar == firstChar) {
			check = true;
		}
		return check;
	}
}
class WordGameApp {
	private String startWord = "��������";
	private Player [] p;
	int num = 0;
	Scanner sc = new Scanner(System.in);
	private void createPlayers() {
		System.out.print("���ӿ� �����ϴ� �ο��� ����Դϱ�>> ");
		num = Integer.parseInt(sc.nextLine());
		p = new Player[num];
		for(int i = 0; i < num; i++) {
			p[i] = new Player("");
		}
	}
	void run() {
		createPlayers();
		for(int i = 0; i < num; i++) {
			System.out.print("�������� �̸��� �Է��ϼ���>> ");
			p[i].setName(sc.nextLine());
		}
		String lastWord = startWord;
		System.out.println("�����ϴ� �ܾ�� " + startWord + "�Դϴ�.");
		int index = 0;
		
		while(true) {
			String newWord = p[index].getWord();
			if(p[index].check(lastWord)==false) {
				System.out.println(p[index].getName() + "�� �����ϴ�.");
				break;
			}
			lastWord = newWord;
			index++;
			index %= p.length; // �����ڰ� ���ư��鼭 �����ձ� - �ε��� ���� �ݺ�
		}
	}
	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();
	}
}