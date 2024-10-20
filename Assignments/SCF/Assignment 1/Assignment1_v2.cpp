#include<bits/stdc++.h>
using namespace std;

class Item{
public:
    int id, price;
    string name, desc;
    Item(int id, string name, string desc, int price){
        this->id = id;
        this->name = name;
        this->desc = desc;
        this->price = price;
    }
};

map<int,int> cart;
int total = 0;

void addItemToCart(Item item, int quantity){
    if(cart.find(item.id) != cart.end()) {
        cout<<"Item is already present in the cart, consider updating the quantity"<<endl;
        return;
    }
    cart[item.id] = quantity;
    total += (cart[item.id] * item.price);
    return;
}

void showQuantity(Item item){
    if(cart.find(item.id) == cart.end()){
        cout<<"No such item in cart."<<endl;
        return;
    }
    cout<<"The quantity of this item is: "<<cart[item.id]<<endl;
    return;
}

void updateQuantity(Item item, int newQuantity){
    total -= (cart[item.id] * item.price);
    cart[item.id] = newQuantity;
    total += (cart[item.id] * item.price);
}

void deleteItem(Item item){
    if(cart.find(item.id) == cart.end()){
        cout<<"Item not present in the cart"<<endl;
        return;
    }
    total -= (cart[item.id] * item.price);
    cart.erase(item.id);
}

void displayTotal(){
    cout<<"The total sum is: "<<total<<endl;
    return;
}

int main(){
    vector<Item> items;
    for(int i = 0; i < 5; i++){
        int id = i;
        char ch = '0' + i;
        string name = "Item_";
        name += ch;
        string desc = "This is the description for the item";
        int price = 10*(i+1);
        items.push_back(Item(id, name, desc, price));
    }     
    while(true){
        int tt;
        cout<<"Enter 1 to add Item to cart."<<endl;
        cout<<"Enter 2 to show quantity of item."<<endl;
        cout<<"Enter 3 to update quantity of item."<<endl;
        cout<<"Enter 4 to delete item."<<endl;
        cout<<"Enter 5 to display total."<<endl;
        cout<<"Enter 6 to exit."<<endl<<endl;
        cout<<"Please enter you choice here: ";
        cin>>tt;

        int id, quantity;
        switch (tt)
        {
        case 1:
            cout<<"Please enter the id of item: ";
            cin>>id;
            cout<<endl;
            cout<<"Please enter the quantity: ";
            cin>>quantity;
            cout<<endl;
            addItemToCart(items[id], quantity);
            break;

        case 2:
            cout<<"Please enter the id of the item: ";
            cin>>id;
            cout<<endl;
            showQuantity(items[id]);
            break;
        
        case 3:
            cout<<"Please enter the id of the item: ";
            cin>>id;
            cout<<endl;
            cout<<"Please enter the new quantity: ";
            cin>>quantity;
            cout<<endl;
            updateQuantity(items[id], quantity);
            break;

        case 4:
            cout<<"Please enter the id of the item: ";
            cin>>id;
            cout<<endl;
            deleteItem(items[id]);
            break;

        case 5:
            cout<<"Total: "<<total<<endl;
            break;
        
        case 6:
            return 0;

        default:
            cout<<"Please enter a valid number."<<endl;
            break;
        }
    }
}