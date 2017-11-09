/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.DAL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pgn
 */
public class WordDAO
{

    /**
     * The name of the file with all the words
     */
    private static final String wordFileName = "companies.csv";

    /**
     * Gets all words from the brit a-z text file.
     *
     * @return List of all words.
     */
    public List<String> getAllWords() throws FileNotFoundException
    {

        ArrayList<String> words = new ArrayList<>();

        //1 get a hold of the file:
        File wordFile = new File(wordFileName);
        //2 Put the file in a file reader so we can read characters in from the file:
        FileReader fr = new FileReader(wordFile);
        //3 Put the file reader in a buffered reader to increase efficiency
        //(Like videos on youtube are buffered):
        BufferedReader br = new BufferedReader(fr);
        //4 Put the buffered reader in a scanner just to get some usefull functionality:
        Scanner scan = new Scanner(br);

        //Start iterating on the data, as long as there are new lines:
        while (scan.hasNextLine())
        {
            //We extract the current nextline:
            String word = scan.nextLine();
            //We add the line to our arraylist of words:
            words.add(word);
        }
        //We close the scanner, and thus all the used connections to the file:
        scan.close();
        //We return the list of words:
        return words;
    }

}
