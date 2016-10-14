import org.junit.Test;
import ucb.junit.textui;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/** String translation.
 *  @author Zhipeng Yu
 */
public class Translate {
    /** Return the String S, but with all characters that occur in FROM
     *  changed to the corresponding characters in TO. FROM and TO must
     *  have the same length. */
    static String translate(String S, String from, String to) {
        /* NOTE: The try {...} catch is a technicality to keep Java happy. */
        char[] buffer = new char[S.length()];
        try {
            Reader RR=new StringReader(S);
            TrReader trR=new TrReader(RR,from,to);
            char[]a=new char[S.length()];
            trR.read(a);
            return new String(a);
            //throw new IOException();
            // REPLACE ABOVE LINE WITH THE RIGHT ANSWER.
        } catch (IOException e) {
            return null;
        }
    }
    @Test
    public void testTranslate() throws IOException {
        String from="Zhipeng";
        String to="gnepihZ";
        String S="gnepihZ";
        String a=translate(S,from,to);
        assertEquals("Zhipeng", a);
    }

    /*
       REMINDER: translate must
      a. Be non-recursive
      b. Contain only 'new' operations, and ONE other method call, and no
         other kinds of statement (other than return).
      c. Use only the library classes String, and anything containing
         "Reader" in its name (browse the on-line documentation).
    */
}
