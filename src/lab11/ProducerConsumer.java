package lab11;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {
    
    public static class prodConsProblem 
    { 
    LinkedList<Integer> buffer = new LinkedList<>(); 
    int capacity = 4; 

    // Produce data 
    public void produce() throws InterruptedException 
    { 
        int dataProduced = 0; 
        while (true) 
        { 
        synchronized (this) 
        { 
        // wait if buffer is full
        while (buffer.size()==capacity) 
            wait(); 

        // to insert data to buffer
        buffer.add(dataProduced++); 
        System.out.println("Produced-" + dataProduced); 

        // notifing consumer thread for availability of data
        notify(); 
        } 
        } 
    } 
  
    //Consume data 
    public void consume() throws InterruptedException 
    { 
        while (true) 
        { 
        synchronized (this) 
        { 
        //wait if no data in buffer
        while (buffer.size()==0) 
            wait(); 

        //consume data from list
        int consumedData = buffer.removeFirst(); 
        System.out.println("Consumer" + consumedData); 

        // notify producer to produce
        notify();  
        } 
        } 
    } 
    } 
 

    public static void main(String[] args) {
        
        prodConsProblem obj=new prodConsProblem();
        
        // Creating producer thread by simple override method
        Thread prodThread = new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                try {
                    obj.produce();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }); 
        //Starting producer thread
        prodThread.start(); 
    
        // Creating consumer thread using lambda function to override run method
       Thread consThread = new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                try {
                    obj.consume();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }); 
        //Starting consumer thread
        consThread.start(); 
        
    }
    
}
