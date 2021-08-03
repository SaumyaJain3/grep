import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Grep {
    public static void grep(List<String> flags,String pattern, List<String> fileNames) {
        for(String fileN : fileNames) {

            {
                try {
                    File file = new File(fileN);
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    int lineNumber=0;
                    String originalLine;
                    while ((originalLine = br.readLine()) != null) {
                        line=originalLine;
                        lineNumber++;
                        if (flags.contains("-i")) {
                            line = line.toLowerCase();

                        }
                        if(!flags.contains("-v") ) {
                            if(flags.contains("-x"))
                            {
                                if (line.matches(pattern)) {
                                    if (flags.contains("-n") && !(flags.contains("-l")))
                                        System.out.println(lineNumber + " : " + originalLine);
                                    else if (flags.contains("-l")) {
                                        System.out.println(fileN);

                                    } else
                                        System.out.println(originalLine);
                                }
                            }

                            else {
                                if (line.contains(pattern)) {
                                    if (flags.contains("-n") && !(flags.contains("-l")))
                                        System.out.println(lineNumber + " : " + originalLine);
                                    else if (flags.contains("-l")) {
                                        System.out.println(fileN);

                                    } else
                                        System.out.println(originalLine);
                                }
                            }

                        }
                        else
                        {
                            if(!line.contains(pattern))
                            {
                                if(flags.contains("-n"))

                                    System.out.println(lineNumber + " : " + originalLine);
                                else
                                    System.out.println(originalLine);

                            }

                        }
                        //if (func(pattern, flags, fileN, line, lineNumber, originalLine)) break;

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println();

            }
        }
    }



    public  static void main(String[] args)
    {
        String pattern="world";
        List<String> fileNames=new ArrayList<>(3);
        fileNames.add("test.txt");
        fileNames.add("test2.txt");
        List<String> flags=new ArrayList<>(3);
//        flags.add("-n");
        flags.add("-i");
//        flags.add("-v");
        grep(flags,pattern,fileNames);
    }



}