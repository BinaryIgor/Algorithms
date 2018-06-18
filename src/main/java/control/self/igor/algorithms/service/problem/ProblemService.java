package control.self.igor.algorithms.service.problem;

import java.util.List;

public interface ProblemService<Problem> {

    Problem createProblem();

    List<Problem> createProblems(int problemsNumber);
}
