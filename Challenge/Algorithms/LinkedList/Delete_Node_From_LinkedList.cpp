#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
struct Node
{
	int data;
	Node *next;
};
Node* Insert(Node *head,int x)
{
   Node *temp = new Node();
   temp->data = x;
   temp->next = NULL;
   if(head == NULL) 
   {
       return temp;
   }
   Node *temp1;
   for(temp1 = head;temp1->next!=NULL;temp1= temp1->next);
   temp1->next = temp;return head;
}/*
  Delete Node at a given position in a linked list 
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Delete(Node *head, int position)
{
  // Complete this method
    int start = 0;
    Node *prev = NULL;
    Node *curr = head;
    while(curr != NULL){
        if(position == start){
            if(prev == NULL) return curr->next;
            else {
                prev->next = curr->next;
                return head;
            }
        } else {
            start++;
            prev = curr;
            curr = curr->next;
        }
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
	while(t-- >0){
		int x; cin>>x;
		 Node *head = NULL;
                while(x--)
                {
                   int y;cin>>y;
		           head = Insert(head,y);
                }
       int pos;cin>>pos;
	   head = Delete(head,pos);
	   Print(head);
	   cout<<"\n";
	}

}
