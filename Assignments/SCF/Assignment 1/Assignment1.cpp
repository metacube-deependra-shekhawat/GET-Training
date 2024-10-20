#include<bits/stdc++.h>
using namespace std;

unordered_map<int,pair<pair<string,string>, int>> inventory;
unordered_map<int,int> cart;
int total = 0;

void addItemToCart(int id, int quantity){
    if(cart.find(id) != cart.end()) {
        cout<<"Item is already present in the cart, consider updating the quantity"<<endl;
        return;
    }
    cart[id] = quantity;
    total += (cart[id] * inventory[id]);
    return;
}

void showQuantity(int id){
    if(cart.find(id) == cart.end()){
        cout<<"No such item in cart."<<endl;
        return;
    }
    cout<<"The quantity of this item is: "<<cart[id]<<endl;
    return;
}

void updateQuantity(int id, int newQuantity){
    total -= (cart[id] * inventory[id].second);
    cart[id] = newQuantity;
    total += (cart[id] * inventory[id].second);
}

void deleteItem(int id){
    if(cart.find(id) == cart.end()){
        cout<<"Item not present in the cart"<<endl;
        return;
    }
    total -= (cart[id] * inventory[id].second);
    cart.erase(id);
}

void displayTotal(){
    cout<<"The total sum is: "<<total<<endl;
    return;
}

int main(){
    inventory[0] = {{"Item1", "Description for Item no.1"}, 10};
    inventory[1] = {{"Item2", "Description for Item no.2"}, 20};
    inventory[2] = {{"Item3", "Description for Item no.3"}, 30};
    inventory[3] = {{"Item4", "Description for Item no.4"}, 40};
    inventory[4] = {{"Item5", "Description for Item no.5"}, 50};

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
            cin>>quantity
            cout<<endl;
            addItemToCart(id, quantity);
            break;

        case 2:
            cout<<"Please enter the id of the item: ";
            cin>>id;
            cout<<endl;
            showQuantity(id);
            break;
        
        case 3:
            cout<<"Please enter the id of the item: ";
            cin>>id;
            cout<<endl;
            cout<<"Please enter the new quantity: ";
            cin>>quantity;
            cout<<endl;
            updateQuantity(id, quantity);
            break;

        case 4:
            cout<<"Please enter the id of the item: ";
            cin>>id;
            cout<<endl;
            deleteItem(id);
            break;

        case 5:
            cout<<"Total: "<<endl;
            break;
        
        case 6:
            return 0;

        default:
            cout<<"Please enter a valid number."<<endl;
            break;
        }
    }
}