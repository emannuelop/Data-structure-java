package provaA2;

import java.util.ArrayList;
import java.util.List;

public class Tarefa {
	private int indice;
	private String descricao;
	private boolean concluida;
	private List<Tarefa> subTarefas;

	public Tarefa(int indice, String descricao) {
		this.indice = indice;
		this.descricao = descricao;
		this.concluida = false;
		subTarefas = new ArrayList<>();
	}

	public void adicionarSubTarefa(Tarefa subTarefa) {
		subTarefas.add(subTarefa);
	}

	public void marcarConcluida() {
		concluida = true;
		marcarSubTarefasConcluidas();
	}

	private void marcarSubTarefasConcluidas() {
		for (Tarefa subTarefa : subTarefas) {
			subTarefa.marcarConcluida();
		}
	}

	public void imprimirTarefa() {
	    imprimirTarefa(this, 0, true);
	}

	private void imprimirTarefa(Tarefa tarefa, int nivel, boolean exibirRaiz) {
	    if (exibirRaiz || tarefa.indice != 0) {
	        for (int i = 0; i < nivel; i++) {
	            System.out.print("\t");
	        }
	        String status = tarefa.concluida ? "[X] " : "[ ] ";
	        System.out.println(tarefa.indice + ". " + status + tarefa.descricao);
	    }

	    for (Tarefa subTarefa : tarefa.subTarefas) {
	        imprimirTarefa(subTarefa, nivel + 1, true);
	    }
	}


	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public List<Tarefa> getSubTarefas() {
		return subTarefas;
	}

	public void setSubTarefas(List<Tarefa> subTarefas) {
		this.subTarefas = subTarefas;
	}

}
