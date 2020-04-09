package test;

import readers.CommandReader;

public class MyInterpreter {

	public static  int interpret(String[] testCommands){
		// call your interpreter here
		// FileReader.readXMLFile(VARIABLE_XML);
		return CommandReader.runCommands(testCommands);
//        VariableMapper.printSymbolMap();

		//DataServerReader.openServerConnection();
	}
}
