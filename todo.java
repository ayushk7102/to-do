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
  static boolean write_stat =true;

  public static void main(String[] args)
  { Scanner sc =new Scanner(System.in);




    String s="";

    while(!(s = sc.nextLine()).equals("exit"))
    { System.out.print(">");
      input(s);
    }

    }

  public static void input(String t)
  { write_stat = true;
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


    case "$strike":
    try
    { if(arr.length>1)
      {
        int str_num = Integer.valueOf(arr[1]);
        strike_task(str_num);

      }

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


        // read character wise from string and write
        // into FileWriter
        for (int i = 0; i < task.length(); i++)
            fw.write(task.charAt(i));

      if(num_tasks!=0){fw.write('\n');}

        if(write_stat){
          System.out.println("\nTask written successfully!\n");
        }
        //close the file
        fw.close();

  }

  public static void strike_task(int ab) throws IOException

  { write_stat = false;

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

     int count = 0;
     ArrayList<String> tas = new ArrayList<String>();
     String d = "";

     for (int a = 0 ; a<content.length(); a++)
     {  String s = content.substring(a,a+1);
        d+=s;

       if(s.equals("\n"))
       {  d=d.substring(0,d.length()-1);
          d = d.substring(d.indexOf(".")+2);
          d = "unstrike "+d;

         tas.add(d);
         d="";

         sum++;
       }



     }



          //System.out.println(tas);

          if(ab<=tas.size() && ab>0)
          {tas.remove(ab-1);

            try
            {   num_tasks=0;

              //System.out.println(num_tasks);
                String aa[] = {""};
                write_task(null);

                //write_task(aa);

              //  System.out.println(tas);

                for(int si=0;si<tas.size();si++)
                {
                  String ak = tas.get(si);
                  num_tasks++;
                  write_task(ak.split(" "));

                }


            }

          catch(Exception e){System.out.println("Error while striking task");}

          }
          else{
            System.out.println("Invalid task number");
          }


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

/*
Download and complete MATH PDE problem sets
Revise PPT ELE1051 delta-star transformations
SMS Piano sir about fee payment
CSE 1051 HW: Algorithm flowchart of surface area & volume of sphere, cone, cylinder
MRM Rover Assignment submit before 1159 pm
Add strike task method in todo.java
Do ELE 1051 hw quiz */
