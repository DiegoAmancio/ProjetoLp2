package dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;


import emprestismo.EmprestimoController;
import item.ItemController;
import usuario.UsuarioController;

public class RecuperarDados {

	public RecuperarDados() {

	}

	public static void getDados() throws IOException {
		getUsuarios();
		getItens();
		getEmprestimos();

	}

	private static void getEmprestimos() throws IOException {
		FileInputStream dadosEmprestimo = new FileInputStream("emprestimo.txt");
		ObjectInputStream ois = new ObjectInputStream(dadosEmprestimo);

		try {
			List emprestimos = (List) ois.readObject();
			EmprestimoController emprestController = new EmprestimoController();
			emprestController.setEmprestimos(emprestimos);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ois.close();
			dadosEmprestimo.close();
		}

	}

	private static void getItens() throws IOException {
		FileInputStream dadosItens = new FileInputStream("item.txt");
		ObjectInputStream ois = new ObjectInputStream(dadosItens);

		try {
			List itens = (List) ois.readObject();
			ItemController item = new ItemController();
			item.setItens(itens);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dadosItens.close();
			ois.close();
		}
	}

	private static void getUsuarios() throws IOException {
		FileInputStream dadosUsuarios = new FileInputStream("usuario.txt");
		ObjectInputStream ois = new ObjectInputStream(dadosUsuarios);

		try {
			Map usuarios = (Map) ois.readObject();
			UsuarioController usuario = new UsuarioController();
			usuario.setUsuarios(usuarios);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dadosUsuarios.close();
			ois.close();
		}
	}
}
