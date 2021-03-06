#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define WORD_LEN 100
#define alloc_list (struct Elem *)malloc(sizeof(struct Elem)+WORD_LEN)


typedef struct Elem {
    struct Elem *next;
    char *word;
    int key;
    int index;
} *elem;

elem init_new_elem()
{
    elem New_elem = alloc_list;
    New_elem->next = NULL;
    New_elem->word = (char *)(New_elem+1)/*sizeof(struct Elem)*/;
    New_elem->word[0] = '\0';
    New_elem->index = 0;
//    printf("NEW_ELEM index = %d\n", New_elem->index);
    return New_elem;
}

//------------------Добавление элемента-------------------

void add_to_tail(elem Head, elem New_elem)
{
    elem Temp = Head;
    while(Temp->next != NULL){
        Temp = Temp->next;
    }
    Temp->next = New_elem;
    New_elem->next = NULL;
    New_elem->index = Temp->index + 1;
}

void add_after(elem Current, elem New_elem)
{
    New_elem->next = Current->next;
    Current->next = New_elem;
    New_elem->index = Current->index + 1;
}

void add_after1(elem Current, char *buff)
{
    elem New_elem = init_new_elem();
    memcpy(New_elem->word, buff, WORD_LEN);
    New_elem->next = Current->next;
    Current->next = New_elem;
    New_elem->index = Current->index + 1;
//    printf("added %d %s\n", New_elem->index, New_elem->word);
}

int list_len(elem Head)
{
    int counter = 0;
    elem Temp = Head;
    while(Temp != NULL){
        ++counter;
        Temp = Temp->next;
    }
    return counter;
}

elem find_tail(elem Head)
{
    elem Tail = Head;
    while(Tail->next != NULL){
        Tail = Tail->next;
    }
    return Tail;
}

//------------------Удаление-------------------
void delete_list(elem Head)
{
    if(Head->next == NULL){
//        printf("free(%d)   ", Head->index);
        free(Head);
        return;
    }
    elem Current = Head;
    elem Next = Current->next;
    while(Next != NULL){
//        printf("free(%d)   ", Current->index);
        free(Current);
        Current = Next;
        Next = Current->next;
    }
    putchar('\n');
//    printf("free(%d)   ", Current->index);
    free(Current);
}

//----------------Считывание и вывод на консоль списка--------------------

#define eat_whitespaces \
{\
    int letter;\
    while((letter = getchar()) == ' '){\
    }\
    ungetc(letter, stdin);\
}

void read_sentence(elem Head)
{
    int letter;
    eat_whitespaces;
    if((letter = getchar()) == '\n'){
        return;
    }
    ungetc(letter, stdin);
    scanf("%s", Head->word);
    Head->key = strlen(Head->word);
    elem Tail = Head;
    elem Temp = NULL;
    while((letter = getchar()) != '\n'){
        ungetc(letter, stdin);
        Temp = init_new_elem();
        scanf(" %s", Temp->word);
        add_after(Tail, Temp);
        Tail = Temp;
        Tail->key = strlen(Tail->word);
    }
}

void print_list(elem Head)
{
    elem Temp = Head;
    while(Temp != NULL){
        printf("%d %s\n", Temp->index, Temp->word);
//        printf("%s\n", Temp->word);
        Temp = Temp->next;
    }
}
//-----------------------------------------------------------

int compare(elem a)
{
    return a->next->key < a->key;
}

void swap_after(elem Before)
{
    elem a = Before->next;
    elem b = a->next;
    printf("swap before = %d, a = %d, b = %d\n", Before->index, a->index, b->index);
    //Было Before->a->b, стало Before->b->a
    a->next = b->next;
    Before->next = b;
    b->next = a;
}

void swap_head(elem Head)
{
    elem Temp = Head;
    Head = Head->next;
    Head->next = Temp;

}

void swap(elem a)
{
    elem b = a->next;
    char buff[WORD_LEN];
    strncpy(buff, a->word, WORD_LEN);
    strncpy(a->word, b->word, WORD_LEN);
    strncpy(b->word, buff, WORD_LEN);
    int temp;
    temp = a->key;
    a->key = b->key;
    b->key = temp;
}

struct Elem *bsort(struct Elem *list)
{
    elem Tail = find_tail(list);
    elem i, bound, prev;
    while(Tail != list){
        bound = Tail;
        for(Tail = i = prev = list; i != bound; i = i->next){
            if(compare(i)){
//                if(i != list){
//                    swap_after(prev);
//                } else {
                swap(i);
                }
                Tail = i;
            }
            prev = i;
        }
    }
    return list;
}

void bublesort(elem list)
{
    elem prev, ptr, tmp;
    int exit = 0;

    while (!exit){
        tmp = prev = NULL;
        ptr = list;
        exit = 1;
        while (ptr->next != NULL){
            elem a = ptr;
            elem b = ptr->next;

            if (compare(ptr)){
                exit = 0;
                if (prev){
                    prev->next = b;
                }
                else{
                    list = b;
                }
                prev = b;
                tmp = b->next;
                b->next = a;
                a->next = tmp;

                ptr = a;
            } else {
                prev = ptr;
                ptr = ptr->next;
            }
        }
    }
}

//struct Elem *bsort(struct Elem *list)
//{
//    elem Tail = find_tail(list);
//    elem i, bound, prev;
//    while(Tail != list){
//        bound = Tail;
//        for(Tail = prev = i = list; i != bound; i = i->next){
//            printf("i = %d; ", i->index);
//            if(compare(i)){
//                swap(i);
//                Tail = i;
//            }
//        }
//    }
//    return list;
//}

int main(void)
{
    elem Head = init_new_elem();
//    add_after(Head, "asdf");
    read_sentence(Head);
    bsort(Head);
    print_list(Head);
    swap_after(Head->next);
//    swap_head(Head);
    print_list(Head);
    delete_list(Head);
    return 0;
}

/*
Сортировка списка пузырьком
Условие
Баллы: 2

Составьте программу listbsort.c, выполняющую сортировку слов в предложении в порядке возрастания их длин. Слова в предложении разделены одним или несколькими пробелами. Программа должна формировать однонаправленный список слов, а затем сортировать этот список пузырьком.

Функция bsort, реализующая алгоритм сортировки, должна быть объявлена как
struct Elem *bsort(struct Elem *list)
{
    ...
}

Структура Elem, указатели на которую фигурируют в объявлении функции bsort, должна представлять элемент однонаправленного списка, содержащего одно слово из предложения:
struct Elem {
    struct Elem *next;
    char *word;
};

Исходное предложение подаётся в стандартный поток ввода программы. Программа должна вывести в стандартный поток вывода отсортированную последовательность слов, разделённых пробелами.

valgrind ~/Qt/3-module/8-list-buble-sort-Debug/8-list-buble-sort

7 8 4 5 4 3 2


*/
