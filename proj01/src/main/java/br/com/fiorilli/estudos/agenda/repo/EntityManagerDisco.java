package br.com.fiorilli.estudos.agenda.repo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import br.com.fiorilli.estudos.agenda.modelo.Nota;

public class EntityManagerDisco implements EntityManager {

	private File file;
	private File diretorio;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static EntityManager instance;

	public static EntityManager getInstance() {
		if (instance == null)
			instance = new EntityManagerDisco();
		return instance;
	}

	public EntityManagerDisco() {
		diretorio = new File("D:" + File.separator + "arquivosestudo");
		file = new File(diretorio, "estudos.txt");
		if (!file.exists()) {
			try {
				diretorio.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	@Override
	public Nota persist(Nota novaNota) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, true));

			String stringzona = "";
			stringzona = novaNota.getId() + ";" + novaNota.getTitulo() + ";"
					+ novaNota.getDescricao() + ";"
					+ sdf.format(novaNota.getData()) + "\n";
			
			bw.write(Base64.getEncoder().encodeToString(stringzona.getBytes()));

			return novaNota;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public List<Nota> listAll() {

		List<Nota> notas = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);

			while (br.ready()) {
				String line = br.readLine();
				if (!"".equals(line)) {
					line = new String(Base64.getDecoder().decode(line.getBytes()));
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

		return notas;
	}

	@Override
	public Nota merge(Nota nota) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Método não implementado ainda");
	}

	@Override
	public void remove(Nota nota) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Método não implementado ainda");
	}

	@Override
	public Nota find(long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Método não implementado ainda");
	}
}
