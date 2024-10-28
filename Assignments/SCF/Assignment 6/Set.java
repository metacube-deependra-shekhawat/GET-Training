import java.util.ArrayList;
import java.util.List;

final class IntSet{

    private final int[] set;

    IntSet(ArrayList<Integer> arr){
        set = new int[101];
        for(int i = 0; i < arr.size(); i++){
            set[arr.get(i)] = 1;
        }
    }

    public boolean isMember(int x){
        return set[x] == 1;
    }

    public boolean isSubSet(IntSet s){
        for(int i = 0; i <= 100; i++){
            if(s.set[i] == 1 && this.set[i] == 0) return false;
        }
        return true;
    }

    public IntSet getComplement(){
        ArrayList<Integer> arb = new ArrayList<>();
        for(int i = 0; i <= 100; i++){
            if(this.set[i] == 0){
                arb.add(i);
            }
        }
        return new IntSet(arb);
    }

    public IntSet union(IntSet s){
        ArrayList<Integer> arb = new ArrayList<>();
        for(int i = 0; i <= 100; i++){
            if(this.set[i] == 1 || s.set[i] == 1){
                arb.add(i);
            }
        }
        IntSet newSet = new IntSet(arb);
        return newSet;
    }

    public void display(){
        for(int i = 1; i <= 100; i++){
            if(this.set[i] == 1) System.out.print(i + " ");
        }
        System.out.println();
    }
};

public class Set {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(1,4,8,18,28,38,58,68,78,88,98));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(3,5,9,19,29,39,49,59,69,79,89,99));
        IntSet set1 = new IntSet(arr1);
        set1.display();
        IntSet set2 = new IntSet(arr2);
        set2.display();
        IntSet setComplement = set1.getComplement();
        setComplement.display();
        IntSet setUnion = set1.union(setComplement);
        setUnion.display();
        boolean flag = setUnion.isSubSet(set1);
        System.out.println(flag);
    }
}
