package service;

import java.util.List;
import model.Line;

public interface LineService {

    List<String> getAverageTimes(List<Line> lines);
}
