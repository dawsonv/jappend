package com.dawsonv.FileAppender;

/**
 * Takes two files and appends them such that any overlapping data is deleted to form a single
 * file with all tweets in chronological order. 
 * 
 * @author dawsonverley
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAppender {
	
	private String fileIn1;
	private String fileIn2;
	
	private Scanner sc1;
	private Scanner sc2;
	
	private ArrayList<String> firstFile  = new ArrayList<String>();
	private ArrayList<String> secondFile  = new ArrayList<String>();
	
	// What do you want the name of the output file to be?
	private String fileOut = "AppendedFile.csv";
	
	/**
	 *  The substring() method is used to make large comparisons faster. 
	 *  Chose an initial value "a" and a final value "b" as indexes that are small enough 
	 *  to be within the bounds of all strings in secondFile, but large enough
	 *  to encompass a unique set of characters. 
	 */
	private int a = 0;
	private int b = 60;
	
	public String output = "";
	
	public FileAppender (String file1, String file2)
	{
    	fileIn1 = file1;
    	fileIn2 = file2;
		openFiles();
		readFiles();
		append();
		printOutput();
	}
	
    public void openFiles()
    {
		try
		{
			sc1 = new Scanner(new File(fileIn1));
		}
		catch(IOException ioexp)
		{
			System.out.println("IOExeption");
		}
		try
		{
			sc2 = new Scanner(new File(fileIn2));
		}
		catch(IOException ioexp)
		{
			System.out.println("IOExeption");
		}
    }
	
	public void readFiles()
	{
    	sc1.nextLine();
    	while(sc1.hasNextLine())
        {
    		firstFile.add(sc1.nextLine());
    	}
        while(sc2.hasNextLine())
        {
        	secondFile.add(sc2.nextLine());
    	}
    }
	
	public void append()
	{
		int i = 0;
		while (!secondFile.get(i).substring(a, b).equals(firstFile.get(0).substring(a, b)))
		{
			output += secondFile.get(i) + "\n";
			i++;
		}
		for (String str : firstFile)
		{
			output += str + "\n";
		}
	}
	
	// Output a file 
	public void printOutput()
	{
		try
		{
		    PrintWriter writer = new PrintWriter(fileOut, "UTF-8");
		    writer.println(output);
		    writer.close();
		}
		catch (IOException e) 
		{
			System.out.println("Error writing file");
		}
	}
	
	public static void main(String[] args)
	{
		// Which files will you be using?
		FileAppender main = new FileAppender("file.csv", "file.csv");
		System.exit(0);
	}
}
