package conditions;

import interfaces.ICondition;

public class EquaCondition implements ICondition {

    public boolean isConditionHappening(double value, double compareValue) {
        return value == compareValue;
    }
}
