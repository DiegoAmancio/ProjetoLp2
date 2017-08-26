package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import emprestismo.Emprestimo;
import emprestismo.EmprestimoComparator;
import enums.CartaoFidelidade;

import enums.Emprestado;
import item.Item;

/**
 * representacao de um usuario
 * 
 * 
 * Laboratorio de Programacao 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public class Usuario {
	private String nome;
	private String telefone;
	private String email;
	private Map<String, Item> itens;
	private List<Emprestimo> emprestou;
	private List<Emprestimo> pegouEmprestado;
	private double reputacao;
	private CartaoFidelidade cartao;

	/**
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param email
	 *            email do usuario
	 */
	public Usuario(String nome, String telefone, String email) {

		validaUsuarioAtributo(nome, "Nome");
		validaUsuarioAtributo(telefone, "Telefone");
		validaUsuarioAtributo(email, "Email");

		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itens = new HashMap<String, Item>();
		emprestou = new ArrayList<Emprestimo>();
		pegouEmprestado = new ArrayList<Emprestimo>();
		this.reputacao = 0;
		this.cartao = CartaoFidelidade.FREE_RIDER;
	}

<<<<<<< HEAD
	public void validaUsuarioAtributo(String atributo, String qualAtributo) {
		if (atributo == null) {
			throw new NullPointerException(qualAtributo + "invalido,nulo");
		}
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(qualAtributo + "invalido,vazio");
		}
	}

	public void calcularTipoCartao() {
		
	
		if (this.reputacao >= 0 && this.reputacao <= 100) {
			setCartao(CartaoFidelidade.NOOB);
		} else if (this.reputacao > 100) {
			setCartao(CartaoFidelidade.BOM_AMIGO);
		} else if (this.reputacao < 0) {
			setCartao(CartaoFidelidade.CALOTEIRO);
		}
	}

	public void sobeReputacao(double preco, String situacao) {
		double valor = 0;
		if (situacao.equals("Emprestou")) {
			valor = this.reputacao + (preco * 0.1);
		} else {
			valor = this.reputacao + (preco * 0.05);
		}
		setReputacao(valor);
		calcularTipoCartao();

	}

=======
>>>>>>> master
	public void abaixaReputacao(double preco, int diasAtrasados) {

		double diminuir = (preco * (diasAtrasados * 0.01));
		setReputacao(this.reputacao - diminuir);
		calcularTipoCartao();
<<<<<<< HEAD
	}

	public void existeItem(String nomeItem) {
		if (!itens.containsKey(nomeItem)) {
			throw new NullPointerException("Item nao encontrado");
		}
	}

	public void empresta(Emprestimo novoEmprestimo, String nomeItem) {
		emprestou.add(novoEmprestimo);
		sobeReputacao(getItem(nomeItem).getPreco(), "Emprestou");
		itens.get(nomeItem).setEmprestado(Emprestado.EMPRESTADO);
	}

	public void pegaEmprestado(Emprestimo novoEmprestimo, String nomeItem) {
		pegouEmprestado.add(novoEmprestimo);
=======

>>>>>>> master
	}

	public void adicionaItem(String nomeItem, Item item) {
		if (!(itens.containsKey(nomeItem))) {
			sobeReputacao(item.getPreco(), "");
			itens.put(nomeItem, item);

		}
		calcularTipoCartao();
	}

	/**
	 * atualiza o preco do item
	 * 
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 * @param preco
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		if (itens.containsKey(nomeItem)) {
			switch (atributo.trim().toUpperCase()) {

			case "PRECO":
				double novoValor = Double.parseDouble(valor);
				itens.get(nomeItem).setPreco(novoValor);
				break;
			case "NOME":
				Item item = itens.get(nomeItem);
				itens.remove(nomeItem);
				itens.put(valor, item);
				itens.get(valor).setNome(valor);
				break;
			default:
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException("Item nao encontrado");
		}
	}
	
	public CartaoFidelidade getCartao() {
		return cartao;
	}
	
	public String getCartaoTxt() {
		return cartao.getMensagem();
	}

	public void setCartao(CartaoFidelidade cartao) {
		this.cartao = cartao;
	}

	public double getReputacao() {
		return reputacao;
	}

	public void setReputacao(double reputacao) {
		this.reputacao = reputacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void calcularTipoCartao() {

		if (this.reputacao >= 0 && this.reputacao <= 100) {
			setCartao(CartaoFidelidade.NOOB);
		} else if (this.reputacao > 100) {
			setCartao(CartaoFidelidade.BOM_AMIGO);
		} else if (this.reputacao < 0) {
			setCartao(CartaoFidelidade.CALOTEIRO);
		} else {
			setCartao(CartaoFidelidade.FREE_RIDER);
		}
	}

	public void empresta(Emprestimo novoEmprestimo, String nomeItem) {
		emprestou.add(novoEmprestimo);
		sobeReputacao(getItem(nomeItem).getPreco(), "Emprestou");
		itens.get(nomeItem).setEmprestado(Emprestado.EMPRESTADO);
	}

	public Emprestimo existeEmprestimo(String nomeItem, String nomeRequerente) {

		for (Emprestimo emprestimo : emprestou) {
			if (emprestimo.getItemEmprestado().equals(nomeItem)
					&& emprestimo.getNomeRequerente().equals(nomeRequerente)) {
				return emprestimo;
			}
		}

		throw new NullPointerException("Emprestimo nao encontrado");

	}

	public void existeItem(String nomeItem) {
		if (!itens.containsKey(nomeItem)) {
			throw new NullPointerException("Item nao encontrado");
		}
	}

	public void fechandoEmprestimo(String dataEntrega, Emprestimo ee) {
		for (int i = 0; i < emprestou.size(); i++) {
			Emprestimo emprestimo = emprestou.get(i);
			if (emprestimo.equals(ee)) {
				emprestimo.fechandoEmprestimo(dataEntrega);

			}
		}
	}

	/**
	 * Retorna o preco do item
	 * 
	 * @param nomeItem
	 * @param atributo
	 * @return
	 */

	public String getInfoItem(String nomeItem, String atributo) {
		if (itens.containsKey(nomeItem)) {
			switch (atributo.trim().toUpperCase()) {
			case "PRECO":
				return Double.toString(itens.get(nomeItem).getPreco());
			case "NOME":
				return itens.get(nomeItem).getNome();
			default:
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	public String listarItensEmprestados() {
		String saida = "Emprestimos: ";
		Collections.sort(emprestou, new EmprestimoComparator());
		if (emprestou.size() > 0) {
			for (int i = 0; i < emprestou.size(); i++) {
				saida += emprestou.get(i).toString();
			}
			return saida;
		} else {
			return ("Nenhum item emprestado");
		}
	}

	public String listarItensPegouEmprestado() {
		String saida = "Emprestimos pegos: ";
		Collections.sort(emprestou, new EmprestimoComparator());
		if (pegouEmprestado.size() > 0) {
			for (int i = 0; i < pegouEmprestado.size(); i++) {
				saida += pegouEmprestado.get(i).toString();
			}
			return saida;
		} else {
			return ("Nenhum item pego emprestado");
		}
	}

	public void pegaEmprestado(Emprestimo novoEmprestimo, String nomeItem) {
		pegouEmprestado.add(novoEmprestimo);
	}

	public void removerItem(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			itens.remove(nomeItem);
		} else {
			throw new NullPointerException("Item nao encontrado");
		}
	}
	
	public Item getItem(String nomeItem) {
		return itens.get(nomeItem);
	}

	public void sobeReputacao(double preco, String situacao) {
		double valor = 0;
		if (situacao.equals("Emprestou")) {
			valor = this.reputacao + (preco * 0.1);
		} else {
			valor = this.reputacao + (preco * 0.05);
		}
		setReputacao(valor);
		calcularTipoCartao();

	}

	public void validaUsuarioAtributo(String atributo, String qualAtributo) {
		if (atributo == null) {
			throw new NullPointerException(qualAtributo + "invalido,nulo");
		}
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(qualAtributo + "invalido,vazio");
		}
	}

	/**
	 * compara um usuario com este.
	 * 
	 * @param usuario
	 *            usuario a ser comparado
	 * @return se o usuario e igual ao dono deste metodo.
	 */
	public boolean equals(Usuario usuario) {
		boolean saida = false;
		if (usuario.getNome().equals(this.nome)) {
			if (usuario.getTelefone().equals(this.telefone)) {
				saida = true;
			}
		}
		return saida;
	}

<<<<<<< HEAD
	public Emprestimo existeEmprestimo(String nomeItem, String nomeRequerente) {
=======
	public String getDetalhes(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			return itens.get(nomeItem).toString();
		}
		throw new NullPointerException("Item nao encontrado");
	}

	public Item getItem(String itemEmprestado) {
		return itens.get(itemEmprestado);
	}

	public CartaoFidelidade getCartao() {
		return cartao;
	}
>>>>>>> master

	public double getReputacao() {
		return reputacao;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getCartaoTxt() {
		return cartao.getMensagem();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setReputacao(double reputacao) {
		this.reputacao = reputacao;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCartao(CartaoFidelidade cartao) {
		this.cartao = cartao;
	}

	/**
	 * representacao de um usuario
	 */
	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}

}
