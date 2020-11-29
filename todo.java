import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class todo
{
  static int num_tasks =0;
  static ArrayList<String> tasks = new ArrayList<String>();

  public static void main(String[] args)
  { Scanner sc =new Scanner(System.in);




    String s="";

    while(!(s = sc.nextLine()).equals("exit"))
    { System.out.print(">");
      input(s);
    }

    }

  public static void input(String t)
  {
    String arr[] = t.split(" ");
    switch(arr[0])
    {
      case "$task":

      try
      {
        num_tasks++;
        write_task(arr);

      break;
      }

    catch(Exception e){break;}

    case "$todo": // print current tasks
        try
        { num_tasks=find_num_tasks();
          //System.out.println(num_tasks);

          String ta = read_tasks();
          System.out.println(ta);
        break;
        }

      catch(Exception e){break;}

      case "$clear":

      try
      { num_tasks=0;

        //System.out.println(num_tasks);
          String aa[] = {""};
          write_task(null);

      System.out.println("\nCurrent tasks cleared!");
      break;
      }

    catch(Exception e){break;}

      case "$exit":
      case "exit":
      break;

      default:
      System.out.println("Unrecognised command");

    }
  }

  public static String read_tasks() throws IOException
  {
    if(num_tasks==0)
    {
      return "No tasks saved!";
    }


System.out.println("You have "+num_tasks+" task(s) saved todo");

       FileReader fr=null;
       try
       {
           fr = new FileReader("todo.txt");
       }
       catch (FileNotFoundException fe)
       {
           System.out.println("File not found");
       }

       String x="";
       String content="";
       BufferedReader br = new BufferedReader(fr);
       boolean eof = false;
       int i=1;

       // read from FileReader till the end of file
       while ((x=br.readLine())!=null )
           {
             content+=(i+". "+x);
             content+="\n";
             i++;

           }

       // close the file
       fr.close();

       return content;

  }


  public static void write_task(String t[]) throws IOException
  {

    FileWriter fw;
    if(num_tasks == 0)
    {

         fw=new FileWriter("todo.txt", false);
         return;
    }

        String task = "";

        for(int i=1; i<t.length;i++)
        { String a= t[i];
          task+=a+" ";

        }

        // attach a file to FileWriter
         fw=new FileWriter("todo.txt", true);

        if(num_tasks!=0){fw.write('\n');}

        // read character wise from string and write
        // into FileWriter
        for (int i = 0; i < task.length(); i++)
            fw.write(task.charAt(i));

        System.out.println("\nTask written successfully!\n");
        //close the file
        fw.close();

  }

  public static int find_num_tasks() throws IOException
  {
      int sum = 0;

       FileReader fr=null;
       try
       {
           fr = new FileReader("todo.txt");
       }
       catch (FileNotFoundException fe)
       {
           System.out.println("File not found");
       }

       String x="";
       String content="";
       BufferedReader br = new BufferedReader(fr);
       boolean eof = false;
       int i=1;

       // read from FileReader till the end of file
       while ((x=br.readLine())!=null )
           {if(!x.equals(""))
             {content+=(i+". "+x);
             content+="\n";
             i++;}

           }

       // close the file
       fr.close();


       for (int a = 0 ; a<content.length(); a++)
       {  String s = content.substring(a,a+1);


         if(s.equals("\n"))
         {

           sum++;
         }
       }

       return sum;

  }


}
