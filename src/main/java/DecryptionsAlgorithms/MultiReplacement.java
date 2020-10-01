package DecryptionsAlgorithms;

import java.util.Arrays;
import java.util.List;

public class MultiReplacement extends Caesar{
    private final char[] keyArr = {'П','О','Б','Е','Д','А'};
    private final int SIZE = 32;
    private final String ruAlphabet2 = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public List<Character> alphChars2 = convertStringToCharList(ruAlphabet2);

    public StringBuilder MRDecrypt(){
        StringBuilder message = new StringBuilder();
        char[][] keyArr = keyTable();
        char[][] vigArr = ViginerTable();
        for (int i =0;i<keyArr[0].length;i++){
            char symb = keyArr[0][i];
            char key = keyArr[1][i];
            for(int a =1;a<vigArr.length;a++){
                for (int b = 0; b < vigArr[a].length; b++) {
                    if (key == vigArr[a][0] && symb == vigArr[a][b]) {
                        message.append(vigArr[0][b]);
                    }
                }
            }

        }
        return message;
    }
    public void showKeyTable(){
        char[][] arr = keyTable();
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar + "|");
            }
            System.out.println();
        }
    }

    public char[][] keyTable(){
        String replacementSymbols = "ДЬЦУЦОЫГПЪТТПЩЙНОРЧЕБРМТВЮЛКООБЬСАННПЕЖХСОЭПЛШФЕЪ";
        List<Character> symbChars = convertStringToCharList(replacementSymbols);
        char[][]arr = new char[2][symbChars.size()];
        for (int i = 0;i < arr.length; i++){
            if(i == 0){
                for (int j = 0; j < arr[i].length; j++){
                    arr[i][j] = symbChars.get(j);
                }
            }else{
                int keyCounter = 0;
                for (int j = 0; j < arr[i].length; j++){
                    arr[i][j] = keyArr[keyCounter];
                    if (keyCounter == keyArr.length-1){
                        keyCounter = 0;
                    }else keyCounter++;
                }
            }
        }
        return arr;
    }

    public void showViginerTable(){
        char[][] arr = ViginerTable();
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar + "|");
            }
            System.out.println();
        }
    }

    public char[][] ViginerTable(){
        char[][] arr = setMatrix();
        char[][] vigArr = new char[1 + keyArr.length][arr.length];
        vigArr[0] = arr[0];
        for(int i =0;i<keyArr.length;i++){
            for (char[] chars : arr) {
                if (keyArr[i] == chars[0]) {
                    vigArr[i+1] = chars;
                }
            }
        }
        return vigArr;
    }

    public char[][] setMatrix(){
        char[][] matrix = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = alphChars2.get(j);
            }
            alphChars2 = Arrays.asList(leftShift());
        }
        return matrix;
    }

    public Character[] leftShift(){
        Character[] result = new Character[SIZE];
        int startFrom = 0;
        for(int  i = 0; i < SIZE; ++i)
        {
            if(1 + i < SIZE)
            {
                result[i] = alphChars2.get(1 + i);
            } else {
                result[i] = alphChars2.get(startFrom);
                ++startFrom;
            }
        }
        return result;
    }

}
