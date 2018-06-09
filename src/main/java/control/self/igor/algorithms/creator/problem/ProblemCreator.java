package control.self.igor.algorithms.creator.problem;

import java.util.List;

public interface ProblemCreator<Problem> {

    Problem create();

    List<Problem> create(int problemsNumber);
}
