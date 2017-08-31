package emprestismo;

import java.util.ArrayList;
import java.util.List;

import enums.CartaoFidelidade;

/**
 * representa um controlador de emprestimos;
 * 
 * @author Diego Amancio - 116210716
 *
 */
public class EmprestimoController {
	private List<Emprestimo> emprestimos;

	public EmprestimoController() {
		this.emprestimos = new ArrayList<Emprestimo>();
	}

	/**
	 * cria um emprestimo
	 * 
	 * @param nomeDono
	 *            nome do dono do item a ser emprestado
	 * @param telefoneDono
	 *            telefone do dono do item a ser emprestado
	 * @param nomeRequerente
	 *            nome do usuario que esta requisitando o item
	 * @param telefoneRequerente
	 *            telefone do usuario que esta requisitando o item
	 * @param itemEmprestado
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            inicio do emprestimo
	 * @param periodo
	 *            periodo limite que o usuario pode ficar com o item
	 * @param cartao
	 *            tipo do cartao do requerente
	 * @return um emprestimo;
	 */
	public Emprestimo criaEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String itemEmprestado, String dataEmprestimo, int periodo,
			CartaoFidelidade cartao) {
		int vencimento = determinarVencimento(cartao);

		if (vencimento < periodo) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
		Emprestimo novoEmprestimo = new Emprestimo(nomeDono, nomeRequerente, itemEmprestado, dataEmprestimo, periodo,
				vencimento);
		emprestimos.add(novoEmprestimo);
		return novoEmprestimo;
	}

	/**
	 * determina a quantidade de dias que usuario pode ficar com o item
	 * emprestado
	 * 
	 * @param cartao
	 *            tipo do cartao do requerente
	 * @return a quantidade de dias max que o usuario pode ficar com o item do
	 *         outro usuario
	 */
	public int determinarVencimento(CartaoFidelidade cartao) {

		if (cartao.equals(CartaoFidelidade.BOM_AMIGO)) {
			return 14;
		} else if (cartao.equals(CartaoFidelidade.NOOB)) {
			return 7;
		} else if (cartao.equals(CartaoFidelidade.FREE_RIDER)) {
			return 5;
		} else {
			throw new NullPointerException("Usuario nao pode pegar nenhum item emprestado");
		}
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
}