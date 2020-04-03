import readers.CommandReader;
import readers.DataServerReader;
import readers.FileReader;

import static readers.FileReader.readXMLFile;
import static utils.Consts.VARIABLE_XML;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader.readXMLFile(VARIABLE_XML);
        CommandReader.parser();
//        VariableMapper.printSymbolMap();

        //DataServerReader.openServerConnection();
    }
}