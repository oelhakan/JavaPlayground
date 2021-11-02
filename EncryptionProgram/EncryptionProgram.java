package EncryptionProgram;

import java.util.*;

public class EncryptionProgram {

    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    private char[] secretLetters;

    EncryptionProgram() {
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList();
        shuffledList = new ArrayList();
        character = ' ';

        newKey();
        askQuestion();
    }

    private void askQuestion() {
        while (true) {
            System.out.println();
            System.out.println("*********************************************");
            System.out.println("What Do You Want To Do?");
            System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
            //get the 1st letter of the user response
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }
    }

    private void newKey() {
        character = ' ';
        list.clear();
        shuffledList.clear();

        // ' ' = 32 in the ASCII Table
        // ADD ALL THE ELEMENTS IN THE ASCII TABLE FROM 32 TO 127 TO THE LIST
        // THEN TO GET A RANDOM SHUFFLED LIST USE COLLENTIONS.SHUFFLE
        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("A NEW KEY HAS BEEN GENERATED");
    }

    private void getKey() {
        System.out.println("Key : ");
        for (Character x : list) {
            System.out.print(x);
        }
        System.out.println();
        for (Character x : shuffledList) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void encrypt() {
        System.out.println("Enter A Message To Be Encrypted : ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted Message : ");
        for (char x : letters) {
            System.out.print(x);
        }
    }

    private void decrypt() {
        System.out.println("Enter A Message To Be Decrypted : ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == shuffledList.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted Message : ");
        for (char x : letters) {
            System.out.print(x);
        }
    }

    private void quit() {
        System.out.println("Thank You. Exiting Program.");
        System.exit(0);
    }
}
