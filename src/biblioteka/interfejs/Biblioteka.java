package biblioteka.interfejs;

import java.util.ArrayList;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public class Biblioteka implements BibliotekaInterface {

	//provera push/pull-a
	//provera perinog eclipse-a
	//ova lista je implementirana kao arraylist zbog ceste pretrage 

	List<Knjiga>knjige=new ArrayList<>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null!");
		}if(knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Ta knjiga vec postoji u biblioteci!");
		}
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null!");
		}if(!knjige.contains(knjiga)) {
			throw new IllegalArgumentException("Ta knjiga ne postoji u biblioteci!");
		}
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiListuKnjiga() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Knjiga knjiga) {

		if(knjiga.getAutori()==null&&knjiga.getIsbn()<=0&&knjiga.getNaslov()==null&&knjiga.getIzdavac()==null) {
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu!");

		}
		List<Knjiga>lista=new ArrayList<Knjiga>();
		if(knjiga.getNaslov()!=null) {
			for(Knjiga k: knjige) {
				if(k.getNaslov().toLowerCase().contains(knjiga.getNaslov().toLowerCase())) {
					lista.add(k);
				}
			}
			
		}else{
			boolean signal=true;
			for(Knjiga k: knjige) {
				for(Autor a:knjiga.getAutori()) {
					if(!k.getAutori().contains(a)) {
						signal=false;
						break;
					}
				}
				if(signal==true) {
					lista.add(k);
				}else {
					signal=true;
				}
			}
		}
		return lista;
	}

}
