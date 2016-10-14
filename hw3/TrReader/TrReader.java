import java.io.Reader;
import java.io.IOException;
import java.io.StringReader;

/** Translating Reader: a stream that is a translation of an
 *  existing reader.
 *  @author Zhipeng Yu
 */
public class TrReader extends Reader {
    /** A new TrReader that produces the stream of characters produced
     *  by STR, converting all characters that occur in FROM to the
     *  corresponding characters in TO.  That is, change occurrences of
     *  FROM.charAt(0) to TO.charAt(0), etc., leaving other characters
     *  unchanged.  FROM and TO must have the same length. */
    //Zhipeng
    public String From;
    public String To;
    public Reader Str;
    //Zhipeng
    public TrReader(Reader str, String from, String to) throws IOException {
        //Zhipeng
        super(str);
        Str=str;
        From=from;
        To=to;
        //Zhipeng
        // FILL IN
    }
    //Zhipeng
    public void close(){}
    public int read (char cbuf[], int off, int len)throws IOException {
        for (int j=0;j<len;j++) {
            int c = Str.read();
            if (c == -1) {
                return c;
            }
            for (int i = 0; i < From.length(); i++) {
                if ((char) c == From.charAt(i)) {
                    c = To.charAt(i);
                    break;
                }
            }
            cbuf[j]=(char)c;
        }
        return len;
    }
    //Zhipeng


    // FILL IN
    // NOTE: Until you fill in the right methods, the compiler will
    //       reject this file, saying that you must declare TrReader
    //     abstract.  Don't do that; define the right methods instead!
}


