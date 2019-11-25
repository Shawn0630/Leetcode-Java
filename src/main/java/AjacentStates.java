import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AjacentStates {

    public List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        while (days > 0) {
            nextState(states);
            days--;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < states.length; i++) {
            list.add(states[i]);
        }

        return list;
    }

    private void nextState(int[] states) {
        int[] prev = Arrays.copyOfRange(states, 0, states.length);
        states[0] = (prev[1]) == 0 ? 0 : 1;
        for(int i = 1; i < states.length - 1; i++) {
            states[i] = (prev[i - 1] ^ prev[i + 1]) == 0 ? 0 : 1;
        }
        states[states.length - 1] = prev[states.length - 2] == 0 ? 0 : 1;
    }
}
