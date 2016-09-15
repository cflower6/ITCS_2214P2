import java.util.Random;

public class Driver{

public static void main(String[] args)
{

PriorityQueue line = new PriorityQueue(); //creates new Priority queue list

for(int i = 1; i<=60; i++) //simulates 60 minutes in the store.
{

int num;
num = new Random().nextInt(4) + 1;

if(num ==1)

{



line.addCustomer();
line.removeCustomer();
}
System.out.println("---------------------------------------------------");
}
//System.out.println("HEAP");
//line.printHeap(0);
}
}