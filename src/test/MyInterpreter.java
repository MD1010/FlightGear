package test;

import readers.CommandReader;

public class MyInterpreter {

	public static  int interpret(String[] lines){
		// call your interpreter here
		// FileReader.readXMLFile(VARIABLE_XML);
		CommandReader.runCommands(lines);
//        VariableMapper.printSymbolMap();

		//DataServerReader.openServerConnection();
		return 0;
	}
}
