package net.projecteuler.level003;

import java.io.IOException;
import java.io.InputStream;

import net.projecteuler.level001.Problem0022;
import net.projecteuler.utils.Utils;

/*
 * Each character on a computer is assigned a unique code and the preferred standard is ASCII
 * (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*)
 * = 42, and lowercase k = 107.
 *
 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte
 * with a given value, taken from a secret key. The advantage with the XOR function is that using
 * the same encryption key on the cipher text, restores the plain text; for example, 65 XOR 42 =
 * 107, then 107 XOR 42 = 65.
 *
 * For unbreakable encryption, the key is the same length as the plain text message, and the key is
 * made up of random bytes. The user would keep the encrypted message and the encryption key in
 * different locations, and without both "halves", it is impossible to decrypt the message.
 *
 * Unfortunately, this method is impractical for most users, so the modified method is to use a
 * password as a key. If the password is shorter than the message, which is likely, the key is
 * repeated cyclically throughout the message. The balance for this method is using a sufficiently
 * long password key for security, but short enough to be memorable.
 *
 * Your task has been made easy, as the encryption key consists of three lower case characters.
 * Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted
 * ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the
 * message and find the sum of the ASCII values in the original text.
 */
public class Problem0059 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0059::first_try);

  }

  public static void first_try() {

    int[] seq = load();

    // Utils.print_seq_to_num(seq);

    System.out.println((int) 'a');
    System.out.println((int) 'z');
    System.out.println((int) 'A');
    System.out.println((int) 'Z');

    int min = 'a';
    int max = 'z';

    for (int a = min; a <= max; a++) {
      for (int b = min; b <= max; b++) {
        for (int c = min; c <= max; c++) {

          StringBuilder sb = new StringBuilder();

          int[] key = new int[] { a, b, c };

          int sum = 0;

          for (int i = 0; i < seq.length; i++) {

            int en = seq[i] ^ key[i % key.length];

            sb.append((char) en);

            sum += en;

          }

          String s = sb.toString();

          if (s.contains("The") && s.contains("the")) {
            System.out.println(sum);
            System.out.println(sb.toString());
          }

        }
      }
    }

  }

  public static int[] load() {

    int[] seq = null;

    InputStream isr = Problem0022.class.getClassLoader()
        .getResourceAsStream("net/projecteuler/res/p059_cipher.txt");

    int i = 0;
    StringBuilder sb = new StringBuilder();
    try {
      while ((i = isr.read()) != -1) {
        sb.append((char) i);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String[] s = sb.toString().split("[,]");

    seq = new int[s.length];

    for (i = 0; i < s.length; i++) {
      seq[i] = Integer.parseInt(s[i]);
    }

    return seq;
  }

}
