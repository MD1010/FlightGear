package conditions;

import interfaces.ICondition;

public class LessThanEqualCondition implements ICondition {

    public boolean isConditionHappening(double value, double compareValue) {
        return value <= compareValue;
    }
}
