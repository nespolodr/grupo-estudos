package br.com.fiorilli.estudos.agenda.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiorilli.estudos.agenda.modelo.Agenda;
import br.com.fiorilli.estudos.agenda.modelo.Nota;

public class CrudAgendaArquivoTexto extends CrudAgendaMemoria implements
		CrudAgendaInterface {

	private File file;
	private File diretorio;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public CrudAgendaArquivoTexto() {

		diretorio = new File("D:" + File.separator + "arquivosestudo");
		file = new File(diretorio, "estudos.txt");
		if (!file.exists()) {
			try {
				diretorio.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			}
		}

	}

	@Override
	public Nota inserir() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, true));

			Nota novaNota = super.inserir();
			String stringzona = "";
			stringzona = novaNota.getId() + ";" + novaNota.getTitulo() + ";" + novaNota.getDescricao() + ";" + sdf.format(novaNota.getData())+ "\n";
			bw.write(stringzona);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public void alterar(Agenda agenda) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listar(Agenda agenda) {

		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);

			List<Nota> notas = agenda.getNotas();
			if (notas == null)
				notas = new ArrayList<>();

			while (br.ready()) {
				String line = br.readLine();
				if (!"".equals(line)) {
					String[] split = line.split(";");

					Nota nota = new Nota();
					nota.setId(Long.parseLong(split[0]));
					nota.setTitulo(split[1]);
					nota.setDescricao(split[2]);
					nota.setData(sdf.parse(split[3]));

					notas.add(nota);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		agenda.getNotas().forEach(s -> System.out.println(s));
	}

	@Override
	public void remover(Agenda agenda) {
		// TODO Auto-generated method stub

	}

}
