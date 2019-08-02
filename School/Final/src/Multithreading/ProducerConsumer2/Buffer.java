package Multithreading.ProducerConsumer2;
// Buffer interface specifies methods called by Producer and Consumer.
public interface Buffer
{
   // place int value into Buffer
   public void set(int value) throws InterruptedException;

   // obtain int value from Buffer
   public int get() throws InterruptedException; 
} // end interface Buffer