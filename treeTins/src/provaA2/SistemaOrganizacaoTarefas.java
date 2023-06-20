package provaA2;

import java.util.Scanner;

public class SistemaOrganizacaoTarefas {
	private Tarefa raiz;
	private int proximoIndice;

	public SistemaOrganizacaoTarefas() {
		raiz = new Tarefa(0, "Tarefas");
		proximoIndice = 1;
	}

	public void adicionarTarefa(String descricao) {
		Tarefa tarefa = new Tarefa(proximoIndice, descricao);
		raiz.adicionarSubTarefa(tarefa);
		proximoIndice++;
	}

	public void adicionarSubTarefa(String descricao, int indicePai) {
		Tarefa pai = buscarTarefa(raiz, indicePai);
		if (pai != null) {
			Tarefa subTarefa = new Tarefa(proximoIndice, descricao);
			pai.adicionarSubTarefa(subTarefa);
			proximoIndice++;
		} else {
			System.out.println("Tarefa pai não encontrada.");
		}
	}

	public void marcarConcluida(int indice) {
		Tarefa tarefa = buscarTarefa(raiz, indice);
		if (tarefa != null) {
			tarefa.marcarConcluida();
			System.out.println("Tarefa marcada como concluída.");
		} else {
			System.out.println("Tarefa não encontrada.");
		}
	}

	public void removerTarefa(int indice) {
		Tarefa tarefaPai = buscarTarefaPai(raiz, indice);
		if (tarefaPai != null) {
			for (int i = 0; i < tarefaPai.getSubTarefas().size(); i++) {
				Tarefa tarefa = tarefaPai.getSubTarefas().get(i);
				if (tarefa.getIndice() == indice) {
					tarefaPai.getSubTarefas().remove(i);
					System.out.println("Tarefa removida com sucesso.");
					return;
				}
			}
		}
		System.out.println("Tarefa não encontrada.");
	}

	private Tarefa buscarTarefa(Tarefa tarefaAtual, int indice) {
		if (tarefaAtual.getIndice() == indice) {
			return tarefaAtual;
		}

		for (Tarefa subTarefa : tarefaAtual.getSubTarefas()) {
			Tarefa tarefaEncontrada = buscarTarefa(subTarefa, indice);
			if (tarefaEncontrada != null) {
				return tarefaEncontrada;
			}
		}

		return null;
	}

	private Tarefa buscarTarefaPai(Tarefa tarefaAtual, int indice) {
		for (Tarefa subTarefa : tarefaAtual.getSubTarefas()) {
			if (subTarefa.getIndice() == indice) {
				return tarefaAtual;
			} else {
				Tarefa tarefaPai = buscarTarefaPai(subTarefa, indice);
				if (tarefaPai != null) {
					return tarefaPai;
				}
			}
		}
		return null;
	}

	public void exibirListaTarefas() {
		raiz.imprimirTarefa();
	}

	public static void main(String[] args) {
		SistemaOrganizacaoTarefas sistema = new SistemaOrganizacaoTarefas();
		Scanner scanner = new Scanner(System.in);

		boolean executando = true;

		while (executando) {
			System.out.println("\n========== Sistema de Organização de Tarefas ==========");
			System.out.println("1. Adicionar tarefa");
			System.out.println("2. Adicionar sub-tarefa");
			System.out.println("3. Marcar tarefa como concluída");
			System.out.println("4. Remover tarefa");
			System.out.println("5. Exibir lista de tarefas");
			System.out.println("6. Sair");
			System.out.print("Escolha uma opção: ");

			try {
				int opcao = Integer.parseInt(scanner.nextLine());

				switch (opcao) {
				case 1:
					System.out.print("Digite a descrição da tarefa: ");
					String descricaoTarefa = scanner.nextLine();
					sistema.adicionarTarefa(descricaoTarefa);
					break;
				case 2:
					System.out.print("Digite a descrição da sub-tarefa: ");
					String descricaoSubTarefa = scanner.nextLine();
					System.out.print("Digite o índice da tarefa pai: ");
					int indicePai = Integer.parseInt(scanner.nextLine());
					sistema.adicionarSubTarefa(descricaoSubTarefa, indicePai);
					break;
				case 3:
					System.out.print("Digite o índice da tarefa a ser concluída: ");
					int indiceConcluir = Integer.parseInt(scanner.nextLine());
					sistema.marcarConcluida(indiceConcluir);
					break;
				case 4:
					System.out.print("Digite o índice da tarefa a ser removida: ");
					int indiceRemover = Integer.parseInt(scanner.nextLine());
					sistema.removerTarefa(indiceRemover);
					break;
				case 5:
					sistema.exibirListaTarefas();
					break;
				case 6:
					executando = false;
					break;
				default:
					System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Erro: entrada inválida. Por favor, tente novamente.");
			}
		}

		System.out.println("Encerrando o sistema...");

		scanner.close();
	}
}