package testpackage;

import java.util.Stack;

public class DisplayNumbersinRever {


public static void main(String[] args) {
        String input = "abc12java34uji234";
        StringBuilder output = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                numberBuffer.append(ch);
            } else {
                if (numberBuffer.length() > 0) {
                    output.append(numberBuffer.reverse());
                    numberBuffer.setLength(0); // clear buffer
                }
                output.append(ch);
            }
        }

        // Append any remaining reversed digits
        if (numberBuffer.length() > 0) {
            output.append(numberBuffer.reverse());
        }

        System.out.println("Output string: " + output.toString());
    }


}
