import java.util.HashMap;
import java.util.Map.Entry;

final class Poly{
    private final int[] deg;
    private final int[] coeff;

    Poly(int[] coeff, int[] deg){
        this.coeff = coeff;
        this.deg = deg;
    }

    public float evaluate(float var){
        int n = deg.length;
        float ans = 0;
        for(int i = 0; i < n; i++){
            ans += (coeff[i] * Math.pow(var,i));
        }
        return ans;
    }

    public int getDegree(){
        int n = deg.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans,this.deg[i]);
        }
        return ans;
    }

    public Poly addPoly(Poly p1, Poly p2){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n1 = p1.deg.length;
        int n2 = p2.deg.length;
        for(int i = 0; i < n1; i++){
            map.put(p1.deg[i],p1.coeff[i]);
        }
        for(int j = 0; j < n2; j++){
            if(map.containsKey(p2.deg[j])){
                map.put(p2.deg[j], map.get(p2.deg[j])+p2.coeff[j]);
            } else {
                map.put(p2.deg[j], p2.coeff[j]);
            }
        }
        int sz = map.size();
        int[] newDeg = new int[sz];
        int[] newCoeff = new int[sz];
        int i = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            newDeg[i] = entry.getKey();
            newCoeff[i++] = entry.getValue();
        }
        return new Poly(newCoeff, newDeg);
    }

    public Poly mulPoly(Poly p1, Poly p2){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n1 = p1.deg.length;
        int n2 = p2.deg.length;
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                int nDeg = p1.deg[i] + p2.deg[j];
                if(map.containsKey(nDeg)){
                    System.out.println(nDeg);
                    map.put(nDeg, map.get(nDeg)+(p1.coeff[i]*p2.coeff[j]));
                } else {
                    map.put(nDeg,p1.coeff[i]*p2.coeff[j]);
                }
            }
        }
        int sz = map.size();
        int[] newDeg = new int[sz];
        int[] newCoeff = new int[sz];
        int i = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            newDeg[i] = entry.getKey();
            newCoeff[i++] = entry.getValue();
        }
        return new Poly(newCoeff,newDeg);
    }

    public void display(){
        int n = deg.length;
        for (int i = 0; i < n; i++) {
            System.out.print("("+coeff[i]+"x^"+deg[i]+") ");
        }
    }
}

public class Polynomial {
    public static void main(String[] args) {
        int[] deg1 = {0,2};
        int[] coeff1 = {5,1}; // x^2 + 5
        int[] deg2 = {1,2};
        int[] coeff2 = {2,1};// x^2 + 2x
        //2x^2 + 2x + 5
        //x^4 + 5x^2 + 2x^3 + 10x
        Poly poly1 = new Poly(coeff1,deg1);
        Poly poly2 = new Poly(coeff2,deg2);
        Poly poly3 = poly1.addPoly(poly1,poly2);
        poly3.display();
    }
}
