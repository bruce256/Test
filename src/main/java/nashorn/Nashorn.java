package nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author lvsheng
 * @date 2017/03/17
 */
public class Nashorn {

	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine        engine  = manager.getEngineByName("JavaScript");

		System.out.println(engine.getClass().getName());
		try {
			System.out.println("Result:" + engine.eval("function f() { return 1; }; f() + 1;"));
		} catch (ScriptException e) {
			e.printStackTrace();
		}

	}
}
