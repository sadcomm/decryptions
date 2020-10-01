package Application;

import DecryptionsAlgorithms.Caesar;
import DecryptionsAlgorithms.MultiReplacement;

import java.util.Scanner;

public class Main {

    public static void menu(){
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.println("1. Цезарь");
            System.out.println("2. Многоалфавитная замена");
            System.out.println("5. Выход");
            int b = in.nextInt();
            switch (b){
                case 1:
                    Caesar caesar = new Caesar();
                    String cryptedMessage = "ШОГЖСРЫЗФХЯНЁ";
                    String decryptedMessageByCaesar = caesar.caesarDecrypt(cryptedMessage);
                    System.out.print(cryptedMessage + " -> ");
                    System.out.println(decryptedMessageByCaesar);
                    break;
                case 2:
                    MultiReplacement mr = new MultiReplacement();
                    System.out.println("Таблица с ключами:");
                    mr.showKeyTable();
                    System.out.println("Таблица Вижинера:");
                    mr.showViginerTable();
                    StringBuilder decryptedMessageByMR = mr.MRDecrypt();
                    System.out.print("Расшифрованное сообщение: ");
                    System.out.println(decryptedMessageByMR);
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            if (b==5){
                break;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
