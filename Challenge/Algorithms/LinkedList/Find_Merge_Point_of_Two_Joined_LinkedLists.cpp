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
   Find merge point of two linked lists
   Node is defined as
   struct Node
   {
       int data;
       Node* next;
   }
*/
int ListLength(const Node *head) {
    int l = 0;
    for (; head; head = head->next)
        ++l;
    return l;
}

int FindMergeNode(Node *headA, Node *headB) {
    int M = ListLength(headA);
    int N = ListLength(headB);
    if (M < N) return FindMergeNode(headB, headA);

    for (int i = M - N; i > 0; --i)
        headA = headA->next;

    for (; headA; headA = headA->next, headB = headB->next) {
        if (headA == headB)
            return headA->data;
    }
}int main()
{
	Node *A, *B, *C, *D,*E,*F,*G;
	A = new Node();	B= new Node();  C= new Node(); D = new Node(); E = new Node(); F= new Node();G = new Node();
	A->data = 2; B->data = 4; C->data = 3; D->data = 5; E->data = 7; F->data = 6;G->data = 11;

	// case 1 = 
	A->next = B; B->next = C; C->next = D; D->next = E; E->next = NULL;
	F->next = G; G->next = C;
	cout<<FindMergeNode(A,F)<<"\n";
	//case 2.
	A->next = B; B->next = C; C->next = E;  E->next = NULL;
	F->next = G; G->next = D;D->next = C;
	cout<<FindMergeNode(A,F)<<"\n";
	//case 3:
	A->next = B; B->next = E; E->next = NULL;
	F->next = G; G->next = D;D->next = C; C->next = E;
	cout<<FindMergeNode(A,F)<<"\n";
}
