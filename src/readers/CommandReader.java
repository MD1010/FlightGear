package readers;

import mappers.CommandMapper;
import utils.ReadCommandFile;
import utils.Consts;
import utils.HelperFuncs;


public class CommandReader {
    public static String[] splitAndRemoveSpaces(String commandString) {
        commandString = commandString.trim();
        return commandString.split(" ");
    }

    public static void parser() throws Exception {
        String[] fileData = ReadCommandFile.fileData;
        for (int lineIndex = 0; lineIndex < fileData.length; lineIndex++) {
           // String[] lineToExecute = CommandReader.trimCommand(fileData[lineIndex]);
            //System.out.println(fileData[lineIndex]);
            lineIndex = HelperFuncs.executeCommand(fileData[lineIndex], lineIndex);
        }
    }

    public static String[] lexer() {
        return FileReader.readFile(Consts.FILE_NAME);

    }
}
