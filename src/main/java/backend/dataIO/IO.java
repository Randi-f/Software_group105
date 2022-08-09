package backend.dataIO;

import java.io.*;
/**
 * @version 1.0
 * @author: Wenhan Yang
 * @date: 2022/3/31 19:42
 */
public class IO {

    /**
     * read file from disk
     * @param fileName
     * @return the content of that file
     * @throws IOException
     */
    protected static String read(String fileName) throws IOException {
        try (
                FileReader fr = new FileReader("./data/" + fileName);
                BufferedReader br = new BufferedReader(fr)
        ) {
            StringBuilder sb = new StringBuilder();
            String temp = "";
            while ((temp = br.readLine()) != null) {
                sb.append(temp + "\n");
            }
            return sb.toString();
        }
    }
    /**
     * write to disk
     * @param fileName
     * @param str content of file
     * @throws IOException
     */
    protected static void write(String fileName, String str) throws IOException {
        File file = new File("./data/" + fileName);
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(str);
        ps.close();
    }
}