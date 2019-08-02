package Multithreading.ProducerConsumer;
// Buffer interface specifies methods called by Producer and Consumer.
public interface Buffer
{
   // place int value into Buffer
   void set(int value) throws InterruptedException;

   // obtain int value from Buffer
   int get() throws InterruptedException;
} // end interface Buffer