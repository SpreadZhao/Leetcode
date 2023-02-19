package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: <a href="https://leetcode.com/problems/regular-expression-matching/">Expression Matching</a>
 */
public class ExpressionMatching {

    // State of FA, 0(num) means start
    static class State{
        public boolean isFinal;
        public int num;

        public State(){}

        public State(int num, boolean isFinal){
            this.isFinal = isFinal;
            this.num = num;
        }
    }

    static class Edge{
        public State from;
        public State to;
        public char input;

        public Edge(State from, State to, char input){
            this.from = from;
            this.to = to;
            this.input = input;
        }
    }

    private List<Edge> edges = new ArrayList<>();

    public boolean isMatch(String s, String p) {
        // Phase One: Determine Input(ch, ch*, ., .*)
        int num = 0;
        State prev = new State(num, false);
        if(p.length() == 1){
            edges.add(new Edge(prev, prev, p.charAt(0)));
        }else if(p.length() == 2){
            if(p.charAt(1) == '*'){
                edges.add(new Edge(prev, prev, p.charAt(0)));
            }else{
                if(p.charAt(0) == p.charAt(1)){
                    edges.add(new Edge(prev, prev, p.charAt(0)));
                }else{
                    State s1 = new State(1, false);
                    State s2 = new State(2, true);
                    edges.add(new Edge(prev, s1, p.charAt(0)));
                    edges.add(new Edge(s1, s2, p.charAt(1)));
                }
            }
        }else{
            for(int i = 0; i < p.length(); i++){
                char ch = p.charAt(i);
                if(i == p.length() - 1){
                    State to = ch == p.charAt(i - 2) ? prev : new State(++num, false);
                    edges.add(new Edge(prev, to, ch));
                    prev = to;
                }else if(p.charAt(i + 1) == '*'){ // ch* or .
                    edges.add(new Edge(prev, prev, ch));
                    i++;
                }else{ // only ch or .
                    State to = ch == p.charAt(i - 2) ? prev : new State(++num, false);
                    edges.add(new Edge(prev, to, ch));
                    prev = to;
                }
//            if(Character.isLetter(ch)){
//                if(p.charAt(i + 1) == '*'){ // ch*
//                    edges.add(new Edge(prev, prev, String.valueOf(ch) + p.charAt(i + 1)));
//                }else{ // only ch
//                    State to = new State(++num, false);
//                    edges.add(new Edge(prev, to, String.valueOf(ch)));
//                    prev = to;
//                }
//            }else if(ch == '.'){
//                if(p.charAt(i + 1) == '*'){ // only .
//
//                }else{ // .*
//
//                }
//            }
            }
        }


        if(!edges.isEmpty()) edges.get(edges.size() - 1).to.isFinal = true;

        int pointer = 0, stateNum = 0;
        while(stateNum != -1 && pointer < s.length()){
            char ch = s.charAt(pointer++);
            stateNum = findNextState(stateNum, ch);
        }

        return pointer == s.length() && edges.get(edges.size() - 1).to.num == stateNum;

    }

    private int findNextState(int fromNum, char input){
        for (Edge edge : edges) {
            if (edge.from.num == fromNum && (edge.input == input || edge.input == '.')) return edge.to.num;
        }
        return -1;
    }
}