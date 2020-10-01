package DecryptionsAlgorithms;

import java.util.List;
import java.util.stream.Collectors;

//Шифр Цезаря
public class Caesar {
    public final String ruAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";   //Алфавит
    public final int step = 3;                                              //Величина сдвига
    public List<Character> alphChars = convertStringToCharList(ruAlphabet);

    //Дешифрование
    public String caesarDecrypt(String mail){
        StringBuilder decryptedMail = new StringBuilder();

        List<Character> mailChars;
        mailChars = convertStringToCharList(mail);

        for(char c : mailChars){
            if(alphChars.contains(c)){
                int index = alphChars.indexOf(c);
                index-=step;
                if(index < 0){
                    index = alphChars.size() - Math.abs(index);
                    decryptedMail.append(alphChars.get(index));
                }else{
                    decryptedMail.append(alphChars.get(index));
                }
                System.out.println(c + " -> " + alphChars.get(index));
            }
        }
        return decryptedMail.toString();
    }

    //Получаем charList алфавита
    public List<Character> convertStringToCharList(String str){
        return str
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
    }
}
