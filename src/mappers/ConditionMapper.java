package mappers;
import commands.*;
import conditions.*;
import interfaces.ICommand;
import interfaces.ICondition;
import utils.Consts;

import java.util.HashMap;
import java.util.Map;

public class ConditionMapper {
    public static Map<String, ICondition> condationsMap = new HashMap<String, ICondition>() {{
        put("==", new EquaCondition());
        put(">", new GreatherThanCondition());
        put("<", new LessThanCondition());
        put(">=", new GreatherThanEqualCondition());
        put("<=", new LessThanEqualCondition());
    }};
}
