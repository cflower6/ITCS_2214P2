/*
	Program: PriorityQueue Class
        Name: Chris Flowers
	Date: 4/5/2016
	Summary: Creates customer when called from the driver and sets priority and put in a heap depending on priority is placed in a certain position.
	Functionality: 
		Constructor: PriorityQueue, heap, addCustomer,
*/


class PriorityQueue{

PriorityCustomer[] heap;
private int size;
private int pointer, parentIndex, leftIndex, rightIndex;
//PriorityCustomer first, last;

public void printHeap(int i)
{
   System.out.println(heap[i].getPriority());
   if( heap[2*i + 1] != null){
       System.out.println("Left of "+ i);printHeap(2*i + 1);}

   if( heap[2*i + 2] != null){
       System.out.println("Right of "+i);printHeap(2*i + 2);}
}

PriorityQueue(){

heap = new PriorityCustomer[100];
size = 100; //size should not be incremented, it should be constant. I gave it 1-- because PriorityCustomers can be 100 maximum
pointer = 0;

}
public void Heapify(int i) // utility routine to percolate down from index i
{
int left, r, min=i; // declare variables

left = 2 * i + 1; // left child
r = 2 * i + 2; // right child
if(heap[left] != null){ //Null condition to not give nullPointerException
if(left < size && heap[left].getPriority() > heap[i].getPriority()) // find smallest child
min = left; // save index of smaller child
else
min = i;
}
if(heap[r] != null){ //Null condition to not give nullPointerException
if(r < size && heap[r].getPriority() > heap[min].getPriority())
min = r; // save index of smaller child
}
PriorityCustomer tmp;// = new PriorityCustomer();
if(min != i && i>=0) //It was not checking for i==0,so added that. // swap and percolate, if necessary
{
tmp = heap[i]; // exchange values at two indices
heap[i] = heap[min];
heap[min] = tmp;
Heapify((i-1)/2); // call Heapify

}// end if

}// end method Heapify
void addCustomer(){

PriorityCustomer c = new PriorityCustomer();
heap[pointer] = c;

if(!isEmpty()){

//pointer = parentIndex;
parentIndex = (pointer-1)/2; //changed the logic of parentIndex

Heapify(parentIndex); //addded function to heapify which takes care of all conditions
      

}
else{

heap[pointer] = c;


}
System.out.println("customer added to queue: " + pointer + "\nPriority: " + heap[pointer].getPriority() + ", ServiceTime: " + heap[pointer].getServiceTime());


pointer++;


}
void removeCustomer(){

PriorityCustomer c = new PriorityCustomer();
heap[pointer] = c;

if(!isEmpty()){

//pointer = parentIndex;
//parentIndex = (pointer-1)/2; //changed the logic of parentIndex
//
//Heapify(parentIndex); //addded function to heapify which takes care of all conditions
c.decServiceTime();
if(c.getServiceTime()==0){
          System.out.println("A Customer has been serviced and removed from the line");
          pointer--;
      }
}
else{

heap[pointer] = c;


}



}
public boolean isEmpty(){
if(pointer == 0)
return true;
else
return false;

}
}