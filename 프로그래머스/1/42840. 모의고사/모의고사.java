import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int [] scores = new int [3];
        int max = 0;
            for (int problem = 0; problem < answers.length;problem++){
                int answer = answers[problem];
                for(int person = 0;person < 3;person++){
                    if (answer == getAnswers(person,problem)){
                        scores[person]++;
                        if (scores[person] > max){
                            max = scores[person];
                        }
                    }
            }
        }
        final int maxCorrects = max;
        // 점수가 max라면, +1 해서 배열에 넣기
        return IntStream.range(0,3)
            .filter(i -> scores[i] == maxCorrects)
            .map( i -> i + 1)
            .toArray();
    }
    
    private static final int[][] rules = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
    };
    
    // 수포자가 찍은 정답 구하기 
        private int getAnswers(int person, int problem) {
            int [] rule = rules[person];
            int index = problem % rule.length;
            return rule[index];
        }
}

