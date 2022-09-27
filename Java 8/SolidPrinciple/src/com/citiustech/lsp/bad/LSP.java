package com.citiustech.lsp.bad;

public class LSP {

	public static void main(String[] args) {

		
		//Logger logger =new Logger();
        Logger logger =new FileLogger(); //replacing parent object with child

logger.log("some code");
logger.clear();
	}

}
class Logger{
	void log(String msg) {
		System.out.println("loggers log method");
	}
	void clear() {
		System.out.println("loggers clear method");
	}
}

//assume filelogger doen not support clearing the log
class FileLogger extends Logger{
	
	void log(String msg) {
		System.out.println("Fileloggers log method");
	}
	void clear() {
		//System.out.println("Fileloggers clear method");
		throw new RuntimeException("operaten not supported");
	}
	
}