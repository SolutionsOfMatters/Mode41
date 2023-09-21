package io.getarrays.start_up_admin.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Main {
        public static void main(String[] args) {
            int[] numbers = {432, 331, 192, 108, 180, 50, 231, 188, 105, 51, 364, 168, 344, 195, 297, 342, 292, 198, 448, 62, 236, 342, 63};

            StringBuilder decryptedMessage = new StringBuilder();

            for (int num : numbers) {
                // Step 1: Find num modulo 41
                int moduloResult = num % 41;

                // Step 2: Find the modular inverse
                int modularInverse = findModularInverse(moduloResult, 41);

                // Step 3: Map to character set
                char mappedChar;
                if (1 <= modularInverse && modularInverse <= 26) {
                    mappedChar = (char) ('A' + modularInverse - 1);
                } else if (27 <= modularInverse && modularInverse <= 36) {
                    mappedChar = (char) ('0' + modularInverse - 27);
                } else if (modularInverse == 37) {
                    mappedChar = '_';
                } else {
                    // Handle any other cases
                    mappedChar = '?'; // Replace with an appropriate character if needed
                }

                decryptedMessage.append(mappedChar);
            }

            // Print the result in the picoCTF flag format
            System.out.println("picoCTF{" + decryptedMessage.toString() + "}");
        }

    // Function to find the modular inverse using the extended Euclidean algorithm
    private static int findModularInverse(int a, int m) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger modularInverse = bigA.modInverse(bigM);
        return modularInverse.intValue();
    }

}
