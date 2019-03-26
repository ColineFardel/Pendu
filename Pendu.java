import java.util.Scanner;

public class Pendu {

	public static void main(String[] args) {
		
		Scanner saisie = new Scanner(System.in);
		
		System.out.println("Devez vous deviner (1) ou faire deviner (2)? ");
		int role = saisie.nextInt();
		
		if(role==1) {
			jouer();
		}
		if(role==2) {
			System.out.println(créerCode(demandeMot()));
		}
		
		
	}
	public static String demandeMot() {
		Scanner saisie = new Scanner(System.in);
		System.out.println("Entrez votre mot : ");
		return saisie.next();
	}
	public static String créerCode(String mot) {
		String code="";
		for(int i=0;i<mot.length();i++) {
			int lettre;
			lettre=mot.charAt(i)+4;
			code=code+(char)lettre;
		}
		System.out.println("Donnez ce code à votre adversaire :");
		return code;
	}
	public static String traduireCode(String code) {
		String mot="";
		for(int i=0;i<code.length();i++) {
			int lettre;
			lettre=code.charAt(i)-4;
			mot=mot+(char)lettre;
		}
		return mot;
	}
	public static char[] essayerLettre(char lettre,String mot,char [] devine) {
		for(int i=0;i<mot.length();i++) {
			if(lettre==mot.charAt(i)) {
				devine[i]=lettre;
			}
		}
		return devine;
	}
	public static char donnerLettre() {
		Scanner saisie = new Scanner(System.in);
		System.out.println("Entrez votre lettre : ");
		return saisie.next().charAt(0);
	}
	public static String donnerCode() {
		Scanner saisie = new Scanner(System.in);
		System.out.println("Entrez le code de votre adversaire : ");
		return saisie.next();
	}
	public static void montrerMot(char[] devine) {
		for(int i=0;i<devine.length;i++) {
			System.out.print(devine[i]+" ");
		}
	}
	public static boolean estMeme(char t1[], char t2[]) {
		for(int i=0;i<t1.length;i++) {
			if(t1[i]!=t2[i]) {
				System.out.println(t1[i]+" "+t2[i]);
				return false;
			}
				
		}
		return true;
	}
	public static void copie(char t1[],char t2[]) {
		for(int i=0;i<t1.length;i++) {
			t1[i]=t2[i];
		}
	}
	public static void jouer() {
		String code=donnerCode();
		String mot=traduireCode(code);
		char [] devine= new char [mot.length()];
		System.out.println("Vous pouvez commencer");
		for(int i=0;i<devine.length;i++) {
			devine[i]='_';
			System.out.print(devine[i]+" ");
		}
		System.out.println();
		
		String devineMot="";
		int cpt;
		for(int i=0;i<10;) {
			cpt=0;
			for(int j=0;j<devine.length;j++) {
				if(devine[j]==mot.charAt(j))
					cpt++;
				if(cpt==mot.length()) {
					System.out.println("Vous avez gagné ! Le mot était : ");
					i=10;
					montrerMot(devine);
					return;
				}
			
			}
				
			char lettre=donnerLettre();
			
			char temp [] = new char[devine.length];
			
			copie(temp,devine);
			
			devine=essayerLettre(lettre,mot,devine);
			
			int reste=0;
			
			if(estMeme(temp,devine)) {
				i++;
			}
				
			montrerMot(devine);
			System.out.println();
			
			reste=10-i;
			System.out.println("Il vous reste "+reste+" essais");
			
			if(i==10) {
				System.out.println("Vous avez perdu ! Le mot était : "+mot);
			}
			
		}
	}
	

}
