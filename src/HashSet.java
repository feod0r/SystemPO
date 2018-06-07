import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashSet {


    int n = 20;

    Bucket[] hashset;

    HashSet(){
        hashset = new Bucket[n];
        for (int i=0; i < n; i++){
            hashset[i] = new Bucket();
        }
    }

    void mset(Double value){
        int hashcode = hash_function(value);
        hashset[hashcode].bucket.add(value);
    }

    Double mget(Double value) {
        int hashcode = hash_function(value);
        return hashset[hashcode].bucket.find(value);
    }


    int hash_function (Double value)
    {
        return value.intValue()/n;
    }

    @Override
    public String toString() {
        return "HashSet{" +
                "n=" + n +
                ", hashset=" + Arrays.toString(hashset) +
                '}';
    }

}
