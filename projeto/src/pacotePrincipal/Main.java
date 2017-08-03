package pacotePrincipal;

import java.util.ArrayList;

import easyaccept.EasyAccept;
import easyaccept.EasyAcceptFacade;

public class Main {
	public static void main(String[] args) {
		 ArrayList<String> testes = new ArrayList<>();
		 testes.add("us/us1");
		 EasyAcceptFacade eaf= new
		 easyaccept.EasyAcceptFacade(new Facade(), testes);
		 eaf.executeTests();
		 System.out.println(eaf.getCompleteResults());
//
//		args = new String[] { "pacotePrincipal.Facade", "us/us1" };
//		EasyAccept.main(args);

	}
}
