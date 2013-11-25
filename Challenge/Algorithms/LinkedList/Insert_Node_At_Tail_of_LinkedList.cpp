#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
struct Node
{
	int data;
	Node *next;
};/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Insert(Node *head,int data)
{
  // Complete this method
    if(head == NULL){
        head = (Node *)malloc(sizeof(Node*));
        head->data = data;
        head->next = NULL;
        return head;
    }
    
    Node *curr = head;
    while(curr->next != NULL){
        curr = curr->next;
    }
    curr->next = (Node *)malloc(sizeof(Node*));
    curr->next->data = data;
    curr->next->next = NULL;
    return head;
}

void Print(Node *head)
{
	Node *temp = head;
	while(temp!= NULL){ cout<<temp->data<<"\n";temp = temp->next;}
}
int main()
{
	int t;
	cin>>t;
	Node *head = NULL;
	while(t-- >0)
	{
		int x; cin>>x;
		head = Insert(head,x);
	}
	Print(head);
}
