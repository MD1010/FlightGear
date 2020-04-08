package test;

import readers.CommandReader;

public class MyInterpreter {

	public static  int interpret(String[] lines){
		// call your interpreter here
		// FileReader.readXMLFile(VARIABLE_XML);
		CommandReader.parser();
//        VariableMapper.printSymbolMap();

		//DataServerReader.openServerConnection();
		return 0;
	}
}
