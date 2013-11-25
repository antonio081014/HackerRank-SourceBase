#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cmath>
using namespace std;
struct Node
{
	int data;
	Node* next;
};/*
  Detect loop in a linked list 
  List could be empty also
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
int HasCycle(Node* head)
{
   // Complete this function
   // Do not write the main method
    if(head == NULL) return 0;
    Node *first = head;
    Node *second = head->next;
    
    while(first != NULL && second != NULL){
        if(first == second) return 1;
        first = first->next;
        if(second->next) second = second->next->next;
        else return 0;
    }
    
    return 0;
}int main()
{
	Node *A, *B, *C, *D,*E,*F;
	A = new Node();	B= new Node();  C= new Node(); D = new Node(); E = new Node(); F= new Node();
	// case 1:  NULL list 
	if(HasCycle(NULL)) cout<<"1";
	else cout<<"0";
	//case 2:
	A->next = B; 
	B->next = C;
	C->next = A;
	if(HasCycle(A)) cout<<"1";
	else cout<<"0";
	//case 3:  
	A->next = B; B->next = C; C->next = D; D->next = E; E->next = F; F->next = E;
	if(HasCycle(A)) cout<<"1";
	else cout<<"0";
	//case 4:
	A->next = B; B->next = C; C->next = D; D->next = E; E->next = F; F->next = NULL;
	if(HasCycle(A)) cout<<"1";
	else cout<<"0";
	// case 5:
	A->next = B; B->next = C; C->next = D; D->next = E; E->next = F; F->next = A;
	if(HasCycle(A)) cout<<"1";
	else cout<<"0";
}
