package biblioteka.interfejs;

import java.util.ArrayList;
import java.util.List;

import biblioteka.Knjiga;

public class Biblioteka implements BibliotekaInterface {

	List<Knjiga>knjige=new ArrayList<>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiListuKnjiga() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Knjiga knjiga) {
		List<Knjiga>lista=new ArrayList<Knjiga>();
		for(Knjiga k: knjige) {
			if(k.getNaslov().toLowerCase().contains(knjiga.getNaslov().toLowerCase())) {
				lista.add(k);
				return lista;
			}
		}
		return lista;
	}

}
