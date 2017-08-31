package dados;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import emprestismo.EmprestimoController;
import item.ItemController;
import usuario.UsuarioController;

public class GravaDados {
			
	public static void salvaDados() throws IOException {	
		salvaEmprestimos();
		salvaUsuarios();
		salvaItens();
	}
	
	/**
	 * Salva os emprestimos no arquivo
	 * @throws IOException
	 */
	private static void salvaEmprestimos() throws IOException {
		FileOutputStream emprestimos = new FileOutputStream("emprestimo.txt");
		ObjectOutputStream oosEmprestimos = new ObjectOutputStream(emprestimos);
		
		EmprestimoController emprestimosCadastrados = new EmprestimoController();
		
		oosEmprestimos.writeObject(emprestimosCadastrados.getEmprestimos());
		oosEmprestimos.close();
	}

	private static void salvaUsuarios() throws IOException {
		FileOutputStream usuarios = new FileOutputStream("usuarios.txt");
		ObjectOutputStream oosUsuarios = new ObjectOutputStream(usuarios);
		
		UsuarioController usuariosCadastrados = new UsuarioController();
		
		oosUsuarios.writeObject(usuariosCadastrados.getUsuarios());
		oosUsuarios.close();
	}

	private static void salvaItens() throws IOException {
		FileOutputStream itens = new FileOutputStream("itens.txt");
		ObjectOutputStream oosItens = new ObjectOutputStream(itens);
		
		ItemController itensCadastrados = new ItemController();
		
		oosItens.writeObject(itensCadastrados.getItens());
		oosItens.close();
	}
}
