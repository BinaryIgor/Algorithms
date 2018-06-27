package control.self.igor.algorithms.service.problem;

import java.util.List;

public interface ProblemService<Problem> {

    Problem createProblem(int problemSize);

    List<Problem> createProblems(int problemsNumber, int problemSize);
}
