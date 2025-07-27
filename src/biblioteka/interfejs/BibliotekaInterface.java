package biblioteka.interfejs;

import java.util.List;

import biblioteka.Knjiga;

public interface BibliotekaInterface {

	
	public void dodajKnjigu(Knjiga knjiga) ;
	
	public void obrisiKnjigu(Knjiga knjiga);
	
	public List<Knjiga> vratiListuKnjiga();
	
	public List<Knjiga> pronadjiKnjigu(Knjiga knjiga);
}
