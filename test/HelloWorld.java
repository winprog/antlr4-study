import java.io.*;
import org.antlr.runtime.*;
import com.rxl.study.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        HelloLexer lex = new HelloLexer(null);
    }
}
