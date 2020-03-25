package utils;

public class HelperFuncs {
    public static void throwIfNumOfArgumentsIsInvalid(boolean predicate, String[] args, int expectedNumOfArgs) throws Exception {
        if (predicate) {
            throw new Exception("Syntax Error, Excpected" + expectedNumOfArgs + " got " + args.length);
        }
    }

    public static void throwIfEqualSignDoesntExist(String argumnet) throws Exception {
        if (!argumnet.equals(Consts.EQUAL_SIGN)) {
            throw new Exception("Syntax Error, Excpected = after variable name ");
        }
    }
    public static int countLinesUntillClosingBrancket(String[] text){
        int lineCounter = 0;
        for(String line: text){
            if(line.equals("}")) break;
            lineCounter++;
        }
        return lineCounter;
    }
}
