package test;

import readers.CommandReader;
import utils.ReadCommandFile;

public class MyInterpreter {

	public static  int interpret(String[] lines){
		// call your interpreter here
		// FileReader.readXMLFile(VARIABLE_XML);
		ReadCommandFile.fileData = lines;
		CommandReader.parser();
//        VariableMapper.printSymbolMap();

		//DataServerReader.openServerConnection();
		return 0;
	}
}
