#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cmath>
using namespace std;
struct Node
{
	int data;
	Node* next;
	Node* prev;
};/*
    Insert Node in a doubly sorted linked list 
    After each insertion, the list should be sorted
   Node is defined as
   struct Node
   {
     int data;
     Node *next;
     Node *prev
   }
*/
Node* SortedInsert(Node *head,int data)
{
    // Complete this function
   // Do not write the main method. 
    Node *tmp = (Node*)malloc(sizeof(Node*));
    tmp->data = data;
    tmp->prev = NULL;
    tmp->next = NULL;
    if(head == NULL){
        head = tmp;
        return head;
    }
    
    if(head->data > data){
        tmp->next = head;
        head->prev = tmp;
        head = tmp;
        return head;
    }
    
    Node *curr = head;
    while(curr->data<=data){
        if(curr->next == NULL){
            curr->next = tmp;
            tmp->prev = curr;
            return head;
        }
        if(curr->next->data > data){
            tmp->next = curr->next;
            curr->next->prev = tmp;
            curr->next = tmp;
            tmp->prev = curr;
            return head;
        }
        curr = curr->next;
    }
    return head;
}void Print(Node *head) {
	if(head == NULL) return;
	while(head->next != NULL){ cout<<head->data<<" "; head = head->next;}
	cout<<head->data<<" ";
	while(head->prev != NULL) { cout<<head->data<<" "; head = head->prev; }
	cout<<head->data<<"\n";
}
int main()
{
	int t; cin>>t;
	Node *head = NULL;
	while(t--) {
	   int n; cin>>n;
           head = NULL;
	   for(int i = 0;i<n;i++) {
		   int x; cin>>x;
		   head = SortedInsert(head,x);
	       Print(head);
	   }
	}
}
