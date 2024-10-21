#include<bits/stdc++.h>
using namespace std;

int main(){
    vector<vector<int>> tasks = {{0,10}, {6,20}, {60,10}, {110,5}};
    int time = 0;
    vector<int> finishingTime, waitingTime, turnAroundTime;
    for(auto it: tasks){
        int startingTimeForProcess = max(time,it[0]);
        int endingTimeForProcess = startingTimeForProcess + it[1];
        waitingTime.push_back(max(0,it[0]-time));
        finishingTime.push_back(endingTimeForProcess);
        time = endingTimeForProcess;
    }
    for(auto it: finishingTime) cout<<it<<" ";
    cout<<endl;
    for(auto it: waitingTime) cout<<it<<" ";
}