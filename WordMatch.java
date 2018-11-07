package hangmanGame;

import java.util.Arrays;
import java.util.Random;

class WordMatch {
    public String[] hangmanWords = {"play", "game", "hangman", "picture", "welcome"};
    public String hangmanTemp;
    public char[] hangmanLetters,charArray, charArrayTest;
    public char[] hangmanBlank = {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
        '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',};
    
    public char[] usedLetterList = {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
        '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',};
 
    boolean winOrLoose,wrongChoice,usedLetter;
    int wrongGuess;
    Random random;

    public void chooseWord() {
        random = new Random();
        hangmanTemp = hangmanWords[random.nextInt(hangmanWords.length)];
        charArrayTest = hangmanTemp.toCharArray();
        hangmanLetters = hangmanTemp.toCharArray();
        charArray = hangmanTemp.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArrayTest[i] = hangmanBlank[i];
            hangmanLetters[i] = hangmanBlank[i];
        }

    }

    public void checkWord(char ch) {
        usedLetter = false;
        wrongChoice = false;
        char c = '-';
        int temp = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ch) {
                hangmanLetters[i] = ch;
            }
        }
        for (int i = 0; i < usedLetterList.length; i++) {
            if (usedLetterList[i] == ch) {
                usedLetter = true;
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ch && wrongChoice == false) {
                wrongChoice = true;
            }
        }
        if (usedLetter == false) {
            for (int i = 0; i < usedLetterList.length; i++) {
                if (usedLetterList[i] == c) {
                    temp = i;
                    break;
                }
            }
            usedLetterList[temp] = ch;
        }
        if (wrongChoice == false) {
            wrongGuess = wrongGuess + 1;
            if (usedLetter == true) {
                wrongGuess = wrongGuess - 1;
            }
        }
        winOrLoose = Arrays.equals(charArray, hangmanLetters);
    }

}
