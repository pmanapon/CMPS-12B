//-----------------------------------------------------------------------------
// Simulation.java
// Pattawut Manapongpun
// pmanapon
// CMPS-12B
// Date: 3-3-2018
// pa4
// Simulate a set of jobs performed by a set of processors.
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Simulation{

//-----------------------------------------------------------------------------
//
// The following function may be of use in assembling the initial backup and/or
// storage queues.  You may use it as is, alter it as you see fit, or delete it
// altogether.
//
//-----------------------------------------------------------------------------

   public static Job getJob(Scanner in) {
      String[] s = in.nextLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int d = Integer.parseInt(s[1]);
      return new Job(a, d);
   }

   public static int getNumJob(Scanner in) {
      String s = in.nextLine();
      int a = Integer.parseInt(s);
      return a;
   }

   public static void sort(int[] x){
      for(int k = x.length-1; k>0;k--){
         for(int j = 1; j<=k; j++){
            if(x[j]<x[j-1]){
               int temp = x[j];
               x[j] = x[j-1];
               x[j-1] = temp;
            }
         }
      }
   }

//-----------------------------------------------------------------------------
//
// The following stub for function main contains a possible algorithm for this
// project.  Follow it if you like.  Note that there are no instructions below
// which mention writing to either of the output files.  You must intersperse
// those commands as necessary.
//
//-----------------------------------------------------------------------------

   public static void main(String[] args) throws IOException{

      //1.  check command line arguments
   	  if(args.length < 1){
         System.err.println("Usage: Simulation input_file");
         System.exit(1);
      }

      //2.  open files for reading and writing
      Scanner in = null;
      PrintWriter report = null;
      PrintWriter trace = null;
      int totalWait, maxWait;
      int newline = 1;
      int m;
      double avgWait;
      Queue storage = new Queue();


      //3.  read in m jobs from input file
      in = new Scanner(new File( args[0]) );
      report = new PrintWriter( new FileWriter(args[0] + ".rpt") );
      trace = new PrintWriter( new FileWriter(args[0] + ".trc") );

      m = getNumJob(in);
      while(in.hasNext()){
      storage.enqueue((Job)getJob(in));
      }

      report.println("Report file: " + args[0] + ".rpt");
      report.println(m + " Jobs:");
      report.println(storage);
      report.println();
      report.println("***********************************************************");
      trace.println("Trace file: " + args[0] + ".trc");
      trace.println(m + " Jobs:");
      trace.println(storage);

      //4.  run simulation with n processors for n=1 to n=m-1  {
      for( int n=1; n<m; n++ ){

         //5.  declare and initialize an array of n processor Queues and any 
         //    necessary storage Queues

         int time = 0;
         Queue[] processor = new Queue[n+1];

         for( int i=0; i<=n; i++ )
            processor[i] = new Queue();

         
         for( int i=0; i<m; i++ ){
            Job j = (Job) storage.dequeue();
            j.resetFinishTime();
            processor[0].enqueue(j);
            storage.enqueue(j);
         }

         int arr1 = ((Job)processor[0].peek()).getArrival();
         int arr2;

         trace.println();
         trace.println("*****************************");
         trace.println( n == 1? n + " processor:" : n + " processors:" );
         trace.println("*****************************");

         // 6.  while unprocessed jobs remain  {
         while( processor[0].isEmpty() || processor[0].length() != m || ((Job) processor[0].peek()).getFinish() == -1 ){

            int[] t = new int[processor.length];

            if( time == 0 ){
               trace.println("time=0");
               for(int i=0; i<=n; i++)
                  trace.println(i + ": " + processor[i]);
            }
            if(newline==1) trace.println();


            //7.  determine the time of the next arrival or finish event and 
            //      update time
            if( time==0 && !processor[0].isEmpty() ){
               time = ( (Job) processor[0].peek() ).getArrival();
            }
            else if( !processor[0].isEmpty() ){
               Job k = (Job) processor[0].peek();
               if( k.getFinish() == -1 )
                  t[0] = k.getArrival();
            }

            for( int i=1; i<processor.length; i++ ){
               if( !processor[i].isEmpty() )
                  t[i] = ( (Job) processor[i].peek() ).getFinish();
            }

            sort(t);

            for( int i=0; i<t.length; i++ ){
               if( t[i] != 0 ){
                  time = t[i];
                  break;
               }
            }

            // 8.  complete all processes finishing now
            for( int i=1; i<=n; i++ ){
               if( !processor[i].isEmpty() && ( (Job)processor[i].peek() ).getFinish() == time ){
                  processor[0].enqueue( processor[i].dequeue() );
                  if( processor[i].length()>0 && ( (Job)processor[i].peek() ).getFinish() == -1 ){
                     ( (Job)processor[i].peek() ).computeFinishTime(time);
                  }
               }
            }

            //9.  if there are any jobs arriving now, assign them to a processor 
            //    Queue of minimum length and with lowest index in the queue array.
            if( processor.length-1==1 && !processor[0].isEmpty() && ( (Job)processor[0].peek() ).getArrival() == time ){
               arr1 = ((Job)processor[0].peek()).getArrival();
               processor[1].enqueue(processor[0].dequeue());
            }else{
               if( !processor[0].isEmpty() && ( (Job)processor[0].peek() ).getArrival() == time ){
                  int[] length = new int[processor.length-1];
                  for( int i=0; i<length.length; i++ )
                     length[i] = processor[i+1].length();
                  int index = 0;
                  int min = length[0];
                  for( int i=1; i<length.length; i++ ){
                     if( length[i] < min ){
                        min = length[i];
                        index = i;
                     }
                  }
                  
                  arr1 = ((Job)processor[0].peek()).getArrival();
                  Job check = (Job)processor[0].dequeue();
                  
                  processor[index+1].enqueue((Job)check);
                  
               }
            }
            for( int i=1; i<processor.length; i++ ){
               if( !processor[i].isEmpty() && ( (Job)processor[i].peek() ).getFinish() == -1 )
                  ((Job)processor[i].peek()).computeFinishTime(time);
            }

            if(!processor[0].isEmpty()){
               arr2 = ((Job)processor[0].peek()).getArrival();
            }else{
               arr2 = arr1+1;
            }

            if((arr1 != arr2)|| processor[0].isEmpty()||((Job) processor[0].peek()).getFinish() != -1 ){
               trace.println("time=" + time);
               for( int i=0; i<=n; i++ ){
                  trace.println(i + ": " + processor[i] );
               }
               newline = 1;
            }else{
               newline = 0;
            }

         //    10.     } end loop 
         }

         //11.  compute the total wait, maximum wait, and average wait for 
         //     all Jobs, then reset finish times
         totalWait = 0;
         int[] allTimes = new int[processor[0].length()];
         for( int i=0; i<allTimes.length; i++ ){
            allTimes[i] = ( (Job)processor[0].peek() ).getWaitTime();
            totalWait = totalWait + allTimes[i];
            processor[0].enqueue( processor[0].dequeue() );
         }
         sort(allTimes);
         maxWait = allTimes[allTimes.length-1];
         avgWait = (double)totalWait/(double)allTimes.length;

         String strDouble = String.format("%.2f", avgWait); 

         report.print(n==1? n + " processor: " : n + " processors: " );
         report.println("totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + strDouble );

      //12. } end loop 
      }

      //13. close input and output files
      trace.close();
      report.close();
      in.close();
   }
}
