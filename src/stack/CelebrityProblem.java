package stack;

/**
 * @author amgarg
 */
public class CelebrityProblem {


    private static int [][] PARTY_MATRIX = {
            { 0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
    };

    public static int findCelebrity(int n) {


        int celebrityId = findPotentialCelebrity(n);

        if(celebrityId == -1) {
            return -1;
        }

        int count1  = 0;
        int count2  = 0;
        for(int i = 0; i < n; i++) {
            if(i != celebrityId) {
                count1 = count1 + knows(celebrityId, i);
                count2 = count2 + knows(i, celebrityId);
            }
        }

        if(count1 == 0 && count2 == n - 1) {
            return celebrityId;
        }
        return -1;

    }

    public static int knows(int a, int b) {
        return PARTY_MATRIX[a][b];
    }
    private static int findPotentialCelebrity(int n) {

        if(n == 0) {
            return -1;
        }

        int celebrityId = findPotentialCelebrity(n - 1);

        if(celebrityId == -1) {
            return n - 1;
        }

        else if(knows(celebrityId, n - 1) == 1) {
            return n - 1;
        }

        else if(knows(n - 1, celebrityId) == 1) {
            return celebrityId;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 4;

        int id = findCelebrity(4);

        System.out.println(id);
    }
}
