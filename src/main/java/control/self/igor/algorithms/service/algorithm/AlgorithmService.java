package control.self.igor.algorithms.service.algorithm;

public interface AlgorithmService<Problem, Solution> {

    Solution solve(Problem problem);
}
