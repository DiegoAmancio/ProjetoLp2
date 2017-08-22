package pacotePrincipal;

import java.io.File;
import java.util.ArrayList;

import easyaccept.EasyAccept;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<String> testes = new ArrayList<>();
		
		testes.add("us" + File.separator + "us1");
		testes.add("us" + File.separator + "us2");
		testes.add("us" + File.separator + "us3");
		testes.add("us" + File.separator + "us4");
		testes.add("us" + File.separator + "us5");
		testes.add("us" + File.separator + "us6");
		testes.add("us" + File.separator + "us7");
		testes.add("us" + File.separator + "us8");
		EasyAccept.executeEasyAcceptTests("pacotePrincipal.Facade", testes);
	}

}
