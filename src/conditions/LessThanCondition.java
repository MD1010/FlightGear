package conditions;

import interfaces.ICondition;

public class LessThanCondition implements ICondition {

    public boolean isConditionHappening(double value, double compareValue) {
        return value < compareValue;
    }
}
