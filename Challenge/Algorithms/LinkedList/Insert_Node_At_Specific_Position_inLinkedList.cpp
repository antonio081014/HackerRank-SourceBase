#include <iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
struct Node
{
	int data;
	Node *next;
};/*
  Insert Node at a given position in a linked list 
  The linked list will not be empty and position will always be valid
  First element in the linked list is at position 0
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* InsertNth(Node *head, int data, int position)
{
  // Complete this method only
  // Do not write main function. 
    if(head == NULL){
        head = (Node *)malloc(sizeof(Node*));
        head->data = data;
        head->next = NULL;
        return head;
    }
    
    Node *tmp = (Node *)malloc(sizeof(Node*));
    tmp->data = data;
    tmp->next = NULL;
    
    if(position == 0){
        tmp->next = head;
        head = tmp;
        return head;
    }
    
    int start = 0;
    Node *curr = head;
    while(start < position){
        if(start + 1 == position) {
            tmp->next = curr->next;
            curr->next = tmp;
            return head;
        }
        curr = curr->next;
        start++;
    }
    return head;
}void Print(Node* head)
{
	while(head != NULL)
	{
		cout<<head->data;
		head=head->next;
	}
}

int main()
{
	int t;
	cin>>t;
	    Node *head = NULL;
		 head = new Node();
		 head->data = 2;
		 head->next = NULL;
	while(t-- >0){
		int x,n; cin>>x>>n;
		 head = InsertNth(head,x,n);
	}
	 Print(head);
	   cout<<"\n";

}
